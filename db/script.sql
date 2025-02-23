CREATE TABLE book(
    book_id serial PRIMARY KEY,
    title VARCHAR(50),
    price DECIMAL(8,2),
    amount INT
);

insert into book(title, price, amount)
values
('Мастер и Маргарита', 150.0, 10),
('Белая гвардия', 100.50, 20);

update book set title = 'Братья Карамазовы'
where amount <> 10;

delete from book;

select * from book;