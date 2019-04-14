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

 Date: 04/14/2019 21:23:35 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文章信息表';

-- ----------------------------
--  Records of `article`
-- ----------------------------
BEGIN;
INSERT INTO `article` VALUES ('1', '485a1e15f7a59b76293ef8c6eaa00d39', '32b73283ef0de43d36c13a594fea7e92', '求租', '<p>xaSdsads</p>', '0', '2019-04-14 17:58:50', '2019-04-14 20:46:02'), ('2', '485a1e15f7a59b76293ef8c6eaa00d39', '32b73283ef0de43d36c13a594fea7e92', '求租2', null, '0', '2019-04-14 17:59:47', '2019-04-14 17:59:47'), ('3', '485a1e15f7a59b76293ef8c6eaa00d39', '3dcea3cd0441eed744ede117ac508e69', '游艇服务', null, '0', '2019-04-14 18:00:08', '2019-04-14 18:00:08'), ('d2ba39e122e8f90a737183d8d02911d3', '485a1e15f7a59b76293ef8c6eaa00d39', '8c08ec451dfa93b90418b709363660e5', '哈哈', '<p>的成长性陈</p>', '0', '2019-04-14 21:11:44', '2019-04-14 21:11:44');
COMMIT;

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(32) NOT NULL COMMENT '菜单id',
  `pid` varchar(32) DEFAULT NULL COMMENT '父菜单id',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `enable_status` int(65) DEFAULT '1' COMMENT '菜单状态 :  1:启用   0:不启用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单信息表';

-- ----------------------------
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('2110a17ebae56262a4359ddd9c70f39e', '', '租游艇', '', null, null, '', '1', '2019-04-14 15:22:24', '2019-04-14 15:22:24'), ('32b73283ef0de43d36c13a594fea7e92', '2110a17ebae56262a4359ddd9c70f39e', '求租', '', null, null, '', '1', '2019-04-14 15:23:56', '2019-04-14 15:23:56'), ('3dcea3cd0441eed744ede117ac508e69', 'fd51533899ded9218be0db7a4cde2244', '游艇服务', '', null, null, '', '1', '2019-04-14 15:25:32', '2019-04-14 15:25:32'), ('4285cad74c44ceda7c420dbc9b24b45e', 'fd51533899ded9218be0db7a4cde2244', '驾照培训', '', null, null, '', '1', '2019-04-14 15:25:03', '2019-04-14 15:25:03'), ('5231959968b645af09e6ee60b5042db1', 'fd51533899ded9218be0db7a4cde2244', '政策法规', '', null, null, '', '1', '2019-04-14 15:24:41', '2019-04-14 15:24:41'), ('6587593020423d936fe29731c2cbb9e0', '', '游艇展', '', null, null, '', '1', '2019-04-14 15:22:09', '2019-04-14 15:22:09'), ('7d07a1c36deffabc0bb0e98eb2e23241', '', '新技术', '', null, null, '', '1', '2019-04-14 15:22:59', '2019-04-14 15:22:59'), ('8936384536c7a43559b4e0d06fb745f4', '', '新闻资讯', '', null, null, '', '1', '2019-04-14 15:25:48', '2019-04-14 15:25:48'), ('8be947aed64225d4523c72e658ebeecb', '', '游艇配套', '', null, null, '', '1', '2019-04-14 15:22:51', '2019-04-14 15:22:51'), ('8c08ec451dfa93b90418b709363660e5', '2110a17ebae56262a4359ddd9c70f39e', '游艇入驻', '', null, null, '', '1', '2019-04-14 15:24:10', '2019-04-14 15:24:10'), ('931e73fc754cc59c6e13d751d16cd5bd', 'fd51533899ded9218be0db7a4cde2244', '游艇知识', '', null, null, '', '1', '2019-04-14 15:24:53', '2019-04-14 15:24:53'), ('998fc76c1e09f6a0238bf81a3ad604ea', '2110a17ebae56262a4359ddd9c70f39e', '游艇出租', '', null, null, '', '1', '2019-04-14 15:23:40', '2019-04-14 15:23:40'), ('bb88e275a69963ce7100d0a9346872de', '2110a17ebae56262a4359ddd9c70f39e', '游艇服务', '', null, null, '', '1', '2019-04-14 15:24:20', '2019-04-14 15:24:20'), ('d0dc2943cc9120ef959cb2fee71a8906', 'fd51533899ded9218be0db7a4cde2244', '配套用品', '', null, null, '', '1', '2019-04-14 15:25:21', '2019-04-14 15:25:21'), ('e567d61d3c63d4f630f90b61f13bcb6e', '', '新闻资讯', '', null, null, '', '1', '2019-04-14 15:23:06', '2019-04-14 15:23:06'), ('f4c6198c17423e7928591b877d77f8f7', '', '联系我们', '', null, null, '', '1', '2019-04-14 15:23:15', '2019-04-14 15:23:15'), ('f5ee7185e4f5e793c68e2bfd56d32d61', 'fd51533899ded9218be0db7a4cde2244', '航海知识', '', null, null, '', '1', '2019-04-14 15:25:10', '2019-04-14 15:25:10'), ('fd51533899ded9218be0db7a4cde2244', '', '玩游艇', '', null, null, '', '1', '2019-04-14 15:22:41', '2019-04-14 15:22:41');
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
INSERT INTO `user` VALUES ('485a1e15f7a59b76293ef8c6eaa00d39', 'zhangsan', '111', '张三', '1', '2', '2019-04-14 14:26:57', '2019-04-14 14:27:27');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
