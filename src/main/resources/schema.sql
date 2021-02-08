DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS quiz_question;

CREATE TABLE quiz
(
    quiz_id    SERIAL PRIMARY KEY NOT NULL,
    session_id VARCHAR
);

CREATE TABLE question
(
    question_id SERIAL PRIMARY KEY NOT NULL,
    question    VARCHAR
);

CREATE TABLE answer
(
    answer_id   SERIAL PRIMARY KEY NOT NULL,
    answer_text VARCHAR,
    correct     BOOLEAN
);

-- joining tables

CREATE TABLE quiz_question
(
    quiz_question_id SERIAL PRIMARY KEY NOT NULL,
    quiz_id          INTEGER,
    question_id      INTEGER
);