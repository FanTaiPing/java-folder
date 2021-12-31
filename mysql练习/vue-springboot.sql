create database vue;

drop table if exists `user`;
create table `user`(
id int(4) primary key auto_increment,
username varchar(50),
age int(4),
salary decimal(20,2),
telephone varchar(20)
);

insert into `user`(username,age,salary,telephone) values("刘备",100,10000,"15511551311"),("关羽",100,10000,"12345665432"),("张飞",100, 10000,"15146489144");

update user set username='刘备',age=100,salary=10000,telephone='15511551310' where id = 1;

select * from `user`;