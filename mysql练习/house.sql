-- -------------------创建数据表-------------------
-- 创建数据库house
create database house;
-- 客户信息表
create table sys_user
(
	UID int(4) primary key auto_increment,		/*客户编号，主键，标识列从1开始，递增值为1*/
	UName varchar(50) not null,						/*客户姓名*/
	UPASSWORD varchar(50) not null				/*密码，至少6个字符*/
);


-- 区县信息表
create table hos_district
(
	DID int(4) primary key auto_increment,		/*区县编号，主键，标识列从1开始，递增值为1*/
	DName varchar(50) not null					/*区县名称*/
);


-- 街道信息表
create table hos_street
(
	SID int(4) primary key auto_increment,		-- 街道编号，主键，标识列从1开始，递增值为1
	SName varchar(50) not null,						-- 街道名称
	SDID int not null								-- 区县编号，外键引用hos_district表
);


/*房屋类型表*/
create table hos_type
(
	HTID int(4) primary key auto_increment,	/*房屋类型编号，主键，标识列从1开始，递增值为1*/
	HTName varchar(50) not null					/*房屋类型名称*/
);

-- 出租房屋信息表
create table hos_house
(
	HMID int(4) primary key auto_increment,	-- 出租房屋编号，主键，标识列从1开始，递增值为1
	UID int not null,								-- 客户编号，外键引用sys_user表
	SID int not null,								-- 街道编号，外键引用hos_street表
	HTID int not null,								-- 房屋类型编号，外键引用hos_type表
	PRICE decimal default (0) not null,				-- 每月租金，默认值为0，要求大于等于0
	TOPIC varchar(50) not null,						-- 标题
	CONTENTS varchar(50) not null,					-- 描述
	HTIME datetime default (now()) not null,	-- 发布时间，默认值为当前日期，要求小于等于当前日期
	COPY varchar(50) default ('暂无备注') null		-- 备注
);

/*------------------------插入数据-----------------------*/
/*表sys_user插入数据*/
INSERT INTO sys_user VALUES('1','张三','s217701');
INSERT INTO sys_user VALUES('2','李四','s217702');
INSERT INTO sys_user VALUES('3','王鑫','s217703');
INSERT INTO sys_user VALUES('4','张建','s217704');
INSERT INTO sys_user VALUES('5','李剑','s217705');
INSERT INTO sys_user VALUES('6','蒋以然','s217706');
INSERT INTO sys_user VALUES('7','王晓超','s217707');
INSERT INTO sys_user VALUES('8','张冬雪','s217708');
INSERT INTO sys_user VALUES('9','孙鹏','s217709');
INSERT INTO sys_user VALUES('10','蒋连昌','s217710');
 
-- 表hos_district插入数据
INSERT INTO hos_district (DNAME) VALUES('海淀区');
INSERT INTO hos_district (DNAME) VALUES('西城区');
INSERT INTO hos_district (DNAME) VALUES('东城区');
INSERT INTO hos_district (DNAME) VALUES('朝阳区');
INSERT INTO hos_district (DNAME) VALUES('景山区');
INSERT INTO hos_district (DNAME) VALUES('宣武区');
INSERT INTO hos_district (DNAME) VALUES('大兴');
INSERT INTO hos_district (DNAME) VALUES('丰台');
 
-- 表hos_street插入数据
INSERT INTO hos_street (SNAME,SDID) VALUES('中关村',1);
INSERT INTO hos_street (SNAME,SDID) VALUES('苏州街',1);
INSERT INTO hos_street (SNAME,SDID) VALUES('万泉庄',1);
INSERT INTO hos_street (SNAME,SDID) VALUES('东四',3);
INSERT INTO hos_street (SNAME,SDID) VALUES('东单',3);
INSERT INTO hos_street (SNAME,SDID) VALUES('西四',2);
INSERT INTO hos_street (SNAME,SDID) VALUES('西单',2);
INSERT INTO hos_street (SNAME,SDID) VALUES('东湖',4);
INSERT INTO hos_street (SNAME,SDID) VALUES('八里庄',4);
INSERT INTO hos_street (SNAME,SDID) VALUES('双井',5);
INSERT INTO hos_street (SNAME,SDID) VALUES('陶然亭',5);
INSERT INTO hos_street (SNAME,SDID) VALUES('南菜园',6);
INSERT INTO hos_street (SNAME,SDID) VALUES('兴丰街',7);
INSERT INTO hos_street (SNAME,SDID) VALUES('黄村',7);
INSERT INTO hos_street (SNAME,SDID) VALUES('南苑街',8);
INSERT INTO hos_street (SNAME,SDID) VALUES('东铁营',8);
 
