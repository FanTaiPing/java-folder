/*创建myschool数据库*/
create database myschool;

/*删除数据库myschool*/
drop database myschool;

/*删除student表里的主键*/
alter table `student` drop primary key;

/*删除student表*/
drop table student;

/*创建表前判断是否存在，存在就删除然后再创建*/
drop table if exists `student`;
create table `student`(
`studentNo` int(20) primary key auto_increment comment '学号',
`name` varchar(50) comment '姓名',
`class` varchar(50) comment '班级',
`sex` char(2) comment '性别',
`bornDate` DATETIME comment '出生日期'
);
/*删除student表里的studentNo和name字段*/
alter table `student` drop `studentNo`,drop `name`;

/*修改表里的studentNo字段为id*/
alter table `student` change `studentNo` `id` int(10);

/*添加兴趣爱好字段*/
alter table `student` add `like` varchar(100);

/*修改student表名为students*/
alter table `student` rename `students`;

/*查询students表的所有行和列*/
select * from `students`;

/*查询students表中学号为2021的学生信息*/
select id,`name`,class,sex,bornDate,`like` from `students` where id = '2021';

/*在students表中增加几条数据*/
 insert into `students` values (2021,'张三','一年级一班','男','2021-01-01','听音乐'),(2022,'李四','一年级二班','女','2022-01-01','打游戏');

/*删除students表中的数据*/
delete from `students` where id = '2021' or id = '2022';

/*清空表中的数据*/
truncate table `students`;

/*修改更新id为2022的姓名为快乐的一只小青蛙*/
update `students` set `name` = '快乐的一只小青蛙' , `sex` = '男' where `id` = '2022';











select * from `student`;
select * from `result`;
select * from `subject`;
select * from `grade`;

/*查询结果集插入新表*/

/*从学生表提取姓名、手机号这两列数据存储到新的通讯录表里*/
create table `phoneList`(
select `studentName`,`phone` from `student` 
);

/*查询新表phoneList*/
select * from `phoneList`;

/*给字段（列）起中文名，方便我们查询时查看，不改变原来表里字段名*/
/*1.as关键字起别名*/
select `studentNo`AS 学生学号,`studentName`as 学生姓名 ,`address` as 学生地址 
from `student` 
where `address` <> '河南新乡';/*学生地址不等于河南新乡的所有学生*/

/*直接空格后加*/
select `studentNo` 学生学号,`studentName` 学生姓名,`address` 学生地址 
from `student`
where `address` <> '河南新乡';

/*查询空行*/
select * from `student`;
select * from `student`
where `email` is null;

/*查询常量列*/
select  `studentName`as 姓名,`address` as 学生地址,'昆明华信' as 学校名称 
from `student`;
select * from `student`;



/*把成绩都降低10%后加5分，查询及格成绩，成绩从高到低排序*/
select `studentNo` as 学生学号,(studentResult*0.9)+5 as 学生成绩
from `result`
where (studentResult*0.9)+5>=60 
order by `studentResult` desc;
select * from result;


/*查询所有年级编号为1的学院信息，按学号升序排序*/
select * from `student`
where `gradeId` = 1
order by `studentNo`;


/*显示前4条记录*/
select * from `student`
where `gradeId` = 1
order by `studentNo`
limit 0,4;/*从第0条记录开始默认是0 ：正常写法：limit 0,4*/

/*每页4条，显示第2页，即从第5条记录开始显示4条数据（5-8）*/
/*第一个参数是从第几开始，第二个参数是取多少条（行）数据*/
select * from `student` 
where `gradeId` = 1
order by `studentNo`
limit 4,4;


/*将学生表中学号为2000，邮箱改为stu20000@163.com，密码=改为000*/
select * from `student` 
where `studentNo` = 20000;

update `student` set `email` = 'stu20000@163.com',`loginPwd` = '000'
where `studentNo` = 20000;


/*讲课目表中课时数大于200且年级编号为1 的科目的课时减少10*/
select * from `subject`;


