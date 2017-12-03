-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: next_j2ee
-- ------------------------------------------------------
-- Server version       5.7.11

--
-- Table structure for table `article`
--

CREATE SCHEMA `ksb_with_mybatis`
  DEFAULT CHARACTER SET utf8mb4;

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
  `author`     VARCHAR(255)        DEFAULT NULL,
  `content`    LONGTEXT,
  `gmt_create` DATETIME            DEFAULT NULL,
  `gmt_modify` DATETIME            DEFAULT NULL,
  `title`      VARCHAR(255)        DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;


DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
  `author`     VARCHAR(50)         DEFAULT NULL,
  `content`    VARCHAR(200),
  `gmt_create` DATETIME            DEFAULT NULL,
  `gmt_modify` DATETIME            DEFAULT NULL,
  `article_id` BIGINT(20),
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name`       VARCHAR(20)         DEFAULT NULL,
  `gmt_create` DATETIME            DEFAULT NULL,
  `gmt_modify` DATETIME            DEFAULT NULL,
  `article_id` BIGINT(20),
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;


SHOW TABLES;

DESC article;
DESC comment;
DESC tag;

SELECT * FROM article;
SELECT * FROM comment WHERE article_id = 2;
SELECT * FROM tag;

