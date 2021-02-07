DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer;

CREATE TABLE quiz
(
    quiz_id   SERIAL PRIMARY KEY NOT NULL,
    sessionId VARCHAR
);

CREATE TABLE question
(
    task_id  SERIAL PRIMARY KEY NOT NULL,
    question VARCHAR
);

CREATE TABLE answer
(
    answer_id   SERIAL PRIMARY KEY NOT NULL,
    answer_text VARCHAR,
    correct     BOOLEAN
)