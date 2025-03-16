create table students (
    id int primary key,
    name varchar(50),
    age int,
    grade varchar(2)
);

insert into students (id, name, age, grade) values (1, '���� ������', 17, 'a');
insert into students (id, name, age, grade) values (2, '����� �������', 16, 'b');
insert into students (id, name, age, grade) values (3, '������� �������', 18, 'a');
insert into students (id, name, age, grade) values (4, '����� ���������', 17, 'c');
insert into students (id, name, age, grade) values (5, '������� ��������', 16, 'b');

insert into students (id, name, age, grade) values (6, '��������� ������', 15, 'd');
delete from students where age = 18;

begin transaction isolation level serializable;

update students set grade = 'a' where name = '����� �������';
update students set grade = 'd' where name = '���� ������;