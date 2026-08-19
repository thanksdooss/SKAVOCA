# 🥑 [SKAVOCA] DBeaver 데이터베이스 연동 및 관리 가이드

본 가이드는 **DBeaver**를 활용하여 SKAVOCA의 **270선 마스터 어휘, 9대 커리큘럼, 암묵적 SM-2 텔레메트리 로그, 주간 리그 데이터**를 시각적으로 관리하고 질의하는 절차를 설명합니다.

---

## 📁 데이터베이스 스크립트 파일 구성

1. [`schema.sql`](file:///Users/jin/Desktop/SKAVOCA/database/schema.sql): 7개 핵심 테이블 DDL (PostgreSQL, MySQL, SQLite, Supabase 호환)
2. [`seed_data.sql`](file:///Users/jin/Desktop/SKAVOCA/database/seed_data.sql): 9개 과목 메타데이터 + **270개 전수 어휘** + 540+개 혼동 오답 해설 + 데모 유저

---

## 🚀 DBeaver 연동 및 실행 3단계

### 1단계: DBeaver에서 데이터베이스 연결 생성
1. DBeaver 실행 후 좌측 상단 **[새 데이터베이스 연결(플러그 아이콘)]** 클릭
2. 대상 DB 선택:
   - **로컬 테스트 추천**: `SQLite` (파일 경로만 지정하여 즉시 구동 가능)
   - **프로덕션/클라우드 추천**: `PostgreSQL` / `Supabase` / `MySQL 8.0`
3. 연결 테스트(Test Connection) 완료 후 **[완료]** 클릭

### 2단계: 스키마 및 시딩 데이터 일괄 실행
1. DBeaver 상단 메뉴 **[SQL 편집기]** ➔ **[새 SQL 편집기]** 열기
2. [`schema.sql`](file:///Users/jin/Desktop/SKAVOCA/database/schema.sql) 파일 내용을 복사하여 붙여넣고 **`Ctrl + Alt + X` (전체 실행)**
   - `USERS`, `CURRICULUM_COURSES`, `WORDS`, `CONFUSING_DISTRACTORS`, `USER_PROGRESS`, `REVIEW_LOGS`, `WEEKLY_LEAGUE` 7개 테이블 생성 완료
3. [`seed_data.sql`](file:///Users/jin/Desktop/SKAVOCA/database/seed_data.sql) 파일 내용을 붙여넣고 **`Ctrl + Alt + X` (전체 실행)**
   - 270개 어휘 및 교재 정밀 오답 피드백 딕셔너리 전수 삽입 완료

---

## 📊 실무 유용한 DBeaver 분석 SQL 쿼리 모음

### ① 과목별 등록 단어 및 난이도 통계
```sql
SELECT 
    c.course_name AS "과목명",
    COUNT(w.word_id) AS "총 단어수",
    COUNT(CASE WHEN w.difficulty = 'EASY' THEN 1 END) AS "EASY",
    COUNT(CASE WHEN w.difficulty = 'MEDIUM' THEN 1 END) AS "MEDIUM",
    COUNT(CASE WHEN w.difficulty = 'HARD' THEN 1 END) AS "HARD"
FROM CURRICULUM_COURSES c
JOIN WORDS w ON c.course_id = w.course_id
GROUP BY c.course_id, c.course_name
ORDER BY c.course_id;
```

### ② SKALA 4기 취약 단어 Top 10 (교수자 대시보드 연동용)
```sql
SELECT 
    w.term AS "어휘 원형",
    c.course_name AS "과목",
    COUNT(r.log_id) AS "오답 시도 횟수",
    ROUND(AVG(r.response_time_sec)::numeric, 2) AS "평균 반응시간(초)",
    ROUND(AVG(r.calculated_ef)::numeric, 2) AS "평균 EF(망각계수)"
FROM REVIEW_LOGS r
JOIN WORDS w ON r.word_id = w.word_id
JOIN CURRICULUM_COURSES c ON w.course_id = c.course_id
WHERE r.inferred_quality < 3
GROUP BY w.word_id, w.term, c.course_name
ORDER BY "오답 시도 횟수" DESC
LIMIT 10;
```

### ③ 오늘 복습해야 할 망각 임계 단어 조회 (SM-2 SRS)
```sql
SELECT 
    u.nickname,
    w.term,
    p.repetitions AS "연속 정답",
    p.interval_days AS "복습 주기(일)",
    p.next_practice_date AS "복습 예정일"
FROM USER_PROGRESS p
JOIN USERS u ON p.user_id = u.user_id
JOIN WORDS w ON p.word_id = w.word_id
WHERE p.next_practice_date <= CURRENT_TIMESTAMP
ORDER BY p.next_practice_date ASC;
```

---

## 🌐 Vercel 1분 배포 가이드

1. **GitHub Repository에 푸시**:
   ```bash
   git add .
   git commit -m "feat: SKAVOCA full release with DBeaver DB & Vercel config"
   git push origin main
   ```
2. **Vercel 콘솔 연동**:
   - [Vercel](https://vercel.com) 로그인 ➔ **[Add New Project]**
   - GitHub 저장소 선택 후 **Root Directory**를 `./app` 또는 루트로 지정
   - **[Deploy]** 버튼 클릭 ➔ 30초 내 글로벌 CDN 실서비스 배포 완료!
