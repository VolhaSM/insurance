# create schema if not exists insurance;
create table insurance_client
(
    id         integer not null,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);
create table insurance_client_police
(
    insurance_client_id integer not null,
    police_id           integer not null
);
create table personal_policy
(
    id                  integer not null,
    client_id           integer,
    coverage_type       integer,
    object_of_insurance varchar(255),
    short_description   varchar(255),
    primary key (id)
);
insert into insurance.insurance_client
values (1, 'ivan', 'petrov');
insert into insurance.insurance_client
values (2, 'petr', 'petrov');
insert into insurance.insurance_client
values (3, 'sidr', 'petrov');
insert into insurance.personal_policy
values (1, 1, 0, 'car', 'insurance of a car');
insert into insurance.personal_policy
values (2, 2, 0, 'car', 'insurance of a car');
insert into insurance.personal_policy
values (3, 3, 0, 'car', 'insurance of a car');
insert into insurance.personal_policy
values (4, 1, 0, 'home', 'insurance of a home');
insert into insurance.personal_policy
values (5, 2, 0, 'home', 'insurance of a home');
insert into insurance.personal_policy
values (6, 3, 0, 'home', 'insurance of a home');
insert into insurance.insurance_client_police
values (1, 1);
insert into insurance.insurance_client_police
values (2, 2);
insert into insurance.insurance_client_police
values (3, 3);
insert into insurance.insurance_client_police
values (1, 4);
insert into insurance.insurance_client_police
values (2, 5);
insert into insurance.insurance_client_police
values (3, 6);