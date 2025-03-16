create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create
or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5
        AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();

insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);

alter table products disable trigger discount_trigger;

drop trigger discount_trigger on products;

create
or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted)
        and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

create
or replace function surtax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.18
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger surtax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure surtax();

insert into products (name, producer, count, price)
VALUES ('product_4', 'producer_1', 7, 100);

create
or replace function surfax2()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.18
        where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger surtax_trigger2
    before insert
    on products
    for each row
    execute procedure surfax2();

insert into products (name, producer, count, price)
VALUES ('product_5', 'producer_1', 70, 1000);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create
or replace function history_of_price_function()
    returns trigger as
$$
    BEGIN
		insert into history_of_price (name, price, date)
		values (NEW.name, new.price, now());
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger history
    before insert
    on products
    for each row
    execute procedure history_of_price_function();

insert into products (name, producer, count, price)
VALUES ('product_6', 'producer_1', 700, 10000);

create
or replace procedure delete_data(tax float, u_id integer)
language 'plpgsql'
as $$
    BEGIN
        if
            tax > 50 THEN
			delete from products where id = u_id;
        end if;
    END;
$$;

call delete_data(51, 6);

create
or replace function f_delete_data(tax float, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
        if tax > 70 THEN
			delete from products
			where id = u_id;
			select into result sum(count)
			from products;
        end if;
        return result;
    end;
$$;

select f_delete_data(71, 4);