INSERT INTO quiz (session_id)
VALUES ('abc'),
       ('cde'),
       ('def'),
       ('efg');

INSERT INTO question (question, quiz_id)
VALUES ('How are you?', 1),
       ('How much do you weight?', 1),
       ('How high are you?', 1);

INSERT INTO answer (answer_text, correct)
VALUES ('Fine, thank you', TRUE),
       ('Not so bad', FALSE),
       ('Could be better, nut thanks', FALSE),
       ('I am 1.8m tall', FALSE);
