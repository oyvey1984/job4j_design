CREATE TABLE author(
    id serial PRIMARY KEY,
    author_name VARCHAR(250)
);


CREATE TABLE book(
    id serial PRIMARY KEY,
    title VARCHAR(250)
);

CREATE TABLE book_authors(
    id serial PRIMARY KEY,
    author_id INT references author(id),
    book_id INT references book(id)
);