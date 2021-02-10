DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS quiz;

CREATE TABLE quiz
(
    quiz_id    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    session_id VARCHAR
);

-- Question is not connected to quiz directly, question will be rather random for the quiz
CREATE TABLE question
(
    question_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
--     quiz_id     INTEGER NOT NULL,
    question    VARCHAR
--     CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)
);

CREATE TABLE answer
(
    answer_id   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    answer_text VARCHAR,
    correct     BOOLEAN,
    question_id INTEGER,
    CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question (question_id)
);
