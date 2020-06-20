-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: formula1
-- ------------------------------------------------------
-- Server version	5.7.30-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `corrida`
--

DROP TABLE IF EXISTS `corrida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `corrida` (
  `idcorrida` int(11) NOT NULL AUTO_INCREMENT,
  `classificacao` int(11) NOT NULL,
  `id_piloto` int(11) NOT NULL,
  PRIMARY KEY (`idcorrida`),
  KEY `id_piloto_idx` (`id_piloto`),
  CONSTRAINT `id_piloto` FOREIGN KEY (`id_piloto`) REFERENCES `piloto` (`idpiloto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corrida`
--

LOCK TABLES `corrida` WRITE;
/*!40000 ALTER TABLE `corrida` DISABLE KEYS */;
INSERT INTO `corrida` VALUES (1,0,1),(2,0,1),(3,55,1),(4,0,1),(5,15,4);
/*!40000 ALTER TABLE `corrida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `equipe` (
  `idequipe` int(11) NOT NULL AUTO_INCREMENT,
  `nomeEquipe` varchar(45) NOT NULL,
  PRIMARY KEY (`idequipe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (2,'bbbb');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` varchar(100) DEFAULT NULL,
  `cargoFuncionario` varchar(45) DEFAULT NULL,
  `id_equipe` int(11) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  KEY `equipe_func_idx` (`id_equipe`),
  CONSTRAINT `equipe_func` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`idequipe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piloto`
--

DROP TABLE IF EXISTS `piloto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `piloto` (
  `idpiloto` int(11) NOT NULL AUTO_INCREMENT,
  `nomePiloto` varchar(45) NOT NULL,
  `id_equipe` int(11) NOT NULL,
  `pontuacaoPiloto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpiloto`),
  KEY `equipe_piloto_idx` (`id_equipe`),
  CONSTRAINT `equipe_piloto` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`idequipe`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piloto`
--

LOCK TABLES `piloto` WRITE;
/*!40000 ALTER TABLE `piloto` DISABLE KEYS */;
INSERT INTO `piloto` VALUES (1,'2',2,1),(2,'bbbb',2,NULL),(3,'a',2,0),(4,'muito bom',2,0),(5,'muito bom',2,0),(6,'Joao',2,0),(7,'Vittor',2,0);
/*!40000 ALTER TABLE `piloto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'formula1'
--

--
-- Dumping routines for database 'formula1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-20 14:52:14
