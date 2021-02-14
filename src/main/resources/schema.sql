DROP TABLE IF EXISTS quiz_to_questions;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS user_answer;
DROP TABLE IF EXISTS subscription;

-- Question is not connected to quiz directly, question will be rather random for the quiz
CREATE TABLE question
(
    question_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    question    VARCHAR,
    tip_pl      VARCHAR,
    tip_eng     VARCHAR,
    level       VARCHAR,
    topic       VARCHAR
);

CREATE TABLE answer
(
    answer_id   INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    answer_text VARCHAR,
    correct     BOOLEAN,
    question_id INTEGER,
    CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question (question_id)
);


CREATE TABLE quiz
(
    quiz_id    INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    session_id VARCHAR
);

CREATE TABLE quiz_to_questions
(
    quiz_to_questions_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    quiz_id              INTEGER NOT NULL,
    question_id          INTEGER NOT NULL,
    CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question (question_id),
    CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)
);


CREATE TABLE user_answer
(
    user_answer_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    quiz_id        INTEGER,
    session_id     VARCHAR,
    question_id    INTEGER,
    question_text  VARCHAR,
    answer_id      INTEGER,
    answer_text    VARCHAR,
    correct        BOOLEAN
);

CREATE TABLE subscription
(
    subscription_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name            VARCHAR,
    email           VARCHAR,
    active          BOOLEAN
)