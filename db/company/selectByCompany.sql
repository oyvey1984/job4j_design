CREATE TABLE company
(
    id integer NOT NULL,
    name varchar(255),
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name varchar(255),
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name) VALUES
(1, 'Google'),
(2, 'Amazon'),
(3, 'Microsoft'),
(4, 'Apple'),
(5, 'Netflix');

INSERT INTO person (id, name, company_id) VALUES
(1, 'Alice', 1),
(2, 'Bob', 2),
(3, 'Charlie', 3),
(4, 'Diana', 1),
(5, 'Eve', NULL),
(6, 'Frank', 4),
(7, 'Grace', 5),
(8, 'Heidi', 2),
(9, 'Ivan', 3),
(10, 'Judy', 4);

select p.name, c.name
from person p
left join company c on p.company_id = c.id
where p.company_id is distinct from 5;



select c.name as Название, count(p.company_id) as Количество
from person p
left join company c on p.company_id = c.id
group by c.name
having count(p.company_id) = (select max(cnt)
from
(select company_id, count(*) as cnt
from person
group by company_id));

