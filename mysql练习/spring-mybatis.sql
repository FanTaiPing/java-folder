create database ssm;

drop table if exists t_user;
create table t_user(
id int(4) primary key auto_increment,
username varchar(20),
`password` varchar(20)
);


drop table if exists t_emp;
create table t_emp(
id int primary key auto_increment,
`name` varchar(20),
age int,
bir datetime
);



insert into t_user(username,`password`) values('刘备','123456'),('关羽','123456'),('张飞','123456'),('孙尚香','123456'),('虞姬','123456');

insert into t_emp(`name`,age,bir) values('唐僧',120,now()),('孙悟空',1000,now()),('猪八戒',400,now()),('沙和尚',200,now()),('如来',5000,now());


select * from t_user;
select * from t_emp;