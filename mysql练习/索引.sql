/*使用数据库*/
use myschoolTwo;
-- 创建索引
create index `index_gradeName`
on grade(`gradeName`);


-- 删除索引
drop index index_gradeName on grade;

-- 查看索引
show index from grade;
 
