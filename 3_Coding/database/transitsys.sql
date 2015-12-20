-- MySQL dump 10.13  Distrib 5.6.27, for Win64 (x86_64)
--
-- Host: localhost    Database: transitsys
-- ------------------------------------------------------
-- Server version	5.6.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (4,'excited',860),(5,'蛤',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arriveorderpassed`
--

DROP TABLE IF EXISTS `arriveorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arriveorderpassed` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `centerId` char(4) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `state` int(1) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arriveorderpassed`
--

LOCK TABLES `arriveorderpassed` WRITE;
/*!40000 ALTER TABLE `arriveorderpassed` DISABLE KEYS */;
INSERT INTO `arriveorderpassed` VALUES ('0250002015121000000','0250','江苏省南京栖霞营业厅',0,'2015-12-10','2015-12-10 19:19:22','董建华','Mrdong'),('0250201512150000000','0100','江苏省南京中转中心',0,'2015-12-16','2015-12-16 11:00:26','彭定康','report');
/*!40000 ALTER TABLE `arriveorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arriveorderunpassed`
--

DROP TABLE IF EXISTS `arriveorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arriveorderunpassed` (
  `id` char(19) NOT NULL,
  `centerId` char(4) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `state` int(1) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) CHARACTER SET gbk NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arriveorderunpassed`
--

LOCK TABLES `arriveorderunpassed` WRITE;
/*!40000 ALTER TABLE `arriveorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `arriveorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arriveorderwaiting`
--

DROP TABLE IF EXISTS `arriveorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arriveorderwaiting` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `centerId` char(4) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `state` int(1) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arriveorderwaiting`
--

LOCK TABLES `arriveorderwaiting` WRITE;
/*!40000 ALTER TABLE `arriveorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `arriveorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centerlorderpassed`
--

DROP TABLE IF EXISTS `centerlorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centerlorderpassed` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `target` varchar(20) NOT NULL,
  `vanid` char(9) CHARACTER SET latin1 NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `escort` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `cost` double NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centerlorderpassed`
--

LOCK TABLES `centerlorderpassed` WRITE;
/*!40000 ALTER TABLE `centerlorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `centerlorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centerlorderunpassed`
--

DROP TABLE IF EXISTS `centerlorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centerlorderunpassed` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `target` varchar(20) NOT NULL,
  `vanid` char(9) CHARACTER SET latin1 NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `escort` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `cost` double NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centerlorderunpassed`
--

LOCK TABLES `centerlorderunpassed` WRITE;
/*!40000 ALTER TABLE `centerlorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `centerlorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centerlorderwaiting`
--

DROP TABLE IF EXISTS `centerlorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centerlorderwaiting` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `target` varchar(20) NOT NULL,
  `vanid` char(9) CHARACTER SET latin1 NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `escort` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `cost` double NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centerlorderwaiting`
--

LOCK TABLES `centerlorderwaiting` WRITE;
/*!40000 ALTER TABLE `centerlorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `centerlorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citiesinfo`
--

DROP TABLE IF EXISTS `citiesinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citiesinfo` (
  `city1` varchar(20) CHARACTER SET gbk NOT NULL,
  `city2` varchar(20) CHARACTER SET gbk NOT NULL,
  `distance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citiesinfo`
--

LOCK TABLES `citiesinfo` WRITE;
/*!40000 ALTER TABLE `citiesinfo` DISABLE KEYS */;
INSERT INTO `citiesinfo` VALUES ('南京','北京',900);
/*!40000 ALTER TABLE `citiesinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` char(4) NOT NULL,
  `name` varchar(20) CHARACTER SET gbk NOT NULL,
  `province` varchar(20) CHARACTER SET gbk NOT NULL,
  `keyid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`keyid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('010','北京','北京',28),('025','南京','江苏',29);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diary`
--

DROP TABLE IF EXISTS `diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diary` (
  `time` datetime NOT NULL,
  `record` varchar(30) CHARACTER SET gbk NOT NULL,
  `operator` varchar(30) CHARACTER SET gbk NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` VALUES ('2015-12-08 21:50:30','修改了用户MoFaShi','历史的行程'),('2015-12-08 21:57:28','添加账户蛤','小平同志'),('2015-12-08 22:50:11','新增城市重庆','江主席'),('2015-12-09 10:05:33','审批了单据','江主席'),('2015-12-09 10:08:44','审批了单据','江主席'),('2015-12-09 10:49:59','审批了单据','江主席'),('2015-12-09 11:01:02','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:01:17','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:01:18','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:01:20','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:04:47','生成快递单1000012233','徐嘉诰'),('2015-12-09 11:31:01','审批了单据','江主席'),('2015-12-09 11:31:04','审批了单据','江主席'),('2015-12-09 11:31:10','审批了单据','江主席'),('2015-12-09 11:33:13','生成快递单1234567890','徐嘉诰'),('2015-12-09 11:33:39','生成快递单0987654321','徐嘉诰'),('2015-12-09 11:34:01','生成快递单4444433333','徐嘉诰'),('2015-12-09 11:34:13','审批了单据','江主席'),('2015-12-09 11:35:54','审批了单据','江主席'),('2015-12-09 17:46:35','修改了用户profzhang','历史的行程'),('2015-12-09 17:55:32','生成了收款单','香港记者'),('2015-12-09 18:21:33','生成快递单1000011100','徐嘉诰'),('2015-12-09 18:21:48','审批了单据','江主席'),('2015-12-09 18:34:07','生成快递单1231321231','徐嘉诰'),('2015-12-09 18:34:28','审批了单据','江主席'),('2015-12-09 18:34:33','审批了单据','江主席'),('2015-12-09 18:53:32','新增司机025000001','香港记者'),('2015-12-09 18:59:52','新增司机025000001','香港记者'),('2015-12-09 19:01:56','修改司机025000001','香港记者'),('2015-12-09 19:05:30','新增司机025000002','香港记者'),('2015-12-09 19:05:42','删除司机025000002','香港记者'),('2015-12-09 19:05:48','修改司机025000001','香港记者'),('2015-12-09 19:14:05','添加车辆025000001','香港记者'),('2015-12-09 19:29:42','生成快递单1234554321','徐嘉诰'),('2015-12-09 19:29:58','审批了单据','江主席'),('2015-12-09 19:43:40','添加车辆025000001','香港记者'),('2015-12-09 19:51:08','添加车辆025000001','香港记者'),('2015-12-09 19:53:19','修改车辆025000001','香港记者'),('2015-12-09 19:59:20','添加车辆025000001','香港记者'),('2015-12-09 19:59:50','修改车辆025000001','香港记者'),('2015-12-09 20:03:19','添加车辆025000001','香港记者'),('2015-12-09 20:05:26','修改车辆025000001','香港记者'),('2015-12-09 20:05:43','修改车辆025000001','香港记者'),('2015-12-09 20:08:14','修改车辆025000001','香港记者'),('2015-12-09 20:08:29','修改车辆025000001','香港记者'),('2015-12-09 20:22:14','生成快递单1234554321','徐嘉诰'),('2015-12-09 20:39:17','新增账','张钟俊'),('2015-12-09 20:45:40','删除账0','张钟俊'),('2015-12-09 20:45:41','新增账','张钟俊'),('2015-12-09 20:46:18','删除账0','张钟俊'),('2015-12-09 20:46:19','新增账','张钟俊'),('2015-12-09 20:51:02','删除账0','张钟俊'),('2015-12-09 20:51:03','新增账','张钟俊'),('2015-12-09 20:53:37','删除账0','张钟俊'),('2015-12-09 21:09:10','修改司机025000001','香港记者'),('2015-12-09 21:18:17','修改了重庆的信息','江主席'),('2015-12-09 21:28:10','审批了单据','江主席'),('2015-12-09 21:28:19','审批了单据','江主席'),('2015-12-09 21:31:16','审批了单据','江主席'),('2015-12-09 21:31:54','修改了用户haha','历史的行程'),('2015-12-10 10:09:03','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:10:43','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:11:20','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:12:54','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:40:47','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:43:09','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:43:41','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:43:53','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:44:12','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:47:53','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:48:28','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:50:19','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:54:05','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:54:39','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:55:19','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:55:28','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:55:58','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:57:05','修改了用户MoFaShi','历史的行程'),('2015-12-10 10:59:19','修改了用户MoFaShi','历史的行程'),('2015-12-10 11:00:03','修改了用户MoFaShi','历史的行程'),('2015-12-10 11:00:55','修改了用户MoFaShi','历史的行程'),('2015-12-10 11:01:27','修改了用户MoFaShi','历史的行程'),('2015-12-10 11:03:37','修改了用户MoFaShi','历史的行程'),('2015-12-10 16:08:52','生成了营业厅装车单','香港记者'),('2015-12-10 16:12:58','生成了营业厅装车单','香港记者'),('2015-12-10 16:14:12','生成了营业厅装车单','香港记者'),('2015-12-10 16:15:57','生成了营业厅装车单','香港记者'),('2015-12-10 16:17:51','生成了营业厅装车单','香港记者'),('2015-12-10 16:21:22','生成了营业厅装车单','香港记者'),('2015-12-10 16:22:38','生成了营业厅装车单','香港记者'),('2015-12-10 16:39:13','生成快递单1000000000','徐嘉诰'),('2015-12-10 16:39:29','审批了单据','长者'),('2015-12-10 16:43:00','生成了营业厅装车单','香港记者'),('2015-12-10 16:54:34','新增机构010000','长者'),('2015-12-10 16:55:52','新增机构0100','长者'),('2015-12-10 17:19:21','审批了单据','长者'),('2015-12-10 17:19:30','审批了单据','长者'),('2015-12-10 17:21:40','修改了用户xixi','历史的行程'),('2015-12-10 17:23:19','修改了用户xixi','历史的行程'),('2015-12-10 17:23:53','修改了用户xixi','历史的行程'),('2015-12-10 18:30:10','审批了单据','长者'),('2015-12-10 18:30:35','修改南京和北京间信息','长者'),('2015-12-10 18:30:41','修改南京和北京间信息','长者'),('2015-12-10 18:40:20','删除人员12345','长者'),('2015-12-10 18:40:41','修改人员历史的行程','长者'),('2015-12-10 18:43:07','修改北京和深圳间信息','长者'),('2015-12-10 18:43:42','修改北京和合肥间信息','长者'),('2015-12-10 18:44:31','修改北京和太原间信息','长者'),('2015-12-10 18:44:55','修改北京和济南间信息','长者'),('2015-12-10 18:45:20','修改北京和重庆间信息','长者'),('2015-12-10 18:49:39','生成了营业厅装车单','香港记者'),('2015-12-10 19:08:00','审批了单据','长者'),('2015-12-10 19:08:02','审批了单据','长者'),('2015-12-10 19:08:26','生成了到达单0250002015121000000','董建华'),('2015-12-10 19:14:34','审批了单据','长者'),('2015-12-10 19:15:13','生成了到达单0250002015121000000','董建华'),('2015-12-10 19:17:39','审批了单据','长者'),('2015-12-10 19:17:50','生成了到达单0250002015121000000','董建华'),('2015-12-10 19:18:46','修改人员董建华','长者'),('2015-12-10 19:18:59','审批了单据','长者'),('2015-12-10 19:19:03','审批了单据','长者'),('2015-12-10 19:19:22','生成了到达单0250002015121000000','董建华'),('2015-12-10 19:25:48','新增用户123','历史的行程'),('2015-12-10 19:31:13','修改了用户1232','历史的行程'),('2015-12-10 19:31:16','修改了用户1232','历史的行程'),('2015-12-10 19:31:22','修改了用户1232','历史的行程'),('2015-12-10 19:31:26','删除用户1232','历史的行程'),('2015-12-10 19:31:33','新增用户sdafsd','历史的行程'),('2015-12-10 19:31:36','修改了用户sdafsd','历史的行程'),('2015-12-10 19:31:38','删除用户sdafsd','历史的行程'),('2015-12-10 19:35:56','生成快递单1234554333','徐嘉诰'),('2015-12-10 19:38:20','修改了用户MoFaShi','历史的行程'),('2015-12-10 19:38:26','修改了用户MoFaShi','历史的行程'),('2015-12-10 19:39:28','生成快递单1234554332','徐嘉诰'),('2015-12-10 19:46:32','审批了单据','长者'),('2015-12-10 19:46:40','审批了单据','长者'),('2015-12-10 19:46:42','审批了单据','长者'),('2015-12-10 19:48:07','审批了单据','长者'),('2015-12-10 19:51:01','生成快递单1234544444','徐嘉诰'),('2015-12-10 19:51:16','审批了单据','长者'),('2015-12-10 19:51:17','审批了单据','长者'),('2015-12-10 19:51:19','审批了单据','长者'),('2015-12-10 19:51:20','审批了单据','长者'),('2015-12-10 19:51:48','审批了单据','长者'),('2015-12-10 19:54:56','修改了用户MoFaShi','历史的行程'),('2015-12-10 19:55:57','修改了用户MoFaShi','历史的行程'),('2015-12-10 20:23:14','生成快递单1233211232','徐嘉诰'),('2015-12-10 20:23:35','生成快递单1233332221','徐嘉诰'),('2015-12-10 20:25:17','审批了单据','长者'),('2015-12-10 20:27:16','生成快递单5555522222','徐嘉诰'),('2015-12-10 20:27:36','生成快递单2342344333','徐嘉诰'),('2015-12-10 20:28:02','审批了单据','长者'),('2015-12-10 20:28:51','生成快递单6546546544','徐嘉诰'),('2015-12-10 20:29:10','生成快递单1233211233','徐嘉诰'),('2015-12-10 20:29:19','审批了单据','长者'),('2015-12-10 20:29:22','审批了单据','长者'),('2015-12-10 20:29:29','审批了单据','长者'),('2015-12-10 20:40:56','生成了收款单','香港记者'),('2015-12-10 20:41:04','生成了收款单','香港记者'),('2015-12-13 20:00:21','修改了用户MoFaShi','历史的行程'),('2015-12-13 20:10:21','生成快递单1234567891','徐嘉诰'),('2015-12-13 20:22:04','审批了单据','长者'),('2015-12-13 20:23:13','生成了收款单','香港记者'),('2015-12-13 20:25:04','审批了单据','长者'),('2015-12-13 20:25:20','审批了单据','长者'),('2015-12-13 20:32:59','审批了单据','长者'),('2015-12-13 20:34:29','审批了单据','长者'),('2015-12-13 20:34:43','审批了单据','长者'),('2015-12-13 20:34:46','审批了单据','长者'),('2015-12-13 20:35:15','生成快递单1102203304','徐嘉诰'),('2015-12-13 21:20:57','生成了营业厅装车单','香港记者'),('2015-12-13 21:25:50','生成了营业厅装车单','香港记者'),('2015-12-13 21:28:14','修改了用户hahaha','历史的行程'),('2015-12-13 21:44:50','修改了用户Mrdong','历史的行程'),('2015-12-13 21:46:18','修改了用户Mrdong','历史的行程'),('2015-12-13 21:46:24','修改了用户Mrdong','历史的行程'),('2015-12-13 21:49:45','添加了架025000000','朱物华'),('2015-12-13 22:47:15','添加了架025000000','朱物华'),('2015-12-13 22:52:18','添加了架025000000','朱物华'),('2015-12-13 22:55:39','添加了架025000000','朱物华'),('2015-12-13 22:55:51','添加了架025000001','朱物华'),('2015-12-13 22:56:15','添加了架025000002','朱物华'),('2015-12-13 22:56:29','添加了架025000003','朱物华'),('2015-12-14 20:45:02','为货物1000000000生成了入库单','朱物华'),('2015-12-14 20:47:15','修改了用户haha','历史的行程'),('2015-12-14 20:48:47','审批了单据','长者'),('2015-12-14 20:49:43','审批了单据','长者'),('2015-12-14 20:57:44','为货物5555522222生成了入库单','朱物华'),('2015-12-14 21:10:54','审批了单据','长者'),('2015-12-14 21:25:32','修改了用户baohua','历史的行程'),('2015-12-14 21:25:57','修改了用户baohua','历史的行程'),('2015-12-14 21:28:31','新增用户nazi','历史的行程'),('2015-12-14 21:30:09','新增用户luxi','历史的行程'),('2015-12-14 21:33:11','删除用户luxi','历史的行程'),('2015-12-14 21:35:37','修改了用户hahaha','历史的行程'),('2015-12-14 21:44:27','修改了用户admin','历史的行程'),('2015-12-14 21:52:37','修改了用户admin','历史的行程'),('2015-12-14 22:01:41','修改了用户nazi','历史的行程'),('2015-12-14 22:09:22','修改了用户nazi','历史的行程'),('2015-12-14 22:15:29','新增用户cancer','历史的行程'),('2015-12-14 22:16:07','新增用户1234','历史的行程'),('2015-12-14 22:18:18','修改了用户MoFaShi','历史的行程'),('2015-12-14 22:44:07','审批了单据','纳兹&露西'),('2015-12-14 22:44:11','审批了单据','纳兹&露西'),('2015-12-14 23:05:01','新增城市南京','纳兹&露西'),('2015-12-14 23:05:45','新增城市南京','纳兹&露西'),('2015-12-14 23:06:05','删除城市南京','纳兹&露西'),('2015-12-14 23:07:17','新增城市南京','纳兹&露西'),('2015-12-15 19:02:05','生成了收款单','香港记者'),('2015-12-15 19:06:32','审批了单据','纳兹&露西'),('2015-12-15 19:06:34','审批了单据','纳兹&露西'),('2015-12-15 19:06:35','审批了单据','纳兹&露西'),('2015-12-15 19:25:07','生成快递单1234567890','1234'),('2015-12-15 19:27:37','生成快递单0987654321','1234'),('2015-12-15 19:30:10','新增司机025000002','香港记者'),('2015-12-15 19:31:43','新增司机025000003','香港记者'),('2015-12-15 19:37:02','审批了单据','纳兹&露西'),('2015-12-15 19:37:37','添加车辆25000002','香港记者'),('2015-12-15 19:37:39','审批了单据','纳兹&露西'),('2015-12-15 19:38:22','生成快递单1231234567','1234'),('2015-12-15 19:38:34','生成快递单4564561234','1234'),('2015-12-15 19:39:11','审批了单据','纳兹&露西'),('2015-12-15 19:39:18','审批了单据','纳兹&露西'),('2015-12-15 19:39:54','审批了单据','纳兹&露西'),('2015-12-15 19:42:33','删除车辆025000001','香港记者'),('2015-12-15 19:44:53','修改车辆25000002','香港记者'),('2015-12-15 19:45:10','修改车辆25000002','香港记者'),('2015-12-15 19:46:02','修改太原和深圳间信息','纳兹&露西'),('2015-12-15 19:46:54','添加车辆25000003','香港记者'),('2015-12-15 19:49:56','新增城市哈尔滨','纳兹&露西'),('2015-12-15 19:51:57','新增城市泗洪','纳兹&露西'),('2015-12-15 19:54:01','删除城市泗洪','纳兹&露西'),('2015-12-15 19:56:27','修改北京和上海间信息','纳兹&露西'),('2015-12-15 19:56:46','修改北京和上海间信息','纳兹&露西'),('2015-12-15 20:00:47','为货物1000000000生成了入库单','朱物华'),('2015-12-15 20:01:29','修改了用户haha','历史的行程'),('2015-12-15 20:02:19','修改北京和上海间信息','纳兹&露西'),('2015-12-15 20:02:41','审批了单据','长者'),('2015-12-15 20:15:53','修改了北京的信息','纳兹&露西'),('2015-12-15 20:17:24','修改了南京的信息','纳兹&露西'),('2015-12-15 20:26:09','修改上海和深圳间信息','纳兹&露西'),('2015-12-15 20:27:09','修改了南京的信息','纳兹&露西'),('2015-12-15 20:27:28','修改了南京的信息','纳兹&露西'),('2015-12-15 20:28:33','设置了常量','纳兹&露西'),('2015-12-15 20:29:39','设置了常量','纳兹&露西'),('2015-12-15 20:30:40','设置了警戒线','朱物华'),('2015-12-15 20:30:55','设置了警戒线','朱物华'),('2015-12-15 20:31:24','设置了常量','纳兹&露西'),('2015-12-15 20:31:44','设置了常量','纳兹&露西'),('2015-12-15 20:32:08','设置了常量','纳兹&露西'),('2015-12-15 20:32:44','设置了常量','纳兹&露西'),('2015-12-15 20:33:20','设置了常量','纳兹&露西'),('2015-12-15 20:33:51','设置了常量','纳兹&露西'),('2015-12-15 20:33:59','设置了常量','纳兹&露西'),('2015-12-15 20:34:06','设置了常量','纳兹&露西'),('2015-12-15 20:35:48','新增城市nanjing','纳兹&露西'),('2015-12-15 20:36:00','删除城市nanjing','纳兹&露西'),('2015-12-15 20:36:22','删除了架025000003','朱物华'),('2015-12-15 20:38:32','设置了常量','纳兹&露西'),('2015-12-15 20:42:05','设置了常量','纳兹&露西'),('2015-12-15 20:42:25','设置了常量','纳兹&露西'),('2015-12-15 20:42:38','设置了常量','纳兹&露西'),('2015-12-15 20:42:52','设置了常量','纳兹&露西'),('2015-12-15 20:43:03','设置了常量','纳兹&露西'),('2015-12-15 20:43:45','添加了架025000003','朱物华'),('2015-12-15 20:44:06','设置了常量','纳兹&露西'),('2015-12-15 20:44:40','设置了常量','纳兹&露西'),('2015-12-15 20:45:26','设置了常量','纳兹&露西'),('2015-12-15 20:45:44','设置了常量','纳兹&露西'),('2015-12-15 20:46:13','添加了架025000004','朱物华'),('2015-12-15 20:57:49','修改人员纳兹&露西','纳兹&露西'),('2015-12-15 20:58:14','修改人员长者','纳兹&露西'),('2015-12-15 20:58:44','新增人员长者','纳兹&露西'),('2015-12-15 20:59:17','新增人员长者','纳兹&露西'),('2015-12-15 20:59:39','新增人员','纳兹&露西'),('2015-12-15 21:15:08','修改了北京的信息','长者'),('2015-12-15 21:56:04','设置了常量','长者'),('2015-12-15 21:59:30','修改了南京的信息','长者'),('2015-12-15 21:59:42','修改北京和南京间信息','长者'),('2015-12-15 22:06:20','修改北京和南京间信息','长者'),('2015-12-15 22:07:00','删除城市哈尔滨','长者'),('2015-12-15 22:07:03','删除城市南京','长者'),('2015-12-15 22:07:06','删除城市上海','长者'),('2015-12-15 22:07:08','删除城市深圳','长者'),('2015-12-15 22:07:10','删除城市合肥','长者'),('2015-12-15 22:07:12','删除城市太原','长者'),('2015-12-15 22:07:14','删除城市重庆','长者'),('2015-12-15 22:07:16','删除城市广州','长者'),('2015-12-15 22:07:18','删除城市济南','长者'),('2015-12-15 22:07:21','删除城市北京','长者'),('2015-12-15 22:07:34','新增城市北京','长者'),('2015-12-15 22:07:44','新增城市南京','长者'),('2015-12-15 22:07:51','修改北京和南京间信息','长者'),('2015-12-15 22:55:53','生成了中转单0250201512150000000','董建华'),('2015-12-15 23:10:13','生成了中转单0250201512150000000','董建华'),('2015-12-15 23:20:44','生成了中转单0250201512150000000','董建华'),('2015-12-15 23:20:55','审批了单据','长者'),('2015-12-15 23:39:21','为货物1000000000生成了出库单','朱物华'),('2015-12-15 23:41:43','为货物1000000000生成了出库单','朱物华'),('2015-12-15 23:42:51','为货物1000000000生成了出库单','朱物华'),('2015-12-15 23:44:27','审批了单据','长者'),('2015-12-16 10:32:01','删除用户null','历史的行程'),('2015-12-16 10:32:04','删除用户null','历史的行程'),('2015-12-16 10:32:07','删除用户null','历史的行程'),('2015-12-16 10:32:19','删除用户cancer','历史的行程'),('2015-12-16 10:35:30','修改了用户report','历史的行程'),('2015-12-16 10:36:27','修改了用户highest','历史的行程'),('2015-12-16 10:37:01','删除人员null','长者'),('2015-12-16 10:37:03','删除人员null','长者'),('2015-12-16 10:37:06','删除人员null','长者'),('2015-12-16 10:38:49','修改人员彭定康','长者'),('2015-12-16 10:38:55','修改人员华莱士','长者'),('2015-12-16 10:55:31','生成了到达单0250201512150000000','彭定康'),('2015-12-16 10:56:00','审批了单据','长者'),('2015-12-16 11:00:26','生成了到达单0250201512150000000','彭定康'),('2015-12-16 11:02:49','新增机构025100','长者'),('2015-12-16 11:05:18','新增机构2','长者'),('2015-12-16 11:07:57','删除机构2','长者'),('2015-12-16 11:09:01','修改机构025100','长者'),('2015-12-16 11:09:07','修改机构025100','长者'),('2015-12-16 11:09:33','修改机构025200','长者'),('2015-12-16 11:09:46','修改机构025200','长者'),('2015-12-16 11:10:00','修改机构025200','长者'),('2015-12-16 11:10:11','修改机构025200','长者'),('2015-12-16 11:08:30','设置了警戒线','朱物华'),('2015-12-16 11:10:54','修改机构025200','长者'),('2015-12-16 11:09:27','生成了付款单','张钟俊'),('2015-12-16 11:12:25','修改机构025000','长者'),('2015-12-16 11:42:43','为货物1231234567生成了出库单','朱物华'),('2015-12-16 11:41:58','审批了单据','长者'),('2015-12-16 11:42:07','审批了单据','长者');
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `id` char(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `idNum` char(18) NOT NULL,
  `mobile` char(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `driveStart` date NOT NULL,
  `driveEnd` date NOT NULL,
  `hallId` char(7) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES ('025000001','111111111111111111','111111111111111111','423423',0,'2015-12-09','2010-12-01','2015-12-09','025000'),('025000002','421122199510047807','421122199510047807','1826003510',0,'2015-12-15','2015-12-15','2015-12-15','025000'),('025000003','421122199510047807','421122199510047807','18260035103',0,'2015-12-15','2015-12-11','2015-12-13','025000');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expressorderpassed`
--

DROP TABLE IF EXISTS `expressorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expressorderpassed` (
  `id` char(10) CHARACTER SET latin1 NOT NULL,
  `sender` varchar(10) NOT NULL,
  `sendloc` varchar(50) NOT NULL,
  `receiver` varchar(10) NOT NULL,
  `receiveloc` varchar(50) NOT NULL,
  `sendMobile` char(11) CHARACTER SET latin1 NOT NULL,
  `receiveMobile` char(11) CHARACTER SET latin1 NOT NULL,
  `sendPhone` char(12) CHARACTER SET latin1 NOT NULL,
  `receivePhone` char(12) CHARACTER SET latin1 NOT NULL,
  `sendUnit` varchar(50) NOT NULL,
  `receiveUnit` varchar(50) NOT NULL,
  `num` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `length` double NOT NULL,
  `width` double NOT NULL,
  `height` double NOT NULL,
  `volumn` double NOT NULL,
  `arriveDate` date NOT NULL,
  `kind` int(11) NOT NULL,
  `cost` double NOT NULL,
  `realReceiver` varchar(10) DEFAULT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `weight` double NOT NULL,
  `parse` int(2) NOT NULL,
  `sendProvince` varchar(10) NOT NULL,
  `sendCity` varchar(20) NOT NULL,
  `receiveProvince` varchar(10) NOT NULL,
  `receiveCity` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expressorderpassed`
--

LOCK TABLES `expressorderpassed` WRITE;
/*!40000 ALTER TABLE `expressorderpassed` DISABLE KEYS */;
INSERT INTO `expressorderpassed` VALUES ('0987654321','寄件人','13111333111','收件人','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111',1,'5',5,3,2,30,'2015-12-09',2,10,NULL,NULL,'2015-12-09 11:33:38','徐嘉诰',4,1,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1000000000','寄件人','一个赛艇','收件人','新华门','12314214213','12341241231','','','','',1,'大新闻',0.5,0.6,0.5,0.15,'2015-12-14',0,170,NULL,NULL,'2015-12-10 16:39:12','徐嘉诰',5,0,'广东','广州','北京','北京','2015-12-10','MoFaShi'),('1000001001','寄件人','wefsadf','收件人','sdadasdas','13111333111','13111333111','13111333111','13111333111','asdsadas','sadasdasd',1,'31413',5,6,2,60,'2015-12-09',1,127,NULL,NULL,'2015-12-09 11:01:02','徐嘉诰',53,2,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1102203304','寄件人','1','收件人','1','18260035103','18260035103','','','','',1,'',1,1,1,1,'2015-12-13',0,4,NULL,NULL,'2015-12-13 20:35:15','徐嘉诰',2,0,'北京','北京','天津','null','2015-12-13','MoFaShi'),('1231234567','寄件人','哇咔咔','收件人','哈哈哈','15161229176','18360027890','','','','',1,'猪饲料',0.5,0.5,0.5,0.125,'2015-12-15',0,0,NULL,NULL,'2015-12-15 19:38:21','1234',5,0,'北京','北京','北京','北京','2015-12-15','1234'),('1233211232','寄件人','1','收件人','1','12332112321','12332112322','1','1','1','1',1,'1',1,1,1,1,'2015-12-10',1,2,NULL,NULL,'2015-12-10 20:23:14','徐嘉诰',1,1,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('1233211233','寄件人','2','收件人','2','12332112331','12332112331','2','2','2','2',1,'4',3,3,3,27,'2015-12-10',1,10,NULL,NULL,'2015-12-10 20:29:09','徐嘉诰',4,1,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('1233332221','寄件人','3','收件人','6','12333322211','12333322211','4','7','5','8',1,'6',2,3,4,24,'2015-12-10',1,12,NULL,NULL,'2015-12-10 20:23:35','徐嘉诰',5,1,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('1234544444','寄件人','1','收件人','1','12345444441','12345444441','1','1','1','1',1,'1',1,1,1,1,'2015-12-10',2,3,NULL,NULL,'2015-12-10 19:51:00','徐嘉诰',1,1,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('1234554321','寄件人','12345543211','收件人','12345543211','12345543211','12345543211','12345543211','12345543211','12345543211','12345543211',1,'7',5,6,5,150,'2015-12-09',1,12,NULL,NULL,'2015-12-09 20:22:14','徐嘉诰',5,1,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1234554332','寄件人','1','收件人','1','13111331331','13111331331','1','1','1','1',1,'2',5,4,3,60,'2015-12-10',1,12,NULL,NULL,'2015-12-10 19:39:28','徐嘉诰',5,0,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('1234554333','寄件人','1234554333','收件人','1234554333','12345543331','12345543331','1234554333','1234554333','1234554333','1',1,'2',5,4,3,60,'2015-12-10',1,12,NULL,NULL,'2015-12-10 19:35:56','徐嘉诰',5,1,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('1234567890','寄件人','fads','收件人','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111',1,'6',2,3,4,24,'2015-12-09',1,12,NULL,NULL,'2015-12-09 11:33:13','徐嘉诰',5,0,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1234567891','寄件人','蛤蛤家','收件人','阳阳家','18260035103','18260035103','','','','',1,'特别的礼物',1,1,1,1,'2015-12-16',0,16,NULL,NULL,'2015-12-13 20:10:21','徐嘉诰',1,0,'北京','北京','江苏','南京','2015-12-13','MoFaShi'),('2342344333','寄件人','1','收件人','1','23423443331','23423443331','1','1','1','1',1,'1',11,1,111,1221,'2015-12-10',1,2,NULL,NULL,'2015-12-10 20:27:36','徐嘉诰',1,1,'北京','北京','北京','北京','2015-12-10','MoFaShi'),('5555522222','寄件人','4','收件人','7','55555222221','55555222221','5','8','6','9',1,'2',3,4,56,672,'2015-12-10',1,14,NULL,NULL,'2015-12-10 20:27:16','徐嘉诰',6,0,'北京','北京','北京','北京','2015-12-10','MoFaShi');
/*!40000 ALTER TABLE `expressorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expressorderunpassed`
--

DROP TABLE IF EXISTS `expressorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expressorderunpassed` (
  `id` char(10) CHARACTER SET latin1 NOT NULL,
  `sender` varchar(10) NOT NULL,
  `sendloc` varchar(50) NOT NULL,
  `receiver` varchar(10) NOT NULL,
  `receiveloc` varchar(50) NOT NULL,
  `sendMobile` char(11) CHARACTER SET latin1 NOT NULL,
  `receiveMobile` char(11) CHARACTER SET latin1 NOT NULL,
  `sendPhone` char(12) CHARACTER SET latin1 NOT NULL,
  `receivePhone` char(12) CHARACTER SET latin1 NOT NULL,
  `sendUnit` varchar(50) NOT NULL,
  `receiveUnit` varchar(50) NOT NULL,
  `num` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `length` double NOT NULL,
  `width` double NOT NULL,
  `height` double NOT NULL,
  `volumn` double NOT NULL,
  `arriveDate` date NOT NULL,
  `kind` int(11) NOT NULL,
  `cost` double NOT NULL,
  `realReceiver` varchar(10) DEFAULT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `weight` double NOT NULL,
  `parse` int(2) NOT NULL,
  `sendProvince` varchar(10) NOT NULL,
  `sendCity` varchar(20) NOT NULL,
  `receiveProvince` varchar(10) NOT NULL,
  `receiveCity` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expressorderunpassed`
--

LOCK TABLES `expressorderunpassed` WRITE;
/*!40000 ALTER TABLE `expressorderunpassed` DISABLE KEYS */;
INSERT INTO `expressorderunpassed` VALUES ('4564561234','寄件人','吧啦吧啦','收件人','哇啦哇啦','18260035103','18260098869','','','','',1,'猪',1,1,1,1,'2015-12-15',1,7,NULL,NULL,'2015-12-15 19:38:34','1234',3,1,'北京','北京','北京','北京','2015-12-15','1234');
/*!40000 ALTER TABLE `expressorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expressorderwaiting`
--

DROP TABLE IF EXISTS `expressorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expressorderwaiting` (
  `id` char(10) CHARACTER SET latin1 NOT NULL,
  `sender` varchar(10) NOT NULL,
  `sendloc` varchar(50) NOT NULL,
  `receiver` varchar(10) NOT NULL,
  `receiveloc` varchar(50) NOT NULL,
  `sendMobile` char(11) CHARACTER SET latin1 NOT NULL,
  `receiveMobile` char(11) CHARACTER SET latin1 NOT NULL,
  `sendPhone` char(12) CHARACTER SET latin1 NOT NULL,
  `receivePhone` char(12) CHARACTER SET latin1 NOT NULL,
  `sendUnit` varchar(50) NOT NULL,
  `receiveUnit` varchar(50) NOT NULL,
  `num` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `length` double NOT NULL,
  `width` double NOT NULL,
  `height` double NOT NULL,
  `volumn` double NOT NULL,
  `arriveDate` date NOT NULL,
  `kind` int(11) NOT NULL,
  `cost` double NOT NULL,
  `realReceiver` varchar(10) DEFAULT NULL,
  `receiveTime` datetime DEFAULT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `weight` double NOT NULL,
  `parse` int(2) NOT NULL,
  `sendProvince` varchar(10) NOT NULL,
  `sendCity` varchar(20) NOT NULL,
  `receiveProvince` varchar(10) NOT NULL,
  `receiveCity` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expressorderwaiting`
--

LOCK TABLES `expressorderwaiting` WRITE;
/*!40000 ALTER TABLE `expressorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `expressorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good` (
  `id` char(10) CHARACTER SET latin1 NOT NULL,
  `stockId` char(7) CHARACTER SET latin1 NOT NULL,
  `destination` varchar(50) NOT NULL,
  `part` int(11) NOT NULL,
  `shelf` char(10) CHARACTER SET latin1 NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `halllorderpassed`
--

DROP TABLE IF EXISTS `halllorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `halllorderpassed` (
  `hallId` char(6) NOT NULL,
  `convertId` char(19) NOT NULL,
  `vanId` char(9) NOT NULL,
  `arriveloc` varchar(20) CHARACTER SET gbk NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) CHARACTER SET gbk NOT NULL,
  `cost` double NOT NULL,
  `userId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halllorderpassed`
--

LOCK TABLES `halllorderpassed` WRITE;
/*!40000 ALTER TABLE `halllorderpassed` DISABLE KEYS */;
INSERT INTO `halllorderpassed` VALUES ('025000','0250002015121000000','025000001','江苏省南京中转中心','郭伟华','徐嘉诰','2015-12-10','2015-12-10 18:49:39','1000000000 ','香港记者',1,'baohua'),('025000','123456','025000001','江苏省南京栖霞营业厅','1','1','2015-12-13','2015-12-13 21:20:57','1234567890 1234567891 ','香港记者',1.2,'baohua'),('025000','123456','025000001','江苏省南京栖霞营业厅','','','2015-12-13','2015-12-13 21:25:50','1234567890 ','香港记者',1,'baohua');
/*!40000 ALTER TABLE `halllorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `halllorderunpassed`
--

DROP TABLE IF EXISTS `halllorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `halllorderunpassed` (
  `hallId` char(6) NOT NULL,
  `convertId` char(19) NOT NULL,
  `vanId` char(9) NOT NULL,
  `arriveloc` varchar(20) CHARACTER SET gbk NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) CHARACTER SET gbk NOT NULL,
  `cost` double NOT NULL,
  `userId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halllorderunpassed`
--

LOCK TABLES `halllorderunpassed` WRITE;
/*!40000 ALTER TABLE `halllorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `halllorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `halllorderwaiting`
--

DROP TABLE IF EXISTS `halllorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `halllorderwaiting` (
  `hallId` char(6) CHARACTER SET latin1 NOT NULL,
  `convertId` char(19) CHARACTER SET latin1 NOT NULL,
  `vanId` char(9) CHARACTER SET latin1 NOT NULL,
  `arriveloc` varchar(20) NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `escort` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halllorderwaiting`
--

LOCK TABLES `halllorderwaiting` WRITE;
/*!40000 ALTER TABLE `halllorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `halllorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incomeorderpassed`
--

DROP TABLE IF EXISTS `incomeorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incomeorderpassed` (
  `id` char(21) NOT NULL,
  `courier` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `opName` varchar(10) NOT NULL,
  `orgId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `account` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incomeorderpassed`
--

LOCK TABLES `incomeorderpassed` WRITE;
/*!40000 ALTER TABLE `incomeorderpassed` DISABLE KEYS */;
INSERT INTO `incomeorderpassed` VALUES ('0250002015121500000','徐嘉诰',170,'2015-12-15','2015-12-15 19:02:05','1000000000 ','香港记者','025000','baohua','excited');
/*!40000 ALTER TABLE `incomeorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incomeorderunpassed`
--

DROP TABLE IF EXISTS `incomeorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incomeorderunpassed` (
  `id` char(21) NOT NULL,
  `courier` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `opName` varchar(10) NOT NULL,
  `orgId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `account` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incomeorderunpassed`
--

LOCK TABLES `incomeorderunpassed` WRITE;
/*!40000 ALTER TABLE `incomeorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `incomeorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incomeorderwaiting`
--

DROP TABLE IF EXISTS `incomeorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incomeorderwaiting` (
  `id` char(21) NOT NULL,
  `courier` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `opName` varchar(10) NOT NULL,
  `orgId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `account` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incomeorderwaiting`
--

LOCK TABLES `incomeorderwaiting` WRITE;
/*!40000 ALTER TABLE `incomeorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `incomeorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org`
--

DROP TABLE IF EXISTS `org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `kind` int(11) NOT NULL,
  `location` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `cityId` char(4) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org`
--

LOCK TABLES `org` WRITE;
/*!40000 ALTER TABLE `org` DISABLE KEYS */;
INSERT INTO `org` VALUES ('0','总部',2,'东城区故宫博物院','北京','010'),('0100','北京市中转中心',1,'五环','北京','021'),('010000','北京东城区营业厅',0,'东城区长安街','北京','021'),('0250','江苏省南京中转中心',1,'栖霞区仙林大道163号','南京','025'),('025000','南京市鼓楼区营业厅',0,'南京鼓楼区广州路36号','南京','025'),('025100','南京市鼓楼区营业厅',0,'南京鼓楼区广州路36号','南京','025');
/*!40000 ALTER TABLE `org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentorderpassed`
--

DROP TABLE IF EXISTS `paymentorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentorderpassed` (
  `id` char(21) NOT NULL,
  `payer` varchar(10) NOT NULL,
  `account` varchar(20) NOT NULL,
  `kind` int(11) NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentorderpassed`
--

LOCK TABLES `paymentorderpassed` WRITE;
/*!40000 ALTER TABLE `paymentorderpassed` DISABLE KEYS */;
INSERT INTO `paymentorderpassed` VALUES ('2015121600000','鸭嘴笔','excited',1,500,'excited!','2015-12-16','2015-12-16 11:09:27','张钟俊','profzhang');
/*!40000 ALTER TABLE `paymentorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentorderunpassed`
--

DROP TABLE IF EXISTS `paymentorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentorderunpassed` (
  `id` char(21) NOT NULL,
  `payer` varchar(10) NOT NULL,
  `account` varchar(20) NOT NULL,
  `kind` int(11) NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentorderunpassed`
--

LOCK TABLES `paymentorderunpassed` WRITE;
/*!40000 ALTER TABLE `paymentorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentorderwaiting`
--

DROP TABLE IF EXISTS `paymentorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentorderwaiting` (
  `id` char(21) NOT NULL,
  `payer` varchar(10) NOT NULL,
  `account` varchar(20) NOT NULL,
  `kind` int(11) NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentorderwaiting`
--

LOCK TABLES `paymentorderwaiting` WRITE;
/*!40000 ALTER TABLE `paymentorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipientorderpassed`
--

DROP TABLE IF EXISTS `recipientorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipientorderpassed` (
  `id` char(23) NOT NULL,
  `transitId` char(19) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `state` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipientorderpassed`
--

LOCK TABLES `recipientorderpassed` WRITE;
/*!40000 ALTER TABLE `recipientorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipientorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipientorderunpassed`
--

DROP TABLE IF EXISTS `recipientorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipientorderunpassed` (
  `id` char(23) NOT NULL,
  `transitId` char(19) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `state` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipientorderunpassed`
--

LOCK TABLES `recipientorderunpassed` WRITE;
/*!40000 ALTER TABLE `recipientorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipientorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipientorderwaiting`
--

DROP TABLE IF EXISTS `recipientorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipientorderwaiting` (
  `id` char(23) NOT NULL,
  `transitId` char(19) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `state` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipientorderwaiting`
--

LOCK TABLES `recipientorderwaiting` WRITE;
/*!40000 ALTER TABLE `recipientorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipientorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sendorderpassed`
--

DROP TABLE IF EXISTS `sendorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendorderpassed` (
  `id` char(23) NOT NULL,
  `expressId` char(10) NOT NULL,
  `courier` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendorderpassed`
--

LOCK TABLES `sendorderpassed` WRITE;
/*!40000 ALTER TABLE `sendorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `sendorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sendorderunpassed`
--

DROP TABLE IF EXISTS `sendorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendorderunpassed` (
  `id` char(23) NOT NULL,
  `expressId` char(10) NOT NULL,
  `courier` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendorderunpassed`
--

LOCK TABLES `sendorderunpassed` WRITE;
/*!40000 ALTER TABLE `sendorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `sendorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sendorderwaiting`
--

DROP TABLE IF EXISTS `sendorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sendorderwaiting` (
  `id` char(23) NOT NULL,
  `expressId` char(10) NOT NULL,
  `courier` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sendorderwaiting`
--

LOCK TABLES `sendorderwaiting` WRITE;
/*!40000 ALTER TABLE `sendorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `sendorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shelf`
--

DROP TABLE IF EXISTS `shelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shelf` (
  `id` char(10) NOT NULL,
  `stockId` char(7) NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `part` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shelf`
--

LOCK TABLES `shelf` WRITE;
/*!40000 ALTER TABLE `shelf` DISABLE KEYS */;
INSERT INTO `shelf` VALUES ('025000000','0250',5,6,0),('025000001','0250',5,8,1),('025000002','0250',6,8,2),('025000003','0250',2,5,0),('025000004','0250',12,555,0);
/*!40000 ALTER TABLE `shelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockinorderpassed`
--

DROP TABLE IF EXISTS `stockinorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockinorderpassed` (
  `id` char(21) NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `arrivePlace` varchar(20) NOT NULL,
  `part` int(11) NOT NULL,
  `shelfId` char(10) CHARACTER SET latin1 NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockinorderpassed`
--

LOCK TABLES `stockinorderpassed` WRITE;
/*!40000 ALTER TABLE `stockinorderpassed` DISABLE KEYS */;
INSERT INTO `stockinorderpassed` VALUES ('02502015121500000','1000000000','北京市中转中心',0,'25000000',1,1,'2015-12-15','2015-12-15 20:00:47','朱物华','0250','ProfZhu');
/*!40000 ALTER TABLE `stockinorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockinorderunpassed`
--

DROP TABLE IF EXISTS `stockinorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockinorderunpassed` (
  `id` char(21) NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `arrivePlace` varchar(20) NOT NULL,
  `part` int(11) NOT NULL,
  `shelfId` char(10) CHARACTER SET latin1 NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockinorderunpassed`
--

LOCK TABLES `stockinorderunpassed` WRITE;
/*!40000 ALTER TABLE `stockinorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockinorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockinorderwaiting`
--

DROP TABLE IF EXISTS `stockinorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockinorderwaiting` (
  `id` char(21) NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `arrivePlace` varchar(20) NOT NULL,
  `part` int(11) NOT NULL,
  `shelfId` char(10) CHARACTER SET latin1 NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockinorderwaiting`
--

LOCK TABLES `stockinorderwaiting` WRITE;
/*!40000 ALTER TABLE `stockinorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockinorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockoutorderloading`
--

DROP TABLE IF EXISTS `stockoutorderloading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockoutorderloading` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockoutorderloading`
--

LOCK TABLES `stockoutorderloading` WRITE;
/*!40000 ALTER TABLE `stockoutorderloading` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockoutorderloading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockoutorderpassed`
--

DROP TABLE IF EXISTS `stockoutorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockoutorderpassed` (
  `id` char(21) NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) CHARACTER SET latin1 NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) CHARACTER SET latin1 NOT NULL,
  `arrivePlace` varchar(50) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockoutorderpassed`
--

LOCK TABLES `stockoutorderpassed` WRITE;
/*!40000 ALTER TABLE `stockoutorderpassed` DISABLE KEYS */;
INSERT INTO `stockoutorderpassed` VALUES ('02502015121500000','1000000000',1,'0250201512150000000','2015-12-15','2015-12-15 23:42:51','朱物华','0250','北京市中转中心','ProfZhu');
/*!40000 ALTER TABLE `stockoutorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockoutorderunpassed`
--

DROP TABLE IF EXISTS `stockoutorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockoutorderunpassed` (
  `id` char(21) NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) CHARACTER SET latin1 NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) CHARACTER SET latin1 NOT NULL,
  `arrivePlace` varchar(50) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockoutorderunpassed`
--

LOCK TABLES `stockoutorderunpassed` WRITE;
/*!40000 ALTER TABLE `stockoutorderunpassed` DISABLE KEYS */;
INSERT INTO `stockoutorderunpassed` VALUES ('02502015121600000','1231234567',0,'0250002015111600000','2015-12-16','2015-12-16 11:42:43','朱物华','0250','总部','ProfZhu');
/*!40000 ALTER TABLE `stockoutorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockoutorderwaiting`
--

DROP TABLE IF EXISTS `stockoutorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockoutorderwaiting` (
  `id` char(21) NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) CHARACTER SET latin1 NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) CHARACTER SET latin1 NOT NULL,
  `arrivePlace` varchar(50) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockoutorderwaiting`
--

LOCK TABLES `stockoutorderwaiting` WRITE;
/*!40000 ALTER TABLE `stockoutorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockoutorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitinfo`
--

DROP TABLE IF EXISTS `transitinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transitinfo` (
  `id` char(10) CHARACTER SET latin1 NOT NULL,
  `info` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitinfo`
--

LOCK TABLES `transitinfo` WRITE;
/*!40000 ALTER TABLE `transitinfo` DISABLE KEYS */;
INSERT INTO `transitinfo` VALUES ('0987654321','2015-12-09 11:33:39 江苏省南京栖霞营业厅快递员 已收件;'),('1000000000','2015-12-10 16:39:12 江苏省南京栖霞营业厅快递员 已收件;2015-12-10 16:43:00 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京中转中心;2015-12-10 18:49:39 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京中转中心;2015-12-10 19:08:26 null 已收入;2015-12-10 19:15:13 null 已收入;2015-12-10 19:17:50 null 已收入;2015-12-10 19:19:22 null 已收入;2015-12-15 23:20:55 江苏省南京中转中心 已发出 下一站 北京市中转中心;2015-12-16 11:02:49 北京市中转中心 已收入;'),('1000000011','2015-12-09 10:55:23 江苏省南京栖霞营业厅快递员 已收件;'),('1000001001','2015-12-09 11:01:02 江苏省南京栖霞营业厅快递员 已收件;'),('1000011100','2015-12-09 18:21:33 江苏省南京栖霞营业厅快递员 已收件;'),('1000012233','2015-12-09 11:04:47 江苏省南京栖霞营业厅快递员 已收件;'),('1102203304','2015-12-14 20:48:47 江苏省南京栖霞营业厅快递员 已收件;'),('1231321231','2015-12-09 18:34:07 江苏省南京栖霞营业厅快递员 已收件;'),('1233211232','2015-12-10 20:23:14 江苏省南京栖霞营业厅快递员 已收件;'),('1233211233','2015-12-10 20:29:09 江苏省南京栖霞营业厅快递员 已收件;'),('1233332221','2015-12-10 20:23:35 江苏省南京栖霞营业厅快递员 已收件;'),('1234544444','2015-12-10 19:51:01 江苏省南京栖霞营业厅快递员 已收件;'),('1234554321','2015-12-09 19:29:42 江苏省南京栖霞营业厅快递员 已收件;'),('1234554332','2015-12-10 19:39:28 江苏省南京栖霞营业厅快递员 已收件;'),('1234554333','2015-12-10 19:35:56 江苏省南京栖霞营业厅快递员 已收件;'),('1234567890','2015-12-09 11:33:13 江苏省南京栖霞营业厅快递员 已收件;2015-12-14 21:10:54 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京栖霞营业厅;'),('1234567891','2015-12-13 20:32:58 江苏省南京栖霞营业厅快递员 已收件;2015-12-14 21:10:54 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京栖霞营业厅;'),('2342344333','2015-12-10 20:27:36 江苏省南京栖霞营业厅快递员 已收件;'),('4444433333','2015-12-09 11:34:01 江苏省南京栖霞营业厅快递员 已收件;'),('5555522222','2015-12-10 20:27:16 江苏省南京栖霞营业厅快递员 已收件;'),('6546546544','2015-12-10 20:28:50 江苏省南京栖霞营业厅快递员 已收件;');
/*!40000 ALTER TABLE `transitinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitorderpassed`
--

DROP TABLE IF EXISTS `transitorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transitorderpassed` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `planeId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `arrivePlace` varchar(20) NOT NULL,
  `containerId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `transit` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitorderpassed`
--

LOCK TABLES `transitorderpassed` WRITE;
/*!40000 ALTER TABLE `transitorderpassed` DISABLE KEYS */;
INSERT INTO `transitorderpassed` VALUES ('0250201512150000000','null','江苏省南京中转中心','北京市中转中心','1-1','赛艇','2015-12-15','2015-12-15 23:20:44','董建华',0.9,'1000000000 ','Mrdong',1);
/*!40000 ALTER TABLE `transitorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitorderunpassed`
--

DROP TABLE IF EXISTS `transitorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transitorderunpassed` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `planeId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `arrivePlace` varchar(20) NOT NULL,
  `containerId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) CHARACTER SET latin1 NOT NULL,
  `cost` double NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `transit` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitorderunpassed`
--

LOCK TABLES `transitorderunpassed` WRITE;
/*!40000 ALTER TABLE `transitorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `transitorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitorderwaiting`
--

DROP TABLE IF EXISTS `transitorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transitorderwaiting` (
  `id` char(19) CHARACTER SET latin1 NOT NULL,
  `planeId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `arrivePlace` varchar(20) NOT NULL,
  `containerId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `supervision` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `transit` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitorderwaiting`
--

LOCK TABLES `transitorderwaiting` WRITE;
/*!40000 ALTER TABLE `transitorderwaiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `transitorderwaiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mobile` char(11) CHARACTER SET latin1 DEFAULT NULL,
  `juri` int(2) DEFAULT NULL,
  `keyid` int(11) NOT NULL AUTO_INCREMENT,
  `orgId` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `org` varchar(50) DEFAULT NULL,
  `kind` int(2) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `commission` int(11) DEFAULT NULL,
  PRIMARY KEY (`keyid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('haha','haha','长者','13999233233',6,3,'0250','江苏省南京中转中心',0,8000,0),('baohua','baohua','香港记者','13999110110',1,12,'025000','江苏省南京栖霞营业厅',0,7000,0),('Mrdong','Mrdong','董建华','13378539926',2,13,'0250','江苏省南京中转中心',0,7000,0),('ProfGuo','ProfGuo','郭伟华','',5,14,'null','总部',0,7000,0),('profzhang','profzhang','张钟俊','12314131231',4,15,'null','总部',0,7000,0),('ProfZhu','ProfZhu','朱物华','',3,16,'0250','江苏省南京中转中心',0,6000,0),('admin','admin','历史的行程','12345022321',7,19,'0','总部',0,5000,0),('MoFaShi','mofashi','徐嘉诰','17823421353',0,20,'025000','江苏省南京栖霞营业厅',2,5000,20),('report','report','彭定康','18260098864',2,21,'0100','北京市中转中心',0,0,0),('highest','highest','华莱士','12345678904',1,24,'010000','北京东城区营业厅',0,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `van`
--

DROP TABLE IF EXISTS `van`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `van` (
  `id` char(10) NOT NULL,
  `plateNum` char(10) NOT NULL,
  `servTime` date NOT NULL,
  `photo` varchar(30) NOT NULL,
  `hallId` char(7) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `van`
--

LOCK TABLES `van` WRITE;
/*!40000 ALTER TABLE `van` DISABLE KEYS */;
INSERT INTO `van` VALUES ('25000002','1231','2015-12-15','vanImage/25000002.jpg','025000'),('25000003','222','2015-12-15','vanImage/25000003.jpg','025000');
/*!40000 ALTER TABLE `van` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-16 16:24:42