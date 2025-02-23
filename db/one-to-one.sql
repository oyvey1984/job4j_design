CREATE TABLE country(
    id serial PRIMARY KEY,
    country_name VARCHAR(250)
);


CREATE TABLE president(
    id serial PRIMARY KEY,
    president_name VARCHAR(250),
    country_id INT references country(id) unique
);