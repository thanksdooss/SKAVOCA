// Dynamic Cloze Sentence Parser (Polycloze Benchmarking)

export function parseClozeSentence(sentence) {
  const regex = /\{\{(.*?)\}\}/;
  const match = sentence.match(regex);

  if (!match) {
    return {
      hasCloze: false,
      prefix: sentence,
      targetTerm: "",
      suffix: "",
      scrambledBlocks: []
    };
  }

  const targetTerm = match[1].trim();
  const parts = sentence.split(match[0]);

  // Generate scrambled blocks for word block assembly UI
  const blocks = generateScrambledBlocks(targetTerm);

  return {
    hasCloze: true,
    prefix: parts[0] || "",
    targetTerm,
    suffix: parts[1] || "",
    scrambledBlocks: blocks
  };
}

function generateScrambledBlocks(targetTerm) {
  // If multi-word (e.g., "List Comprehension", "One-Hot Encoding")
  if (targetTerm.includes(" ")) {
    const words = targetTerm.split(" ");
    // Add 1~2 distractor words
    const distractors = ["Async", "Mapping", "Pattern", "Module"];
    const pool = [...words, distractors[Math.floor(Math.random() * distractors.length)]];
    return shuffleArray(pool.map((text, idx) => ({ id: `word-${idx}`, text, type: "word" })));
  }

  // If single word or short acronym (e.g., "kubectl", "yaml", "war", "PR")
  const letters = targetTerm.split("");
  const alphabetPool = "abcdefghijklmnopqrstuvwxyz";
  const dummyCount = Math.max(1, 8 - letters.length);
  const extraLetters = [];
  for (let i = 0; i < dummyCount; i++) {
    extraLetters.push(alphabetPool[Math.floor(Math.random() * alphabetPool.length)]);
  }

  const pool = [...letters, ...extraLetters];
  return shuffleArray(pool.map((char, idx) => ({ id: `char-${idx}`, text: char, type: "letter" })));
}

function shuffleArray(array) {
  const arr = [...array];
  for (let i = arr.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [arr[i], arr[j]] = [arr[j], arr[i]];
  }
  return arr;
}
