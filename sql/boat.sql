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

 Date: 05/22/2019 15:43:56 PM
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
  `yacht_id` varchar(32) NOT NULL COMMENT '记录游艇id，修改库存',
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
--  Records of `article`
-- ----------------------------
BEGIN;
INSERT INTO `article` VALUES ('857d8c545b531e11e82fe37795f50259', 'dcce7b55d3c5a0de62503a888d833f95', '54e014ff3fb1e1e1bcb38c9c009f1cba', '测试', '<div id=\"navCategory\"><ul><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label0\">&nbsp; &nbsp; 一、Vue.js简要说明</a></li><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label1\">&nbsp; &nbsp; 二、Vue.js优雅的实现任务列表的操作预览</a></li><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label2\">&nbsp; &nbsp; 三、HTML骨架CSS样式代码</a></li><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label3\">&nbsp; &nbsp; 四、实例化Vue及应用Vue指令Directives添加项目中</a></li></ul></div><div><a name=\"_label0\"></a></div><h4><strong>&nbsp; &nbsp; 一、Vue.js简要说明</strong></h4><p>Vue.js (读音 /vjuː/) 是一套构建用户界面的渐进式框架。与前端框架Angular一样， Vue.js在设计上采用MVVM模式，当View视图层发生变化时，会自动更新到ViewModel.反之亦然，View与ViewModel之间通过数据双向绑定(&gt;<img src=\"https://images2017.cnblogs.com/blog/819169/201711/819169-20171112193914544-2117333055.png\" alt=\"\" width=\"400\"></p><p>Vue.js通过MVVM模式将视图与数据分成两部分(或者说视图代码与业务逻辑的解耦)，因此我们只需关心数据的操作，DOM的视图的更新等一系列事情，Vue会帮我们自动搞定。</p><p><br></p>', '1', '2019-05-16 15:04:14', '2019-05-16 15:04:14');
COMMIT;

-- ----------------------------
--  Table structure for `classification`
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification` (
  `id` varchar(32) NOT NULL,
  `classification` varchar(255) NOT NULL COMMENT '游艇类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='游艇类别表';

-- ----------------------------
--  Records of `classification`
-- ----------------------------
BEGIN;
INSERT INTO `classification` VALUES ('08f90a13fc27aada9b678cde84a4c058', '舒适性游艇'), ('2494f7722cd7471e6716872b9ea69dfb', '活动会议艇'), ('300ae21de8b6c6e55448b608d352fd46', '双体船'), ('58c651d5caa88b592bd82afebd8e6e81', '游船'), ('5bd17a13f72f81dde9ed501e3b930337', '舒适性游艇'), ('65dab9cf9f0a61a6d9671f7cec6f3e1b', '经济型游艇'), ('7bd516cdd705e9a87b15726bb0489a65', '钓鱼艇'), ('86c8c83594d388e6625fc9d3fe668bf4', '运动快艇'), ('9449f47e1ec214f32dc3ff678f552b20', '双体船'), ('a122a0b8e290598d926a0f42570a8512', '奢华型游艇'), ('a3219058222c9577a26b0cb0cec17b55', '豪华型游艇'), ('a6c74bcad6583920d5d2e6736d1afe36', '经济型游艇'), ('b1e49fb72a6ed85834382391813fb7e5', '单体帆船'), ('b21fa4ce35e0ffb1a2904d44b3ed459f', '活动会议艇'), ('b85507621adced0cc2bbaa1bcb0d0714', '奢华型游艇'), ('c34645964e8c9a70bacbfd453643ba59', '游船'), ('cce6d1ec20d4a820298f8de8818bc0d3', '钓鱼艇'), ('d9e37fe576709e4c4f33cd30318381fd', '豪华型游艇'), ('e91dcd58485172f9312e2f333dd7d93b', '单体帆船'), ('f494ad48fe4d4eb525e14d625f938a42', '运动快艇');
COMMIT;

-- ----------------------------
--  Table structure for `invoice`
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` varchar(32) NOT NULL,
  `invoice_title` varchar(255) NOT NULL COMMENT '发票抬头',
  `invoice_details` varchar(255) NOT NULL DEFAULT '游艇项目咨询费' COMMENT '发票明细',
  `post_address` varchar(255) NOT NULL COMMENT '邮寄地址',
  `postcode` varchar(6) NOT NULL COMMENT '邮政编码',
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
--  Records of `leasing_yacht`
-- ----------------------------
BEGIN;
INSERT INTO `leasing_yacht` VALUES ('a6759d1169147f1c4174bf9267def352', '1', '596f46e64b9d811a43cc6cd5671ecbd7', '1', '1231', '23', '1231', '23', '1'), ('5f42965b32aba35d6257e173b51fabf6', '3', '05195cf29c3fc6297633fa066a48f5b5', '3', '税后', '1ada', 'scz', 'sad', '1');
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

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(32) NOT NULL COMMENT '商品id',
  `product_name` varchar(20) NOT NULL COMMENT '商品名称',
  `type` int(11) NOT NULL COMMENT '商品类别，1：发电机，2：蓄电池，3：传感器',
  `description` varchar(50) DEFAULT NULL COMMENT '商品描述',
  `img_url` varchar(1024) DEFAULT NULL COMMENT '商品图片的路径',
  `owner_id` varchar(32) NOT NULL COMMENT '商品所有者id,关联user.id',
  `enable_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否可用 1：可用，0：不可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `region` varchar(255) DEFAULT NULL COMMENT '产地',
  PRIMARY KEY (`id`),
  KEY `ownner_id` (`owner_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE
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
--  Records of `purpose`
-- ----------------------------
BEGIN;
INSERT INTO `purpose` VALUES ('1acb1efad65eb8e585b96e7e44612452', '亲友活动'), ('2e99fdf5114b52cc3ee2aad4dff84509', '放生礼拜'), ('4cc10965277fb4c3e489ae6402e7b94b', '潜水'), ('56e95b7ef7b53d74f325416384986bbd', '专业海钓'), ('8d0de8e0eedc5adf8ff1e104ef4b09e5', '同学聚会'), ('8f6bcfa2d30f6cc50fbd4388a6577fa5', '玩艇尝试'), ('9e2844edfe1e1afb5c785a99fa9072ef', '休闲海钓'), ('a883a163f7b4994c896538a3b61da45f', '主题Party'), ('aaf32805ef56dfa22815aa8e1c031a0c', '商务接待'), ('d8793c3f25d464db5c24ccd6b0f94f34', '其它'), ('e5189c774c24d254778d7f88100fc8ba', '摄影'), ('fc8ad8931aeb6d979f0a503c1b7d9b19', '家庭体验');
COMMIT;

