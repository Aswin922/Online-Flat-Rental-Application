drop database if exists user_db;
create database user_db;
use  user_db;


create table user(
   userId int auto_increment,
   userName varchar(50),
   password varchar(20),
   userType varchar(20),
   constraint ps_userId_pk primary key (userId)
);
insert into customer (userId, userName, password, userType) values (1,'James','james@123','Free');
insert into customer (userId, userName, password, userType) values (2,'Sarah','sarah#347','Premium');
insert into customer (userId, userName, password, userType) values (3,'Ram','ram@537','Free');

commit;
select * from user;