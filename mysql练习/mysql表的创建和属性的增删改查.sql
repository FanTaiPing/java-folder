/*如果表存在，先删除*/ 
DROP TABLE IF EXISTS `student`;
/*创建学生表*/
CREATE TABLE `student` (
`studentNo` int(10) primary key auto_increment comment '学号',
`loginPwd` varchar(20) not null comment '密码',
`studentName` varchar(50) not null  comment '姓名',
`sex` char(2) not null default '男' comment '性别',
`gradeId` int(4) unsigned comment '年级表ID外键',
`phone` varchar(50) comment '电子邮箱',
`address` varchar(255) default '地址不详' comment '地址',
`bornDate` datetime,
`email` varchar(50) comment '电子邮箱',
`identityCard` varchar(18) unique key comment '身份证号'
);

/*查询student表中的所有行和列*/
select * from `student`;

/*清除student表中的所有数据*/
delete from student;/*方法一*/
truncate table student;/*方法二*/

/*student表数据*/
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10000','123','郭靖','男','1','13645667783','天津市河西区','1990-09-08 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10001','123','李文才','男','1','13645667890','地址不详','1994-04-12 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10002','123','李斯文','男','1','13645556793','河南洛阳','1993-07-23 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10003','123','张萍','女','1','13642345112','地址不详','1995-06-10 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10004','123','韩秋洁','女','1','13812344566','北京市海淀区','1995-07-15 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10005','123','张秋丽','女','1','13567893246','北京市东城区','1994-01-17 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10006','123','肖梅','女','1','13563456721','河北省石家庄市','1991-02-17 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10007','123','秦洋','男','1','13056434411','上海市卢湾区','1992-04-18 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('10008','123','何睛睛','女','1','13053445221','广州市天河区','1997-07-23 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('20000','123','王宝宝','男','2','15076552323','地址不详','1996-06-05 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('20010','123','何小华','女','2','13318877954','地址不详','1995-09-10 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('30011','123','陈志强','男','3','13689965430','地址不详','1994-09-27 00:00:00',NULL,NULL);
insert into `student` (`studentNo`, `loginPwd`, `studentName`, `sex`, `gradeId`, `phone`, `address`, `bornDate`, `email`, `identityCard`) values('30012','123','李露露','女','3','13685678854','地址不详','1992-09-27 00:00:00',NULL,NULL);

/*查看表*/
show tables;
/*查看表定义*/
describe `myschooltwo`;
desc `myschooltwo`;


/*创建年级表，创建前先删除表*/
drop table if exists `grade`;

/*创建年级表*/
create table `grade` (
`id` int(4) primary key auto_increment comment '年级编号',
`gradeName` varchar(10) comment '年级名称'
);

/*创建科目表和成绩表*/
drop table if exists `subject`;
create table `subject` (
`subjectNo` int(4) primary key auto_increment comment '课程编号',
`subjectName` varchar(50) comment '年级编号',
`classHour` int(4) comment '学时',
`gradeID` INT(4) comment '年级编号'
);

select * from subject;
/*在科目表中添加数据*/
insert into `subject`
value('1','logic java','200','1'),('2','HTML','160','2'),('3','java OOP','180','3');

 drop table if exists `result`;
 CREATE TABLE `result` (
    `studentNo` INT(4) NOT NULL COMMENT '学号',
    subjectNo INT(4) NOT NULL COMMENT '课程编号',
    examDate DATETIME NOT NULL COMMENT '考试日期',
    studentResult INT(4) NOT NULL COMMENT '考试成绩'
);

/*查询成绩表中的所有行和列*/
select * from `result`;
/*result表数据*/
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10000','1','2016-02-15 00:00:00','71');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10000','1','2016-02-17 00:00:00','60');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10001','1','2016-02-17 00:00:00','46');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10002','1','2016-02-17 00:00:00','83');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10003','1','2016-02-17 00:00:00','60');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10004','1','2016-02-17 00:00:00','60');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10005','1','2016-02-17 00:00:00','95');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10006','1','2016-02-17 00:00:00','93');
insert into `result` (`studentNo`, `subjectNo`, `examDate`, `studentResult`) values('10007','1','2016-02-17 00:00:00','23');

 
 
 
 /*学号、课程编号、考试日期构成组合主键*/
 alter table `result` add constraint `pk_result`
 primary key `result`(`studentNo`,`subjectNo`,`examDate`);
 
 /*主表student和从表result通过studentNo字段建立主外键关联*/
 alter table `result` add constraint `fk_student_result`
 foreign key(`studentNo`)
 references `student` (`studentNo`);

/*删除外键约束*/
alter table result drop foreign key fk_student_result;

/*创建test数据库*/
create database test;

/*创建person表，创建前先删除表*/
drop table if exists `person`;

create table `person` (
`number` INT(4) primary key AUTO_INCREMENT comment '序号',
`name` varchar(50) not null comment '姓名',
`sex` char(2) comment '性别',
`bornDate` DATETIME  comment '出生日期'
);

/*将表名修改为tb_person*/
alter table `person` rename `tb_person`;

/*删除出生日期字段*/
alter table `tb_person` drop `bornDate`;

/*添加出生日期字段，数据类型为date*/
alter table `tb_person` add `bornDate` date;

/*修改序号字段名（number）为id,类型为bigint*/
alter table `tb_person` change number `id` BIGINT;


/*创建表demo01,创建前先删除*/
DROP TABLE IF EXISTS demo01;

/*创建表*/
create table demo01(
`id` int(10) not null primary key auto_increment comment '编号',
`name` varchar(8) not null comment '姓名'
);

/*修改表名*/
alter table demo01 rename demo02;

/*添加字段*/
alter table demo02 add password varchar(32) not null;

/*修改字段*/
alter table demo02 change `name` `username` char(10) not null;

/*删除字段*/
alter table demo02 drop password;