-- ----------------------------
--  Table structure for `route`
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `id` varchar(32) NOT NULL,
  `route_desc` varchar(255) NOT NULL COMMENT '航线说明',
  `price` decimal(10,0) NOT NULL COMMENT '价格',
  `yacht_id` varchar(32) NOT NULL DEFAULT '' COMMENT '所属游艇id',
  PRIMARY KEY (`id`),
  KEY `yacht_id` (`yacht_id`),
  KEY `yacht_id_2` (`yacht_id`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`yacht_id`) REFERENCES `leasing_yacht` (`yacht_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='航线表';

-- ----------------------------
--  Records of `route`
-- ----------------------------
BEGIN;
INSERT INTO `route` VALUES ('5958d9e890e3e2397cf163c3a753c7eb', '123123', '0', 'a6759d1169147f1c4174bf9267def352'), ('d28bd3795fac4b96c6f06fd4e6a5898d', '三亚-泰姬陵', '11200', '5f42965b32aba35d6257e173b51fabf6');
COMMIT;

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
--  Records of `stock`
-- ----------------------------
BEGIN;
INSERT INTO `stock` VALUES ('a6759d1169147f1c4174bf9267def352', '6'), ('5f42965b32aba35d6257e173b51fabf6', '1');
COMMIT;

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
INSERT INTO `user` VALUES ('53f7f03086981fb61a1d8fa5683fda70', 'zhangsan', '111', '张三', '1', '1', '2019-04-28 00:46:02', '2019-05-19 17:39:48'), ('dcce7b55d3c5a0de62503a888d833f95', 'admin', '123456', '田七', '1', '3', '2019-05-01 04:02:48', '2019-05-16 13:38:35'), ('dd30b6c4a0ec052a43cb2ac1db5babf3', 'xx', '111', 'xx', '2', '2', '2019-05-05 16:46:11', '2019-05-05 16:46:11'), ('ea8513a7c8fa4d0bf6b49429c2005345', 'lisi', '111', '李四', '1', '1', '2019-05-02 00:22:26', '2019-05-02 00:22:26');
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
--  Records of `wharf`
-- ----------------------------
BEGIN;
INSERT INTO `wharf` VALUES ('05195cf29c3fc6297633fa066a48f5b5', '三亚港星华码头'), ('0fabbf96e13ac0143956f314c8b7fc59', '三亚港务局游艇码头'), ('18276148709d83d96b00d295f26b4015', '三亚凤凰岛码头'), ('30c95fd0e45c67c451cc7ca8e468936d', '水上飞机码头'), ('53a9993c93b247765159573049e69398', '三亚鸿洲码头'), ('596f46e64b9d811a43cc6cd5671ecbd7', '亚龙湾游艇会'), ('9c64fc005d8a97272cfd1769e919adda', '鹿回头码头'), ('a486df6c917b3dcb21ffeaadf4c9ff33', '三亚港林荫河畔'), ('b63b8c14af3fd4531df056fa6329c174', '清水湾游艇码头'), ('cad333588aaf2e4a635c5b342538fc32', '半山半岛帆船港');
COMMIT;

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
  `classification_id` varchar(32) NOT NULL COMMENT '游艇类型，外键',
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`),
  KEY `classification` (`classification_id`),
  KEY `classification_2` (`classification_id`),
  CONSTRAINT `yacht_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE,
  CONSTRAINT `yacht_ibfk_2` FOREIGN KEY (`classification_id`) REFERENCES `classification` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游艇信息';

-- ----------------------------
--  Records of `yacht`
-- ----------------------------
BEGIN;
INSERT INTO `yacht` VALUES ('5f42965b32aba35d6257e173b51fabf6', 'Sky 001', 'upload/2015420172766542.jpg', '26', null, '法国', '2019', '66', '<p>豪华</p>', 'ea8513a7c8fa4d0bf6b49429c2005345', '1', '2019-05-20 00:06:29', '2019-05-20 00:07:42', '300ae21de8b6c6e55448b608d352fd46'), ('a6759d1169147f1c4174bf9267def352', 'Hanse 316', 'upload/2018917127073778.jpg', '8.12', null, '美国', '2018', '12.23', '<p>很好</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:21', '2019-05-18 02:02:21', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('a6759d1169147f1c4174bf9267def353', 'Hanse 316', 'upload/2018917127073778.jpg', '8.12', null, '美国', '2018', '12.23', '<p>很好</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:21', '2019-05-18 02:02:21', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('c58bcf7738c54280ab57e1ca0592ea11', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:00', '2019-05-18 02:06:00', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea12', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '英国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:14', '2019-05-18 16:47:49', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea13', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:14', '2019-05-18 02:06:14', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea14', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '法国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:00', '2019-05-18 16:47:52', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea15', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:00', '2019-05-18 02:06:00', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea1f', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '中国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:04:09', '2019-05-18 16:47:58', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea20', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '中国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:04:09', '2019-05-18 16:48:01', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea21', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:04:09', '2019-05-18 02:04:09', '7bd516cdd705e9a87b15726bb0489a65'), ('d3764c9d1582b50b7e85e064340afbf3', 'Hanse 315', 'upload/2017824125423519.jpg', '8.12', null, '美国', '2018', '23.74', '<p>奢华型，hanse315</p><p><span style=\"color: rgb(194, 79, 74);\">bang bang bang</span></p><p><img src=\"http://localhost:8082/manage/upload/2017824125423519.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(194, 79, 74);\"><br></span></p><p style=\"text-align: right;\">联系1888888888</p>', 'dcce7b55d3c5a0de62503a888d833f95', '2', '2019-05-16 13:42:21', '2019-05-19 17:18:01', 'a122a0b8e290598d926a0f42570a8512'), ('d3764c9d1582b50b7e85e064340afbf4', 'Hanse 315', 'upload/2017824125423519.jpg', '8.12', null, '法国', '2018', '23.74', '<p>奢华型，hanse315</p><p><span style=\"color: rgb(194, 79, 74);\">bang bang bang</span></p><p><img src=\"http://localhost:8082/manage/upload/2017824125423519.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(194, 79, 74);\"><br></span></p><p style=\"text-align: right;\">联系1888888888</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-16 13:42:21', '2019-05-18 16:48:05', 'a122a0b8e290598d926a0f42570a8512'), ('d3764c9d1582b50b7e85e064340afbfd', 'Hanse 315', 'upload/2017824125423519.jpg', '8.12', null, '美国', '2018', '23.74', '<p>奢华型，hanse315</p><p><span style=\"color: rgb(194, 79, 74);\">bang bang bang</span></p><p><img src=\"http://localhost:8082/manage/upload/2017824125423519.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(194, 79, 74);\"><br></span></p><p style=\"text-align: right;\">联系1888888888</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-16 13:42:21', '2019-05-16 13:42:21', 'a122a0b8e290598d926a0f42570a8512'), ('e4922209fbbdbf24db52459ac1b792b2', 'Hanse 315', 'upload/2017824133297253.jpg', '23', null, '美国', '2015', '12.33', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:52', '2019-05-18 02:02:52', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('e4922209fbbdbf24db52459ac1b792b3', 'Hanse 315', 'upload/2017824133297253.jpg', '23', null, '美国', '2015', '12.33', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:52', '2019-05-18 02:02:52', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('e4922209fbbdbf24db52459ac1b792b4', 'Hanse 315', 'upload/2017824133297253.jpg', '23', null, '日本', '2015', '12.33', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:52', '2019-05-18 16:48:09', '65dab9cf9f0a61a6d9671f7cec6f3e1b');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
