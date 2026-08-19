ALTER TABLE words
  ADD COLUMN IF NOT EXISTS is_active BOOLEAN NOT NULL DEFAULT TRUE,
  ADD COLUMN IF NOT EXISTS deleted_at TIMESTAMP NULL,
  ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP NOT NULL DEFAULT NOW();

CREATE TABLE IF NOT EXISTS course_words_map (
    id BIGSERIAL PRIMARY KEY,
    curriculum_course_id BIGINT NOT NULL REFERENCES curriculum_courses(course_id) ON DELETE RESTRICT,
    word_id BIGINT NOT NULL REFERENCES words(word_id) ON DELETE RESTRICT,
    sort_order INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE(curriculum_course_id, word_id)
);

INSERT INTO course_words_map (curriculum_course_id, word_id, sort_order)
SELECT course_id, word_id, ROW_NUMBER() OVER (PARTITION BY course_id ORDER BY word_id) - 1
FROM words
ON CONFLICT (curriculum_course_id, word_id) DO NOTHING;

ALTER TABLE confusing_distractors DROP CONSTRAINT IF EXISTS confusing_distractors_word_id_fkey;
ALTER TABLE confusing_distractors ADD CONSTRAINT confusing_distractors_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(word_id) ON DELETE RESTRICT;

ALTER TABLE user_progress DROP CONSTRAINT IF EXISTS user_progress_word_id_fkey;
ALTER TABLE user_progress ADD CONSTRAINT user_progress_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(word_id) ON DELETE RESTRICT;

ALTER TABLE users 
  ADD COLUMN IF NOT EXISTS last_login_at TIMESTAMP NULL,
  ADD COLUMN IF NOT EXISTS login_fail_count INTEGER NOT NULL DEFAULT 0,
  ADD COLUMN IF NOT EXISTS lockout_until TIMESTAMP NULL,
  ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP NOT NULL DEFAULT NOW();

ALTER TABLE review_logs
  ADD COLUMN IF NOT EXISTS is_correct BOOLEAN NOT NULL DEFAULT TRUE,
  ADD COLUMN IF NOT EXISTS xp_earned INTEGER NOT NULL DEFAULT 0;

ALTER TABLE user_progress
  ADD COLUMN IF NOT EXISTS quality INTEGER NULL,
  ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP NOT NULL DEFAULT NOW();

-- Handle curriculum_courses updates safely
ALTER TABLE curriculum_courses
  ADD COLUMN IF NOT EXISTS course_code VARCHAR(30) NULL,
  ADD COLUMN IF NOT EXISTS description TEXT NULL,
  ADD COLUMN IF NOT EXISTS is_active BOOLEAN NOT NULL DEFAULT TRUE;
  
UPDATE curriculum_courses SET course_code = 'COURSE_' || course_id WHERE course_code IS NULL;

ALTER TABLE curriculum_courses ALTER COLUMN course_code SET NOT NULL;
ALTER TABLE curriculum_courses DROP CONSTRAINT IF EXISTS curriculum_courses_course_code_key;
ALTER TABLE curriculum_courses ADD CONSTRAINT curriculum_courses_course_code_key UNIQUE(course_code);

