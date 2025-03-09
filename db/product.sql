CREATE TABLE type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type_id INT REFERENCES type(id),
    expired_date DATE,
    price FLOAT
);

INSERT INTO type (name) VALUES
('���'),
('������'),
('���������'),
('����');

INSERT INTO product (name, type_id, expired_date, price) VALUES
('��� ����������', 1, '2023-12-31', 500.0),
('��� �����', 1, '2023-11-15', 700.0),
('������ ����� � �������', 2, '2023-10-20', 100.0),
('��������� �������', 3, '2023-09-30', 50.0),
('��������� ������', 3, '2023-10-15', 70.0),
('���� �����������', 4, '2023-10-05', 80.0),
('���� ��������', 4, '2025-05-05', 76.0),
('���� �������', 4, '2025-05-06', 700.0);

select product.name
from product inner join type
on product.type_id = type.id
where type.name = '���';

select * from product
where name ILIKE '%���������%';

select * from product
where expired_date < CURRENT_DATE;

SELECT p.name AS product_name, p.price, t.name AS type_name
FROM product p INNER JOIN type t
ON p.type_id = t.id
WHERE p.price = (SELECT MAX(price) FROM product);

select t.name as ���_����, count(p.type_id) as ����������
from product p inner join type t
on p.type_id = t.id
group by t.name;

select *
from product inner join type
on product.type_id = type.id
where type.name = '���' or type.name = '������';

select t.name as type_name, count(p.id) AS product_count
from type t
inner join product p on t.id = p.type_id
group by t.id
having count(p.id) < 10;

SELECT p.name, t.name
FROM product p INNER JOIN type t
ON p.type_id = t.id;

