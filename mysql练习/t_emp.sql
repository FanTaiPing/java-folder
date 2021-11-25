create database `t_emp`;

use mybatis;

drop table if exists `t_emp`;

create table `t_emp`(
id int(4) primary key auto_increment,
`name` varchar(20),
age int(4),
bir datetime
);