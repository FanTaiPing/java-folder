/*1.检查‘logic java’ 课程最近一次考试成绩*/
/*2.如果有80分以上，显示分数排前5名的学员学号和分数*/
select * from result;

select studentNo as 学生学号,
studentResult as 学生成绩 from result 
where exists (
select studentNo,studentResult from result 
where examDate in (
select max(r.examDate) from result as r 
inner join subject as s 
on r.subjectNo = s.subjectNo 
where subjectName = 'logic java'
) 
)and studentResult>80
order by studentResult desc
limit 5;

/*检查“Logic Java”课程最近一次考试成绩，如果全部未通过考试（60分及格），认为本次考试偏难，计算的该次考试平均分加5分*/



select avg(studentResult)+5 as 平均分 from result 
where exists (
select studentNo from result 
where examDate in (
select max(r.examDate) from result as r 
inner join subject as s
on r.subjectNo = s.subjectNo
where s.subjectName = 'logic java'
) and studentResult>=60
);

select * from subject;
/*制作学生成绩单*/
select s.studentName as 学生姓名,
(select gradeName from grade where id = su.gradeID) as 课程所属年级,
su.subjectName as 课程名称,r1.examDate as 考试日期,r1.studentResult as 成绩 
from result as r1
inner join student as s 
on r1.studentNo = s.studentNo
inner join subject as su 
on su.subjectNo = r1.subjectNo
where r1.examDate in (
select max(examDate) from result as r2
where r1.subjectNo = r2.subjectNo
group by r2.subjectNo
)
order by su.gradeID;


/*分组查询没门课平均分*/
select subjectNo as 科目编号,
avg(studentResult) as 平均分
from result
group by subjectNo
ORDER BY AVG(studentResult) desc;


/*分别统计每个年级男、女生人数*/
select gradeId as 年级编号,sex as 性别,count(1) as 人数 from student 
group by gradeId,sex
order by gradeId;

/*分组筛选出课程平均分大于等于60分的课程*/
select subjectNo as 课程编号,
avg(studentResult) as 平均分
 from result
group by subjectNo
having 平均分>=60;



/*内连接查询*/
select s.studentName as 学生姓名,r.subjectNo as 科目编号,r.studentResult as 科目成绩 
from student as s,result as r
where s.studentNo = r.studentNo;

/*inner join on */
select s.studentName as 学生姓名,r.subjectNo as 科目编号,r.studentResult as 科目成绩
from student as s 
inner join result as r 
on s.studentNo = r.studentNo;

/*左外连接 left join 前面的表为主表，以主表里的字段为依据，把从表里的数据填充给主表，从表里面没有的字段以null填充  on 后面的表为从表*/
select s.studentName as 学生姓名,
r.subjectNo as 科目编号,
r.studentResult as 学生成绩
from student as s 
left join result as r 
on s.studentNo = r.studentNo;

/*右外连接 right join前面的表为主表，以主表里的字段为依据，把从表里的数据填充给主表，从表里面没有的字段以null填充  on 后面的表为从表 */
select r.subjectNo as 科目编号,
r.studentResult as 学生成绩,
s.studentNo as 学生编号
from result as r
right join  student as s
on r.studentNo = s.studentNo;




