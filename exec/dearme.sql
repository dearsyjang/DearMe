-- MariaDB dump 10.19  Distrib 10.8.3-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: dearme
-- ------------------------------------------------------
-- Server version	10.8.3-MariaDB-1:10.8.3+maria~jammy

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `board_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `date` datetime(6) NOT NULL,
  `hit_cnt` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`board_id`),
  KEY `FKlho2xe27c3m4cr1gl0yqunh8d` (`id`),
  CONSTRAINT `FKlho2xe27c3m4cr1gl0yqunh8d` FOREIGN KEY (`id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES
(1,'2022-08-18 09:42:05.000000','2022-08-18 23:44:09.368610','공부는 왜 이렇게 하기 싫은 걸까요...나이는 먹어가는데 의욕은 더 떨어지네요. ㅠㅠ','2022-08-18 23:28:37.139598',30,'취업 준비중입니다...',1),
(2,'2022-08-18 09:42:05.000000','2022-08-18 23:18:05.234944','매일 아침에 일어날때마다 기분이 너무 안좋아요 ㅠㅠ...','2022-08-18 09:42:05.000000',7,'살려주세요',1),
(3,'2022-08-18 09:42:05.000000','2022-08-18 11:11:22.367432','취준이 길어지니까 자꾸 안좋은 생각만 드는거 같아요...','2022-08-18 09:42:05.000000',4,'힘들어요...',1),
(4,'2022-08-18 09:42:05.000000','2022-08-18 23:30:06.872218','10년째 취업준비중입니다... 끝이 안보여요...','2022-08-18 09:42:05.000000',2,'취업이 이렇게 힘든건가요',2),
(5,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','친구들은 다들 직장다니고 결혼도하고 잘나가는데 저만 취준생이에요 ㅠ...','2022-08-18 09:42:05.000000',0,'우울해요',2),
(6,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','서류탈락만 300번입니다. 저는 면접 볼 가치도 없다는 걸까요...','2022-08-18 09:42:05.000000',0,'제가 할 수 있을까요?',3),
(7,'2022-08-18 09:42:05.000000','2022-08-18 18:41:28.183385','다른 취준생들은 친구들끼리 가끔 만나서 술을 마시기도 하고 서로 힘이 되는거같은데 전 그럴 친구가 없어요 ㅠ 외롭습니다 ㅠㅠ','2022-08-18 09:42:05.000000',3,'털어 놓을 곳이 없어요.',4),
(8,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','여기서 상담 받으면 좀 괜찮아질까요??','2022-08-18 09:42:05.000000',0,'알려주세요',5),
(9,'2022-08-18 09:42:05.000000','2022-08-18 11:11:40.525509','가격 문의요','2022-08-18 09:42:05.000000',1,'상담 가격이 어케됩니까',6),
(10,'2022-08-18 09:42:05.000000','2022-08-18 11:11:37.281158','매일 사는게 지옥같습니다 ㅠ 취업하면 좀 괜찮아질까요...?','2022-08-18 09:42:05.000000',11,'취업 하면 좀 나아질까요?',1),
(11,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','점점 취업이 어려워지는거같아요. 나이는 벌써 서른이 훌쩍 넘어버렸는데 신입은 안뽑고 매일매일이 우울합니다...','2022-08-18 09:42:05.000000',0,'나이는 차고 취업문은 좁고',2),
(12,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','밖에 나가면 다들 저한테 아직도 취업 못했냐고 비웃는거 같아요 ㅠㅠ 밖에 나가기가 무서워요','2022-08-18 09:42:05.000000',0,'사람이 무서워요',3),
(13,'2022-08-18 09:42:05.000000','2022-08-18 11:12:19.826813','이젠 정말 한계인 것 같아요. 더이상 취업준비 못 하겠습니다... 그만두고싶어요...','2022-08-18 09:42:05.000000',1,'할 수 있는게 더는 없습니다...',4),
(14,'2022-08-18 09:42:05.000000','2022-08-18 11:12:12.398403','친구는 삼성 취업했다고 자랑하는데 저는 아직도 취준생이고...친구가 너무 짜증납니다.','2022-08-18 09:42:05.000000',2,'친구가 너무 짜증나요',5),
(15,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','부모님이 빨리 취업하라고 매일 잔소리하시는게 너무 싫어요 ㅠㅠ 저도 하고 싶은데 못 하는 건데 ㅠㅠ','2022-08-18 09:42:05.000000',0,'부모님이 너무 싫어요 ㅠ',6),
(16,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','그동안 너무 힘들었습니다. 이만 내려 놓을까 합니다.','2022-08-18 09:42:05.000000',0,'이만 포기하려합니다...',7),
(17,'2022-08-18 09:42:05.000000','2022-08-18 11:12:05.591153','할 수 있다! 용기를 받고싶어요!!','2022-08-18 09:42:05.000000',1,'용기를 주세요!',8),
(18,'2022-08-18 09:42:05.000000','2022-08-18 13:06:36.254862','안녕하세요. 혼자 동생 둘을 키우는 22살 취준생입니다. 이제까진 알바만 해서 동생들을 키웠지만 더이상은 힘들거같아요. 그래서 제대로된 직장에 자리잡으려고 취업준비를 시작했는데 너무 힘듭니다... 속마음 털어 놓을 곳이 없어요... 동생들은 저만 보고있고ㅠㅠ','2022-08-18 09:42:05.000000',1,'너무 힘든 상황입니다.',9),
(19,'2022-08-18 09:42:05.000000','2022-08-18 23:29:52.512490','취업 준비를 시작한 이후로 하루도 기분좋게 하루를 마무리 한 적이 없어요 ㅠ ','2022-08-18 09:42:05.000000',1,'상담 받으면 좀 나아질까요?',9),
(20,'2022-08-18 09:42:05.000000','2022-08-18 15:49:52.595623','면접만 벌써 20번째 탈락입니다... 탈락할때마다 자존감이 너무 떨어집니다 ㅠ...','2022-08-18 09:42:05.000000',1,'저는 안되나봐요..',1),
(21,'2022-08-18 13:03:26.290372','2022-08-18 13:03:26.290372','살기 싫어요(진짜)','2022-08-18 13:03:26.261626',0,'살기 싫어요',1),
(22,'2022-08-18 23:29:10.070885','2022-08-18 23:29:10.070885','언제까지 이렇게 우울해야할까요.','2022-08-18 23:29:10.064539',0,'너무 힘듭니다.',1);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `career`
--

DROP TABLE IF EXISTS `career`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `career` (
  `career_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`career_id`),
  KEY `FKsloeqxqy71aejo3h4aa31sjd0` (`counselor_id`),
  CONSTRAINT `FKsloeqxqy71aejo3h4aa31sjd0` FOREIGN KEY (`counselor_id`) REFERENCES `counselor_profile` (`counselor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `career`
--

LOCK TABLES `career` WRITE;
/*!40000 ALTER TABLE `career` DISABLE KEYS */;
INSERT INTO `career` VALUES
(1,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','성광중학교 상담사 2년',10),
(2,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','누리심리상담센터 3년',10),
(3,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','한마음심리상담센터 1년',10),
(4,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','상서고등학교 상담사 5년',11),
(5,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','서울심리상담센터 3년',11),
(6,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','구미심리상담센터 2년',11),
(7,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','대구심리상담센터 3년',11),
(8,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','수원심리상담센터 5년',12),
(9,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','동탄심리상담센터 6년',13),
(10,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','동서울심리상담센터 4년',14),
(11,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','온도심리상담센터 5년',15),
(12,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','마음심리상담센터 8년',16),
(13,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','행복심리상담센터 10년',17),
(14,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','영남여성심리상담센터 4년',18),
(15,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','대구여성상담센터 5년',19),
(16,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','마음치료상담센터 3년',20),
(17,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','새마음심리상담센터 2년',20),
(18,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','온누리심리상단센터 3년',20),
(19,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','구인철심리상담소 1년',20),
(20,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','전인숙심리상담소 2년',20);
/*!40000 ALTER TABLE `career` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FKm33qdo2kf7m9au9t103e4o05k` (`counselor_id`),
  CONSTRAINT `FKm33qdo2kf7m9au9t103e4o05k` FOREIGN KEY (`counselor_id`) REFERENCES `counselor_profile` (`counselor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES
(1,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','가족',11),
(2,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','직장, 진로',11),
(3,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','연애, 결혼',11),
(4,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','가족',12),
(5,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','직장, 진로',12),
(6,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','연애, 결혼',12),
(7,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','자기이해',13),
(8,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','자기이해',14),
(9,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','연애,결혼',15),
(10,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','직장,진로',16),
(11,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','직장,진로',17),
(12,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','가족',18),
(13,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','직장,진로',19),
(14,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','직장, 진로',20),
(15,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','연애,결혼',20);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificate` (
  `certificate_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`certificate_id`),
  KEY `FKh7ww6pjox17abht2gppgoul5k` (`counselor_id`),
  CONSTRAINT `FKh7ww6pjox17abht2gppgoul5k` FOREIGN KEY (`counselor_id`) REFERENCES `counselor_profile` (`counselor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES
(1,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','2급 상담심리사',10),
(2,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 전문상담사',10),
(3,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','3급 청소년상담사',10),
(4,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 상담심리사',11),
(5,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','2급 전문상담사',11),
(6,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 청소년 상담사',11),
(7,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 전문상담사',12),
(8,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','2급 전문상담사',13),
(9,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 전문상담사',14),
(10,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','2급 상담심리사',15),
(11,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','2급 상담심리사',16),
(12,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 전문상담사',17),
(13,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 전문상담사',18),
(14,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','2급 상담심리사',19),
(15,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','1급 전문상담사',20);
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `date` datetime(6) NOT NULL,
  `boardid` bigint(20) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FKjjjuxh5tsv8pensf4tn4e2wct` (`boardid`),
  KEY `FKekiovl5a6s391pvs9wys74o2v` (`id`),
  CONSTRAINT `FKekiovl5a6s391pvs9wys74o2v` FOREIGN KEY (`id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKjjjuxh5tsv8pensf4tn4e2wct` FOREIGN KEY (`boardid`) REFERENCES `board` (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES
(1,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','원래 세상에서 공부가 제일 어려워요ㅠ 저랑 가볍게 얘기 한번 해보실까요?','2022-08-18 09:42:06.000000',1,11),
(2,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','아침마다 기분이 안좋으시군요 ㅠㅠ 일어나자마자 좋아하는 일부터 시작해보는건 어떨까요? ','2022-08-18 09:42:06.000000',2,11),
(3,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','긍정적인 자극으로 스트레스 해소가 필요해보입니다. 자세한 상담을 원하시면 저와 얘기 해봐요.','2022-08-18 09:42:06.000000',3,11),
(4,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','많이 힘드시겠군요 ㅠㅠ 하지만 분명 끝은 옵니다! 긍정적으로 생각하는 것이 중요합니다! ','2022-08-18 09:42:06.000000',4,11),
(5,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','ㅠㅠ 비교는 본인에게 절대 도움이 되지 않아요! 모든 사람에겐 본인만의 템포가 있습니다!','2022-08-18 09:42:06.000000',5,11),
(6,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','서류 300번이라니 대단하시네요! 그만큼 회사에서 필요한 스펙을 갖고계시다는 방증 아닐까요? 실력이 충분하신만큼 면접에서 자신감만 갖고 임한다면 좋은 결과 있을것같아요!','2022-08-18 09:42:06.000000',6,11),
(7,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','많이 외로우시겠군요 ㅠㅠ 저는 항상 열려있으니 언제든 찾아오셔서 대화 나눠요!','2022-08-18 09:42:06.000000',7,12),
(8,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','어떤 문제실까요? 자세한 상담을 원하시면 1:1상담을 신청해주세요!','2022-08-18 09:42:06.000000',8,12),
(9,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','상담사는 답만하는 로봇이 아니에요 ㅠㅠ 최소한의 예의를 지켜주세요','2022-08-18 09:42:06.000000',9,12),
(10,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','과정에서 작은 즐거움을 찾는게 중요합니다! 저랑 상담 해보시면서 같이 찾아보면 좋을 것 같아요!','2022-08-18 09:42:06.000000',10,12),
(11,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','나이때문에 걱정이 많으시군요 ㅠㅠ 하지만 나이는 숫자에 불과해요!! ','2022-08-18 09:42:06.000000',11,13),
(12,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','대인기피증 초기증상으로 보입니다. 자세한 상담을 통해 미리 예방하는 것이 좋아보여요.','2022-08-18 09:42:06.000000',12,14),
(13,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','많이 힘드시겠군요 ㅠㅠ 한계를 느끼실 정도면 정말 힘드신 상황이시겠어요. 저랑 한번 대화 나눠보는건 어떠실까요?','2022-08-18 09:42:06.000000',13,15),
(14,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','비교는 본인에게 전혀 도움이 안됩니다 ㅠㅠ 어제의 나보다 발전한 오늘의 나를 칭찬해주세요!!','2022-08-18 09:42:06.000000',14,16),
(15,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','부모님께서도 걱정되는 마음에 하시는거 아시죠? ㅠㅠ 부모님과 관계개선을 위한 집단상담프로그램을 진행중인데 관심 있으시면 참여해보시겠어요?','2022-08-18 09:42:06.000000',15,11),
(16,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','왜 내려놓으시려고 하시나요 ㅠㅠ 자세한 얘기가 궁금합니다 ㅠㅠ 저한테 상담 신청 해주세요!','2022-08-18 09:42:06.000000',16,18),
(17,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','화이팅입니다!!','2022-08-18 09:42:06.000000',17,11),
(18,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','아이고 ㅠㅠ 많이 힘든 상황이시겠어요... 동생 두분을 책임지시다보니 어깨가 많이 무거우실겁니다 ㅠㅠ 편안하게 속마음 털어놓을 창구가 필요하시다면 저를 찾아주세요!','2022-08-18 09:42:06.000000',18,19),
(19,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','기분 좋게 하루를 마무리 하고 싶으신거군요! 하루를 정리하면서 긍정적인 상황들을 다시한번 생각해보는 시간을 가지는게 좋답니다! 원하신다면 도와드리겠습니다!!','2022-08-18 09:42:06.000000',19,20),
(20,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','면접을 20번이나 보신건가요?? 이미 세상에서 필요로 하는 인재시네요! 실패는 성공의 어머니! 20번의 경험이 반드시 힘이 될겁니다!','2022-08-18 09:42:06.000000',20,20),
(21,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','공부가 하기 싫을때는 하루를 온전히 휴식을 가져보세요! 불안하시겠지만 도움이 될겁니다!','2022-08-18 09:42:06.000000',1,20),
(22,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','아침의 기분은 잠들기전 기분이 결정합니다! 잠들기전에 즐거운 마음으로 잠들어보세요! ','2022-08-18 09:42:06.000000',2,20),
(23,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','저런 ㅠㅠ 많이 힘드시다면 저랑 대화 나눠봐요 ㅠㅠ','2022-08-18 09:42:06.000000',3,20),
(24,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','끝이 안보인다고 생각하시겠지만 결국 해내실겁니다! 10년이나 준비하셨다니 대단하세요! 그런 끈기라면 무조건 성공하실거에요!','2022-08-18 09:42:06.000000',4,20),
(25,'2022-08-18 09:42:06.000000','2022-08-18 09:42:06.000000','본인에게만 집중하세요!! 남은 신경쓸거 없습니다!','2022-08-18 09:42:06.000000',5,20);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counseling`
--

DROP TABLE IF EXISTS `counseling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counseling` (
  `counseling_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `day` int(11) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `counseling_room_id` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`counseling_id`),
  KEY `FK5peg7rorv5w8rkk0o6r7qufky` (`counseling_room_id`),
  KEY `FKhuubu96hipq6y0nk5sywdp8` (`counselor_id`),
  KEY `FKna4cj9io9pggph9pm0k6w2fo1` (`group_id`),
  KEY `FKn95gllfsnpqesvt2d51ccqd71` (`user_id`),
  CONSTRAINT `FK5peg7rorv5w8rkk0o6r7qufky` FOREIGN KEY (`counseling_room_id`) REFERENCES `counseling_room` (`session_name`),
  CONSTRAINT `FKhuubu96hipq6y0nk5sywdp8` FOREIGN KEY (`counselor_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKn95gllfsnpqesvt2d51ccqd71` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKna4cj9io9pggph9pm0k6w2fo1` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counseling`
--

LOCK TABLES `counseling` WRITE;
/*!40000 ALTER TABLE `counseling` DISABLE KEYS */;
INSERT INTO `counseling` VALUES
(2,21,10,8,'ACCEPTED',NULL,2022,NULL,11,NULL,1),
(3,20,12,8,'ACCEPTED',NULL,2022,NULL,12,NULL,1),
(4,16,14,8,'ACCEPTED',NULL,2022,NULL,11,1,1),
(5,20,16,8,'ACCEPTED',NULL,2022,NULL,12,2,1),
(6,17,18,8,'ACCEPTED',NULL,2022,NULL,11,NULL,2),
(7,20,20,8,'ACCEPTED',NULL,2022,NULL,11,NULL,2),
(8,18,8,8,'ACCEPTED',NULL,2022,NULL,12,NULL,2),
(9,16,10,8,'ACCEPTED',NULL,2022,NULL,11,1,2),
(10,20,10,8,'ACCEPTED',NULL,2022,NULL,12,2,2),
(11,16,16,8,'ACCEPTED',NULL,2022,NULL,11,1,3),
(12,20,18,8,'ACCEPTED',NULL,2022,NULL,12,2,4),
(14,20,18,8,'ACCEPTED',NULL,2022,NULL,12,2,6),
(21,21,11,8,'UNACCEPTED',NULL,2022,NULL,10,NULL,1);
/*!40000 ALTER TABLE `counseling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counseling_document`
--

DROP TABLE IF EXISTS `counseling_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counseling_document` (
  `counseling_document_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `is_open` bit(1) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `counseling_id` bigint(20) DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`counseling_document_id`),
  KEY `FKqbp4li7kef7koyaq6ibdjc0w9` (`counseling_id`),
  KEY `FKp0ggr8r6ojauwtnwlmrc0nbjn` (`counselor_id`),
  KEY `FKn4yugmir49xii0jaappcyyqm9` (`group_id`),
  KEY `FKaoy4i74eetnu65id3k31yapja` (`user_id`),
  CONSTRAINT `FKaoy4i74eetnu65id3k31yapja` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKn4yugmir49xii0jaappcyyqm9` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`),
  CONSTRAINT `FKp0ggr8r6ojauwtnwlmrc0nbjn` FOREIGN KEY (`counselor_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKqbp4li7kef7koyaq6ibdjc0w9` FOREIGN KEY (`counseling_id`) REFERENCES `counseling` (`counseling_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counseling_document`
--

LOCK TABLES `counseling_document` WRITE;
/*!40000 ALTER TABLE `counseling_document` DISABLE KEYS */;
INSERT INTO `counseling_document` VALUES
(2,'서류만 매일 떨어지고 있습니다. 자존감이 너무 낮아진 것 같아요...',21,10,'',8,2022,2,11,NULL,1),
(3,'사람들이 무섭습니다. 밖으로 나가는게 두려워요.',20,12,'\0',8,2022,3,12,NULL,1),
(4,'부모님이랑 매일 싸우고있어요. 취업좀 빨리하라고 잔소리하시는거 듣는거 너무 힘듭니다.',16,14,'\0',8,2022,4,11,1,1),
(5,'취준하면서 연애하기 너무 힘듭니다. 여자친구가 매번 보자고할때마다 거절하는게 너무 힘들어요',20,16,'\0',8,2022,5,12,2,1),
(6,'할 수 있는건 다한 것 같은데 도저히 일이 안풀리네요. 그냥 막막하기만 합니다.',17,18,'\0',8,2022,6,11,NULL,2),
(7,'친구들은 다들 취업했는데 저만 몇년째 취준생이에요.',20,20,'\0',8,2022,7,11,NULL,2),
(8,'매번 불합격통보만 들으니 자존감이 너무 떨어집니다. 우울해져서 손에 아무것도 안잡혀요. 어떻게 극복할 수 있을까요? ',18,8,'\0',8,2022,8,12,NULL,2),
(9,'아버지가 취업 언제할꺼냐고 매일 잔소리하시는게 너무 듣기 싫어요. 저도 하고싶지만 못하는건데 들을때마다 화가 납니다.',16,10,'\0',8,2022,9,11,1,2),
(10,'여자친구가 제가 취업할때까지 기다려줄까요? 가끔 여자친구 친구들의 남자친구 얘기에 자존감이 너무 떨어져요.',20,10,'\0',8,2022,10,12,2,2),
(11,'저는 개발자가 하고싶은데 아버지는 공무원을 하기를 바라세요. 어떻게 아버지를 설득시킬 수 있을까요',16,16,'\0',8,2022,11,11,1,3),
(12,'취준생인데 남자친구가 결혼하자고 합니다. 저는 결혼은 취업이후에 하고싶거든요. 고민입니다.',20,18,'\0',8,2022,12,12,2,4),
(14,'남자친구가 취업하라고 옆에서 너무 짜증나게해요. 헤어질까요?',20,18,'\0',8,2022,14,12,2,6),
(21,'밤마다 우울해서 잠을 못잡니다. 뭐가 원인일까요. 하루라도 푹 자보고 싶어요.',21,11,'',8,2022,21,10,NULL,1);
/*!40000 ALTER TABLE `counseling_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counseling_room`
--

DROP TABLE IF EXISTS `counseling_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counseling_room` (
  `session_name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `counselor_token` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counseling_id` bigint(20) DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`session_name`),
  KEY `FK9tnjbs6liea4g5s3cjixdt01l` (`counseling_id`),
  KEY `FKt0rq6f6mbbudsoa1otd38nk5y` (`counselor_id`),
  KEY `FKp7v92lwpjnaohntuerym9657g` (`group_id`),
  CONSTRAINT `FK9tnjbs6liea4g5s3cjixdt01l` FOREIGN KEY (`counseling_id`) REFERENCES `counseling` (`counseling_id`),
  CONSTRAINT `FKp7v92lwpjnaohntuerym9657g` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`),
  CONSTRAINT `FKt0rq6f6mbbudsoa1otd38nk5y` FOREIGN KEY (`counselor_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counseling_room`
--

LOCK TABLES `counseling_room` WRITE;
/*!40000 ALTER TABLE `counseling_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `counseling_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counselor_profile`
--

DROP TABLE IF EXISTS `counselor_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counselor_profile` (
  `counselor_id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `introduce` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `price` bigint(20) NOT NULL,
  `review_cnt` bigint(20) DEFAULT NULL,
  `review_value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`counselor_id`),
  CONSTRAINT `FKgt4kyfu6rl5wmqf5dd4nld2i6` FOREIGN KEY (`counselor_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counselor_profile`
--

LOCK TABLES `counselor_profile` WRITE;
/*!40000 ALTER TABLE `counselor_profile` DISABLE KEYS */;
INSERT INTO `counselor_profile` VALUES
(10,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','안녕하세요. 편안하게 찾아주세요.',1000,0,0),
(11,'2022-08-18 09:42:05.000000','2022-08-18 17:04:59.338053','안녕하세요. 편안하게 찾아주세요.',1000,7,9),
(12,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','편안한 대화상대가 되어드리겠습니다.',1500,1,4),
(13,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','당신의 이야기를 들려주십시오.',2000,0,0),
(14,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','저는 항상 열려있습니다. 언제든 찾아주세요.',1000,0,0),
(15,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','당신의 친구가 되어드리겠습니다',3000,0,0),
(16,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','전문적인 상담으로 해답을 드리겠습니다',2000,0,0),
(17,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','친절한 상담, 편안한 분위기',3000,0,0),
(18,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','경청하는 상담사를 원하신다면 저를 찾아주세요',2000,0,0),
(19,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','고민이 있다면 저를 찾아주세요.',1000,0,0),
(20,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','경험에서 나오는 상담을 원하신다면 저를 찾아주세요',2000,0,0);
/*!40000 ALTER TABLE `counselor_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `file_name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `real_file_name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgy0uu7qsty7pngxouem5rm5na` (`counselor_id`),
  CONSTRAINT `FKgy0uu7qsty7pngxouem5rm5na` FOREIGN KEY (`counselor_id`) REFERENCES `counselor_profile` (`counselor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorite` (
  `favorite_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `counselor_user_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`favorite_id`),
  KEY `FKtndvuqumj6d5d5xhg6ul3r6na` (`counselor_user_id`),
  KEY `FKt8nhx5c3o8cqvl16fqjcpvdt3` (`id`),
  CONSTRAINT `FKt8nhx5c3o8cqvl16fqjcpvdt3` FOREIGN KEY (`id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKtndvuqumj6d5d5xhg6ul3r6na` FOREIGN KEY (`counselor_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES
(1,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000',11,1),
(2,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000',12,1),
(3,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000',13,1),
(4,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000',11,2),
(5,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000',12,2);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `day` bigint(20) DEFAULT NULL,
  `hours` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `counselor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `FK9lolfk4l5uua9pwv7lbkm6af` (`counselor_id`),
  CONSTRAINT `FK9lolfk4l5uua9pwv7lbkm6af` FOREIGN KEY (`counselor_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES
(1,'가족과 갈등이 있으신분들의 참여를 기다립니다!',NULL,NULL,0,'가족과의 갈등',11),
(2,'연인과의 관계에 고민이 있으신분들! 같이 얘기 나눠요!',NULL,NULL,0,'연애와 결혼',12);
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_user`
--

DROP TABLE IF EXISTS `group_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt8orq8qkvvoj5rvicebm0ab1i` (`group_id`),
  KEY `FKtu7ubh1gugtwoi1cjcqsm5pj` (`user_id`),
  CONSTRAINT `FKt8orq8qkvvoj5rvicebm0ab1i` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`),
  CONSTRAINT `FKtu7ubh1gugtwoi1cjcqsm5pj` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_user`
--

LOCK TABLES `group_user` WRITE;
/*!40000 ALTER TABLE `group_user` DISABLE KEYS */;
INSERT INTO `group_user` VALUES
(1,1,1),
(2,2,1),
(3,1,2),
(4,2,2),
(5,1,3),
(6,2,4),
(7,1,5),
(8,2,6);
/*!40000 ALTER TABLE `group_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `review_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `value` bigint(20) NOT NULL,
  `counselor_user_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FKldst14q9gn5uuk83fqemher84` (`counselor_user_id`),
  KEY `FKi0vbu956h4hki8hq29v7nclmv` (`id`),
  CONSTRAINT `FKi0vbu956h4hki8hq29v7nclmv` FOREIGN KEY (`id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKldst14q9gn5uuk83fqemher84` FOREIGN KEY (`counselor_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES
(1,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','감사합니다!',5,11,1),
(2,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','최고의 상담!',4,11,1),
(3,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','속이 시원해졌어요!',4,11,2),
(4,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','친절한 상담 감사해요!',4,12,2),
(5,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','상담 받길 너무 잘 했네요!',5,11,2),
(6,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','다음엔 좀 더 유익하길',2,11,3),
(7,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','여전히 답답해요',1,11,5),
(8,'2022-08-18 17:04:59.328822','2022-08-18 17:04:59.328822','너무 좋아요!',5,11,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `text_diary`
--

DROP TABLE IF EXISTS `text_diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `text_diary` (
  `text_diary_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `negative` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `positive` double DEFAULT NULL,
  `sentiment` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`text_diary_id`),
  KEY `FK8yhtih6tyqo4p4k64qjn25mkd` (`user_id`),
  CONSTRAINT `FK8yhtih6tyqo4p4k64qjn25mkd` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `text_diary`
--

LOCK TABLES `text_diary` WRITE;
/*!40000 ALTER TABLE `text_diary` DISABLE KEYS */;
INSERT INTO `text_diary` VALUES
(1,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','오늘은 너무 힘들었다. 서류에서 불합격만 몇번인지 모르겠다. 얼마전 지원했던 곳 10곳 전부 서류불합이다 ㅠㅠ',10,8,99.93,0.06,99.93,0.01,'negative','우울하다',2022,1),
(2,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','이젠 진짜 모르겠다 언제까지 이렇게 해야하는지 ㅠㅠ 취업은 언제쯤 할 수 있을런지 ㅠㅠ 힘들고 지겹다.',11,8,87.58,12.4,87.58,0.03,'negative','지겹다',2022,1),
(3,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','오늘은 힘들지만 그래도 기분이 나쁘지않아서 좀 더 열심히 한 것 같아 뿌듯하다! 이렇게 하다보면 좋은 날도 있지 않을까?',12,8,0.01,0.04,99.96,99.96,'positive','그래도 다시 해보자!',2022,1),
(4,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','서류 합격은 누가 하는지 모르겠다. 왜 항상 나만 불합격인거지 ㅠㅠ 옆에 친구들은 잘만 합격하던데 또 우울하다.',13,8,94.32,5.67,0.01,94.32,'negative','또 불합격...',2022,1),
(5,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','오늘 점심에 족발 사먹었는데 맛있었다. 잠시나마 취준생이란걸 잊을 수 있었는듯하다. 가끔 맛있는걸 먹으러 가야겠다. 기분이 좋아졌다.',14,8,0.03,14.07,85.9,85.9,'positive','오늘은 밥이 맛있네',2022,1),
(6,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','드디어 서류합격을 했다!! 이게 얼마만인지 모르겠다. 제일 가고싶은 회사는 아니지만 그래도 이정도면 감지덕지다. 면접준비 열심히 해봐야지! 화이팅!',15,8,0.11,5.59,94.3,94.3,'positive','이게 맞지',2022,1),
(7,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','면접을 준비하려고 면접스터디원을 구했다. 다들 의욕이 넘치고 스펙이 좋아서 좀 주눅들긴하지만 그래도 까보기전까진 모르니까 최선을 다해보자!',16,7,0.03,14.31,85.66,85.66,'positive','면접스터디!',2022,1),
(9,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','면접을 보고왔다...정말 아무말도 못 했다. 예상질문을 철저히 준비해갔다고 생각했는데 막상 면접장에 가니 아무것도 생각이 나지 않았다..ㅠㅠ 면접장 나오자마자 펑펑 울었다. 망한 것 같아...',18,7,95.47,4.49,0.03,95.47,'negative','면접...',2022,1),
(11,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','오늘따라 왜이렇게 공부가 손에 안잡히는지 모르겠다. 아침부터 지금까지 아무것도 못 했다. 우울해서 눈물이 나온다. 힘들다 힘들어',11,8,99.97,0.02,0.01,99.97,'negative','힘들다',2022,2),
(12,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','어제 늦게 자서 그런지 아침에 알람을 못 듣고 자버렸다. ㅠㅠ 학원에 결국 지각했다. 하루종일 정신이 없는 하루였다. 아침부터 지각해서 그런지 일이 자꾸 꼬이는 기분이 들었다. 힘든 하루 였다.',12,8,95.99,4,0.01,95.99,'negative','알람을 못 들었다 ㅠㅠ',2022,2),
(13,'2022-08-18 09:42:07.000000','2022-08-18 09:42:07.000000','난 왜이렇게 일이 잘 안풀릴까? 오늘도 또 지각을 해버렸다. 왜 매번 알람을 못 듣고 자버리는걸까? 잠자기전에 인스타그램보는걸 그만해야겠다.',13,8,95.96,4.04,0,95.96,'negative','힘든 하루였다',2022,2),
(14,'2022-08-18 11:17:50.165374','2022-08-18 11:17:50.165374','너무너무 희망적이다',18,8,0.05,0,99.95,99.95,'positive','희망적이다',2022,1);
/*!40000 ALTER TABLE `text_diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `birth` datetime(6) NOT NULL,
  `email` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `gender` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `id` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `nick_name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `file_name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `real_file_name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `points` bigint(20) NOT NULL,
  `pw` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `refresh_token` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_8qtpnv06elxuryeuv1ac4ximm` (`id`),
  UNIQUE KEY `UK_d2ia11oqhsynodbsi46m80vfc` (`nick_name`),
  UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(1,'2022-08-18 09:42:05.000000','2022-08-18 23:35:43.121265','2021-09-19 00:00:00.000000','ltumayan0@google.fr','MALE','test1','test1','010-4926-4291','pikachu','pikachu.png',12000,'test1','refresh Token','USER'),
(2,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-08-25 00:00:00.000000','sfeaveer1@epa.gov','FEMALE','test2','test2','010-3908-6081','basic','basic.png',20000,'test2','refresh Token','USER'),
(3,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-11-28 00:00:00.000000','ddemaine2@tumblr.com','FEMALE','test3','test3','010-4447-6503','basic','basic.png',3000,'test3','refresh Token','USER'),
(4,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-10-17 00:00:00.000000','cbastian3@themeforest.net','MALE','test4','test4','010-1414-9459','basic','basic.png',4000,'test4','refresh Token','USER'),
(5,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-11-10 00:00:00.000000','ctrue4@mac.com','FEMALE','test5','test5','010-3935-3593','basic','basic.png',5000,'test5','refresh Token','USER'),
(6,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-05-28 00:00:00.000000','bcowherd5@tuttocitta.it','MALE','test6','test6','010-5483-5633','basic','basic.png',6000,'test6','refresh Token','USER'),
(7,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-08-19 00:00:00.000000','wphette6@imageshack.us','FEMALE','test7','test7','010-2761-5915','basic','basic.png',7000,'test7','refresh Token','USER'),
(8,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-12-05 00:00:00.000000','gcasseldine7@cocolog-nifty.com','FEMALE','test8','test8','010-4411-8045','basic','basic.png',8000,'test8','refresh Token','USER'),
(9,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-03-12 00:00:00.000000','oloram8@europa.eu','FEMALE','test9','test9','010-1530-7150','basic','basic.png',9000,'test9','refresh Token','USER'),
(10,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-12-22 00:00:00.000000','kpaprotnyt@chicagotribune.com','MALE','test30','test30','010-3521-2216','ggobugi','ggobugi.jpeg',3000,'test30','refresh Token','COUNSELOR'),
(11,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-08-29 00:00:00.000000','gstrangu@biglobe.ne.jp','MALE','test31','test31','010-6447-2507','isanghessi','isanghessi.png',3100,'test31','refresh Token','COUNSELOR'),
(12,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-07-27 00:00:00.000000','cboggesv@ucoz.ru','MALE','test32','test32','010-9341-7795','metamong','metamong.jpg',3200,'test32','refresh Token','COUNSELOR'),
(13,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-07-12 00:00:00.000000','mcorradow@typepad.com','MALE','test33','test33','010-6597-1235','pairi','pairi.jpeg',3300,'test33','refresh Token','COUNSELOR'),
(14,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-06-16 00:00:00.000000','vgauchx@utexas.edu','FEMALE','test34','test34','010-3054-2172','basic','basic.png',3400,'test34','refresh Token','COUNSELOR'),
(15,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-02-09 00:00:00.000000','dpladeny@163.com','FEMALE','test35','test35','010-2469-8882','basic','basic.png',3500,'test35','refresh Token','COUNSELOR'),
(16,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-11-16 00:00:00.000000','uretterz@washington.edu','FEMALE','test36','test36','010-1530-5329','basic','basic.png',3600,'test36','refresh Token','COUNSELOR'),
(17,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-02-22 00:00:00.000000','atrengrove10@istockphoto.com','MALE','test37','test37','010-9503-3978','basic','basic.png',3700,'test37','refresh Token','COUNSELOR'),
(18,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-07-22 00:00:00.000000','mdufore11@diigo.com','MALE','test38','test38','010-1403-9986','basic','basic.png',3800,'test38','refresh Token','COUNSELOR'),
(19,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2021-10-21 00:00:00.000000','agaspar12@mapy.cz','MALE','test39','test39','010-8520-2486','basic','basic.png',3900,'test39','refresh Token','COUNSELOR'),
(20,'2022-08-18 09:42:05.000000','2022-08-18 09:42:05.000000','2022-01-30 00:00:00.000000','ltomczykowski13@wisc.edu','MALE','test40','test40','010-5153-6837','basic','basic.png',4000,'test40','refresh Token','COUNSELOR');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_diary`
--

DROP TABLE IF EXISTS `video_diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video_diary` (
  `video_diary_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `contents` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `negative` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `positive` double DEFAULT NULL,
  `real_file_name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `sentiment` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`video_diary_id`),
  KEY `FKndlk46dr4x65of080bqdsgv60` (`user_id`),
  CONSTRAINT `FKndlk46dr4x65of080bqdsgv60` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_diary`
--

LOCK TABLES `video_diary` WRITE;
/*!40000 ALTER TABLE `video_diary` DISABLE KEYS */;
INSERT INTO `video_diary` VALUES
(11,'2022-08-19 00:14:10.868687','2022-08-19 00:14:10.868687','가게 정리해 주는게 포인트가 들어간 거 예술을 통해 살펴볼게요 시간을 부족으로 같은 프로젝트 안에서 가실래요',19,8,0.465,99.521,99.521,0.014,'ses_N6U00zjsEs','neutral','video',2022,1);
/*!40000 ALTER TABLE `video_diary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  0:56:51
