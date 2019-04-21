DROP TABLE USERS cascade;
DROP TABLE ROLES cascade;
DROP TABLE USER_ROLE cascade;




CREATE TABLE USERS
(
    user_id     SERIAL primary key,
    user_role   int not null,
    user_name   varchar(100) not null,
    user_email  varchar(100) not null,
    user_firstname  varchar(100) not null,
    user_lastname   varchar(100) not null,
    user_password   varchar(100) not null

);

CREATE TABLE ROLES
(
    role_id integer primary key not null,
    role_name   varchar(30) not null,
    role_discription    varchar(30) not null
);

CREATE TABLE USER_ROLE
(
    user_id     int,
    role_id     integer not null,
    primary key(user_id, role_id),
    foreign key(user_id) references USERS(user_id),
    foreign key(role_id) references ROLES(role_id)
);

INSERT INTO ROLES(role_id, role_name, role_description) values
    (1, 'admin', 'parent'),
    (2, 'user', 'child');