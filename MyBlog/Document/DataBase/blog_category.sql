/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-03-26 16:23:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `CATE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATE_CODE` varchar(255) NOT NULL,
  `CATE_NAME` varchar(255) NOT NULL,
  `CATE_DESC` varchar(255) DEFAULT NULL,
  `CATE_SORT` int(11) DEFAULT NULL,
  PRIMARY KEY (`CATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
