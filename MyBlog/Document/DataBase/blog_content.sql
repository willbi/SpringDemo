/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-03-26 16:23:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_content
-- ----------------------------
DROP TABLE IF EXISTS `blog_content`;
CREATE TABLE `blog_content` (
  `BLOG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATE_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `BLOG_TITLE` varchar(255) NOT NULL,
  `BLOG_TITLE_EN` varchar(255) NOT NULL,
  `BLOG_CONTENT` text NOT NULL,
  `BLOG_DESC` varchar(500) NOT NULL,
  `CREATE_DATETIME` datetime NOT NULL,
  PRIMARY KEY (`BLOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
