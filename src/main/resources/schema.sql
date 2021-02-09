DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS quiz;

CREATE TABLE quiz
(
    quiz_id    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    session_id VARCHAR
);

CREATE TABLE question
(
    question_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    quiz_id     INTEGER NOT NULL,
    question    VARCHAR,
    CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)
);

CREATE TABLE answer
(
    answer_id   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    answer_text VARCHAR,
    correct     BOOLEAN
);
