-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enjoytrips
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`user_id`),
  CONSTRAINT `plan_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (2,'강릉 여행','ssafy','2023-06-02','2023-06-30'),(3,'전주 여행','ssafy','2023-07-02','2023-08-02'),(4,'속초 여행','ssafy','2023-07-02','2023-07-04'),(5,'순천 여행','ssafy','2023-05-06','2023-06-12'),(6,'박소윤이랑 간다~','ssafy','2023-05-18','2023-06-19'),(7,'원호랑 엠티','ssafy','2023-05-12','2023-06-20'),(9,'제주 여행','ssafy','2023-05-09','2023-05-11'),(10,'강원도 여행','ssafy','2023-06-07','2023-06-10'),(11,'거제 여행','ssafy','2023-07-04','2023-07-05'),(12,'여행고','ssafy','2023-05-06','2023-06-05'),(13,'부산여행2','ssafy','2023-06-07','2023-06-08'),(14,'부산여행3','ssafy','2023-06-14','2023-06-15'),(15,'통영 여행','ssafy','2023-05-29','2023-05-31'),(16,'경주 여행','ssafy','2023-06-05','2023-06-07'),(17,'서산','ssafy','2023-05-09','2023-05-12'),(18,'ㅘㅘㅓㅓㅏ','ssafy','2023-05-12','2023-06-15'),(19,'dsdfs','ssafy','2023-05-05','2023-05-29'),(20,'전주','ssafy','2023-06-08','2023-06-09'),(21,'산','ssafy','2023-05-12','2023-06-05'),(22,'부산','ssafy','2023-06-08','2023-06-10'),(23,'ㅇㄴㅇ','ssafy','2023-05-19','2023-05-20'),(24,'서산','ssafy','2023-05-18','2023-06-17'),(25,'내 여행','ssafy','2023-05-11','2023-06-12'),(26,'23333','ssafy','2023-05-11','2023-06-21'),(27,'ㅇㅎㅇㅀㅇㄹ','ssafy','2023-05-11','2023-06-20'),(28,'ㅇㄹㅇㄹㄴㅇㄹㄴㅇㄹ','ssafy','2023-05-20','2023-06-27'),(29,'ㅌㅋㅍㅊㅍㅌㅍ','ssafy','2023-05-05','2023-06-28'),(30,'ㅁㄴㅇㄻㅇㄴㄻㅇㄹ','ssafy','2023-05-01','2023-07-07'),(31,'12312312','ssafy','2023-05-09','2023-06-19'),(32,'ㄴㅇㄹㄴㅇㄹㄴㅇ','ssafy','2023-05-03','2023-06-19'),(33,'ㄴㅇㄹㄴㅇㄹㄴㅇㄹ','ssafy','2023-05-01','2023-06-13'),(34,'ㄴㅇㄹㄴㅇㄹ','ssafy','2023-05-02','2023-06-20'),(35,'q2q2321','ssafy','2023-05-23','2023-06-26'),(36,'sdfsdfsd','ssafy','2023-05-09','2023-06-27'),(37,'fdsdbfsdfb','ssafy','2023-05-10','2023-06-22'),(38,'dfasdfasdfsd','ssafy','2023-05-18','2023-06-20'),(39,'dsdfs','ssafy','2023-05-16','2023-06-27'),(40,'sdfsdf','ssafy','2023-05-03','2023-06-22'),(41,'경주 여행','ssafy','2023-05-02','2023-06-23'),(42,'','ssafy','2023-05-11','2023-06-12'),(43,'sdfsdfs','ssafy','2023-05-08','2023-06-12');
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-23 16:49:52
