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
INSERT INTO `account` VALUES (4,'excited',0),(5,'蛤',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arriveorderpassed`
--

DROP TABLE IF EXISTS `arriveorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arriveorderpassed` (
  `id` char(19) NOT NULL,
  `centerId` char(4) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `state` int(1) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arriveorderpassed`
--

LOCK TABLES `arriveorderpassed` WRITE;
/*!40000 ALTER TABLE `arriveorderpassed` DISABLE KEYS */;
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
  `opName` varchar(10) NOT NULL,
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
  `id` char(19) NOT NULL,
  `centerId` char(4) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `state` int(1) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` char(19) NOT NULL,
  `target` varchar(20) CHARACTER SET gbk NOT NULL,
  `vanid` char(9) NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `cost` double NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` char(19) NOT NULL,
  `target` varchar(20) CHARACTER SET gbk NOT NULL,
  `vanid` char(9) NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `cost` double NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` char(19) NOT NULL,
  `target` varchar(20) CHARACTER SET gbk NOT NULL,
  `vanid` char(9) NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `cost` double NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
INSERT INTO `citiesinfo` VALUES ('南京','北京',900),('123','北京',0),('南京','北京',900),('南京','123123123213',0),('123','北京',0),('123','123123123213',0),('123','南京',0),('45','北京',0),('45','123123123213',0),('45','南京',0),('45','123',0),('111','北京',0),('111','123123123213',0),('111','南京',0),('111','123',0),('111','45',0),('453123','北京',0),('453123','123123123213',0),('453123','南京',0),('453123','123',0),('453123','45',0),('453123','111',0),('453123','北京',0),('453123','123123123213',0),('453123','南京',0),('453123','123',0),('453123','45',0),('453123','111',0),('453123','453123',0),('453123','北京',0),('453123','123123123213',0),('453123','南京',0),('453123','123',0),('453123','45',0),('453123','111',0),('453123','453123',0),('453123','453123',0),('453123','北京',0),('453123','123123123213',0),('453123','南京',0),('453123','123',0),('453123','45',0),('453123','111',0),('453123','453123',0),('453123','453123',0),('453123','453123',0),('123','北京',0),('南京','北京',900),('上海','北京',1064.7),('上海','南京',266),('深圳','北京',0),('深圳','南京',0),('深圳','上海',0),('广州','北京',1888.8),('广州','南京',1132),('广州','上海',1213),('广州','深圳',0),('合肥','北京',0),('合肥','南京',0),('合肥','上海',0),('合肥','深圳',0),('合肥','广州',0),('太原','北京',0),('太原','南京',0),('太原','上海',0),('太原','深圳',0),('太原','广州',0),('太原','合肥',0),('济南','北京',0),('济南','南京',0),('济南','上海',0),('济南','深圳',0),('济南','广州',0),('济南','合肥',0),('济南','太原',0),('重庆','北京',0),('重庆','南京',0),('重庆','上海',0),('重庆','深圳',0),('重庆','广州',0),('重庆','合肥',0),('重庆','太原',0),('重庆','济南',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('021','北京','北京',5),('025','南京','江苏',16),('021','上海','上海',17),('0755','深圳','广东',18),('020','广州','广东',19),('0551','合肥','安徽',20),('0351','太原','山西',21),('0531','济南','山东',22),('023','重庆','重庆',23);
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
  `operator` varchar(30) CHARACTER SET gbk NOT NULL,
  PRIMARY KEY (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` VALUES ('2015-12-08 21:50:30','修改了用户MoFaShi','历史的行程'),('2015-12-08 21:57:28','添加账户蛤','小平同志'),('2015-12-08 22:50:11','新增城市重庆','江主席'),('2015-12-09 10:05:33','审批了单据','江主席'),('2015-12-09 10:08:44','审批了单据','江主席'),('2015-12-09 10:49:59','审批了单据','江主席'),('2015-12-09 11:01:02','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:01:17','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:01:18','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:01:20','生成快递单1000001001','徐嘉诰'),('2015-12-09 11:04:47','生成快递单1000012233','徐嘉诰'),('2015-12-09 11:31:01','审批了单据','江主席'),('2015-12-09 11:31:04','审批了单据','江主席'),('2015-12-09 11:31:10','审批了单据','江主席'),('2015-12-09 11:33:13','生成快递单1234567890','徐嘉诰'),('2015-12-09 11:33:39','生成快递单0987654321','徐嘉诰'),('2015-12-09 11:34:01','生成快递单4444433333','徐嘉诰'),('2015-12-09 11:34:13','审批了单据','江主席'),('2015-12-09 11:35:54','审批了单据','江主席'),('2015-12-09 17:46:35','修改了用户profzhang','历史的行程'),('2015-12-09 17:55:32','生成了收款单','香港记者'),('2015-12-09 18:21:33','生成快递单1000011100','徐嘉诰'),('2015-12-09 18:21:48','审批了单据','江主席'),('2015-12-09 18:34:07','生成快递单1231321231','徐嘉诰'),('2015-12-09 18:34:28','审批了单据','江主席'),('2015-12-09 18:34:33','审批了单据','江主席'),('2015-12-09 18:53:32','新增司机025000001','香港记者'),('2015-12-09 18:59:52','新增司机025000001','香港记者'),('2015-12-09 19:01:56','修改司机025000001','香港记者'),('2015-12-09 19:05:30','新增司机025000002','香港记者'),('2015-12-09 19:05:42','删除司机025000002','香港记者'),('2015-12-09 19:05:48','修改司机025000001','香港记者'),('2015-12-09 19:14:05','添加车辆025000001','香港记者'),('2015-12-09 19:29:42','生成快递单1234554321','徐嘉诰'),('2015-12-09 19:29:58','审批了单据','江主席'),('2015-12-09 19:43:40','添加车辆025000001','香港记者'),('2015-12-09 19:51:08','添加车辆025000001','香港记者'),('2015-12-09 19:53:19','修改车辆025000001','香港记者'),('2015-12-09 19:59:20','添加车辆025000001','香港记者'),('2015-12-09 19:59:50','修改车辆025000001','香港记者'),('2015-12-09 20:03:19','添加车辆025000001','香港记者'),('2015-12-09 20:05:26','修改车辆025000001','香港记者'),('2015-12-09 20:05:43','修改车辆025000001','香港记者'),('2015-12-09 20:08:14','修改车辆025000001','香港记者'),('2015-12-09 20:08:29','修改车辆025000001','香港记者'),('2015-12-09 20:22:14','生成快递单1234554321','徐嘉诰'),('2015-12-09 20:39:17','新增账','张钟俊'),('2015-12-09 20:45:40','删除账0','张钟俊'),('2015-12-09 20:45:41','新增账','张钟俊'),('2015-12-09 20:46:18','删除账0','张钟俊'),('2015-12-09 20:46:19','新增账','张钟俊'),('2015-12-09 20:51:02','删除账0','张钟俊'),('2015-12-09 20:51:03','新增账','张钟俊'),('2015-12-09 20:53:37','删除账0','张钟俊'),('2015-12-09 21:09:10','修改司机025000001','香港记者'),('2015-12-09 21:18:17','修改了重庆的信息','江主席'),('2015-12-09 21:28:10','审批了单据','江主席'),('2015-12-09 21:28:19','审批了单据','江主席'),('2015-12-09 21:31:16','审批了单据','江主席'),('2015-12-09 21:31:54','修改了用户haha','历史的行程');
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
INSERT INTO `driver` VALUES ('025000001','111111111111111111','111111111111111111','423423',0,'2015-12-09','2010-12-01','2015-12-09','025000');
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
INSERT INTO `expressorderpassed` VALUES ('0987654321','寄件人','13111333111','收件人','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111',1,'5',5,3,2,30,'2015-12-09',2,10,NULL,NULL,'2015-12-09 11:33:38','徐嘉诰',4,1,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1000000000','寄件人','一个赛艇','收件人','新华门','13241213413','13241231241','','','','',1,'大新闻',1,1,1,1,'2015-12-13',0,340,NULL,NULL,'2015-12-09 00:21:29','徐嘉诰',10,0,'广东','广州','北京','北京','2015-12-09','MoFaShi'),('1000001001','寄件人','wefsadf','收件人','sdadasdas','13111333111','13111333111','13111333111','13111333111','asdsadas','sadasdasd',1,'31413',5,6,2,60,'2015-12-09',1,127,NULL,NULL,'2015-12-09 11:01:02','徐嘉诰',53,2,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1234554321','寄件人','12345543211','收件人','12345543211','12345543211','12345543211','12345543211','12345543211','12345543211','12345543211',1,'7',5,6,5,150,'2015-12-09',1,12,NULL,NULL,'2015-12-09 20:22:14','徐嘉诰',5,1,'北京','北京','北京','北京','2015-12-09','MoFaShi'),('1234567890','寄件人','fads','收件人','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111','13111333111',1,'6',2,3,4,24,'2015-12-09',1,12,NULL,NULL,'2015-12-09 11:33:13','徐嘉诰',5,0,'北京','北京','北京','北京','2015-12-09','MoFaShi');
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
  `id` char(10) NOT NULL,
  `stockId` char(7) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `part` int(11) NOT NULL,
  `shelf` char(10) NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` char(20) NOT NULL,
  `hallId` char(6) NOT NULL,
  `convertId` char(19) NOT NULL,
  `vanId` char(9) NOT NULL,
  `arriveloc` varchar(20) CHARACTER SET gbk NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halllorderpassed`
--

LOCK TABLES `halllorderpassed` WRITE;
/*!40000 ALTER TABLE `halllorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `halllorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `halllorderunpassed`
--

DROP TABLE IF EXISTS `halllorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `halllorderunpassed` (
  `id` char(20) NOT NULL,
  `hallId` char(6) NOT NULL,
  `convertId` char(19) NOT NULL,
  `vanId` char(9) NOT NULL,
  `arriveloc` varchar(20) CHARACTER SET gbk NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
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
  `id` char(20) NOT NULL,
  `hallId` char(6) NOT NULL,
  `convertId` char(19) NOT NULL,
  `vanId` char(9) NOT NULL,
  `arriveloc` varchar(20) CHARACTER SET gbk NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `escort` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courier` varchar(10) CHARACTER SET gbk NOT NULL,
  `cost` double NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) CHARACTER SET gbk NOT NULL,
  `orgId` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incomeorderpassed`
--

LOCK TABLES `incomeorderpassed` WRITE;
/*!40000 ALTER TABLE `incomeorderpassed` DISABLE KEYS */;
INSERT INTO `incomeorderpassed` VALUES (1,'徐嘉诰',170,'2015-12-09','2015-12-09 17:55:29','1000000000 ','香港记者','025000','baohua');
/*!40000 ALTER TABLE `incomeorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incomeorderunpassed`
--

DROP TABLE IF EXISTS `incomeorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incomeorderunpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courier` varchar(10) CHARACTER SET gbk NOT NULL,
  `cost` double NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text NOT NULL,
  `opName` varchar(10) CHARACTER SET gbk NOT NULL,
  `orgId` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courier` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `express` text CHARACTER SET latin1 NOT NULL,
  `opName` varchar(10) NOT NULL,
  `orgId` varchar(10) CHARACTER SET latin1 NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incomeorderwaiting`
--

LOCK TABLES `incomeorderwaiting` WRITE;
/*!40000 ALTER TABLE `incomeorderwaiting` DISABLE KEYS */;
INSERT INTO `incomeorderwaiting` VALUES (1,'徐嘉诰',170,'2015-12-09','2015-12-09 17:55:29','1000000000 ','香港记者','025000','baohua');
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
  `name` varchar(20) CHARACTER SET gbk NOT NULL,
  `kind` int(11) NOT NULL,
  `location` varchar(50) CHARACTER SET gbk NOT NULL,
  `city` varchar(20) CHARACTER SET gbk NOT NULL,
  `cityId` char(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org`
--

LOCK TABLES `org` WRITE;
/*!40000 ALTER TABLE `org` DISABLE KEYS */;
INSERT INTO `org` VALUES ('0','总部',2,'东城区故宫博物院','北京','010'),('0250','江苏省南京中转中心',1,'栖霞区仙林大道163号','南京','025'),('025000','江苏省南京栖霞营业厅',0,'栖霞区学则路','南京','025');
/*!40000 ALTER TABLE `org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentorderpassed`
--

DROP TABLE IF EXISTS `paymentorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentorderpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payer` varchar(10) CHARACTER SET gbk NOT NULL,
  `account` varchar(20) CHARACTER SET gbk NOT NULL,
  `kind` int(11) NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentorderpassed`
--

LOCK TABLES `paymentorderpassed` WRITE;
/*!40000 ALTER TABLE `paymentorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentorderunpassed`
--

DROP TABLE IF EXISTS `paymentorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentorderunpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payer` varchar(10) CHARACTER SET gbk NOT NULL,
  `account` varchar(20) CHARACTER SET gbk NOT NULL,
  `kind` int(11) NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payer` varchar(10) CHARACTER SET gbk NOT NULL,
  `account` varchar(20) CHARACTER SET gbk NOT NULL,
  `kind` int(11) NOT NULL,
  `amount` double NOT NULL,
  `remarks` varchar(20) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
INSERT INTO `shelf` VALUES ('','00001',5,5,0);
/*!40000 ALTER TABLE `shelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockinorderpassed`
--

DROP TABLE IF EXISTS `stockinorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockinorderpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `arrivePlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `part` int(11) NOT NULL,
  `shelfId` char(10) NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockinorderpassed`
--

LOCK TABLES `stockinorderpassed` WRITE;
/*!40000 ALTER TABLE `stockinorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockinorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockinorderunpassed`
--

DROP TABLE IF EXISTS `stockinorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockinorderunpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `arrivePlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `part` int(11) NOT NULL,
  `shelfId` char(10) NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `arrivePlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `part` int(11) NOT NULL,
  `shelfId` char(10) NOT NULL,
  `row` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) NOT NULL,
  `arrivePlace` varchar(50) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockoutorderpassed`
--

LOCK TABLES `stockoutorderpassed` WRITE;
/*!40000 ALTER TABLE `stockoutorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockoutorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockoutorderunpassed`
--

DROP TABLE IF EXISTS `stockoutorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockoutorderunpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) NOT NULL,
  `arrivePlace` varchar(50) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockoutorderunpassed`
--

LOCK TABLES `stockoutorderunpassed` WRITE;
/*!40000 ALTER TABLE `stockoutorderunpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockoutorderunpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockoutorderwaiting`
--

DROP TABLE IF EXISTS `stockoutorderwaiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockoutorderwaiting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expressId` char(10) NOT NULL,
  `kind` int(11) NOT NULL,
  `transitId` char(19) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `stockId` char(10) NOT NULL,
  `arrivePlace` varchar(50) NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` char(10) NOT NULL,
  `info` varchar(50) CHARACTER SET gbk NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitinfo`
--

LOCK TABLES `transitinfo` WRITE;
/*!40000 ALTER TABLE `transitinfo` DISABLE KEYS */;
INSERT INTO `transitinfo` VALUES ('0987654321','2015-12-09 11:33:39 江苏省南京栖霞营业厅快递员 已收件;'),('1000000000','2015-12-09 00:21:29 江苏省南京栖霞营业厅快递员 已收件;'),('1000000011','2015-12-09 10:55:23 江苏省南京栖霞营业厅快递员 已收件;'),('1000001001','2015-12-09 11:01:02 江苏省南京栖霞营业厅快递员 已收件;'),('1000011100','2015-12-09 18:21:33 江苏省南京栖霞营业厅快递员 已收件;'),('1000012233','2015-12-09 11:04:47 江苏省南京栖霞营业厅快递员 已收件;'),('1231321231','2015-12-09 18:34:07 江苏省南京栖霞营业厅快递员 已收件;'),('1234554321','2015-12-09 19:29:42 江苏省南京栖霞营业厅快递员 已收件;'),('1234567890','2015-12-09 11:33:13 江苏省南京栖霞营业厅快递员 已收件;'),('4444433333','2015-12-09 11:34:01 江苏省南京栖霞营业厅快递员 已收件;');
/*!40000 ALTER TABLE `transitinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitorderpassed`
--

DROP TABLE IF EXISTS `transitorderpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transitorderpassed` (
  `id` char(19) NOT NULL,
  `planeId` varchar(20) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `arrivePlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `containerId` varchar(10) NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `express` text NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transitorderpassed`
--

LOCK TABLES `transitorderpassed` WRITE;
/*!40000 ALTER TABLE `transitorderpassed` DISABLE KEYS */;
/*!40000 ALTER TABLE `transitorderpassed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transitorderunpassed`
--

DROP TABLE IF EXISTS `transitorderunpassed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transitorderunpassed` (
  `id` char(19) NOT NULL,
  `planeId` varchar(20) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `arrivePlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `containerId` varchar(10) NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `express` text NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
  `id` char(19) NOT NULL,
  `planeId` varchar(20) NOT NULL,
  `startPlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `arrivePlace` varchar(20) CHARACTER SET gbk NOT NULL,
  `containerId` varchar(10) NOT NULL,
  `supervision` varchar(10) CHARACTER SET gbk NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `express` text NOT NULL,
  `userId` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('haha','haha','长者','13999233233',6,3,'0','总部',0,8000,0),('baohua','baohua','香港记者','13999110110',1,12,'025000','江苏省南京栖霞营业厅',0,7000,0),('Mrdong','Mrdong','董建华','',2,13,'0250','江苏省南京中转中心',0,7000,0),('ProfGuo','ProfGuo','郭伟华','',5,14,'null','总部',0,7000,0),('profzhang','profzhang','张钟俊','12314131231',4,15,'null','总部',0,7000,0),('ProfZhu','ProfZhu','朱物华','',3,16,'0250','江苏省南京中转中心',0,6000,0),('admin','admin','历史的行程','12345022321',7,19,'null','总部',0,5000,0),('MoFaShi','mofashi','徐嘉诰','17823421247',0,20,'025000','江苏省南京栖霞营业厅',2,5000,20);
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
INSERT INTO `van` VALUES ('025000001','5534','2015-12-09','vanImage/025000001.jpg','025000');
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

-- Dump completed on 2015-12-09 21:49:36
