create database mybank;

DROP TABLE IF EXISTS BANK;
create table `bank`(
`customerName` varchar(50),
`currentMoney` decimal(10,2)
);
 
 
 insert into bank
 values('张三','1000'),('李四',1);
 
 select * from bank;


/*模拟转账*/
begin;
update bank set currentMoney = currentMoney-500
where customerName = '张三';

update bank set currentMoney = currentMoney + 500
 where customerName = '李四';
 
commit;
 rollback;
 update bank set currentMoney = currentMoney + 500
 where customerName = '张三';

update bank set currentMoney = currentMoney - 500
where customerName = '李四';

/*关闭自动提交事务*/
set autocommit = 0;

/*打开自动提交事务（默认）*/
set autocommit = 1;


/*创建视图 创建前先判断是否存在，如存在则删除*/
use house;
drop view if exists view_house;
create view view_house
as select * from hos_house;

select * from view_house;
update view_house set copy ='中关村'
where hmid ='1';

/*创建学生成绩表视图*/
use myschooltwo;
drop view if exists view_student_result;
create view view_student_result
as select s.studentName as 姓名,
s.studentNo as 学号,
r.studentResult as 成绩,
so.subjectName as 课程名称,
r.examDate as 考试日期
from student as s
inner join result as r
on s.studentNo = r.studentNo
inner join subject as so
on r.subjectNo = so.subjectNo
order by s.studentNo;

select *,count(*)from view_student_result ;
update view_student_result set studentName ='李斯'
where studentName = '李文才';
