create table departments (
id serial primary key,
name varchar(255)
);

create table employees (
id serial primary key,
name varchar(255),
department_id int references departments(id)
);

INSERT INTO departments (name) VALUES
('Отдел разработки'),
('Отдел маркетинга'),
('Отдел продаж'),
('Отдел поддержки'),
('Отдел кадров')
('Юридический отдел');

INSERT INTO employees (name, department_id) VALUES
('Иван Иванов', 1),
('Петр Петров', 1),
('Сидор Сидоров', 2),
('Мария Кузнецова', 3),
('Алексей Алексеев', 4),
('Ольга Ольгова', 5),
('Николай Николаев', 2),
('Елена Еленова', 3),
('Дмитрий Дмитриев', 4),
('Анна Аннова', 5)
('Григорий Гришин', null);

select * from departments
left join employees
on departments.id = employees.department_id;

select * from departments
right join employees
on departments.id = employees.department_id;

select * from departments
full join employees
on departments.id = employees.department_id;

select * from departments
cross join employees;

select * from departments
left join employees
on departments.id = employees.department_id
where employees.department_id is null;

SELECT
    e.id AS employee_id,
    e.name AS employee_name,
    d.id AS department_id,
    d.name AS department_name
FROM
    employees e
LEFT JOIN
    departments d ON e.department_id = d.id;

SELECT
    e.id AS employee_id,
    e.name AS employee_name,
    d.id AS department_id,
    d.name AS department_name
FROM
    departments d
RIGHT JOIN
    employees e ON e.department_id = d.id;