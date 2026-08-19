/**
 * Levenshtein Distance & Canonical Semantic Matcher for SKAVOCA
 * 
 * 1. normalizeCanonical: 하이픈(-), 공백( ), 슬래시(/), 별표(*), 점(.), 골뱅이(@) 및 대소문자 차이를
 *    완전히 정규화하여 'git flow'와 'git-flow', 'v model'과 'v-model' 등을 완벽한 정답으로 인정
 * 2. evaluateAnswerMatch: Direct Match -> Canonical Match -> 혼동 오답 검사 -> Levenshtein Typo Grace 4단계 평가
 */

export function normalizeCanonical(str) {
  if (!str) return "";
  return str
    .toLowerCase()
    .replace(/[\s\-_/\.\*\@\,]/g, "")
    .trim();
}

export function calculateLevenshteinDistance(a, b) {
  const str1 = (a || "").trim().toLowerCase();
  const str2 = (b || "").trim().toLowerCase();
  const matrix = [];

  for (let i = 0; i <= str1.length; i++) {
    matrix[i] = [i];
  }
  for (let j = 0; j <= str2.length; j++) {
    matrix[0][j] = j;
  }

  for (let i = 1; i <= str1.length; i++) {
    for (let j = 1; j <= str2.length; j++) {
      if (str1.charAt(i - 1) === str2.charAt(j - 1)) {
        matrix[i][j] = matrix[i - 1][j - 1];
      } else {
        matrix[i][j] = Math.min(
          matrix[i - 1][j - 1] + 1, // substitution
          matrix[i][j - 1] + 1,     // insertion
          matrix[i - 1][j] + 1      // deletion
        );
      }
    }
  }

  const distance = matrix[str1.length][str2.length];
  const maxLen = Math.max(str1.length, str2.length);
  const similarity = maxLen === 0 ? 1.0 : 1.0 - distance / maxLen;

  return {
    distance,
    similarity,
    isTypo: distance <= 2 && similarity >= 0.75 && similarity < 1.0
  };
}

/**
 * 지능형 4단계 정답 평가 (혼동 오답 우선 검사):
 * 1단계: 원문 일치 (Exact Match)
 * 2단계: 기호/공백/대소문자 관용 정규화 일치 (Canonical Match)
 * 3단계: 혼동 오답 검사 — 입력값이 270개 마스터 단어 중 다른 단어와 일치하면 '개념 혼동'
 * 4단계: 퍼지 매칭 — 사전에 없는 이상한 텍스트일 경우에만 오타 유예
 * 
 * @param {string} userInput - 사용자 입력
 * @param {object} targetWord - 정답 단어 객체 { term, fullTerm }
 * @param {Array} allWords - 전체 270개 단어 배열 (혼동 오답 검사용, optional)
 */
export function evaluateAnswerMatch(userInput, targetWord, allWords = []) {
  if (!targetWord) return { isCorrect: false, isTypo: false, isConfusion: false };

  const rawInput = (userInput || "").trim().toLowerCase();
  const rawTarget = (targetWord.term || "").trim().toLowerCase();
  const rawFullTarget = (targetWord.fullTerm || "").trim().toLowerCase();

  // 1. Direct Match
  if (rawInput === rawTarget || (rawFullTarget && rawInput === rawFullTarget)) {
    return { isCorrect: true, isCanonicalMatch: false, isConfusion: false };
  }

  // 2. Canonical Match (기호 및 띄어쓰기 차이 관용 허용)
  const canonInput = normalizeCanonical(userInput);
  const canonTarget = normalizeCanonical(targetWord.term);
  const canonFull = normalizeCanonical(targetWord.fullTerm);

  if (canonInput && (canonInput === canonTarget || (canonFull && canonInput === canonFull))) {
    return { isCorrect: true, isCanonicalMatch: true, isConfusion: false };
  }

  // 3. 혼동 오답 검사 — 입력이 다른 IT 용어와 정확히 일치하면 '개념 혼동' (war→jar 등)
  if (allWords.length > 0) {
    const confusedWord = allWords.find(w => {
      if (w.wordId === targetWord.wordId) return false; // 자기 자신 제외
      const wTerm = (w.term || "").trim().toLowerCase();
      const wFull = (w.fullTerm || "").trim().toLowerCase();
      const wCanon = normalizeCanonical(w.term);
      return rawInput === wTerm || rawInput === wFull || canonInput === wCanon;
    });

    if (confusedWord) {
      return {
        isCorrect: false,
        isTypo: false,
        isConfusion: true,
        confusedWith: confusedWord.term,
        confusedWordId: confusedWord.wordId,
      };
    }
  }

  // 4. Levenshtein Typo Grace (사전에 없는 텍스트만 오타로 판별)
  const fuzzy = calculateLevenshteinDistance(canonInput, canonTarget);
  if (fuzzy.isTypo) {
    return {
      isCorrect: false,
      isTypo: true,
      isConfusion: false,
      distance: fuzzy.distance,
      similarity: fuzzy.similarity
    };
  }

  return { isCorrect: false, isTypo: false, isConfusion: false };
}
