-- 创建数据库
create database `master`;

-- 创建数据表
drop table if exists `master`;
create table `master`(
`id` int(4) primary key auto_increment,
`name` varchar(20),
`password` varchar(15)
);

drop table if exists pet_type;
create table pet_type(
id int(4) primary key auto_increment,
`name` varchar(20)
);

drop table if exists pet;
create table pet(
id int(4) primary key auto_increment,
master_id int(4),
`name` varchar(20),
type_id int(4),
health varchar(4),
love varchar(4),
adopt_time datetime comment '领养时间',
`status` int(4) comment '状态' default 0
);


-- 添加三条测试数据
insert into `master`
values(1,'程灵素','123456'),(2,'法海','654321'),(3,'许仙','987654');

insert into pet_type
values(1,'狗狗'),(2,'企鹅'),(3,'猫咪');

insert into pet
values(1,null,'小白',1,100,0,now(),0),(2,null,'招财',3,100,0,now(),0),(3,null,'豆豆',2,100,0,now(),0);

select * from `master`;
select * from pet_type;
select * from pet;

select id,`password` from `master`;
select `id` `name`,`password` from `master` where `name`= '法海' and `password` ='654321';


select id from pet where `name` like concat('%','小白','%');

select id from pet_type where `name` = '企鹅';
-- 两表内连接查询
select p.id from pet_type as pt 
inner join pet as p
on pt.id = p.type_id
where pt.name = '猫咪' and master_id is null and `status` = 0
limit 1;

-- 子查询
select * from  pet as p
where p.type_id in (
select  id from pet_type as pt 
where pt.`name` = '猫咪'
) and master_id is null and `status` = 0
limit 1;


update pet set master_id = '',`name` = '',`status` = 1 where id = '';





