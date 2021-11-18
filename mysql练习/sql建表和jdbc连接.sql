
drop table if exists epet;
create table epet(
`id` int(4) primary key auto_increment,
`name` varchar(20),
birthday datetime,
salary decimal(10,2)
);

insert into epet
values(1,'张三','2001-02-15',8000.00),(2,'李四','2008-05-15',6000.00),(3,'王五','2003-02-18',10000.00);

select * from epet;
select id,`name`,birthday,salary from epet;
select id,name,birthday,salary from epet where id = 1;
insert into epet(name,birthday,salary) 
values('小明','2021-09-11','2500');
delete from epet where id = 3;

update epet set name = '李大大' where id = 2;