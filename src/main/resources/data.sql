INSERT INTO quiz (session_id)
VALUES ('abc'),
       ('cde'),
       ('def'),
       ('efg');

INSERT INTO question (question, tip_eng, tip_pl)
VALUES ('How are you?', 'I dont have anything special for you', 'Radź sobie sam!'),
       ('How much do you weight?', null, null),
       ('How high are you?', null, null),
       ('What are the odds?', null, null);

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

INSERT INTO subscription (name, email, active)
VALUES ('Tom', 'tpalucki@gmail.com', true);