/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : leung

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 05/20/2018 21:09:39 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `content` varchar(4096) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `score` varchar(9) DEFAULT NULL COMMENT '分数',
  `productId` int(9) DEFAULT NULL COMMENT '关联产品id',
  `userId` int(9) DEFAULT NULL COMMENT '关联user表',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `order_base`
-- ----------------------------
DROP TABLE IF EXISTS `order_base`;
CREATE TABLE `order_base` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号',
  `userId` int(9) DEFAULT NULL COMMENT '关联userId表信息主键',
  `productId` int(9) DEFAULT NULL COMMENT '关联商品的id',
  `account` int(9) DEFAULT NULL COMMENT '购买的数量',
  `totalMoney` decimal(16,2) DEFAULT NULL COMMENT '购买金额',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系地址',
  `linkName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '购买手机号',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `userId` int(9) DEFAULT NULL COMMENT '关联用户id',
  `productName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称',
  `productIntro` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '产品简介',
  `tag` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '产品标签',
  `centPrice` decimal(16,2) DEFAULT NULL COMMENT '产品单价',
  `isShip` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '包邮(0-不包邮,1-包邮)',
  `scanAmount` int(9) DEFAULT NULL COMMENT '浏览量',
  `saleAmount` int(9) DEFAULT NULL COMMENT '销售量',
  `img` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片链接',
  `originPrice` decimal(16,2) DEFAULT NULL COMMENT '原价格',
  `activityPrice` decimal(16,2) DEFAULT NULL COMMENT '活动价格',
  `advPrice` decimal(16,2) DEFAULT NULL COMMENT '广告价',
  `productAmount` int(9) DEFAULT NULL COMMENT '产品数量(0-不限数量)',
  `score` double(3,2) DEFAULT NULL COMMENT '客户分数(默认值4.0'')',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `scan_tag`
-- ----------------------------
DROP TABLE IF EXISTS `scan_tag`;
CREATE TABLE `scan_tag` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `userId` int(9) DEFAULT NULL COMMENT '关联主账户',
  `tag` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '产品标签',
  `amount` int(9) DEFAULT NULL COMMENT '浏览次数',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `productId` int(9) DEFAULT NULL COMMENT '关联产品id',
  `userId` int(9) DEFAULT NULL COMMENT '关联用户id',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `nick` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名、昵称',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `defaultAttr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户属性',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户类型(0-普通客户，1-商户)',
  `companyPrice` decimal(16,2) DEFAULT NULL COMMENT '公司营业额',
  `companyName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名称',
  `companyAddress` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '公司地址',
  `linkName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '公司联系人',
  `telPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '座机号码',
  `harvestPeople` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
  `harvestAddress` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '收货地址',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
