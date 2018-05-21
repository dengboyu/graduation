/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : gz

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 05/22/2018 00:43:25 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `collegeNum` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学院编号',
  `collegeName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学院名称',
  `startTime` date DEFAULT NULL COMMENT '成立时间',
  `statu` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '状态(0-无效，1-有效)',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseNum` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '课程编号',
  `courseName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '课程名称',
  `college` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '外键关联学院id',
  `profession` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联专业id',
  `teacher` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联user_info表的id',
  `statu` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '有效性(0-无效，1-有效)',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `evalution`
-- ----------------------------
DROP TABLE IF EXISTS `evalution`;
CREATE TABLE `evalution` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答题分数',
  `totalCore` int(9) DEFAULT NULL COMMENT '总分',
  `suggestion` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '建议',
  `studentId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联学生外键',
  `teacherId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联教师外键',
  `couseId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '课程id',
  `statu` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `profession`
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `proNum` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '专业编号',
  `proName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '专业名称',
  `startTime` date DEFAULT NULL COMMENT '成立时间',
  `collegeId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学院外键',
  `statu` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '有效性(0-无效，1-有效)',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '标签',
  `question` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '问题',
  `statu` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '状态(0-无效，1-有效)',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `identity` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '身份(0-学生，1-教师，2-管理员)',
  `number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学号、教师工号',
  `college` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '外键关联学院id',
  `profession` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联专业id',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `statu` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '状态(0-无效，1-有效)',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
