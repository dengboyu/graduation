/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : tt

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 01/26/2018 21:56:26 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `comName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `linkPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `linkName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `company`
-- ----------------------------
BEGIN;
INSERT INTO `company` VALUES ('1', '公司一', '18322695243', '梁杰', '0323-3232323', '4789235@163.com', '滨海新区', '2018-01-25 10:08:44', '2018-01-25 10:08:44'), ('2', '公司二', '17643243243', '王删', '098-43242334', 'jkfda78@163.com', '河西区', '2018-01-25 11:26:21', '2018-01-25 11:26:21');
COMMIT;

-- ----------------------------
--  Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `companyId` int(9) DEFAULT NULL COMMENT '公司外键',
  `linkName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人姓名',
  `post` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '职务',
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `tel` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `wwTel` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '旺旺号码',
  `fax` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '传真',
  `qq` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `msn` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `customer`
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES ('1', '1', '李诞', '销售', '男', '18743243243', '022-43243243', '542354245', '83445345', '542452432', '5342542542', '8989432jh@163.com', '天津市河西区大沽南路', '备注1', '2018-01-25 16:09:59', '2018-01-25 17:30:10');
COMMIT;

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `proName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sortId` int(9) DEFAULT NULL COMMENT '关联分类表id',
  `norm` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '规格',
  `proNum` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '产品编号',
  `cent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '单位',
  `costPrice` decimal(16,2) DEFAULT NULL COMMENT '成本价',
  `centPrice` decimal(16,2) DEFAULT NULL COMMENT '单价',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `product`
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('1', '产品一', '3', '规格一', '1023231', '元', '1.00', '1.00', '产品一的备注', '2018-01-25 18:28:52', '2018-01-25 19:00:23'), ('2', '产品二', '3', '长*宽', 'A101', '米', '1.00', '10.00', '床', '2018-01-26 10:29:21', '2018-01-26 10:29:21');
COMMIT;

-- ----------------------------
--  Table structure for `product_sort`
-- ----------------------------
DROP TABLE IF EXISTS `product_sort`;
CREATE TABLE `product_sort` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `sortName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `product_sort`
-- ----------------------------
BEGIN;
INSERT INTO `product_sort` VALUES ('1', '分类一', '2018-01-25 08:37:04', '2018-01-25 08:37:04'), ('2', '分类二', '2018-01-25 08:37:08', '2018-01-25 08:37:08'), ('3', '分类三', '2018-01-25 08:41:43', '2018-01-25 08:41:43');
COMMIT;

-- ----------------------------
--  Table structure for `quoProduct`
-- ----------------------------
DROP TABLE IF EXISTS `quoProduct`;
CREATE TABLE `quoProduct` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `quotationId` int(9) DEFAULT NULL COMMENT '关联外键',
  `proName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `norm` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '规格',
  `num` int(9) DEFAULT NULL COMMENT '数量',
  `cent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '单位',
  `centPrice` decimal(16,2) DEFAULT NULL COMMENT '单价',
  `totalPrice` decimal(16,2) DEFAULT NULL COMMENT '总价格',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `quoProduct`
-- ----------------------------
BEGIN;
INSERT INTO `quoProduct` VALUES ('1', '2', '产品一', '规格一', '1', '元', '1.00', '1.00', '产品一的备注', '2018-01-26 16:03:33', '2018-01-26 16:03:33'), ('2', '2', '产品二', '长*宽', '1', '米', '10.00', '10.00', '床', '2018-01-26 16:03:33', '2018-01-26 16:03:33'), ('3', '3', '产品一', '规格一', '2', '元', '1.00', '2.00', '产品一的备注', '2018-01-26 21:53:56', '2018-01-26 21:53:56');
COMMIT;

-- ----------------------------
--  Table structure for `quotation`
-- ----------------------------
DROP TABLE IF EXISTS `quotation`;
CREATE TABLE `quotation` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `quoNum` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '报价单编号',
  `companyId` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `linkName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `quoName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '报价人',
  `quoTime` date DEFAULT NULL COMMENT '报价日期',
  `totalPrice` decimal(16,2) DEFAULT NULL,
  `cent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '币种',
  `transport` decimal(16,2) DEFAULT NULL COMMENT '运费',
  `remark` varchar(2095) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `quoPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '报价单顶部电话',
  `quoFax` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '报价单顶部传真',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `quotation`
-- ----------------------------
BEGIN;
INSERT INTO `quotation` VALUES ('2', '2018012682882', '2', '王删', '17643243243', '098-43242334', 'jkfda78@163.com', '河西区', '张丽丽', '2018-01-26', '21.00', '元', '10.00', '1.不扣税\n2.非人为损坏，3年保修\n3.以上产品单价均为含税单价，含税17\n', '18732342432', '022-432432342', '2018-01-26 16:03:33', '2018-01-26 16:03:33'), ('3', '2018012669390', '1', '梁杰', '18322695243', '0323-3232323', '4789235@163.com', '滨海新区', '张丽丽', '2018-01-26', '22.00', '元', '20.00', '1.备注一下\n2.备注二\n3.不扣税\n', '18932323233', '022-983232323', '2018-01-26 21:53:56', '2018-01-26 21:53:56');
COMMIT;

-- ----------------------------
--  Table structure for `remark`
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `remark`
-- ----------------------------
BEGIN;
INSERT INTO `remark` VALUES ('1', '备注一下', '2018-01-25 18:00:40', '2018-01-25 18:00:40'), ('2', '备注二', '2018-01-25 18:01:29', '2018-01-25 18:01:29'), ('3', '不扣税', '2018-01-25 18:04:53', '2018-01-25 18:04:53'), ('4', '非人为损坏，3年保修', '2018-01-25 21:14:31', '2018-01-25 21:14:31'), ('5', '以上产品单价均为含税单价，含税17', '2018-01-25 21:14:37', '2018-01-25 21:14:37');
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `realName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', '张丽丽', '123456', '张丽', 'fdadfa@163.com', '18632342443', '2018-01-24 23:09:39', '2018-01-24 23:31:41');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
