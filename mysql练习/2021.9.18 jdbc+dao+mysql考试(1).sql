-- 创建pet_store数据库
create database pet_store;
-- 创建宠物商店库
create database pet_store;
-- 创建宠物表
drop table if exists pet;
create table pet(
owner_id integer(4) comment '主人编号',
pet_id int(4) primary key auto_increment comment '宠物编号',
`name` varchar(20) comment '登录名',
type_name varchar(20) comment '宠物类型',
health int(4) comment '健康值',
love int(4) comment '亲密度',
birthday datetime comment '出生日期',
store_id int(4) comment '宠物所属商店编号'
);

-- 创建宠物主人表
drop table if exists pet_owner;
create table pet_owner(
owner_id int(4) primary key auto_increment comment '主人编号',
`name` varchar(20) comment '宠物主人名',
`password` varchar(20) comment '宠物主人登录密码',
money decimal comment '宠物主人余额'
);


-- 宠物商店表
drop table if exists pet_store;
create table pet_store(
store_id int(4) primary key auto_increment comment '商店编号',
`name` varchar(50) comment '宠物商店名',
`password` varchar(20) comment '宠物商店密码',
`balance` decimal comment '宠物商店账号余额'
);

-- 账目信息表
drop table if exists `account`;
create table `account`(
account_id int(4) primary key auto_increment comment '账单编号',
deal_type int(4) comment '交易类型：1：商店卖给宠物主人，2：宠物主人卖给商店',
pet_id int(4) comment '宠物编号',
seller_id int(4) comment '卖家编号',
buyer_id int(4) comment '买家编号',
price decimal comment '交易价格',
deal_time datetime comment '交易时间'
);



insert into pet
values(null,'1','小白','狗狗',100,100,'2021-09-18',1),
(null,'2','小蓝','猫咪',100,100,'2021-09-18',2),
(null,'3','小红','兔子',100,100,'2021-09-18',3),
(null,'4','小紫','企鹅',100,100,'2021-09-18',4),
(1,'5','小黄','狗狗',100,100,'2021-09-18',1),
(2,'6','小灰','猫咪',100,100,'2021-09-18',2),
(3,'7','小白','兔子',100,100,'2021-09-18',3),
(1,'8','小花','企鹅',100,100,'2021-09-18',4);

insert into pet_owner
values(1,'唐三','123456',1000),(2,'小舞','654321',1000),(3,'千仞雪','abcdef',1000);


insert into pet_store
values(1,'快乐宠物商店','123456',200),(2,'忧伤宠物商店','123456',300),(3,'萌萌宠物商店','123456',100);


insert into `account`
 values(1,1,1,1,2,200,'2021-09-18'),(2,1,3,2,1,300,'2021-09-21'),(3,2,2,3,3,100,'2021-09-18');
 
 select owner_id,`name`,`password`,money from pet_owner;
 
 select `name`,password from pet_owner where name = '唐三' and password = '123456';
 
 select owner_id,`name`,`money` from pet_owner where `name` = '唐三' and `password` = '123456';
 
 select `name`,'balance' from pet_store where `name` = '快乐宠物商店' and `password` = '123456';
 
select p.`pet_id`,p.`name`,p.`type_name`,a.`price` from pet as p
inner join `account` as a
on p.pet_id = a.pet_id
where p.owner_id is null;

select owner_id,pet_id,`name`,type_name,health,love,birthday from pet;

select owner_id,`name`,`password`,money from pet_owner;

select store_id,`name`,`password`,`balance` from pet_store;

select p.pet_id,p.name,p.type_name from pet_owner as po
inner join pet as p
on po.owner_id = p.owner_id
where po.`name` = '唐三' and po.`password` = '123456';


select p.deal_type,p.pet_id,p.store_id,p.owner_id,a.price,a.deal_time from `account` as a
inner join pet as p 
on a.pet_id = p.pet_id
inner join pet_owner as po
on p.owner_id = po.owner_id;

update pet set owner_id = null where pet_id = 1;

insert into `account` (`deal_type`,pet_id,seller_id,buyer_id,price,deal_time)
values();

select owner_id,pet_id,`name`,type_name,health,love,birthday,store_id from pet where pet_id=?;


update pet_owner set money=money-100 where `name` = ? and `password` = ?;
update pet_owner set money=money+100 where `name` = '唐三' and `password` = '123456';

update pet_store set `balance` = `balance`-300 where store_id=?;

update pet set owner_id = null,store_id =3 where pet_id = 3;

select * from pet;
select * from pet_owner;
select * from pet_store;
select * from `account`;