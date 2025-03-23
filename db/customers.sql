CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

INSERT INTO customers (first_name, last_name, age, country)
VALUES
    ('����', '������', 30, '������'),
    ('�����', '�������', 25, '��������'),
    ('�������', '�������', 40, '���������'),
    ('�����', '���������', 35, '������'),
    ('�������', '�������', 28, '�������');

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders (amount, customer_id)
VALUES
    (100, 1),
    (200, 2),
    (150, 3),
    (300, 1),
    (250, 4);

select * from customers
where customers.id NOT IN (select customer_id from orders);