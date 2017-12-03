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
  `gmt_create` TIMESTAMP           DEFAULT CURRENT_TIMESTAMP(),
  `gmt_modify` TIMESTAMP           DEFAULT CURRENT_TIMESTAMP(),
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
  `gmt_create` TIMESTAMP           DEFAULT CURRENT_TIMESTAMP(),
  `gmt_modify` TIMESTAMP           DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id`         BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name`       VARCHAR(20)         DEFAULT NULL,
  `gmt_create` TIMESTAMP           DEFAULT CURRENT_TIMESTAMP(),
  `gmt_modify` TIMESTAMP           DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `article_comments`;
CREATE TABLE `article_comments` (
  `article_id` BIGINT(20) NOT NULL,
  `comment_id` BIGINT(20) NOT NULL
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags` (
  `article_id` BIGINT(20) NOT NULL,
  `tag_id`     BIGINT(20) NOT NULL
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;


SHOW TABLES;

DESC article;
DESC article_comments;
DESC article_tags;
DESC comment;
DESC tag;

SELECT *
FROM article;

SELECT *
FROM comment;

SELECT *
FROM tag;

SELECT *
FROM article_comments;

SELECT *
FROM article_tags;

SELECT t.* FROM tag t join article_tags at on t.id = at.tag_id
where at.article_id =1;

SELECT c.* FROM comment c
  join article_comments ac on c.id = ac.comment_id
WHERE ac.article_id =1;

