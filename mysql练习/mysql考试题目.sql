drop table if exists`Student`;
/*创建学生表Student*/
create table if not exists `Student`(
`Sid` int(20) primary key auto_increment comment '学生编号',
`Sname` varchar(50) comment '学生姓名',
`Sage` datetime comment '出生年月',
`Ssex` char(2) comment '学生性别'
);

select * from `Student`;

/*在学生表中插入测试数据*/
insert into `Student`(`Sname`,`Sage`,`Ssex`)
values ('赵雷','1990-01-01','男'),('钱电','1990-12-21','男'),('孙风','1990-05-20','男'),('李云','1990-08-06','男'),('周梅','1991-12-01','女'),
('吴兰','1992-03-01','女'),('郑竹','1989-07-01','女'),('张三','2017-12-20','女'),('李四','2017-12-25','女'),('李四','2017-12-30','女'),
('赵六','2017-01-01','女'),('孙七','2018-01-01','女');

/*清除学生表里的所有内容*/
truncate table `Student`;

/*创建前先判断是否存在，存在则删除*/
drop table if exists `Course`;
/*创建课程表Course*/
create table if not exists `Course`(
`Cid` int(50) primary key auto_increment comment '课程编号',
`Cname` varchar(50) comment '课程名称',
`Tid` int(20) comment '教师编号'
);

select * from `Course`;
truncate table `Course`;

/*在课程表中添加测试数据*/
insert into `Course`
values('1','语文','0'+'2'),('2','数学','0'+'1'),('3','英语','0'+'3');


/*创建前先判断此表是否存在，如存在则删除*/
drop table if exists `Teacher`;
/*创建教师表*/
create table `Teacher`(
`Tid` int(20) primary key auto_increment comment '教师编号',
`Tname` varchar(50) comment '教师姓名'
);

/*查询教师表的所有行和列*/
select * from `Teacher`;

/*在教师表中添加测试数据*/
insert into `Teacher`
values ('1','张三'),('2','李四'),('3','王五');

/*清空教师表里的所有内容*/
truncate table `Teacher`;

/*创建前先判断此表是否存在，如存在则删除*/
drop table if exists `SC`;
/*创建成绩表*/
create table `SC`(
`Sid` int(10) comment '学生编号',
`Cid` int(20) comment '课程编号',
`score` int(4) comment '分数'
);

/*查询成绩表SC的所有行和列*/
select * from `SC`;


/*删除Course表中的外键*/
alter table `Course` drop foreign key fk_Student_Course ;

/*设置学生表和成绩表的主外键关联*/
alter table `SC` add constraint fk_SC_Student
foreign key(`Sid`)
references `Student`(`Sid`);

/*查询成绩表中的所有行和列*/
select * from `SC`;

/*设置课程表和成绩表的主外键关联*/
alter table `SC` add constraint fk_SC_Course
foreign key (`Cid`)
references `Course`(`Cid`);

/*删除成绩表中的外键*/
alter table `SC` drop foreign key fk_SC_Student,drop foreign key fk_SC_Course;

/*在成绩表中添加测试数据*/
insert into `SC`
values ('1','01','80'),('1','02','90'),('1','03','99'),('2','01','70'),('2','02','60'),('2','03','80'),('3','01','80'),
('3','02','80'),('3','03','80'),('4','01','50'),('4','02','30'),('4','03','20'),('5','01','76'),('5','02','87'),('6','01','31'),
('6','03','34'),('7','02','89'),('7','03','98');

/*1.查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩*/
select Student.Sid,Sname,avg(SC.score) 
from Student INNER JOIN SC ON Student.Sid = SC.Sid 
group by Student.Sid having avg(SC.score)>=60;

/*2.查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )*/
select Student.Sid as 学生编号,Sname as 学生姓名,count(SC.Cid) as 选课总数,sum(SC.score) as 课程成绩总和
from Student left join SC on Student.Sid = SC.Sid group by Student.Sid;

/*3.查有成绩的学生信息*/
select distinct Student.* from Student,SC where Student.Sid=SC.Sid;

/*4.查询学过「张三」老师授课的同学的信息*/
select Student.* 
from Student inner join SC on Student.Sid = SC.Sid 
inner join Course on Course.Cid = SC.Cid 
inner join Teacher on Teacher.Tid = Course.Tid 
 where Teacher.Tname = '张三';
 
 /*5.按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩*/
SELECT SC.*,avg_score
FROM SC LEFT JOIN 
(SELECT SC.Sid,AVG(SC.score)as avg_score 
from SC
GROUP BY SC.Sid)r
ON SC.Sid=r.Sid
ORDER BY avg_score DESC;


/*6.查询课程名称为「数学」，且分数低于 60 的学生姓名和分数*/
select Student.Sname,SC.score
from Student inner join SC on Student.Sid = SC.Sid 
inner join Course on SC.Cid = Course.Cid 
where Course.Cname = '数学' and SC.score<60;



-- 第二次考试
-- 1.查询在SC表存在成绩的学生信息

select * from student as s
inner join SC as sc
on s.sid = sc.Sid
where exists (
select Sid,score from SC  
);


-- 2.查询【李】姓老师的数量
insert into teacher 
values (4,'李东'),(5,'李阳');
select '李姓老师' as 李姓老师,count(*) as 数量 from teacher
where Tname like '%李%';

select *from teacher;

-- 3.查询各科成绩前三名的记录
select * from course;
select * from sc;
select * from student;

select c.Cid as 课程编号,
c.Cname as 课程名称,
sc.score as 成绩
from sc
inner join course as c
on sc.Cid = c.Cid
where (select count(1) from sc as s where sc.Cid = s.Cid and s.score > sc.score) < 3
order by 课程编号,
成绩 desc;


-- 4.查询男生、女生人数
select Ssex as 性别,count(Ssex) as 人数 from student
group by Ssex;


-- 5.查询名字中含有【风】字的学生信息
select * from student
where Sname like '%风%';

-- 6.查询1990年出生的学生名单
select * from student
-- where Sage >= '1990-01-01 00:00:00' and Sage <= '1990-12-31 23:59:59';
where year(Sage) = '1990';
-- 7.查询课程编号为01且课程成绩在80分以上的学生的学号和姓名
select * from course;

select stu.Sid as 学号,
stu.Sname as 姓名,
s.score as 成绩
from student as stu
inner join sc as s 
on stu.Sid = s.Sid
where s.Cid = '1' and s.score >= 80;

