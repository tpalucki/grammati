INSERT INTO quiz (session_id)
VALUES ('abc'),
       ('cde'),
       ('def'),
       ('efg');

INSERT INTO question (question, tip_eng, tip_pl, level)
VALUES ('How are you?', 'I dont have anything special for you', 'Radź sobie sam!', 'A1'),
       ('How much do you weight?', null, null, 'A1'),
       ('How high are you?', null, null, 'A1'),
       ('What are the odds?', null, null, 'A1');

INSERT INTO answer (answer_text, correct, question_id)
VALUES ('Fine, thank you', TRUE, 1),
       ('Not so bad', FALSE, 1),
       ('100 kg', TRUE, 2),
       ('I dont know', FALSE, 2),
       ('1.8m tall', TRUE, 3),
       ('I dont remember', FALSE, 3),
       ('50% / 50%', FALSE, 4),
       ('100%', FALSE, 4),
       ('0% in my opinion', FALSE, 4),
       ('None of the above', TRUE, 4);

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