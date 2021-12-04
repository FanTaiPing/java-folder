create database `t_emp`;

use mybatis;

drop table if exists `t_emp`;
-- 创建员工表
create table `t_emp`(
id int(4) primary key auto_increment,
`name` varchar(20),
age int(4),
bir datetime
);

-- 创建薪资表
drop table if exists `salary`;
create table `salary`(
id int primary key auto_increment,
`blance` decimal(7,2),
emp_id int 
);

-- 创建用户表
drop table if exists users;
create table users(
id int primary key auto_increment,
usersname varchar(50),
bir datetime,
address varchar(100),
sex char(2)
);

insert into users(`name`,bir,address,sex) values ('刘备',now(),'云南昆明','男'),('关羽',now(),'云南曲靖','男'),('张飞',now(),'贵州贵阳','男'),('貂蝉',now(),'四川成都','女'),('孙尚香',now(),'四川重庆','女');

insert into `salary` values(1,6000,1),(2,8000,3);

select id,`name`,age,bir from t_emp where id = 1 and `name` = '关羽';

insert into `t_emp`(`name`,age) values('曹操',80);

update t_emp set  age = 49 where id = 3;

select * from t_emp;
select * from salary;
select * from users;


-- 创建数据库
create database mybatis;
-- 创建学生表
drop table if exists student;
create table student(
id int primary key auto_increment,
`name` varchar(20),
`password` varchar(20),
`t_id` int
);

-- 创建老师表
drop table if exists teacher;
create table teacher(
id int primary key auto_increment,
`name` varchar(20),
`password` varchar(20)
);

-- 插入数据
insert into student(`name`,`password`,t_id) values('嫦娥','123456',2),('玉兔','123456',2),('猪八戒','123456',1),('孙悟空','123456',1),('小哪吒','123456',4);

insert into teacher(`name`,`password`) values('唐三','123456'),('太白星君','123456'),('玉皇大帝','123456'),('太上老君','123456'),('月老','123456');


select * from student;
select * from teacher;