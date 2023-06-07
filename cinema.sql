-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `card_id` varchar(50) NOT NULL,
  `member_id` varchar(50) DEFAULT NULL,
  `balance` int DEFAULT '0' COMMENT '人民币余额',
  `lose` int DEFAULT '0' COMMENT '1为丢失，0为未丢失',
  `grade` int DEFAULT '1',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES ('0161c880e711464c9bbb5f699f292e23','567ced95cf1541bc94ccb3dfa767b53f',320,0,1),('0967a8dd2cc04fc887cb69f35ae831fd','567ced95cf1541bc94ccb3dfa767b53f',4700,0,1),('09961c29e8494649b29851388ef440fb','569b67f5c340462f9c343a98ab6e64db',1035,0,1),('0b5705e0ed8f4b6fafc4126147b7d6fc','4e0553653d27447896440c4a16eda042',1000,0,1),('4f59de19d3534abfb948f4c9a38e53dc','569b67f5c340462f9c343a98ab6e64db',1231,0,1),('8b06e3dcd4334c368d666081f666b500','567ced95cf1541bc94ccb3dfa767b53f',2551,0,1),('8c0328f28b60400f983a806d67f705cc','288bced48b0243bdaefb4d602fa30c62',4910,0,1),('9368dcf533ed4392a1586964b1a886ff','567ced95cf1541bc94ccb3dfa767b53f',1000,0,3),('9a6a2bfb4e95421d92774444c229ddfd','567ced95cf1541bc94ccb3dfa767b53f',100,0,1),('9c535625f7cc477eb69921849a40871d','edabd56c406449a0ab105bb7bfe92346',1314250,0,1),('a81128bc8be54aec84b0dadf0b1d6fe1','4e0553653d27447896440c4a16eda042',0,0,1),('aa20dce977254b599508979d2e667884','567ced95cf1541bc94ccb3dfa767b53f',100,1,1),('aaa3dcc485144a44ae779d614a808ad0','4e0553653d27447896440c4a16eda042',0,0,1),('b27a7b32a0c44561abe8104977814152','edabd56c406449a0ab105bb7bfe92346',0,0,1),('ba0977e470ba4f6fb48b8c157da98b4d','edc5c2070d154561b8d5aa94ded0ccd9',9900,0,1),('cb09d3ef48f24a14a58cde8ab4bc0a6f','569b67f5c340462f9c343a98ab6e64db',0,0,1),('d5369d546dd94b68a1ae652b54f55ff7','567ced95cf1541bc94ccb3dfa767b53f',0,0,1),('f0cc8a64e9744fac89ec05c99b9a13e1','569b67f5c340462f9c343a98ab6e64db',0,0,1),('f226a06fed11438882f0d3cffd0ece4f','567ced95cf1541bc94ccb3dfa767b53f',180,0,1),('fb0838a8d15e4306aff60bde281b2f27','94ce3d7b848649edb01a1e2de6b7e143',1314,0,1);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `care_info`
--

DROP TABLE IF EXISTS `care_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `care_info` (
  `name` varchar(10) NOT NULL,
  `info` varchar(225) DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `care_info`
--

LOCK TABLES `care_info` WRITE;
/*!40000 ALTER TABLE `care_info` DISABLE KEYS */;
INSERT INTO `care_info` VALUES ('blessing','happy birthday'),('grade_1','one'),('grade_2','two'),('grade_3','three');
/*!40000 ALTER TABLE `care_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consume_record`
--

DROP TABLE IF EXISTS `consume_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consume_record` (
  `card_id` varchar(50) DEFAULT NULL,
  `value` int DEFAULT '0',
  `time` varchar(20) DEFAULT NULL,
  `reason` int DEFAULT NULL,
  `info` varchar(255) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consume_record`
--

