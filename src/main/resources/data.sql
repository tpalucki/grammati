INSERT INTO quiz (session_id)
VALUES ('abc'),
       ('cde'),
       ('def'),
       ('efg');

INSERT INTO question (question)
VALUES ('How are you?'),
       ('How much do you weight?'),
       ('How high are you?');

INSERT INTO answer (answer_text, correct, question_id)
VALUES ('Fine, thank you', TRUE, 1),
       ('Not so bad', FALSE, 1),
       ('Could be better, nut thanks', FALSE, 1),
       ('I am 1.8m tall', FALSE, 1);
