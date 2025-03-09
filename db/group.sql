create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices (name, price) values ('Гаечный ключ', 131.5), ('Плоскогубцы', 356.9), ('Отвёртка', 271.3);

insert into people (name) values ('Иван'), ('Михаил'), ('Артур');

insert into devices_people (device_id, people_id) values (1, 1), (1, 2), (2, 2), (2, 3), (3, 3), (3, 1);

select avg(price) from devices;

select people.name, avg(devices.price)
from people
inner join devices_people on people.id = devices_people.people_id
inner join devices on devices.id = devices_people.device_id
group by people.name
having avg(devices.price) > 202;