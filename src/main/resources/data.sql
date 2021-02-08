INSERT INTO quiz (session_id)
VALUES ('abc'),
       ('cde'),
       ('def'),
       ('efg');

INSERT INTO question (question)
VALUES ('How are you?');

INSERT INTO answer (answer_text, correct)
VALUES ('Fine, thank you', true),
       ('Not so bad', false),
       ('Could be better, nut thanks', false);