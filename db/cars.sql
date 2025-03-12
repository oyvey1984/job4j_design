create table car_bodies (
id serial primary key,
name varchar(255)
);

create table car_engines (
id serial primary key,
name varchar(255)
);

create table car_transmissions (
id serial primary key,
name varchar(255)
);

create table cars (
id serial primary key,
name varchar(255),
body_id int references car_bodies(id),
engine_id int references car_engines(id),
transmission_id int references car_transmissions(id)
);

INSERT INTO car_bodies (name) VALUES
('Sedan'),
('Hatchback'),
('SUV'),
('Coupe'),
('Convertible'),
('PickUp');

INSERT INTO car_engines (name) VALUES
('Gasoline 1.6L'),
('Diesel 2.0L'),
('Electric'),
('Hybrid'),
('Gasoline 2.5L');

INSERT INTO car_transmissions (name) VALUES
('Manual'),
('Automatic'),
('CVT'),
('Dual-Clutch'),
('Semi-Automatic');

INSERT INTO cars (name, body_id, engine_id, transmission_id) VALUES
('Toyota Camry', 1, 1, 2),
('Ford Focus', 2, 1, 1),
('Tesla Model S', 1, 3, 2),
('BMW X5', 3, 2, 2),
('Audi A5', 4, 5, 4),
('Hyundai Solaris', 1, null, 2);

SELECT c.name AS car_name, cb.name AS body, ce.name AS engine, ct.name AS transmission
FROM cars c
left join car_bodies cb ON c.body_id = cb.id
left join car_engines ce ON c.engine_id = ce.id
left join car_transmissions ct ON c.transmission_id = ct.id;

SELECT cb.name
FROM car_bodies cb
LEFT JOIN cars c ON cb.id = c.body_id
WHERE c.id IS NULL;

SELECT ce.name
FROM car_engines ce
LEFT JOIN cars c ON ce.id = c.engine_id
WHERE c.id IS NULL;

SELECT ct.name
FROM car_transmissions ct
LEFT JOIN cars c ON ct.id = c.transmission_id
WHERE c.id IS NULL;

create view show_cars_with_automatic_transmissions
as
select c.name as car_name, ct.name as car_transmission, cb.name as car_bodie, ce.name as car_engine
from cars c
join car_transmissions ct on c.transmission_id = ct.id
join car_bodies cb on c.body_id = cb.id
join car_engines ce on c.engine_id = ce.id
where ct.name = 'Automatic'
order by c.name desc;

select * from show_cars_with_automatic_transmissions;