-- 表hos_type插入数据
INSERT INTO hos_type (HTNAME) VALUES('一室一卫');
INSERT INTO hos_type (HTNAME) VALUES('一室一厅');
INSERT INTO hos_type (HTNAME) VALUES('两室一卫');
INSERT INTO hos_type (HTNAME) VALUES('两室一厅');
INSERT INTO hos_type (HTNAME) VALUES('三室一厅');
INSERT INTO hos_type (HTNAME) VALUES('三室两厅');
 
-- 表hos_house插入数据
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(1,1,2,2600,'中关村','中关村一条街','2009-1-2','中关村');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(2,2,3,3600,'苏州街','苏州街一条街','2009-1-3','苏州街');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(3,3,4,4600,'万泉庄','万泉庄一条街','2009-1-4','万泉庄');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(1,3,2,1500,'万泉庄附近','万泉庄附近一条街','2009-7-2','万泉庄附近');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(1,5,2,2700,'东单','东单很多美食','2009-9-2','东单');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(3,1,2,2600,'中关村','中关村电脑城','2009-4-1','中关村');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(4,4,1,2000,'东四','东四一条街','2009-4-2','东四');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(5,6,3,3600,'西四','西四一条街','2009-1-2','西四');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(5,7,2,3600,'西单','西单购物城','2009-4-2','西单');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(6,2,2,2600,'苏州街','苏州街美食','2009-2-2','苏州街');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(7,8,3,2900,'朝阳东湖','朝阳东湖一景','2009-3-2','朝阳');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(8,3,1,700,'万泉庄','万泉庄一条街','2009-5-2','万泉庄');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(3,2,3,4200,'苏州街','苏州街二条街','2009-1-3','苏州街');
INSERT INTO hos_house(UID,SID,HTID,PRICE,TOPIC,CONTENTS,HTIME,COPY)
VALUES(4,2,3,4100,'苏州街','苏州街西街','2009-1-3','苏州街');


select * from hos_district;-- 区县表
select * from hos_street; -- 街道表
select * from hos_type; -- 房屋类型
select * from hos_house;
select * from sys_user; -- 用户表

-- 查询输出第6条到第10条出租房屋信息
select HMID,uid,sid,htid,price,topic,contents,htime,copy
from hos_house
limit 5,5;

-- 创建临时表保存查询结果
create temporary table temp_house(
select HMID,uid,sid,htid,price,topic,contents,htime,copy
from hos_house
limit 5,5
);
select * from temp_house;

-- 查询张三发布的所有出租房屋信息，并显示房屋分布的街道和区县
select d.DName as 区县,
s.SName as 街道,
h.htid as 户型,
format(h.PRICE,2)  as 价格, -- 查询之后保留小数点之后两位
h.TOPIC as 标价,
h.CONTENTS as 描述,
h.COPY as 备注
from hos_house as h
inner join sys_user as u
on u.uid = h.uid 
inner join hos_street as s
on h.SID = s.SID 
inner join hos_district as d
on s.SDID = d.did
inner join hos_type as t
on h.HTID = t.HTID
where u.UName = '张三';

-- 根据户型和房屋所在区县和街道，为至少有两个街道有出租房屋的区县制作出租房屋清单、
select t.HTName as 户型,
u.UName as 姓名,
d.DName as 区县,
s.SName as 街道
from hos_type as t 
inner join hos_house as h
on t.htid = h.HTID
inner join sys_user as u 
on h.UID = u.UID
inner join hos_street as s
on s.sid = h.sid
inner join hos_district as d
on s.SDID = d.DID
group by 街道
having count(街道) >1;

SELECT hos_type.HTNAME AS '户型',sys_user.UNAME AS '姓名',

hos_district.DNAME AS '区县',hos_street.SNAME AS '街道'

FROM hos_house INNER JOIN sys_user ON (hos_house.UID=sys_user.UID)

                  INNER JOIN hos_street ON(hos_house.SID=hos_street.SID)

                  INNER JOIN hos_district ON(hos_street.SDID=hos_district.DID)

                  INNER JOIN hos_type ON(hos_house.HTID=hos_type.HTID)

WHERE hos_street.SDID IN (

      SELECT hos_street.SDID
  FROM hos_house INNER JOIN hos_street ON
                 (hos_house.SID=hos_street.SID)

                 INNER JOIN hos_district ON(hos_street.SDID=hos_district.DID)

      GROUP BY hos_street.SDID
  HAVING COUNT(hos_street.SDID)>1

   );

