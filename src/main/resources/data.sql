INSERT INTO quiz (session_id)
VALUES ('abc'),
       ('cde'),
       ('def'),
       ('efg');

INSERT INTO question (question)
VALUES ('How are you?'),
       ('How much do you weight?'),
       ('How high are you?'),
       ('What are the odds?');

INSERT INTO answer (answer_text, correct, question_id)
VALUES ('Fine, thank you', TRUE, 1),
       ('Not so bad', FALSE, 1),
       ('100 kg', TRUE, 2),
       ('I dont know', FALSE, 2);

INSERT INTO quiz_to_questions (quiz_id, question_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4);


-- INSERT INTO quiz_to_questions (quiz_id, question_id)
-- VALUES (1, 1),
--        (1, 2),
--        (1, 3),
--        (1, 4);
