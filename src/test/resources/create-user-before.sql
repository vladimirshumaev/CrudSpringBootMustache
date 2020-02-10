delete FROM user_role;
delete FROM usr;

insert into usr(id, active, password, username) values
(1, true, '123' , 'dron'),
(2, true, '123' , 'serj');

insert into user_role(user_id, roles) values
(1, 'USER'), (1, 'ADMIN'),
(2, 'USER');