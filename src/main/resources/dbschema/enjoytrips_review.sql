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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `article_no` int NOT NULL AUTO_INCREMENT,
  `content_id` int NOT NULL,
  `subject` varchar(20) NOT NULL,
  `content` varchar(500) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `hit` int DEFAULT '0',
  `register_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `plan_id` bigint NOT NULL,
  PRIMARY KEY (`article_no`),
  KEY `content_id` (`content_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`content_id`) REFERENCES `attraction_info` (`content_id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (16,125266,'ㅇㅇ','반가워','ssafy',0,'2023-05-23 15:52:10',2),(17,125266,'안녕','반가워','ssafy',0,'2023-05-23 15:52:20',2),(18,125409,'안녕','반가워','ssafy',0,'2023-05-23 15:52:24',2),(19,125266,'','반가워','ssafy',0,'2023-05-23 15:52:26',2),(20,125266,'','반가워','ssafy',0,'2023-05-23 15:52:28',2),(21,125409,'','반가워','ssafy',0,'2023-05-23 15:52:41',2),(25,125266,'ㅇㅇ','국립중앙박물관은 42만 점의 소장유물을 소장하고 있으며, 고고, 역사, 미술, 기증, 아시아 관련 문화재를 전시하는 상설 전시실과 다양한 전시가 가능하도록 가변성 있게 구성된 ','ssafy',0,'2023-05-23 16:38:25',2),(26,126486,'ㅇㅇ','국립중앙박물관은 42만 점의 소장유물을 소장하고 있으며, 고고, 역사, 미술, 기증, 아시아 관련 문화재를 전시하는 상설 전시실과 다양한 전시가 가능하도록 가변성 있게 구성된 기획 전시실, 체험과 참여 학습을 통해 전시를 이해하도록 설계된 어린이 박물관, 박물관 야외정원을 이용하여 석탑 등 다양한 석조유물을 전시한 야외전시실로 이뤄진다. 국립중앙박물관은 국내·외 전시활동 외에도 유물의 수집과 보존, 조사연구, 사회교육활동, 학술자료발간, 국제문화교류활동, 각종 공연 등의 기회를 제공하는 복합문화공간으로서 교육적 측면 뿐 아니라 친환경 녹색공간과 휴게시설 및 양질의 문화 프로그램도 함께 마련되어 있어 남녀노소를 불문하고 언제든 찾아가고 싶은 새로운 도심 속 명소의 역할을 하고 있다. 국립중앙박물관은 정원의 폭포와 아름다운 전경으로도 유명하며, 산책을 즐기기에도 그만이다. 전시관 내에 카페테리아와 휴게공간, 아트숍, 식당가, 편의점 등도 편리하게 이용할 수 있다. [나주 서성문 안 ','ssafy',0,'2023-05-23 16:41:50',43);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
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
