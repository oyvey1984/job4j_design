CREATE TABLE teens (
    id serial primary key,
    name varchar(255),
    gender varchar(10)
);

INSERT INTO teens (name, gender) VALUES
('Вася', 'Мужской'),
('Маша', 'Женский'),
('Петя', 'Мужской'),
('Оля', 'Женский'),
('Коля', 'Мужской'),
('Аня', 'Женский');

SELECT
    t1.name AS name1,
    t2.name AS name2
FROM
    teens t1
CROSS JOIN
    teens t2
WHERE
    t1.gender <> t2.gender AND t1.id < t2.id;