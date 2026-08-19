# [SKAVOCA] RESTful API 명세서 (API Specification)


## 1. API 개요 및 공통 표준
- **Base URL**: `https://api.skavoca.skala.ac.kr/api/v1`
- **통신 포맷**: JSON (`Content-Type: application/json; charset=UTF-8`)
- **보안 및 인증**: HTTP `Authorization: Bearer <JWT_ACCESS_TOKEN>` 헤더
- **에러 응답 표준 규격**:
```json
{
  "status": 400,
  "code": "INVALID_INPUT_VALUE",
  "message": "입력값이 올바르지 않습니다.",
  "timestamp": "2026-08-18T12:00:00.000Z"
}
```

---

## 2. 엔드포인트 종합 목록


| 도메인 | HTTP Method | Endpoint | 설명 | 인증 |
| :--- | :---: | :--- | :--- | :---: |
| **인증 (Auth)** | `POST` | `/api/v1/auth/signup` | 회원가입 (교육생/교수자) | Public |
| | `POST` | `/api/v1/auth/login` | 로그인 및 JWT 토큰 발급 | Public |
| **학습 (Learning)** | `GET` | `/api/v1/learning/today` | 오늘의 학습/복습 덱 (Due Words + S3 오디오 URL) | User |
| | `POST` | `/api/v1/learning/submit-answer` | **[핵심]** 쾌속 정답 제출 + 퍼지 매칭 + SM-2 자동 추론 + EXP 지급 | User |
| **AI 피드백 (LLM)** | `POST` | `/api/v1/ai/explain-distractor` | DB 캐시 + 한국어 템플릿 비동기 오답 해설 생성 및 DB 자동 캐싱 | User |
| **게이미피케이션** | `GET` | `/api/v1/gamification/league` | SKALA 4기 주간 랭킹 리그전 순위 및 승급 현황 조회 | User |
| | `GET` | `/api/v1/gamification/profile` | 내 RPG 티어(노비~CTO), 누적 EXP, 보유 배지 조회 | User |
| **교수자 (Admin)** | `GET` | `/api/v1/admin/analytics/difficult-words` | 기수별 Top 10 취약 어휘 통계 분석 | Admin/Inst |
| | `POST` | `/api/v1/admin/words` | 신규 단어 등록 및 **S3 정적 오디오 사전 생성 트리거** | Admin/Inst |

---

## 3. 핵심 엔드포인트 상세 명세

### 1. 쾌속 정답 제출 & 암묵적 SM-2 자동 추론 API (핵심 엔진)
- **Endpoint**: `POST /api/v1/learning/submit-answer`
- **Description**: 정답 판정, 레벤슈타인 퍼지 매칭(오타 유예), 텔레메트리 기반 SM-2 자동 연산, EXP 지급, LLM 오답 피드백 조회를 단일 트랜잭션으로 초고속 처리
- **Header**: `Authorization: Bearer <token>`
- **Request Body**:
```json
{
  "wordId": 105,
  "userInput": "kubctl",
  "responseTimeSec": 3.2,
  "hintCount": 0,
  "typoCount": 0
}
```

- **Response (200 OK - Case 1: 레벤슈타인 80% 유사 오타 감지 시)**:
```json
{
  "status": 200,
  "data": {
    "resultType": "TYPO_WARNING",
    "isCorrect": false,
    "isTypo": true,
    "similarity": 0.857,
    "message": "앗, 오타인가요? 1글자가 빠졌어요! 다시 한번 확인해 보세요.",
    "allowRetry": true
  }
}
```

