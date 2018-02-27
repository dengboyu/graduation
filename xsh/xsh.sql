/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : xsh

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 02/27/2018 22:49:27 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `act`
-- ----------------------------
DROP TABLE IF EXISTS `act`;
CREATE TABLE `act` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `actName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '活动名称',
  `actPerson` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '活动负责人',
  `communityId` int(9) DEFAULT NULL COMMENT '社团id',
  `actTime` datetime DEFAULT NULL COMMENT '活动时间',
  `actWhere` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '活动地点',
  `actIntro` varchar(4096) COLLATE utf8_bin DEFAULT NULL COMMENT '活动简介',
  `actDetail` varchar(4096) COLLATE utf8_bin DEFAULT NULL COMMENT '活动详情',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `act`
-- ----------------------------
BEGIN;
INSERT INTO `act` VALUES ('1', '校园十大歌手', '张则天', '1', '2018-02-28 21:39:40', '大学生活动中心', '本着十大歌手比赛的目的', '具体详情请参看', '2018-02-26 21:40:03', '2018-02-26 21:40:03'), ('2', '篝火晚会', '李诞', '2', '2018-02-28 21:43:14', '图书馆门前', '活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介', '活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情活动详情', '2018-02-26 21:43:31', '2018-02-26 22:58:00');
COMMIT;

-- ----------------------------
--  Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `actId` int(9) DEFAULT NULL COMMENT '活动id',
  `userId` int(9) DEFAULT NULL COMMENT '用户id',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '插入数据当前时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收藏活动表';

-- ----------------------------
--  Records of `collect`
-- ----------------------------
BEGIN;
INSERT INTO `collect` VALUES ('5', '1', '2', '2018-02-27 16:04:44', '2018-02-27 16:04:44');
COMMIT;

-- ----------------------------
--  Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `collegeName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学院名称',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '插入数据当前时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='学院表';

-- ----------------------------
--  Records of `college`
-- ----------------------------
BEGIN;
INSERT INTO `college` VALUES ('1', '经济与管理学院', '2018-02-25 14:29:49', '2018-02-25 14:29:49'), ('2', '机械学院', '2018-02-25 14:33:44', '2018-02-25 14:33:44');
COMMIT;

-- ----------------------------
--  Table structure for `community`
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `communityName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '社团名称',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '插入数据当前时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='社团表';

-- ----------------------------
--  Records of `community`
-- ----------------------------
BEGIN;
INSERT INTO `community` VALUES ('1', '学生会', '2018-02-25 16:07:34', '2018-02-25 16:07:34'), ('2', '红十字协会', '2018-02-25 16:07:47', '2018-02-25 16:07:47'), ('3', '科技协会', '2018-02-25 16:08:39', '2018-02-25 16:08:39');
COMMIT;

-- ----------------------------
--  Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `friendId` int(9) DEFAULT NULL COMMENT '好友用户id',
  `groupId` int(9) DEFAULT NULL COMMENT '用户分组id',
  `userId` int(9) DEFAULT NULL COMMENT '当前用户id',
  `number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '非系统学生学号',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '非系统学生姓名',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `collegeId` int(9) DEFAULT NULL COMMENT '学院id',
  `professionId` int(9) DEFAULT NULL COMMENT '专业id',
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `friend`
-- ----------------------------
BEGIN;
INSERT INTO `friend` VALUES ('1', '3', '5', '2', null, null, null, null, null, null, '2018-02-26 11:35:00', '2018-02-26 11:35:00'), ('2', '4', '6', '2', '14086105', '赵以', '15832335235', '1', '2', '男', '2018-02-26 13:42:51', '2018-02-27 17:48:45'), ('3', null, '3', '2', '14076105', '任盛', '18632834324', '2', '3', '女', '2018-02-27 16:09:18', '2018-02-27 16:09:18');
COMMIT;

-- ----------------------------
--  Table structure for `friendGroup`
-- ----------------------------
DROP TABLE IF EXISTS `friendGroup`;
CREATE TABLE `friendGroup` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分组名称',
  `userId` int(9) DEFAULT NULL COMMENT '关联用户id',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `friendGroup`
-- ----------------------------
BEGIN;
INSERT INTO `friendGroup` VALUES ('3', '个人分组三', '2', '2018-02-26 08:51:36', '2018-02-26 08:51:36'), ('5', '分组一', '2', '2018-02-26 09:37:28', '2018-02-26 09:37:28'), ('6', '分组二', '2', '2018-02-26 09:37:34', '2018-02-26 09:37:34');
COMMIT;

-- ----------------------------
--  Table structure for `profession`
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `collegeId` int(9) DEFAULT NULL COMMENT '学院id',
  `professionName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '专业名称',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '插入数据当前时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='专业表';

-- ----------------------------
--  Records of `profession`
-- ----------------------------
BEGIN;
INSERT INTO `profession` VALUES ('1', '1', '信息管理与信息系统', '2018-02-25 15:27:15', '2018-02-25 15:27:15'), ('2', '1', '物流管理', '2018-02-25 15:27:35', '2018-02-25 15:27:35'), ('3', '2', '工程制造', '2018-02-25 15:48:57', '2018-02-25 15:48:57');
COMMIT;

-- ----------------------------
--  Table structure for `recommandAct`
-- ----------------------------
DROP TABLE IF EXISTS `recommandAct`;
CREATE TABLE `recommandAct` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `actId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '活动id',
  `userId` int(9) DEFAULT NULL COMMENT '用户id',
  `recommandUser` int(9) DEFAULT NULL COMMENT '推荐人id',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '插入数据当前时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='推荐活动人表';

-- ----------------------------
--  Records of `recommandAct`
-- ----------------------------
BEGIN;
INSERT INTO `recommandAct` VALUES ('1', '1', '2', '1', '2018-02-27 17:06:35', '2018-02-27 17:06:35'), ('2', '1', '2', '2', '2018-02-27 17:09:08', '2018-02-27 17:09:08'), ('3', '2', '2', '2', '2018-02-27 17:09:34', '2018-02-27 17:09:34'), ('4', '2', '2', '3', '2018-02-27 17:09:34', '2018-02-27 17:09:34');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学号',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `collegeId` int(9) DEFAULT NULL COMMENT '学院',
  `professionId` int(9) DEFAULT NULL COMMENT '专业',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', null, null, null, null, null, null, '2018-02-25 09:33:46', '2018-02-25 09:56:15'), ('2', '14086103', '1234567', 'aaa897@163.com', '张文文', '18322498763', '男', '1', '2', '2018-02-25 16:42:56', '2018-02-25 17:30:17'), ('3', '14086104', '123456', 'jhdka@163.com', '李丽', '15876232243', '女', '1', '2', '2018-02-26 09:38:37', '2018-02-26 09:38:37'), ('4', '14086105', '123456', 'zyiyi@163.com', '赵以以', '18736234323', '女', '2', '3', '2018-02-27 17:48:45', '2018-02-27 17:48:45');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
