-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: myschoolTwo
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `demo02`
--

DROP TABLE IF EXISTS `demo02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `demo02` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo02`
--

LOCK TABLES `demo02` WRITE;
/*!40000 ALTER TABLE `demo02` DISABLE KEYS */;
/*!40000 ALTER TABLE `demo02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '年级编号',
  `gradeName` varchar(10) DEFAULT NULL COMMENT '年级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,'一年级'),(2,'二年级'),(3,'三年级');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonelist`
--

DROP TABLE IF EXISTS `phonelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonelist` (
  `studentName` varchar(50) NOT NULL COMMENT '姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '电子邮箱'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonelist`
--

LOCK TABLES `phonelist` WRITE;
/*!40000 ALTER TABLE `phonelist` DISABLE KEYS */;
INSERT INTO `phonelist` VALUES ('郭靖','13645667783'),('李文才','13645667890'),('李斯文','13645556793'),('张萍','13642345112'),('韩秋洁','13812344566'),('张秋丽','13567893246'),('肖梅','13563456721'),('秦洋','13056434411'),('何睛睛','13053445221'),('王宝宝','15076552323'),('何小华','13318877954'),('陈志强','13689965430'),('李露露','13685678854');
/*!40000 ALTER TABLE `phonelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `studentNo` int NOT NULL COMMENT '学号',
  `subjectNo` int NOT NULL COMMENT '课程编号',
  `examDate` datetime NOT NULL COMMENT '考试日期',
  `studentResult` int NOT NULL COMMENT '考试成绩',
  PRIMARY KEY (`studentNo`,`subjectNo`,`examDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (10000,1,'2016-02-15 00:00:00',71),(10000,1,'2016-02-17 00:00:00',60),(10001,1,'2016-02-17 00:00:00',46),(10002,1,'2016-02-17 00:00:00',83),(10003,1,'2016-02-17 00:00:00',60),(10004,1,'2016-02-17 00:00:00',60),(10005,1,'2016-02-17 00:00:00',95),(10006,1,'2016-02-17 00:00:00',93),(10007,1,'2016-02-17 00:00:00',23);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentNo` int NOT NULL AUTO_INCREMENT COMMENT '学号',
  `loginPwd` varchar(20) NOT NULL COMMENT '密码',
  `studentName` varchar(50) NOT NULL COMMENT '姓名',
  `sex` char(2) NOT NULL DEFAULT '男' COMMENT '性别',
  `gradeId` int unsigned DEFAULT NULL COMMENT '年级表ID外键',
  `phone` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(255) DEFAULT '地址不详' COMMENT '地址',
  `bornDate` datetime DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `identityCard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`studentNo`),
  UNIQUE KEY `identityCard` (`identityCard`)
) ENGINE=InnoDB AUTO_INCREMENT=30013 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (10000,'123','郭靖','男',1,'13645667783','天津市河西区','1990-09-08 00:00:00',NULL,NULL),(10001,'123','李文才','男',1,'13645667890','地址不详','1994-04-12 00:00:00',NULL,NULL),(10002,'123','李斯文','男',1,'13645556793','河南洛阳','1993-07-23 00:00:00',NULL,NULL),(10003,'123','张萍','女',1,'13642345112','地址不详','1995-06-10 00:00:00',NULL,NULL),(10004,'123','韩秋洁','女',1,'13812344566','北京市海淀区','1995-07-15 00:00:00',NULL,NULL),(10005,'123','张秋丽','女',1,'13567893246','北京市东城区','1994-01-17 00:00:00',NULL,NULL),(10006,'123','肖梅','女',1,'13563456721','河北省石家庄市','1991-02-17 00:00:00',NULL,NULL),(10007,'123','秦洋','男',1,'13056434411','上海市卢湾区','1992-04-18 00:00:00',NULL,NULL),(10008,'123','何睛睛','女',1,'13053445221','广州市天河区','1997-07-23 00:00:00',NULL,NULL),(20000,'000','王宝宝','男',2,'15076552323','地址不详','1996-06-05 00:00:00','stu20000@163.com',NULL),(20010,'123','何小华','女',2,'13318877954','地址不详','1995-09-10 00:00:00',NULL,NULL),(30011,'123','陈志强','男',3,'13689965430','地址不详','1994-09-27 00:00:00',NULL,NULL),(30012,'123','李露露','女',3,'13685678854','地址不详','1992-09-27 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_grade1`
--

DROP TABLE IF EXISTS `student_grade1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_grade1` (
  `studentName` varchar(50) NOT NULL COMMENT '姓名',
  `sex` char(2) NOT NULL DEFAULT '男' COMMENT '性别',
  `bornDate` datetime DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL COMMENT '电子邮箱'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_grade1`
--

LOCK TABLES `student_grade1` WRITE;
/*!40000 ALTER TABLE `student_grade1` DISABLE KEYS */;
INSERT INTO `student_grade1` VALUES ('郭靖','男','1990-09-08 00:00:00','13645667783'),('李文才','男','1994-04-12 00:00:00','13645667890'),('李斯文','男','1993-07-23 00:00:00','13645556793'),('张萍','女','1995-06-10 00:00:00','13642345112'),('韩秋洁','女','1995-07-15 00:00:00','13812344566'),('张秋丽','女','1994-01-17 00:00:00','13567893246'),('肖梅','女','1991-02-17 00:00:00','13563456721'),('秦洋','男','1992-04-18 00:00:00','13056434411'),('何睛睛','女','1997-07-23 00:00:00','13053445221');
/*!40000 ALTER TABLE `student_grade1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subjectNo` int NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `subjectName` varchar(50) DEFAULT NULL COMMENT '年级编号',
  `classHour` int DEFAULT NULL COMMENT '学时',
  `gradeID` int DEFAULT NULL COMMENT '年级编号',
  PRIMARY KEY (`subjectNo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'logic java',200,1),(2,'HTML',160,2),(3,'java OOP',180,3);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_person`
--

DROP TABLE IF EXISTS `tb_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_person` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `bornDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_person`
--

LOCK TABLES `tb_person` WRITE;
/*!40000 ALTER TABLE `tb_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_type`
--

DROP TABLE IF EXISTS `tb_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_type` (
  `sid` int(4) unsigned zerofill DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_type`
--

LOCK TABLES `tb_type` WRITE;
/*!40000 ALTER TABLE `tb_type` DISABLE KEYS */;
INSERT INTO `tb_type` VALUES (0012),(1234),(123456);
/*!40000 ALTER TABLE `tb_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_student_result`
--

DROP TABLE IF EXISTS `view_student_result`;
/*!50001 DROP VIEW IF EXISTS `view_student_result`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_student_result` AS SELECT 
 1 AS `姓名`,
 1 AS `学号`,
 1 AS `成绩`,
 1 AS `课程名称`,
 1 AS `考试日期`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_student_result`
--

/*!50001 DROP VIEW IF EXISTS `view_student_result`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_student_result` AS select `s`.`studentName` AS `姓名`,`s`.`studentNo` AS `学号`,`r`.`studentResult` AS `成绩`,`so`.`subjectName` AS `课程名称`,`r`.`examDate` AS `考试日期` from ((`student` `s` join `result` `r` on((`s`.`studentNo` = `r`.`studentNo`))) join `subject` `so` on((`r`.`subjectNo` = `so`.`subjectNo`))) order by `s`.`studentNo` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-07  9:42:07
