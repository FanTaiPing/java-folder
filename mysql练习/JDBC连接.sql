create database Pet;

use Pet;

-- 建表 狗 表
drop table if exists dog;
create table dog(
id int primary key auto_increment,
`name` varchar(20),
health int,
love int,
strain varchar(20)
);

-- 创建主人表
drop table if exists master;
create table master(
id int primary key auto_increment,
`name` varchar(20),
`password` varchar(20),
money int
);


-- 添加测试数据
insert into `master`
values(1,"刘春蕾","123456","200"),(2,"韩蝶儿","654321","500"),(3,"程南亚","987654",100);

insert into dog
values(1,"傻狗","100","80","二哈"),(2,"小白",100,100,"中华田园犬"),(3,"旺财",100,100,"金毛");

insert into dog(`name`,health,love,`string`)
values("小黄",100,100,"中华田园犬");

update dog set love =80 where id =2;
delete from dog where id = 4;

select * from `master`;
select * from dog;

