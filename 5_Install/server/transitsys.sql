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
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
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
  `isArrived` tinyint(1) NOT NULL,
  `startPlace` varchar(50) NOT NULL,
  `startOrgId` char(21) NOT NULL,
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
  `isArrived` tinyint(1) NOT NULL,
  `startPlace` varchar(50) NOT NULL,
  `startOrgId` char(21) NOT NULL,
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
  `isArrived` tinyint(1) NOT NULL,
  `startPlace` varchar(50) NOT NULL,
  `startOrgId` char(21) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
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
  `nowOrgId` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expressorderpassed`
--

LOCK TABLES `expressorderpassed` WRITE;
/*!40000 ALTER TABLE `expressorderpassed` DISABLE KEYS */;
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
  `nowOrgId` char(10) NOT NULL,
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
  `nowOrgId` char(10) NOT NULL,
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
  `userId` varchar(20) NOT NULL,
  `isArrived` tinyint(1) NOT NULL
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
  `userId` varchar(20) NOT NULL,
  `isArrived` tinyint(1) NOT NULL
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
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `isArrived` tinyint(1) NOT NULL
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
  `orgId` varchar(10) NOT NULL,
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
  `orgId` varchar(10) NOT NULL,
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
  `orgId` varchar(10) NOT NULL,
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
  `id` char(23) CHARACTER SET latin1 NOT NULL,
  `transitId` char(19) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `state` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
  `id` char(23) CHARACTER SET latin1 NOT NULL,
  `transitId` char(19) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `state` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
  `id` char(23) CHARACTER SET latin1 NOT NULL,
  `transitId` char(19) CHARACTER SET latin1 NOT NULL,
  `startPlace` varchar(20) NOT NULL,
  `state` int(11) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
  `id` char(23) CHARACTER SET latin1 NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `courier` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
  `id` char(23) CHARACTER SET latin1 NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `courier` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
  `id` char(23) CHARACTER SET latin1 NOT NULL,
  `expressId` char(10) CHARACTER SET latin1 NOT NULL,
  `courier` varchar(10) NOT NULL,
  `comDate` date NOT NULL,
  `opTime` datetime NOT NULL,
  `opName` varchar(10) NOT NULL,
  `userId` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
INSERT INTO `transitinfo` VALUES ('0987654321','2015-12-09 11:33:39 江苏省南京栖霞营业厅快递员 已收件;'),('1000000000','2015-12-10 16:39:12 江苏省南京栖霞营业厅快递员 已收件;2015-12-10 16:43:00 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京中转中心;2015-12-10 18:49:39 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京中转中心;2015-12-10 19:08:26 null 已收入;2015-12-10 19:15:13 null 已收入;2015-12-10 19:17:50 null 已收入;2015-12-10 19:19:22 null 已收入;2015-12-15 23:20:55 江苏省南京中转中心 已发出 下一站 北京市中转中心;2015-12-16 11:02:49 北京市中转中心 已收入;2015-12-17 09:42:31 北京市中转中心 已发出 下一站 北京东城区营业厅;2015-12-17 11:37:26 北京东城区营业厅 已收入;2015-12-17 17:30:40 北京东城区营业厅派件员 鸭嘴笔正在派件;2015-12-17 19:15:28 北京东城区营业厅 已签收 签收人 图样;'),('1000000011','2015-12-09 10:55:23 江苏省南京栖霞营业厅快递员 已收件;'),('1000001001','2015-12-09 11:01:02 江苏省南京栖霞营业厅快递员 已收件;'),('1000011100','2015-12-09 18:21:33 江苏省南京栖霞营业厅快递员 已收件;'),('1000012233','2015-12-09 11:04:47 江苏省南京栖霞营业厅快递员 已收件;'),('1000500015','2015-12-23 22:02:28 江苏省南京栖霞营业厅快递员 已收件;'),('1000500016','2015-12-23 22:37:49 江苏省南京栖霞营业厅快递员 已收件;'),('1102203304','2015-12-14 20:48:47 江苏省南京栖霞营业厅快递员 已收件;'),('1111112312','您的包裹已经起飞;您的包裹已经降落;'),('1231321231','2015-12-09 18:34:07 江苏省南京栖霞营业厅快递员 已收件;'),('1233211232','2015-12-10 20:23:14 江苏省南京栖霞营业厅快递员 已收件;'),('1233211233','2015-12-10 20:29:09 江苏省南京栖霞营业厅快递员 已收件;'),('1233332221','2015-12-10 20:23:35 江苏省南京栖霞营业厅快递员 已收件;'),('1234544444','2015-12-10 19:51:01 江苏省南京栖霞营业厅快递员 已收件;'),('1234554321','2015-12-09 19:29:42 江苏省南京栖霞营业厅快递员 已收件;'),('1234554332','2015-12-10 19:39:28 江苏省南京栖霞营业厅快递员 已收件;'),('1234554333','2015-12-10 19:35:56 江苏省南京栖霞营业厅快递员 已收件;'),('1234567890','2015-12-09 11:33:13 江苏省南京栖霞营业厅快递员 已收件;2015-12-14 21:10:54 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京栖霞营业厅;'),('1234567891','2015-12-13 20:32:58 江苏省南京栖霞营业厅快递员 已收件;2015-12-14 21:10:54 江苏省南京栖霞营业厅 已发出 下一站 江苏省南京栖霞营业厅;'),('2342344333','2015-12-10 20:27:36 江苏省南京栖霞营业厅快递员 已收件;'),('4444433333','2015-12-09 11:34:01 江苏省南京栖霞营业厅快递员 已收件;'),('5555522222','2015-12-10 20:27:16 江苏省南京栖霞营业厅快递员 已收件;'),('6546546544','2015-12-10 20:28:50 江苏省南京栖霞营业厅快递员 已收件;');
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
  `isArrived` tinyint(1) NOT NULL,
  `startOrgId` char(21) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
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
  `isArrived` tinyint(1) NOT NULL,
  `startOrgId` char(21) NOT NULL,
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
  `isArrived` tinyint(1) NOT NULL,
  `startOrgId` char(21) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','admin','','',7,1,'','',0,0,0);
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

-- Dump completed on 2015-12-24 22:32:10
