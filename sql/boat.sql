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

 Date: 05/14/2019 21:40:09 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `advance_order`
-- ----------------------------
DROP TABLE IF EXISTS `advance_order`;
CREATE TABLE `advance_order` (
  `id` varchar(255) NOT NULL,
  `yacht_name` varchar(255) NOT NULL COMMENT '游艇名称',
  `trip_date` date NOT NULL COMMENT '出航日期',
  `trip_time` time NOT NULL COMMENT '出航时间',
  `route` varchar(32) NOT NULL COMMENT '航线，外键',
  `people_count` int(11) NOT NULL COMMENT '出行人数',
  `trip_purpose` varchar(32) NOT NULL COMMENT '出行目的，外键',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `phone` varchar(13) NOT NULL COMMENT '手机号',
  `customer_name` varchar(50) NOT NULL,
  `gender` int(2) DEFAULT NULL COMMENT '性别 0：男，1：女',
  `invoice` varchar(32) DEFAULT NULL COMMENT '票据id，如果选择开票则存在一个id指向另外一张表',
  PRIMARY KEY (`id`),
  KEY `route` (`route`),
  KEY `trip_ purpose` (`trip_purpose`),
  KEY `invoice` (`invoice`),
  CONSTRAINT `advance_order_ibfk_1` FOREIGN KEY (`route`) REFERENCES `route` (`id`),
  CONSTRAINT `advance_order_ibfk_2` FOREIGN KEY (`trip_purpose`) REFERENCES `purpose` (`id`),
  CONSTRAINT `advance_order_ibfk_3` FOREIGN KEY (`invoice`) REFERENCES `invoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预定订单表';

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(32) NOT NULL COMMENT '信息id',
  `editor_id` varchar(32) NOT NULL COMMENT '发布者id,关联user.id',
  `menu_id` varchar(32) NOT NULL COMMENT '所属栏目id,关联menu.id',
  `title` varchar(20) NOT NULL COMMENT '信息标题',
  `content` text COMMENT '信息内容',
  `enable_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否可用 1：可用，0：不可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `editor_id` (`editor_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`editor_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文章信息表';

-- ----------------------------
--  Table structure for `invoice`
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` varchar(32) NOT NULL,
  `invoice_title` varchar(255) NOT NULL COMMENT '发票抬头',
  `invoice_details` varchar(255) NOT NULL DEFAULT '游艇项目咨询费' COMMENT '发票明细',
  `post_address` varchar(255) NOT NULL COMMENT '邮寄地址',
  `postcode` int(6) NOT NULL COMMENT '邮政编码',
  `addressee` varchar(255) NOT NULL COMMENT '收件人',
  `phone` varchar(13) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='票据信息表';

-- ----------------------------
--  Table structure for `leasing_yacht`
-- ----------------------------
DROP TABLE IF EXISTS `leasing_yacht`;
CREATE TABLE `leasing_yacht` (
  `yacht_id` varchar(32) NOT NULL COMMENT '游艇id，外键',
  `maxpeople` int(11) DEFAULT NULL COMMENT '限载人数',
  `wharf` varchar(32) DEFAULT NULL COMMENT '停靠码头（外键）',
  `bedroom` int(2) DEFAULT NULL COMMENT '游艇卧室数量',
  `standard_seaman` varchar(255) DEFAULT NULL COMMENT '标配船员',
  `standard_subject` varchar(255) NOT NULL COMMENT '标配项目',
  `apolegamy_subject` varchar(255) DEFAULT NULL COMMENT '选配项目',
  `insurance_declare` varchar(255) DEFAULT NULL COMMENT '保险说明',
  `belonging` int(2) NOT NULL COMMENT '游艇隶属，如果拥有者不是管理员，隶属为私人，否则为企业；0:企业 1:私人',
  KEY `yacht_id` (`yacht_id`),
  KEY `wharf` (`wharf`),
  CONSTRAINT `leasing_yacht_ibfk_1` FOREIGN KEY (`yacht_id`) REFERENCES `yacht` (`id`) ON DELETE CASCADE,
  CONSTRAINT `leasing_yacht_ibfk_2` FOREIGN KEY (`wharf`) REFERENCES `wharf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租赁游艇表';

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(32) NOT NULL COMMENT '菜单id',
  `pid` varchar(32) DEFAULT NULL COMMENT '父菜单id',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT '0' COMMENT '菜单排序号',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `enable_status` int(65) DEFAULT '1' COMMENT '菜单状态 :  1:启用   0:不启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单信息表';

-- ----------------------------
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('1ea19b9f2e33446fb46ebf3ff8aac1e3', '', '玩游艇', '/play', '3', '', '1', '2019-05-04 16:28:13', '2019-05-04 16:28:13'), ('510be10ee91daa4d549336c64e9de25b', '', '新技术', '/newtech', '5', '', '1', '2019-05-04 16:29:27', '2019-05-04 16:30:12'), ('54e014ff3fb1e1e1bcb38c9c009f1cba', '', '新闻资讯', '/news', '6', '', '1', '2019-05-04 16:29:46', '2019-05-04 16:30:39'), ('b8cbb569f8f1c16948fd0e028a4a32f8', '', '游艇配套', '/suporting', '4', '', '1', '2019-05-04 16:28:58', '2019-05-04 16:30:25'), ('bf6f4414cda8eb19713fc8c78e128b8b', '', '游艇展', '/yachtshow', '1', '', '1', '2019-05-04 16:26:59', '2019-05-04 16:26:59'), ('db6701caae23f61669f7b2c96ce92358', '', '租游艇', '/rent', '2', '', '1', '2019-05-04 16:27:45', '2019-05-04 16:27:45');
COMMIT;

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(32) NOT NULL COMMENT '商品id',
  `product_name` varchar(20) NOT NULL COMMENT '商品名称',
  `type` int(11) NOT NULL COMMENT '商品类别，1：游艇，2：零件',
  `description` varchar(50) DEFAULT NULL COMMENT '商品描述',
  `img_url` varchar(1024) DEFAULT NULL COMMENT '商品图片的路径',
  `ownner_id` varchar(32) NOT NULL COMMENT '商品所有者id,关联user.id',
  `enable_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否可用 1：可用，0：不可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `ownner_id` (`ownner_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`ownner_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品信息表';

-- ----------------------------
--  Table structure for `purpose`
-- ----------------------------
DROP TABLE IF EXISTS `purpose`;
CREATE TABLE `purpose` (
  `id` varchar(32) NOT NULL,
  `purpose` varchar(255) NOT NULL COMMENT '出航目的',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出行目的表';

-- ----------------------------
--  Table structure for `route`
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `id` varchar(32) NOT NULL,
  `route_desc` varchar(255) NOT NULL COMMENT '航线说明',
  `price` decimal(10,0) NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='航线表';

-- ----------------------------
--  Table structure for `slider_img`
-- ----------------------------
DROP TABLE IF EXISTS `slider_img`;
CREATE TABLE `slider_img` (
  `id` varchar(32) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '轮播图路径',
  `num` int(2) DEFAULT '0' COMMENT '图片次序，默认0',
  KEY `id` (`id`),
  CONSTRAINT `slider_img_ibfk_1` FOREIGN KEY (`id`) REFERENCES `leasing_yacht` (`yacht_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播图片表';

-- ----------------------------
--  Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` varchar(32) DEFAULT NULL,
  `count` int(11) DEFAULT NULL COMMENT '库存数量',
  KEY `id` (`id`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`id`) REFERENCES `leasing_yacht` (`yacht_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存表';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '用户实体id',
  `account` varchar(20) NOT NULL COMMENT '账户',
  `password` varchar(20) NOT NULL DEFAULT '000000' COMMENT '密码',
  `nickname` varchar(20) NOT NULL COMMENT '用户昵称，用来显示',
  `enable_status` int(11) NOT NULL DEFAULT '1' COMMENT '是否可用 1：可用，0：不可用',
  `user_type` int(11) NOT NULL DEFAULT '1' COMMENT '用户角色，1.用户；2.管理员；3.超级管理员',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('53f7f03086981fb61a1d8fa5683fda70', 'zhangsan', '111', '张三', '2', '1', '2019-04-28 00:46:02', '2019-05-05 16:41:30'), ('dcce7b55d3c5a0de62503a888d833f95', 'tianqi', '123456', '田七', '1', '3', '2019-05-01 04:02:48', '2019-05-01 14:39:48'), ('dd30b6c4a0ec052a43cb2ac1db5babf3', 'xx', '111', 'xx', '2', '2', '2019-05-05 16:46:11', '2019-05-05 16:46:11'), ('ea8513a7c8fa4d0bf6b49429c2005345', 'lisi', '111', '李四', '1', '1', '2019-05-02 00:22:26', '2019-05-02 00:22:26');
COMMIT;

-- ----------------------------
--  Table structure for `wharf`
-- ----------------------------
DROP TABLE IF EXISTS `wharf`;
CREATE TABLE `wharf` (
  `id` varchar(32) NOT NULL,
  `wharf` varchar(255) NOT NULL COMMENT '停靠码头',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='码头表';

-- ----------------------------
--  Table structure for `yacht`
-- ----------------------------
DROP TABLE IF EXISTS `yacht`;
CREATE TABLE `yacht` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '游艇名称',
  `img_path` varchar(2048) DEFAULT NULL COMMENT '图片路径',
  `length` float DEFAULT NULL COMMENT '艇长',
  `max_speed` float DEFAULT NULL COMMENT '最高航速，单位节',
  `region` varchar(255) DEFAULT NULL COMMENT '产地',
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `price` float DEFAULT NULL COMMENT '售价',
  `description` text COMMENT '详情描述',
  `owner_id` varchar(32) NOT NULL COMMENT '游艇所有者id,关联user.id',
  `enable_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否可用 1：可用，0：不可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`),
  CONSTRAINT `yacht_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游艇信息';

-- ----------------------------
--  Records of `yacht`
-- ----------------------------
BEGIN;
INSERT INTO `yacht` VALUES ('82e80b32718e71431467fc5f7ad970b7', 'Hanse 315', 'upload/2017127109645061.jpg', '8.12', null, '美国', '2018', '23.74', '很大<p>hhhh<img src=\"http://localhost:8082/manage/upload/2013115159364265.jpg\" style=\"font-size: 1rem; max-width: 100%;\"></p>', '53f7f03086981fb61a1d8fa5683fda70', '1', '2019-04-30 23:32:55', '2019-05-01 18:28:09');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
