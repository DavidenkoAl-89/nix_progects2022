create table IF NOT EXISTS role (
id LONG AUTO_INCREMENT primary key not null,
name varchar(50)
);


INSERT INTO role VALUES  (1, 'Admin');
INSERT INTO role VALUES  (2, 'Client');
INSERT INTO role VALUES  (3, 'Moderator');