- **Response (200 OK - Case 2: 정답 및 암묵적 SM-2 자동 갱신 + 쾌속 넥스트)**:
```json
{
  "status": 200,
  "data": {
    "resultType": "CORRECT",
    "isCorrect": true,
    "correctTerm": "kubectl",
    "audioUrl": "https://cdn.skavoca.skala.ac.kr/audio/words/105_kubectl.mp3",
    "earnedXp": 20,
    "currentTotalXp": 1440,
    "inferredQuality": 5,
    "algorithmMetrics": {
      "repetitions": 3,
      "easinessFactor": 2.60,
      "intervalDays": 6,
      "nextPracticeDate": "2026-08-24T12:00:00Z"
    }
  }
}
```

- **Response (200 OK - Case 3: 오답 및 LLM 동적 피드백 제공)**:
```json
{
  "status": 200,
  "data": {
    "resultType": "INCORRECT",
    "isCorrect": false,
    "correctTerm": "war",
    "userInput": "tar",
    "earnedXp": 5,
    "inferredQuality": 0,
    "feedback": {
      "title": "war와 tar의 핵심 차이점 비교",
      "explanation": "입력하신 tar는 리눅스에서 단순 파일 아카이브 포맷이며, Tomcat과 같은 WAS에 웹 전체 애플리케이션을 배포할 때는 war를 사용해야 합니다.",
      "isAiGenerated": true
    },
    "audioUrl": "https://cdn.skavoca.skala.ac.kr/audio/words/72_war.mp3"
  }
}
```

---

### 2. SKALA 4기 주간 랭킹 리그전 조회 API
- **Endpoint**: `GET /api/v1/gamification/league?cohort=4`
- **Description**: SKALA 4기 동기들의 주간 획득 EXP 실시간 리더보드 및 리그 승급/강등 컷오프 조회
- **Response (200 OK)**:
```json
{
  "status": 200,
  "data": {
    "cohort": 4,
    "leagueTier": "GOLD",
    "weekEndDate": "2026-08-24T23:59:59Z",
    "myRank": 7,
    "myWeeklyXp": 1420,
    "promotionCutoffRank": 5,
    "demotionCutoffRank": 26,
    "leaderboard": [
      { "rank": 1, "nickname": "김코딩", "tier": "SENIOR", "weeklyXp": 2840, "streak": 14 },
      { "rank": 2, "nickname": "이파이", "tier": "JUNIOR", "weeklyXp": 2610, "streak": 9 },
      { "rank": 3, "nickname": "박스프링", "tier": "JUNIOR", "weeklyXp": 2400, "streak": 7 },
      { "rank": 7, "nickname": "홍길동(나)", "tier": "JUNIOR", "weeklyXp": 1420, "streak": 7 }
    ]
  }
}
```

---

### 3. 신규 단어 등록 및 S3 정적 오디오 사전 생성 API (교수자용)
- **Endpoint**: `POST /api/v1/admin/words`
- **Security**: `ROLE_INSTRUCTOR` 또는 `ROLE_ADMIN`
- **Description**: 단어 생성 시 백엔드가 Google Cloud TTS를 1회만 호출하여 `.mp3` 바이너리를 생성하고 AWS S3에 자동 업로드한 후 `audio_url`을 영구 보관
- **Request Body**:
```json
{
  "courseId": 8,
  "term": "kubectl",
  "pronunciationKr": "쿠브씨티엘 (Kube-control)",
  "pronunciationSsml": "<speak><phoneme alphabet=\"x-sampa\" ph=\"kjub-k@n-troUl\">kubectl</phoneme></speak>",
  "easyMeaning": "쿠버네티스 클러스터를 CLI 환경에서 명령어로 제어하는 공식 도구",
  "contextSentence": "쿠버네티스 환경에서 파드 목록을 조회하기 위해 [  ] get pods 명령어를 사용한다.",
  "difficulty": "HARD"
}
```
- **Response (201 Created)**:
```json
{
  "status": 201,
  "message": "단어 등록 및 S3 정적 오디오 캐싱 완료",
  "data": {
    "wordId": 105,
    "term": "kubectl",
    "audioUrl": "https://cdn.skavoca.skala.ac.kr/audio/words/105_kubectl.mp3"
  }
}
```
