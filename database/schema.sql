-- ==========================================================
-- SKAVOCA (SKALA VOCA) Master Database DDL Schema
-- Compatible with: PostgreSQL, MySQL 8.0+, SQLite 3, Supabase
-- ==========================================================

DROP TABLE IF EXISTS REVIEW_LOGS;
DROP TABLE IF EXISTS USER_PROGRESS;
DROP TABLE IF EXISTS WEEKLY_LEAGUE;
DROP TABLE IF EXISTS CONFUSING_DISTRACTORS;
DROP TABLE IF EXISTS WORDS;
DROP TABLE IF EXISTS CURRICULUM_COURSES;
DROP TABLE IF EXISTS USERS;

-- 1. USERS: 회원 및 게이미피케이션 프로필
CREATE TABLE USERS (
    user_id BIGINT PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    role VARCHAR(20) DEFAULT 'ROLE_STUDENT', -- ROLE_STUDENT, ROLE_INSTRUCTOR
    cohort INT DEFAULT 4,
    xp BIGINT DEFAULT 0,
    tier VARCHAR(50) DEFAULT '코딩 노비',
    streak_days INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. CURRICULUM_COURSES: SKALA 9대 정규 커리큘럼 과목
CREATE TABLE CURRICULUM_COURSES (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    icon VARCHAR(20),
    color VARCHAR(20),
    order_index INT NOT NULL
);

-- 3. WORDS: 270선 핵심 IT 어휘 마스터 테이블
CREATE TABLE WORDS (
    word_id BIGINT PRIMARY KEY,
    course_id INT NOT NULL REFERENCES CURRICULUM_COURSES(course_id) ON DELETE CASCADE,
    term VARCHAR(100) NOT NULL,
    full_term VARCHAR(200),
    pronunciation_kr VARCHAR(100),
    pronunciation_ssml TEXT,
    easy_meaning TEXT NOT NULL,
    context_sentence TEXT NOT NULL,
    difficulty VARCHAR(20) DEFAULT 'MEDIUM',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. CONFUSING_DISTRACTORS: 혼동 오답 비교 분석 피드백 딕셔너리
CREATE TABLE CONFUSING_DISTRACTORS (
    distractor_id BIGINT PRIMARY KEY,
    word_id BIGINT NOT NULL REFERENCES WORDS(word_id) ON DELETE CASCADE,
    wrong_input VARCHAR(100) NOT NULL,
    feedback_explanation TEXT NOT NULL,
    is_ai_generated BOOLEAN DEFAULT FALSE
);

-- 5. USER_PROGRESS: 사용자별 단어 망각 곡선 (SM-2 SRS 스케줄링)
CREATE TABLE USER_PROGRESS (
    progress_id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES USERS(user_id) ON DELETE CASCADE,
    word_id BIGINT NOT NULL REFERENCES WORDS(word_id) ON DELETE CASCADE,
    repetitions INT DEFAULT 0,
    interval_days INT DEFAULT 1,
    easiness_factor FLOAT DEFAULT 2.5,
    next_practice_date TIMESTAMP NOT NULL,
    last_reviewed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_reviews INT DEFAULT 0,
    total_lapses INT DEFAULT 0,
    CONSTRAINT uq_user_word UNIQUE (user_id, word_id)
);

-- 6. REVIEW_LOGS: 암묵적 텔레메트리 학습 이력 로그
CREATE TABLE REVIEW_LOGS (
    log_id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES USERS(user_id),
    word_id BIGINT NOT NULL REFERENCES WORDS(word_id),
    inferred_quality INT NOT NULL, -- 0 (Again) ~ 5 (Perfect)
    response_time_sec FLOAT NOT NULL,
    hint_count INT DEFAULT 0,
    typo_count INT DEFAULT 0,
    calculated_ef FLOAT NOT NULL,
    review_interval INT NOT NULL,
    reviewed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 7. WEEKLY_LEAGUE: 기수별 주간 랭킹 리그
CREATE TABLE WEEKLY_LEAGUE (
    league_id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES USERS(user_id) ON DELETE CASCADE,
    cohort INT DEFAULT 4,
    league_tier VARCHAR(50) DEFAULT '골드 리그',
    weekly_xp INT DEFAULT 0,
    rank_position INT DEFAULT 1,
    week_start_date DATE NOT NULL
);

-- 인덱스 설계
CREATE INDEX idx_words_course ON WORDS(course_id);
CREATE INDEX idx_progress_schedule ON USER_PROGRESS(user_id, next_practice_date);
CREATE INDEX idx_logs_user_date ON REVIEW_LOGS(user_id, reviewed_at);