update `subject` set `classHour` = `classHour` - 10 
where `classHour` > 200 and `gradeID` = 1;



/*将所有年级标号为1的学院姓名、性别、出生日期、手机号码信息保存到新表student_grade1*/
create table `student_grade1`(
select `studentName`,`sex`,`bornDate`,`phone` 
from `student` 
where `gradeID` = 1
);


/*方法一：查找比‘李斯文’年龄小的学生*/
/*1.查询出李斯文的出生*/
select `bornDate` from `student`
where `studentName` = '李斯文';

/*2.查询出生日期不李斯文的出生日期大的学生*/
select * from `student`
where `bornDate` > '1903-07-23';

/*方法二：子查询合并两个查询*/
select * from `student`
where `bornDate` >(
select `bornDate` from `student`
where `studentName` = '李斯文'
);


/*查询参加最近一次logic java 考试成绩的学生的最高分和最低分*/
/*1.查询参加最近一次logic java 考试的学生*/
select * from `result`;
select * from `subject`;



/*根据上面查询的日期再来查学生表*/
select max(`studentResult`) as 最高分,min(`studentResult`) as 最低分
from `result`
where `examDate` = (
select max(r.`examDate`) from `result` as r,
`subject` as s
where r.subjectNo = s.subjectNo
and s.subjectName = 'logic java'
);


/*查询logic 课程考试成绩为60分的学生名单*/
select `studentName` from student 
where studentNo in (
select `studentNo` from `result` as r,
`subject` as s 
where r.subjectNo = s.subjectNo
and r.studentResult = 60
and s.subjectName = 'logic java'
);


/*查询参加“Logic Java”课程最近一次考试的在读学生名单*/
/*1.获得 “Logic Java”课程的课程编号 子查询*/
select max(r.examDate) from result as r
inner join subject as s 
on r.subjectNo = s.subjectNo
where s.subjectName = 'logic java';

/*2.根据课程编号查询得到“Logic Java”课程最近一次的考试日期*/
select * from student as s 
inner join result as r 
on s.studentNo = r.studentNo
where r.examDate in (
select max(r.examDate) from result as r 
inner join `subject` as s 
on r.subjectNo = s.subjectNo
where s.subjectName = 'logic java'
);

select * from student
where studentNo in (select studentNo from result);


/*查询未参加'logic java'课程最近一次考试的在读学生名单*/
select * from student as s 
inner join result as r 
on s.studentNo = r.studentNo
where examDate not in (
select max(r.examDate) from result as r
inner join `subject` as s 
on r.subjectNo = s.subjectNo
where s.subjectName = 'logic java'
); 



select * from grade;
select * from student;
select * from subject;
/*先查询获得年级名称是一年级的所有课程的课程编号,再根据课程编号查询课程表得到课程名称*/
select subjectName from `subject`
where gradeId in (
select gradeId from grade where gradeName = '一年级'
);



select * from result;
/*查询未参加“HTML”课程最近一次考试的在读学生名单*/
select * from student
where studentNo not in
(select studentNo from result
where studentNo in(
select max(r.examDate) from result as r 
inner join `subject` as s 
on r.subjectNo = s.subjectNo
where subjectName = 'HTML'
))
and gradeId = (
select subjectNo from subject
where subjectName = 'HTML'
);


SELECT `studentName` FROM `student` 
WHERE `studentNo` NOT IN (
      SELECT `studentNo` FROM `result` 
      WHERE `subjectNo` = (
          SELECT `subjectNo` FROM `subject` 
          WHERE `subjectName`='HTML'
       )
      AND `examDate` = (
          SELECT MAX(`examDate`) FROM `result` 
          WHERE `subjectNo` =(
              SELECT `subjectNo` FROM `subject` 
              WHERE `subjectName`='HTML' ) 
       ))
AND `gradeId` = (
      SELECT `gradeId` FROM `subject` 
      WHERE `subjectName`='HTML'
);
