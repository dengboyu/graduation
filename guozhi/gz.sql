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

 Date: 01/26/2018 21:56:38 PM
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
--  Records of `college`
-- ----------------------------
BEGIN;
INSERT INTO `college` VALUES ('1', '01', '机械学院', '2010-06-09', '1', '2018-01-19 17:11:50', '2018-01-19 22:26:41'), ('2', '02', '艺术与设计学院', '2009-01-07', '1', '2018-01-19 17:12:41', '2018-01-19 22:27:05'), ('3', '03', '外国语学院', '2013-01-10', '1', '2018-01-19 17:12:57', '2018-01-19 22:27:07'), ('4', '08', '经济与管理学院', '2014-01-08', '1', '2018-01-19 17:13:21', '2018-01-19 22:27:08'), ('5', '07', '法政学院', '2013-01-17', '1', '2018-01-20 00:00:10', '2018-01-20 00:00:10');
COMMIT;

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
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '00001', '电子商务', '4', '1', '8', '1', '2018-01-20 00:36:35', '2018-01-24 16:26:07'), ('3', '0002', '计算机原理', '4', '1', '9', '1', '2018-01-20 20:44:05', '2018-01-24 16:26:09'), ('5', '0004', 'web设计的开发与应用', '4', '1', '8', '1', '2018-01-20 20:47:27', '2018-01-24 16:26:10');
COMMIT;

-- ----------------------------
--  Table structure for `evalution`
-- ----------------------------
DROP TABLE IF EXISTS `evalution`;
CREATE TABLE `evalution` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答题分数',
  `totalCore` int(9) DEFAULT NULL COMMENT '总分',
  `studentId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联学生外键',
  `teacherId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关联教师外键',
  `couseId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '课程id',
  `statu` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `evalution`
-- ----------------------------
BEGIN;
INSERT INTO `evalution` VALUES ('1', '1-10,2-10,3-10,4-10,5-10,6-10,7-10,8-10,9-10,10-10,11-10,12-10,13-10,14-10,15-10,16-10,17-10,18-10,19-10,21-10', '200', '1', '8', '1', '1', '2018-01-24 16:14:45', '2018-01-24 16:16:25'), ('2', '1-6,2-8,3-4,4-10,5-6,6-8,7-6,8-4,9-8,10-4,11-8,12-6,13-10,14-8,15-10,16-8,17-10,18-8,19-10,21-8', '150', '1', '9', '3', '1', '2018-01-24 16:38:22', '2018-01-24 16:38:22'), ('3', '1-6,2-4,3-8,4-6,5-4,6-8,7-4,8-8,9-8,10-6,11-4,12-8,13-10,14-8,15-8,16-6,17-10,18-4,19-2,21-8', '130', '2', '8', '1', '1', '2018-01-24 17:23:27', '2018-01-24 17:23:27');
COMMIT;

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
--  Records of `profession`
-- ----------------------------
BEGIN;
INSERT INTO `profession` VALUES ('1', '01', '信息管理与信息系统', '2015-01-05', '4', '1', '2018-01-19 17:52:03', '2018-01-19 17:52:03'), ('2', '02', '物流与管理', '2015-01-22', '4', '1', '2018-01-19 17:52:24', '2018-01-19 17:52:24'), ('3', '01', '英语专业', '2012-01-11', '3', '1', '2018-01-19 22:27:45', '2018-01-19 22:27:45'), ('4', '02', '口语专业', '2013-01-09', '3', '1', '2018-01-19 22:27:57', '2018-01-19 22:27:57');
COMMIT;

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
--  Records of `question`
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES ('1', '教学态度', '上课认真，耐心辅导答疑，认真批改作业', '1', '2018-01-20 14:17:06', '2018-01-20 15:42:01'), ('2', '教学态度', '注意与学生的沟通和交流，关心学生学习', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('3', '教学态度', '按时上下课，不擅自停课、调课', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('4', '教学态度', '备课充分，有讲稿或补充材料', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('5', '教学内容', '内容充实，概念准确，重点突出', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('6', '教学内容', '观点鲜明，对问题有自己独特的见解', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('7', '教学内容', '积极充实更新教学内容，提供参考资料和相关信息', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('8', '教学内容', '理论联系实际，不照本宣科', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('9', '教学方法', '积极有效地运用现代教育手技术段上课', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('10', '教学方法', '实行启发式教学，充分发挥学生的积极主动性', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('11', '教学方法', '教学进度安排适当，适应学生的学习能力', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('12', '教学方法', '注重复习检查，促进学生对知识的理解和巩固', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('13', '教学效果', '学生对课程基础知识掌握的较好', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('14', '教学效果', '学生分析问题和解决问题的能力有显著提高', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('15', '教学效果', '课堂气氛活跃，学生对本课程的学习产生了浓厚的兴趣', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('16', '教学效果', '拓宽了学生的知识面，开阔了学生的思路', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('17', '教学素养', '上课情绪饱满，富有感染力', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('18', '教学素养', '普通话标准，语言清晰流畅，板书规范', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('19', '教学素养', '思路清晰，讲解逻辑性强', '1', '2018-01-20 14:17:06', '2018-01-20 14:17:06'), ('21', '教学素养', '对待学生公正、客观，教学责任心强', '1', '2018-01-20 16:06:43', '2018-01-20 16:06:43');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', '张赫', '123456', '342432@163.com', '0', '12086102', '4', '1', '18322632342', '1', '2018-01-19 23:50:08', '2018-01-20 19:26:42'), ('2', '李根', '123456', 'reqr@163.com', '0', '12086103', '4', '1', '18932423452', '1', '2018-01-19 23:51:46', '2018-01-19 23:51:46'), ('3', '王五', '123456', '583443252@qq.com', '0', '12076103', '3', '3', '1832294623', '1', '2018-01-19 23:53:40', '2018-01-19 23:53:40'), ('4', '李福', '123456', '18344321@qq.com', '0', '12076104', '3', '4', '18732426732', '1', '2018-01-19 23:55:03', '2018-01-19 23:55:03'), ('5', '熊熊', '123456', '54234522@qq.com', '0', '12077103', '3', '4', '18326834243', '1', '2018-01-19 23:57:54', '2018-01-19 23:57:54'), ('8', '张高', '123456', '5423452@163.com', '1', '111111', '4', '1', '16742342432', '1', '2018-01-20 00:10:49', '2018-01-24 18:28:45'), ('9', '刘帅', '123456', '431434@163.com', '1', '222222', '4', '1', '18643243234', '1', '2018-01-20 00:13:11', '2018-01-24 18:31:08'), ('10', '王天盛', '123456', '414123@qq.com', '1', '102032', '4', '1', '18443214314', '1', '2018-01-20 20:48:08', '2018-01-20 20:48:08'), ('11', 'admin', '123456', '4542452@163.com', '2', 'admin', null, null, null, '1', '2018-01-20 20:50:18', '2018-01-24 18:31:36'), ('12', '王胜', '123456', '13414432@163.com', '1', 'A101', '4', '1', '18322673424', '1', '2018-01-22 23:57:28', '2018-01-22 23:57:28');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
