INSERT INTO role SET name = 'admin';
INSERT INTO role SET name = 'user';


insert into user (login, password, email, firstName, lastName, birthday, roleID) VALUES ('admin', 'admin', 'admin@gmail', 'Alexandr', 'adminLN','2000-10-10', 1);
insert into user (login, password, email, firstName, lastName, birthday, roleID) VALUES ('user', 'user', 'user@gmail', 'Vasia','userLN','1999-11-11', 2);


