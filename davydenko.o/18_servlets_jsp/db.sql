drop table IF EXISTS user;
drop table IF EXISTS role;


create table role (
 id IDENTITY,
name varchar(50)
);

create table user (
id ,
login varchar(50),
password varchar(50),
email varchar(50),
firstName varchar(50),
lastName varchar(50),
birthday date,
roleID LONG,
FOREIGN KEY (roleID) REFERENCES role (id)
);

insert into role SET name = 'admin';
insert into role SET name = 'user';


insert into user (login, password, email, firstName, lastName, birthday, roleId)
 VALUES ('admin', 'admin', 'admin@gmail', 'Alexandr', 'adminLN','2000-10-10', 1);
insert into user (login, password,email, firstName, lastName, birthday, roleId)
 VALUES ('user', 'user', 'user@gmail', 'Vasia','userLN','1999-11-11', 2);

