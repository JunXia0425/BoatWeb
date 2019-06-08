/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost
 Source Database       : boat

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : utf-8

 Date: 06/08/2019 17:38:44 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `yacht_order`
-- ----------------------------
DROP TABLE IF EXISTS `yacht_order`;
CREATE TABLE `yacht_order` (
  `id` varchar(32) NOT NULL,
  `yacht_name` varchar(255) NOT NULL COMMENT '游艇名称',
  `price` float NOT NULL COMMENT '价格',
  `phone` varchar(13) NOT NULL COMMENT '手机号',
  `customer_name` varchar(50) NOT NULL COMMENT '顾客姓名',
  `yacht_id` varchar(32) NOT NULL COMMENT '游艇id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '支付状态，0未支付，1 已支付',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='游艇订单表';

SET FOREIGN_KEY_CHECKS = 1;
