DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;

create table role (
 id IDENTITY,
name varchar(50)
);

create table user (
id IDENTITY,
login varchar(50),
password varchar(50),
email varchar(50),
firstName varchar(50),
lastName varchar(50),
birthday date,
roleID LONG,
FOREIGN KEY (roleID) REFERENCES role (id)
);


