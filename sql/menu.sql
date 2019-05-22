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

 Date: 05/22/2019 15:43:26 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
INSERT INTO `menu` VALUES ('19c14db97cf0a96f82d693eea7562e83', 'db6701caae23f61669f7b2c96ce92358', '游艇出租', '/rentout', '0', '', '1', '2019-05-21 21:45:24', '2019-05-21 21:45:24'), ('1ea19b9f2e33446fb46ebf3ff8aac1e3', '', '玩游艇', '/play', '3', '', '1', '2019-05-04 16:28:13', '2019-05-04 16:28:13'), ('510be10ee91daa4d549336c64e9de25b', '', '新技术', '/newtech', '5', '', '1', '2019-05-04 16:29:27', '2019-05-04 16:30:12'), ('519b2238cd8fe16490546c330d4ed6d7', '1ea19b9f2e33446fb46ebf3ff8aac1e3', '政策法规', '/regulations', '0', '', '1', '2019-05-21 21:48:43', '2019-05-21 21:48:43'), ('54e014ff3fb1e1e1bcb38c9c009f1cba', '', '新闻资讯', '/news', '6', '', '1', '2019-05-04 16:29:46', '2019-05-04 16:30:39'), ('56ba82cd011e2a2a856578a8ef6c5292', 'db6701caae23f61669f7b2c96ce92358', '游艇服务', '/yacht-service', '0', '', '1', '2019-05-21 21:47:45', '2019-05-21 21:47:45'), ('89e70edc7ec16c3fc35b2197f665ade9', '1ea19b9f2e33446fb46ebf3ff8aac1e3', '游艇知识', '/yacht-knowlege', '0', '', '1', '2019-05-21 21:49:24', '2019-05-21 21:54:02'), ('a982bb1a483e3108822ab5c26d65e8d5', 'db6701caae23f61669f7b2c96ce92358', '求租', '/qrent', '0', '', '1', '2019-05-21 21:45:53', '2019-05-21 21:45:53'), ('b868bd55922f236443cf4f54d845dad6', '1ea19b9f2e33446fb46ebf3ff8aac1e3', '驾照培训', '/license', '0', '', '1', '2019-05-21 21:49:54', '2019-05-21 21:49:54'), ('b8cbb569f8f1c16948fd0e028a4a32f8', '', '游艇配套', '/suporting', '4', '', '1', '2019-05-04 16:28:58', '2019-05-04 16:30:25'), ('bf6f4414cda8eb19713fc8c78e128b8b', '', '游艇展', '/yachtshow', '1', '', '1', '2019-05-04 16:26:59', '2019-05-04 16:26:59'), ('db6701caae23f61669f7b2c96ce92358', '', '租游艇', '/rent', '2', '', '1', '2019-05-04 16:27:45', '2019-05-04 16:27:45'), ('df121075d5b7c055c61666a2721f12bb', '1ea19b9f2e33446fb46ebf3ff8aac1e3', '航海知识', '/nautical-knowledge', '0', '', '1', '2019-05-21 21:51:18', '2019-05-21 21:51:18'), ('eb664d934b770bfbf94e6ffea52522e4', 'db6701caae23f61669f7b2c96ce92358', '游艇入驻', '/yacht-entering', '0', '', '1', '2019-05-21 21:47:06', '2019-05-21 21:47:06');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
