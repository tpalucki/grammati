
CREATE TABLE IF NOT EXISTS quiz (
    quiz_id SERIAL,
    reference VARCHAR,
    PRIMARY KEY quiz_id
)

CREATE TABLE IF NOT EXISTS task {
    task_id SERIAL,
    quiz_id INTEGER
    question VARCHAR,
    PRIMARY KEY task_id,
    FOREIGN KEY references quiz.quiz_id
}