insert into role SET name = 'admin';
insert into role SET name = 'user';


insert into user (login, password, email, firstName, lastName, birthday, roleId)
 VALUES ('admin', 'admin', 'admin@gmail', 'Alexandr', 'adminLN','2000-10-10', 1);
insert into user (login, password,email, firstName, lastName, birthday, roleId)
 VALUES ('user', 'user', 'user@gmail', 'Vasia','userLN','1999-11-11', 2);
insert into user (login, password, email, firstName, lastName, birthday, roleId)
 VALUES ('some', 'pass', 'some@gmail','someN','someLN', '2010-10-10', 1);
