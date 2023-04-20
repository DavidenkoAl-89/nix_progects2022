drop table IF EXISTS user;
drop table IF EXISTS role;

create table role (
 id LONG AUTO_INCREMENT,
name varchar(50)
);

create table user (
id LONG AUTO_INCREMENT,
login varchar(50),
password varchar(50),
email varchar(50),
firstName varchar(50),
lastName varchar(50),
birthday date,
roleID LONG,
FOREIGN KEY (roleID) REFERENCES role (id)
);


