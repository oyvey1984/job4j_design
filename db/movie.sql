CREATE TABLE movie
(
    id       SERIAL PRIMARY KEY,
    name     text,
    director text
);

CREATE TABLE book
(
    id     SERIAL PRIMARY KEY,
    title  text,
    author text
);

INSERT INTO movie (name, director)
VALUES ('���������', '����� �����'),
       ('�������', '������ ��������'),
       ('��������� �����', '����� �������'),
       ('����� ������ � ����� ��������', '�������� ������'),
       ('�������� �������', '���� �����');

INSERT INTO book (title, author)
VALUES ('����� ������ � ����� ��������', '����� �������'),
       ('��������� �����', '���� ������'),
       ('1984', '������ ������'),
       ('���������', '���� ���'),
       ('������������ �������', '����� ��������');

select name
from movie
INTERSECT
select title
from book;

select title
from book
EXCEPT
select name
from movie;

select title
from book
EXCEPT
select name
from movie
UNION ALL
(select name
from movie
EXCEPT
select title
from book);