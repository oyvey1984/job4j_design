CREATE TABLE roles(
    id serial PRIMARY KEY,
    roles_title text
);

CREATE TABLE rules(
    id serial PRIMARY KEY,
    rule text
);

CREATE TABLE rules_role(
    id serial PRIMARY KEY,
    rule_id int references rules(id),
    role_id int references roles(id)
);

CREATE TABLE users(
    id serial PRIMARY KEY,
    user_name text,
    roles_id int references roles(id)
);

CREATE TABLE states(
    id serial PRIMARY KEY,
    items_status text
);

CREATE TABLE categories(
    id serial PRIMARY KEY,
    category_item text
);

CREATE TABLE items(
    id serial PRIMARY KEY,
    items_name text,
    user_id int references users(id),
    categories_id int references categories(id),
    states_id int references states(id)
);

CREATE TABLE comments(
    id serial PRIMARY KEY,
    comments_text text,
    items_id int references items(id)
);

CREATE TABLE attachs(
    id serial PRIMARY KEY,
    files text,
    items_id int references items(id)
);




