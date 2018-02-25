-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: assigment
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `other_details` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `activity_codes_activity_code` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FKjaewr5og8qq1di5gna3w45jny` (`activity_codes_activity_code`),
  KEY `FKsp1gle1x16hi1viq0vjx26hmf` (`project_id`),
  CONSTRAINT `FKjaewr5og8qq1di5gna3w45jny` FOREIGN KEY (`activity_codes_activity_code`) REFERENCES `activity_codes` (`activity_code`),
  CONSTRAINT `FKsp1gle1x16hi1viq0vjx26hmf` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (1,'2017-02-12 00:00:00','Details for activity updated from postman','2017-02-12 00:00:00',1,1),(2,'2017-02-12 00:00:00','Details for activity created from postman','2017-02-12 00:00:00',3,1);
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_codes`
--

DROP TABLE IF EXISTS `activity_codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_codes` (
  `activity_code` int(11) NOT NULL AUTO_INCREMENT,
  `activity_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activity_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_codes`
--

LOCK TABLES `activity_codes` WRITE;
/*!40000 ALTER TABLE `activity_codes` DISABLE KEYS */;
INSERT INTO `activity_codes` VALUES (1,'Other details for activityCode postman created'),(3,'Other details for activityCode postman created 3.1');
/*!40000 ALTER TABLE `activity_codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost_centers`
--

DROP TABLE IF EXISTS `cost_centers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost_centers` (
  `cost_center_id` int(11) NOT NULL AUTO_INCREMENT,
  `cost_center_decription` varchar(255) DEFAULT NULL,
  `cost_center_name` varchar(255) DEFAULT NULL,
  `other_details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cost_center_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost_centers`
--

LOCK TABLES `cost_centers` WRITE;
/*!40000 ALTER TABLE `cost_centers` DISABLE KEYS */;
INSERT INTO `cost_centers` VALUES (1,'Decription for cost center updated from postman','cost center 1 updated from postman','Other details for cost center updated from postman'),(2,'Decription for cost center from postman','cost center 1 from postman','Other details for cost center from postman');
/*!40000 ALTER TABLE `cost_centers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `other_details` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'2017-02-12 00:00:00','Other details for employee postman update','2017-01-10 00:00:00'),(3,'2017-02-12 00:00:00','Other details for employee postman','2017-01-10 00:00:00');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `location_code` int(11) NOT NULL AUTO_INCREMENT,
  `location_decription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Airport5'),(3,'Airport3');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `other_details` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `project_mgr_employee_id` int(11) DEFAULT NULL,
  `location_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKhsyceikm32eknq5d2udphe2lm` (`project_mgr_employee_id`),
  KEY `FK5q3vgp1eslymx047gswbnax95` (`location_code`),
  CONSTRAINT `FK5q3vgp1eslymx047gswbnax95` FOREIGN KEY (`location_code`) REFERENCES `location` (`location_code`),
  CONSTRAINT `FKhsyceikm32eknq5d2udphe2lm` FOREIGN KEY (`project_mgr_employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'2017-02-12 00:00:00','Other details for project postman updated','2017-02-12 00:00:00',3,1),(3,'2017-02-12 00:00:00','Other details for project 3','2017-02-12 00:00:00',1,3),(4,'2017-02-12 00:00:00','Other details for project postman','2017-02-12 00:00:00',3,1),(5,'2017-02-12 00:00:00','Other details for project postman','2017-02-12 00:00:00',3,3),(6,'2017-02-12 00:00:00','Other details for project postman','2017-02-12 00:00:00',1,1),(7,'2017-02-12 00:00:00','Other details for project postman created postman','2017-02-12 00:00:00',3,1);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheets`
--

DROP TABLE IF EXISTS `timesheets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheets` (
  `timesheet_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `other_details` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `submitted_date` datetime DEFAULT NULL,
  `activity_id` int(11) DEFAULT NULL,
  `cost_center_id` int(11) DEFAULT NULL,
  `timesheet_for_employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`timesheet_id`),
  KEY `FKgi8eup8yorodtdrha4yjm8bp8` (`activity_id`),
  KEY `FK4pfv4bqaqsfja0rsmlw1qh1y2` (`cost_center_id`),
  KEY `FKa6lmuk1oncyik1uvenswkymuq` (`timesheet_for_employee_id`),
  CONSTRAINT `FK4pfv4bqaqsfja0rsmlw1qh1y2` FOREIGN KEY (`cost_center_id`) REFERENCES `cost_centers` (`cost_center_id`),
  CONSTRAINT `FKa6lmuk1oncyik1uvenswkymuq` FOREIGN KEY (`timesheet_for_employee_id`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `FKgi8eup8yorodtdrha4yjm8bp8` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheets`
--

LOCK TABLES `timesheets` WRITE;
/*!40000 ALTER TABLE `timesheets` DISABLE KEYS */;
INSERT INTO `timesheets` VALUES (1,'2017-02-12 00:00:00','Other details for timesheet updated from postman','2017-02-12 00:00:00','2017-01-12 00:00:00',1,2,1),(2,'2017-02-12 00:00:00','Other details for timesheet created from postman','2017-02-12 00:00:00','2017-01-12 00:00:00',2,2,1);
/*!40000 ALTER TABLE `timesheets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-25 22:54:07
