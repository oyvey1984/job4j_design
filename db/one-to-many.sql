CREATE TABLE song(
    id serial PRIMARY KEY,
    song VARCHAR(250)
);


CREATE TABLE album(
    id serial PRIMARY KEY,
    title VARCHAR(250),
    song_id INT references song(id)
);