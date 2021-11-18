create database `user`;

drop table if exists `user`;
create table `user`(
id int(4) primary key auto_increment comment '用户编号',
userName varchar(50) comment '用户名',
`password` varchar(20) comment '密码',
passwordOne varchar(20) comment '确认密码',
email varchar(50) comment '邮箱',
sex char(2) comment '性别',
birth Date comment '出生日期' 
);

insert into `user` values(1,'豆豆','123456','123456','123456789@qq.com','女','2021-09-25');