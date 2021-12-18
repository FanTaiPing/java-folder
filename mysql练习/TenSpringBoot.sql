-- 创建银行管理系统数据库---------------------------------------------------------------
create database bankOnline;

use bankOnline;

drop table if exists `account`;
create table `account`(
cardno bigint(16) primary key auto_increment,
`password` varchar(20) not null,
`balance` decimal(11,2) not null,
`status` int(1) default 1 not null
);

drop table if exists transaction_record;
create table transaction_record(
id int(4) primary key auto_increment,
cardno bigint(16) not null,
transaction_date datetime not null comment '交易日期',
expense decimal(11,2) comment '支出',
income decimal(11,2) comment '存入',
`balance` decimal(11,2) not null comment '账户余额',
transaction_type varchar(10) not null comment '交易类型',
remark varchar(20) comment '交易备注'
);

insert into `account` values(6217003639684433,'123456',100000,1),(6217003639684443,'123456',100000,1),(6217003639684321,'123456',100000,1),(6217003639684567,'123456',100000,1),(6217003639684399,'123456',100000,1);


insert into `transaction_record` values(1,6217003639684433,now(),1000,0,99000,'消费',null),(2,6217003639684443,now(),0,2000,101000,'存款',null),(3,6217003639684321,now(),1000,0,100000,'消费',null),(4,6217003639684567,now(),0,10000,90000,'存款',null),(5,6217003639684399,now(),10000,0,80000,'消费',null);

select cardno,password from account where cardno='';

update `account` set `balance` = `balance` + 10 where cardno ='';

insert into `transaction_record`(cardno,transaction_date,expense,income,`balance`,transaction_type) values(1,6217003639684433,now(),1000,0,99000,'消费');

select * from `account`;
select * from transaction_record;


-- 创建图书管理系统数据库 -----------------------------------------------------------------------------------
create database bookdb;

drop table if exists `user`;
create table `user`(
id int(10) primary key auto_increment,
`name` varchar(20) not null,
`password` varchar(40) not null,
age int(5),
sex char(2) not null,
nick_name varchar(50) not null comment '昵称',
user_type int(2) default 1 not null comment '0:普通用户  1:图书系统管理员'
);


drop table  if exists book;
create table `book`(
id int(10) primary key auto_increment,
`Name` varchar(100) not null comment '图书名',
Author varchar(100) not null comment '图书作者',
publish varchar(100) not null comment '出版社',
publish_date Date not null comment '出版社日期',
`page` int(100) comment '页数' ,
price decimal(10,2) comment '价格',
content varchar(500) comment '内容摘要'
);


insert into `user` values(1,'李白','123456',500,'男','青莲剑歌',1),(2,'李清照','123456',500,'女','易安居士',1),(3,'杜甫','123456',500,'男','诗圣',1),(4,'李鬼','123456',500,'男','诗鬼',1),(5,'韩信','123456',500,'男','街头霸王',1);

insert into book values(1,'李白诗集','李白','青莲剑歌诗集出版社',now(),10000,1000,'纯属自传，请勿轻信'),(2,'李清照诗集','李清照','易安居士诗集出版社',now(),10000,1000,'纯属自传，请勿轻信'),(3,'杜甫诗集','杜甫','诗圣诗集出版社',now(),10000,1000,'纯属自传，请勿轻信'),(4,'李鬼诗集','李白','诗鬼诗集出版社',now(),10000,1000,'纯属自传，请勿轻信'),(5,'韩信上分教程','韩信','韩信上分教程出版社',now(),10000,1000,'纯属自传，请勿轻信');

select id,Name,Author,publish,publish_date,page,price,content from Book;
        
select * from `user`;
select * from book;













