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
select * from `account`;
select * from transaction_record;