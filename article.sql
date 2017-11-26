-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: next_j2ee
-- ------------------------------------------------------
-- Server version       5.7.11

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
  `author`     VARCHAR(255)        DEFAULT NULL,
  `content`    LONGTEXT,
  `gmt_create` DATETIME            DEFAULT NULL,
  `gmt_modify` DATETIME            DEFAULT NULL,
  `title`      VARCHAR(255)        DEFAULT NULL,
  `url`        VARCHAR(250)        DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_la4e9l2g2otn85r9ih4btnmi` (`url`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;

