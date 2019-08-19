-- ----------------------------
-- Generally speaking, if in China, you should append string `default-time-zone = '+08:00'`
-- to `/etc/mysql/mysql.conf.d/mysqld.cnf` config file.
-- Thus set mysql timezone to `UTC+0800`,
-- for `CST` timezone will cause problem of more or less several hours.
-- ----------------------------

-- ----------------------------
-- 一般而言，需要在 `/etc/mysql/mysql.conf.d/mysqld.cnf` 尾部
-- 加上 `default-time-zone = '+08:00'`
-- 设定数据库时区为 UTC+0800，CST 时区会导致时间差问题
-- ----------------------------

-- ----------------------------
-- Database definition
-- ----------------------------
-- CREATE DATABASE `starter` DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(30) NOT NULL DEFAULT (CONCAT(UUID_SHORT(), SUBSTR(RAND(), 3, 8))) COMMENT 'uuid',
  `username` varchar(64) NOT NULL COMMENT 'username',
  `email` varchar(64) NOT NULL COMMENT 'email',
  `password` varchar(64) NOT NULL COMMENT 'password(encrypted)',
  `deleted` tinyint(1) DEFAULT 0 COMMENT 'deleted or not',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT 'create time',
  `update_time` datetime NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT 'update time',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='user table';

-- ----------------------------
-- Table structure for article
-- ----------------------------
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(30) NOT NULL DEFAULT (CONCAT(UUID_SHORT(), SUBSTR(RAND(), 3, 8))) COMMENT 'uuid',
  `title` varchar(100) NOT NULL COMMENT 'title',
  `read_count` int(11) DEFAULT 0 COMMENT 'read count',
  `support_count` int(11) DEFAULT 0 COMMENT 'support count',
  `intro` varchar(500) DEFAULT NULL COMMENT 'article summary',
  `content` text COMMENT 'article content',
  `create_user_uuid` varchar(30) NOT NULL COMMENT 'creator user_uuid',
  `deleted` tinyint(1) DEFAULT 0 COMMENT 'deleted or not',
  `create_time` datetime NOT NULL DEFAULT NOW() COMMENT 'create time',
  `update_time` datetime NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT 'update time',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`),
  KEY `idx_create_user_uuid` (`create_user_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='article table';