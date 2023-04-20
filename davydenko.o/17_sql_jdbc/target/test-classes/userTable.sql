create table IF NOT EXISTS role (
id LONG AUTO_INCREMENT primary key not null,
name varchar(50)
);


create table IF NOT EXISTS user (
id LONG AUTO_INCREMENT primary key not null,
login varchar(50),
password varchar(50),
email varchar(50),
firstName varchar(50),
lastName varchar(50),
birthday date,
roleID LONG,
CONSTRAINT fk_user_roleID foreign key (roleID) references role(id)
);

INSERT INTO role VALUES  (1, 'Admin');
INSERT INTO role VALUES  (2, 'Client');
INSERT INTO role VALUES  (3, 'Moderator');

INSERT INTO user VALUES  (1, 'aaaa', '1111', 'com@', 'nik1', 'lastN1', '2020-11-11', 1);
INSERT INTO user VALUES  (2, 'bbbb', '2222', '@com', 'nik2', 'lastN2', '2020-10-11', 2);
INSERT INTO user VALUES  (3, 'cccc', '3333', 'com@gmail', 'nik3', 'lastN3', '2020-11-10', 3);