LOCK TABLES `consume_record` WRITE;
/*!40000 ALTER TABLE `consume_record` DISABLE KEYS */;
INSERT INTO `consume_record` VALUES ('0967a8dd2cc04fc887cb69f35ae831fd',300,'2023-05-30 21:24:13',1,'tip1*10'),('0161c880e711464c9bbb5f699f292e23',100,'2023-05-30 21:24:13',2,'recharge'),('9368dcf533ed4392a1586964b1a886ff',1000,'2023-05-31 21:24:21',2,'recharge'),('0161c880e711464c9bbb5f699f292e23',60,'2023-05-31 22:05:15',1,'tip1*2');
/*!40000 ALTER TABLE `consume_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchange_record`
--

DROP TABLE IF EXISTS `exchange_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exchange_record` (
  `member_id` varchar(50) DEFAULT NULL,
  `value` int DEFAULT '0',
  `time` datetime DEFAULT NULL,
  `reason` int DEFAULT NULL,
  `info` varchar(255) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchange_record`
--

LOCK TABLES `exchange_record` WRITE;
/*!40000 ALTER TABLE `exchange_record` DISABLE KEYS */;
INSERT INTO `exchange_record` VALUES ('567ced95cf1541bc94ccb3dfa767b53f',3000,'2023-05-30 21:24:13',2,'tip1*10'),('567ced95cf1541bc94ccb3dfa767b53f',500,'2023-05-30 21:26:11',1,'23*5'),('567ced95cf1541bc94ccb3dfa767b53f',600,'2023-05-31 22:05:15',2,'tip1*2'),('567ced95cf1541bc94ccb3dfa767b53f',1000,'2023-05-31 22:43:53',1,'23*10');
/*!40000 ALTER TABLE `exchange_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good` (
  `name` varchar(255) NOT NULL,
  `integral` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` VALUES ('23',100,10),('变形金刚',5000,10),('可乐',500,10),('布娃娃',3000,10),('玩具车',900,10),('航模',6666,10);
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `manager_id` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `role` varchar(10) DEFAULT '操作员',
  `time` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('admin','123123','张三','操作员','2020-06-11 11:06:23');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birthday` varchar(25) DEFAULT NULL,
  `integral` int DEFAULT '0',
  `grade` int DEFAULT '1',
  `info` varchar(255) DEFAULT '',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('2525943c9c0f4f6a9530262628df56db','123123','梅超风','女','05-08',0,3,'three zero'),('288bced48b0243bdaefb4d602fa30c62','123123','小智','男','03-05',0,1,'one zero'),('39d86e911df04588bc2c75407318465f','123123','胖大海','男','04-02',0,1,'one zero'),('467e64ae0d1d440495be860179d5be78','123123','慕容复','男','04-28',0,1,'one zero'),('4e0553653d27447896440c4a16eda042','123123','令狐冲','男','04-03',0,1,'one zero'),('567ced95cf1541bc94ccb3dfa767b53f','123123','乔峰','男','04-09',2800,1,'one no zero'),('569b67f5c340462f9c343a98ab6e64db','123123','张三丰','男','04-23',0,1,'one zero'),('64bfda46ead04696978961f399c37e6d','123123','白晶晶','女','04-30',0,1,'one zero'),('94ce3d7b848649edb01a1e2de6b7e143','123123','段誉','男','04-04',0,1,'one zero'),('a15763ae3fd9431cb7c4542d2122d7a1','123123','至尊宝','男','04-01',0,1,'one zero'),('a58b8b60a698446292df3a79d16799c6','123123','风云无忌','男','04-29',0,1,'one zero'),('edabd56c406449a0ab105bb7bfe92346','123123','紫霞','女','04-01',0,1,'one zero'),('edc5c2070d154561b8d5aa94ded0ccd9','123123','宁采臣','男','04-30',0,1,'one zero'),('fcac671e85354bbc8086a94102d8c170','123123','扫地僧','男','01-01',0,1,'one zero');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `name` varchar(49) NOT NULL,
  `price` int DEFAULT '0',
  `integral` int DEFAULT '0',
  `time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('tip1',30,300,'2023-05-29 15:13:00'),('tip2',5,500,'2023-05-29 14:27:39'),('回到明朝当王爷',200,88,'2020-04-30 22:22:20'),('西虹市首富',100,10,'2020-04-25 17:04:13'),('让子弹飞',90,12,'2020-04-25 18:15:05'),('雪国列车',99,99,'2020-04-25 16:49:02'),('雪山飞狐',50,10,'2020-04-29 20:55:11'),('饥饿站台',1000,85,'2020-04-25 16:53:36'),('黄金甲',99,25,'2020-04-29 20:56:11'),('龙争虎斗',90,20,'2020-04-30 22:31:07');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-01 11:23:45
