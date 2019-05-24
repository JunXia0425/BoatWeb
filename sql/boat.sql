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

 Date: 05/25/2019 01:08:28 AM
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
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
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
INSERT INTO `article` VALUES ('106cbaa12e5fda6bb3062517d72b5f93', 'dcce7b55d3c5a0de62503a888d833f95', 'b868bd55922f236443cf4f54d845dad6', 'A1F游艇操作人员驾驶证培训班', '<p><strong>培训课程：共15天</strong><br></p><p>第1天：上午《游艇基本理论》《游艇简介》 下午《游艇基本理论》《游艇动力装置》<br>第2天：上午《游艇基本理论》《游艇操纵知识》 下午《游艇基本理论》《游艇操纵方法》<br>第3天：上午《帆船基本理论》《帆船基础知识》 下午《帆船基本理论》《帆船动力装置》<br>第4天：上午《帆船基本理论》《帆船驾驶技术》 下午《帆船基本理论》《帆船其他知识》<br>第5天：上午《航海基本理论与法律法规》《航行基本知识》 下午《航海基本理论与法律法规》《基本安全知识》<br>第6天：上午《航海基本理论与法律法规》《航行基本知识》 下午《航海基本理论与法律法规》《法律法规》<br>第7天：上午《航海基本理论与法律法规》《避碰技术》 下午《航海基本理论与法律法规》《避碰技术》<br>第8天：上午《理论应用》 下午《理论应用》<br>第9-14天：实操培训<br>第15天：实操应用</p><p><strong>实操游艇介绍：</strong><br><img src=\"https://www.jyacht.com/up15/image/201806/20180610102512871287.jpg\" alt=\"三亚翟墨海洋意识文化发展有限公司\"><br>&nbsp;JP70尺豪华游艇 、进口Bavaria帆船</p><p><strong>食宿介绍：</strong><br>可选：明申高尔夫酒店双人标准间 &nbsp;330元/间（含双早）<br>鹿回头安置区联排别墅独卫套间 &nbsp;100元/间</p>', '1', '2019-05-22 21:58:24', '2019-05-22 21:58:24'), ('316489e149d9a2dd48f714bfb0e0122a', 'dcce7b55d3c5a0de62503a888d833f95', '89e70edc7ec16c3fc35b2197f665ade9', '船舶抛绳设备的安全使用与保管', '<p>船用抛绳设备主要有枪式抛绳设备和筒式抛绳设备，用于遇难船、救生艇、筏与救助船舶或船岸之间远距离快速带缆以便开展救助。</p><p>&nbsp;&nbsp;&nbsp;&nbsp; 抛绳设备是利用火箭的发射带出抛绳至目标船或岸上，在使用设备时应注意安全，持枪者应站在抛射盒的后方，枪口瞄准目标，水平仰角一般为30°左右，手指扣动扳机，触发抛射药筒，即可引发火箭。抛绳发射完毕以后，利用抛绳在船舶之间或者船与岸之间传递和架设缆绳，运送人员或救出物资。为了得到尽可能远的抛射距离，发射船应位于上风。其他无关人员应在安全的距离外，以免因发射不准发生误伤他人。</p><p>&nbsp;&nbsp;&nbsp;&nbsp; 每艘船舶应配备至少4套抛绳设备，4盒抛绳（每盒绳长400m长）应备有使用说明书及图解。抛绳设备平时存放于驾驶室或海图室内，存放位置应有明显标志。</p>', '1', '2019-05-22 21:57:22', '2019-05-22 21:57:22'), ('39c61bc46297fa2a88fbf89c090d136d', 'dcce7b55d3c5a0de62503a888d833f95', '519b2238cd8fe16490546c330d4ed6d7', '中华人民共和国高速客船安全管理规则', '<div align=\"center\">中华人民共和国高速客船安全管理规则<br></div><p>&nbsp;&nbsp;&nbsp; （交通部 • 2006年2月13日经第3次部务会议通过 • 交通部令2006年第4号 • 2006年2月24日发布 • 2006年6月1日起施行）</p><p>&nbsp;&nbsp;&nbsp;&nbsp;<strong>第一章　总　　则</strong></p><p>&nbsp;&nbsp;&nbsp; 第一条　为加强对高速客船的安全监督管理，维护水上交通秩序，保障人命财产安全，依据《中华人民共和国海上交通安全法》、《中华人民共和国内河交通安全管理条例》等有关法律和行政法规，制定本规则。</p><p>&nbsp;&nbsp;&nbsp; 第二条　本规则适用于在中华人民共和国通航水域航行、停泊和从事相关活动的高速客船及船舶所有人、经营人和相关人员。</p><p>&nbsp;&nbsp;&nbsp; 第三条　中华人民共和国海事局是实施本规则的主管机关。</p><p>&nbsp;&nbsp;&nbsp; 各海事管理机构负责在本辖区内实施本规则。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;<strong>第二章　船公司</strong></p><p>&nbsp;&nbsp;&nbsp; 第四条　经营高速客船的船公司应满足《国内船舶运输经营资质管理规定》的要求，取得相应的经营资质。</p><p>&nbsp;&nbsp;&nbsp; 第五条　船公司从境外购置或光租的二手外国籍高速客船应满足《老旧运输船舶管理规定》的要求。</p><p>&nbsp;&nbsp;&nbsp; 第六条　船公司在高速客船开始营运前，应以手册形式编制下列资料和指南：</p><p>&nbsp;&nbsp;&nbsp; （一）航线运行手册；</p><p>&nbsp;&nbsp;&nbsp; （二）船舶操作手册；</p><p>&nbsp;&nbsp;&nbsp; （三）船舶维修及保养手册；</p><p>&nbsp;&nbsp;&nbsp; （四）培训手册。</p><p>&nbsp;&nbsp;&nbsp; 上述各项手册所应包含的内容由主管机关确定。</p><p>&nbsp;&nbsp;&nbsp; 第七条　经营高速客船的船公司应当建立适合高速客船营运特点的安全管理制度，包括为防止船员疲劳的船员休息制度。</p><p><strong>&nbsp;&nbsp;&nbsp; 第三章　船　　舶</strong></p><p>&nbsp;&nbsp;&nbsp; 第八条　高速客船须经船舶检验合格，并办理船舶登记手续，持有有效的船舶证书。</p><p>&nbsp;&nbsp;&nbsp; 第九条　高速客船投入营运前，应向主要营运地的海事管理机构申请办理《高速客船操作安全证书》。</p><p>&nbsp;&nbsp;&nbsp; 申请办理《高速客船操作安全证书》，应提交下列资料：</p><p>&nbsp;&nbsp;&nbsp; （一）船舶检验证书；</p><p>&nbsp;&nbsp;&nbsp; （二）船舶所有权证书和船舶国籍证书；</p><p>&nbsp;&nbsp;&nbsp; （三）船员适任证书和特殊培训合格证；</p><p>&nbsp;&nbsp;&nbsp; （四）航线运行手册；</p><p>&nbsp;&nbsp;&nbsp; （五）船舶操作手册；</p><p>&nbsp;&nbsp;&nbsp; （六）船舶维修及保养手册；</p><p>&nbsp;&nbsp;&nbsp; （七）培训手册；</p><p>&nbsp;&nbsp;&nbsp; （八）法律、法规规定的其它资料。</p><p>&nbsp;&nbsp;&nbsp; 海事管理机构对经审核符合要求的，予以签发《高速客船操作安全证书》。高速客船取得该证书后方可投入营运。</p><p>&nbsp;&nbsp;&nbsp; 高速客船应随船携带最新的适合于本船的航线运行手册、船舶操作手册、船舶维修及保养手册和培训手册。</p><p>&nbsp;&nbsp;&nbsp; 第十条　高速客船必须按规定要求配备号灯、号型、声响信号、无线电通信设备、消防设备、救生设备和应急设备等。高速客船上所有的设备和设施均应处于完好备用状态。</p><p>&nbsp;&nbsp;<strong>&nbsp; 第四章　船　　员</strong></p><p>&nbsp;&nbsp;&nbsp; 第十一条　在高速客船任职的船员应符合下列要求：</p><p>&nbsp;&nbsp;&nbsp; （一）经主管机关认可的基本安全培训并取得培训合格证，其中船长、驾驶员、轮机长、轮机员以及被指定为负有安全操作和旅客安全职责的普通船员还必须通过主管机关认可的特殊培训并取得特殊培训合格证。</p><p>&nbsp;&nbsp;&nbsp; （二）船长、驾驶员、轮机长、轮机员按规定持有相应的职务适任证书。</p><p>&nbsp;&nbsp;&nbsp; （三）取得高速客船船员职务适任证书者，在正式任职前见习航行时间不少于10小时和20个单航次。</p><p>&nbsp;&nbsp;&nbsp; （四）男性船长、驾驶员的年龄不超过60周岁，女性船长、驾驶员的年龄不超过55周岁。</p><p>&nbsp;&nbsp;&nbsp; 在非高速客船上任职的船员申请高速客船船长、大副、轮机长职务适任证书时的年龄不超过45周岁。</p><p>&nbsp;&nbsp;&nbsp; （五）船长、驾驶员的健康状况，尤其是视力、听力和口语表达能力应符合相应的要求。</p><p>&nbsp;&nbsp;&nbsp; 第十二条　主管机关授权的海事管理机构负责高速客船船员的培训管理和考试、发证工作。有关培训、考试、发证的规定由主管机关颁布实施。</p><p>&nbsp;&nbsp;&nbsp; 第十三条　高速客船应向办理船舶登记手续的海事管理机构申领最低安全配员证书。高速客船的最低配员标准应满足本规则附录的要求。</p><p>&nbsp;&nbsp;&nbsp; 第十四条　高速客船驾驶人员连续驾驶值班时间不得超过两个小时，两次驾驶值班之间应有足够的间隔休息时间，具体由当地海事管理机构确定。</p><p><strong>&nbsp;&nbsp;&nbsp; 第五章　航行安全</strong></p><p>&nbsp;&nbsp;&nbsp; 第十五条　高速客船航行时应使用安全航速，以防止发生碰撞和浪损。高速客船进出港口及航经特殊航段时，应遵守当地海事管理机构有关航速的规定。</p><p>&nbsp;&nbsp;&nbsp; 高速客船在航时，须显示黄色闪光灯。</p><p>&nbsp;&nbsp;&nbsp; 第十六条　高速客船在航时，值班船员必须在各自岗位上严格按职责要求做好安全航行工作。驾驶台负责瞭望的人员必须保持正规的瞭望。无关人员禁止进入驾驶台。</p><p>&nbsp;&nbsp;&nbsp; 第十七条　高速客船在港口及内河通航水域航行时，应主动让清所有非高速船舶。高速客船在海上航行及高速客船与其它高速船舶之间避让时，应按避碰规则的规定采取措施。高速客船在特殊航段航行时，应遵守海事管理机构公布的特别航行规定。</p><p>&nbsp;&nbsp;&nbsp; 第十八条　海事管理机构认为必要时可为高速客船推荐或指定航路。高速客船必须遵守海事管理机构有关航路的规定。</p><p>&nbsp;&nbsp;&nbsp; 第十九条　遇有恶劣天气或能见度不良时，海事管理机构可建议高速客船停航。</p><p>&nbsp;&nbsp;&nbsp; 第二十条　高速客船应按规定的乘客定额载客，禁止超载。高速客船禁止在未经批准的站、点上下旅客。</p><p>&nbsp;<strong>&nbsp;&nbsp; 第六章　安全保障</strong></p><p>&nbsp;&nbsp;&nbsp; 第二十一条　高速客船应在专用的码头上下旅客，如需使用非专用码头时，应经海事管理机构审核同意。</p><p>&nbsp;&nbsp;&nbsp; 第二十二条　高速客船应靠泊符合下列条件的码头：</p><p>&nbsp;&nbsp;&nbsp; （一）满足船舶安全靠泊的基本要求；</p><p>&nbsp;&nbsp;&nbsp; （二）高速客船靠泊时不易对他船造成浪损；</p><p>&nbsp;&nbsp;&nbsp; （三）避开港口通航密集区和狭窄航段；</p><p>&nbsp;&nbsp;&nbsp; （四）上下旅客设施符合安全条件；</p><p>&nbsp;&nbsp;&nbsp; （五）夜间有足够的照明；</p><p>&nbsp;&nbsp;&nbsp; （六）冬季有采取防冻防滑的安全保护措施。</p><p>&nbsp;&nbsp; &nbsp; 第二十三条　高速客船对旅客携带物品应有尺度和数量限制，旅客的行李物品不得堵塞通道。严禁高速客船载运或旅客携带危险物品。</p><p>&nbsp;&nbsp;&nbsp; 第二十四条　高速客船应每周进行一次应急消防演习和应急撤离演习，并做好演习记录；每次开航前，应向旅客讲解有关安全须知。</p><p>&nbsp;&nbsp;&nbsp; 第二十五条　高速客船应建立开航前安全自查制度，制定开航前安全自查表并进行对照检查，海事管理机构可对开航前安全自查表进行监督抽查。</p><p>&nbsp;&nbsp;&nbsp; 第二十六条　高速客船应按规定办理进出港口手续，并缴纳规费。国内航行的高速客船每天至少应办理一次船舶签证手续，国际航行的高速客船可申请不超过7天的定期进出口岸许可证。</p><p>&nbsp;&nbsp;&nbsp; 高速客船不得夜航。但航行特殊水域的高速客船确需夜航的，应当向当地海事管理机构申请船舶进出港口许可，经批准后方可夜航。</p><p>&nbsp;&nbsp;&nbsp; 第二十七条　高速客船发生交通事故、遇险或人员落水，应采取措施积极自救，并立即向就近海事管理机构报告。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;<strong>第七章　法律责任</strong></p><p>&nbsp;&nbsp;&nbsp; 第二十八条　违反本规定的，由海事管理机构依照有关法律、行政法规以及交通部的有关规定进行处罚。</p><p>&nbsp;&nbsp;&nbsp; 第二十九条　高速客船违反本规则经海事管理机构处罚仍不改正的，海事管理机构可责令其停航。</p><p>&nbsp;&nbsp;&nbsp; 第三十条　海事管理机构工作人员违反规定，滥用职权，玩忽职守，给人民生命财产造成损失的，由所在单位或上级主管机关给予行政处分；构成犯罪的，依法追究其刑事责任。<strong><br></strong></p><p><strong>&nbsp;&nbsp;&nbsp; 第八章　附　　则</strong></p><p>&nbsp;&nbsp;&nbsp; 第三十一条　本规则所述“高速客船”系指载客12人以上，最大航速（m/s）等于或大于以下数值的船舶：3.7▽0.1667，式中“▽”系指对应设计水线的排水体积（m³）。但不包括在非排水状态下船体由地效应产生的气动升力完全支承在水面上的船舶。</p><p>&nbsp;&nbsp;&nbsp; 本规则所述“船公司”系指船舶所有人、经营人或者管理人以及其他已从船舶所有人处接受船舶的营运责任并承担船舶安全与防污染管理的所有义务和责任的组织。</p><p>&nbsp;&nbsp;&nbsp; 第三十二条　外国籍高速客船不适用本规则第二、三、四章的规定，但应满足船旗国主管当局的要求。</p><p>&nbsp;&nbsp;&nbsp; 第三十三条　本规则未尽事宜，按国家其他有关法规和我国加入的国际公约执行。</p><p>&nbsp;&nbsp;&nbsp; 第三十四条　本规则由交通部负责解释。</p><p>&nbsp;&nbsp;&nbsp; 第三十五条　本规则自2006年6月1日起施行。交通部1996年12月24日发布的《中华人民共和国高速客船安全管理规则》（交通部令1996年第13号）同时废止。</p>', '1', '2019-05-22 21:56:32', '2019-05-22 21:56:32'), ('857d8c545b531e11e82fe37795f50259', 'dcce7b55d3c5a0de62503a888d833f95', '54e014ff3fb1e1e1bcb38c9c009f1cba', '测试', '<div id=\"navCategory\"><ul><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label0\">&nbsp; &nbsp; 一、Vue.js简要说明</a></li><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label1\">&nbsp; &nbsp; 二、Vue.js优雅的实现任务列表的操作预览</a></li><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label2\">&nbsp; &nbsp; 三、HTML骨架CSS样式代码</a></li><li><em>•</em><a href=\"https://www.cnblogs.com/zjf-1992/p/7841156.html#_label3\">&nbsp; &nbsp; 四、实例化Vue及应用Vue指令Directives添加项目中</a></li></ul></div><div><a name=\"_label0\"></a></div><h4><strong>&nbsp; &nbsp; 一、Vue.js简要说明</strong></h4><p>Vue.js (读音 /vjuː/) 是一套构建用户界面的渐进式框架。与前端框架Angular一样， Vue.js在设计上采用MVVM模式，当View视图层发生变化时，会自动更新到ViewModel.反之亦然，View与ViewModel之间通过数据双向绑定(&gt;<img src=\"https://images2017.cnblogs.com/blog/819169/201711/819169-20171112193914544-2117333055.png\" alt=\"\" width=\"400\"></p><p>Vue.js通过MVVM模式将视图与数据分成两部分(或者说视图代码与业务逻辑的解耦)，因此我们只需关心数据的操作，DOM的视图的更新等一系列事情，Vue会帮我们自动搞定。</p><p><br></p>', '1', '2019-05-16 15:04:14', '2019-05-16 15:04:14'), ('dd5b94ac17868c9cc93001e2be43296d', 'dcce7b55d3c5a0de62503a888d833f95', 'df121075d5b7c055c61666a2721f12bb', '海事核心价值体系', '<p align=\"left\"><strong>一、使命：保障水上交通安全，保护水域环境清洁，保护船员整体权益，维护国家海上主权和人民利益。</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 使命是海事管理机构存在的意义和价值，表明基本的履职目标、任务和责任。</p><p align=\"left\">保障水上交通安全，保护水域环境清洁，保护船员整体权益</p><p align=\"left\">&nbsp;&nbsp;&nbsp; 海事管理机构行使国家赋予的水上交通安全监管职能，集中概括了海事机构的基本职责，即，通过“船舶适航、船员适任、安全畅通、有效监管、优质服务”，实现“航行更安全，水域更清洁，航运更便捷”。</p><p align=\"left\">维护国家海上主权</p><p align=\"left\">&nbsp;&nbsp;&nbsp; 经授权，海事管理机构代表中国政府参与国际海事事务，履行有关国际公约和承担国际义务。根据有关法律规定，海事管理机构对外代表国家行使水上交通安全监督管理职权，依法维护国家主权。</p><p align=\"left\">维护人民利益</p><p align=\"left\">&nbsp;&nbsp;&nbsp; 海事管理机构作为承担国家水上交通安全监管职责的社会管理和公共服务机构，具有服务经济社会发展的最本质属性，必须服从和服务于人民的利益。<br><br><strong>二、宗旨：建设人民满意的海事。</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 宗旨是海事忠贞不渝追求的奋斗目标，体现勇于超越自我、不断追求卓越的时代精神和向国家、人民作出的庄严承诺。</p><p align=\"left\">建设人民满意的海事</p><p align=\"left\">&nbsp;&nbsp;&nbsp; 人民满意是检验海事工作的最高标准，也是海事发展追求的目标。海事系统坚持以人民为中心的发展思想和为人民担当的责任情怀，权为民所用，情为民所系，利为民所谋，牢记宗旨，不辱使命。&nbsp;<br><br><strong>三、核心价值观：航行安全、水域清洁，服务交通、奉献社会。</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 核心价值观是在系统内倡导、职工践行、社会理解的价值追求，是全系统最核心的统一意志和行动标准。</p><p align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;<strong>航行安全、水域清洁</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 体现海事工作人员内心价值追求和基本的责任担当。这与国际海事界共同愿景意思表达相一致，也体现海事参与全球海事公共治理的态度。</p><p align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;<strong>服务交通、奉献社会</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 坚持以水上交通安全监管为中心任务，服务于现代综合交通运输事业和经济社会发展，为交通运输提供安全、清洁和便捷的保障服务。“服务”是政府部门的基本属性，服务船员和船舶，服务行业、经济和社会，服务国家战略是海事履职的基本要求。“奉献”是对海事工作人员的精神状态要求，贯穿于全面履职的过程，体现水上交通安全监管治理体系和治理能力的建设成效，体现海事工作人员以人民为中心、为人民担当的责任情怀。</p><p align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;<strong>四、共同愿景：坚持“三化”统领，坚定“三个追求”，建设国内一流的经济执法系统和国际领先的海事管理机构。</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 共同愿景是海事和全体海事工作人员追求的自我激励和价值实现的目标，是自觉激发内生动力的源泉，是促进人的全面发展和推动事业发展的力量。</p><p align=\"left\"><strong>坚持“三化”统领</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 革命化，要求海事队伍忠诚于党、听从指挥、服务人民、奉献社会，这是海事履职的政治保障；正规化，要求海事队伍素质精良、作风过硬，海事管理法制健全、科学规范，这是海事履职的重要基础；现代化，要求海事装备精良、技术先进、文化领先，这是海事履职的根本要求。三者相辅相成，共同构成一个有机统一的整体。</p><p align=\"left\"><strong>坚定“三个追求”</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 勇于负责，追求社会满意度最高。要求海事工作人员认真履责、不辱使命，全力维护人民群众的根本利益，最大限度地满足经济社会发展对海事工作的需求；干对干好，追求岗位业绩最优。每一个海事工作人员负有维护海事形象的责任，要求做到恪尽职守、无私奉献，以卓越的岗位业绩践行宗旨；创造环境，追求职工归属感最强。要求坚持人的全面发展，创造和谐奋进的工作、学习和生活环境，促使海事工作人员都能在海事事业发展的进程中不断实现自身价值，不断增强事业的认同感和组织的归属感，形成推动事业持续发展的精神动力。</p><p align=\"left\"><strong>建设国内一流的经济执法系统和国际领先的海事管理机构</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp; 这是海事“三化”建设的目标。要求建设听从指挥、素质精良、作风过硬、服务人民的海事队伍；建立职责清晰、管理规范、运转协调、行为统一的海事管理体制机制；建成监管到位、保障有力、反应快捷、服务智能的现代海事治理和服务体系。</p><p align=\"left\"><strong>五、发展理念：全国海事一家人，水上监管一盘棋，行政执法一面旗。</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 发展理念是海事事业发展思路、发展方向和发展着力点的集中体现。深入贯彻“创新、协调、绿色、开放、共享”发展理念是实现全国海事系统科学发展的时代要求。</p><p align=\"left\"><strong>全国海事一家人</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 强调海事队伍的整体性。要求坚决服从和服务于交通运输事业发展大局，做到各单位的发展与全国海事发展总体战略相适应，单位之间实现良性互动、相互协调、优势互补，软硬实力同步提升，全国海事协调发展。</p><p align=\"left\"><strong>水上监管一盘棋</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 强调海事目标任务的统一性。要求坚持统一布局、统一政令、统一监督管理，步调一致、协同配合；坚持统一执法流程、统一服务标准、统一行为规范、统一视觉形象，构建全社会共同参与水上交通安全监管的综合治理格局，提升治理能力和治理体系现代化建设水平；坚持保障水上交通安全形势稳定，维护水路运输绿色低碳发展，让发展成果惠及广大人民群众。</p><p align=\"left\"><strong>行政执法一面旗</strong></p><p align=\"left\">&nbsp;&nbsp;&nbsp; 强调海事行政执法和服务的先进性。要求坚持推进简政放权、放管结合、优化服务，强化规范化管理，提升国际制度性话语权，以人民满意的执法水平、服务质量、工作效率和优良作风，建设国内一流的经济执法系统和国际领先的海事管理机构。</p>', '1', '2019-05-22 21:55:45', '2019-05-22 21:55:45');
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
INSERT INTO `classification` VALUES ('08f90a13fc27aada9b678cde84a4c058', '舒适性游艇'), ('2494f7722cd7471e6716872b9ea69dfb', '活动会议艇'), ('300ae21de8b6c6e55448b608d352fd46', '双体船'), ('58c651d5caa88b592bd82afebd8e6e81', '游船'), ('5bd17a13f72f81dde9ed501e3b930337', '舒适性游艇'), ('65dab9cf9f0a61a6d9671f7cec6f3e1b', '经济型游艇'), ('7bd516cdd705e9a87b15726bb0489a65', '钓鱼艇'), ('86c8c83594d388e6625fc9d3fe668bf4', '运动快艇'), ('9449f47e1ec214f32dc3ff678f552b20', '双体船'), ('a122a0b8e290598d926a0f42570a8512', '奢华型游艇');
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
  `wharf_id` varchar(32) DEFAULT NULL COMMENT '停靠码头（外键）',
  `bedroom` int(2) DEFAULT NULL COMMENT '游艇卧室数量',
  `standard_seaman` varchar(255) DEFAULT NULL COMMENT '标配船员',
  `standard_subject` varchar(255) NOT NULL COMMENT '标配项目',
  `apolegamy_subject` varchar(255) DEFAULT NULL COMMENT '选配项目',
  `insurance_declare` varchar(255) DEFAULT NULL COMMENT '保险说明',
  `belonging` int(2) NOT NULL COMMENT '游艇隶属，如果拥有者不是管理员，隶属为私人，否则为企业；0:企业 1:私人',
  KEY `yacht_id` (`yacht_id`),
  KEY `wharf` (`wharf_id`),
  CONSTRAINT `leasing_yacht_ibfk_1` FOREIGN KEY (`yacht_id`) REFERENCES `yacht` (`id`) ON DELETE CASCADE,
  CONSTRAINT `leasing_yacht_ibfk_2` FOREIGN KEY (`wharf_id`) REFERENCES `wharf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租赁游艇表';

-- ----------------------------
--  Records of `leasing_yacht`
-- ----------------------------
BEGIN;
INSERT INTO `leasing_yacht` VALUES ('5f42965b32aba35d6257e173b51fabf6', '5', '0fabbf96e13ac0143956f314c8b7fc59', '4', '企鹅我打车', '阿萨', '强大的是', '已购', '1'), ('d30ed7c5aad8446107c908922ca0b02a', '2', null, '2', '萨达', '说的是', '请问请问', '请问', '1');
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
  `type_id` varchar(32) NOT NULL COMMENT '商品类别，外键',
  `description` text COMMENT '商品描述',
  `img_url` varchar(1024) DEFAULT NULL COMMENT '商品图片的路径',
  `owner_id` varchar(32) NOT NULL COMMENT '商品所有者id,关联user.id',
  `enable_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否可用 1：可用，0：不可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `region` varchar(255) DEFAULT NULL COMMENT '产地',
  `price` float DEFAULT NULL COMMENT '装备价格',
  PRIMARY KEY (`id`),
  KEY `ownner_id` (`owner_id`),
  KEY `type` (`type_id`),
  KEY `type_2` (`type_id`),
  KEY `type_3` (`type_id`),
  KEY `type_4` (`type_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE,
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `product_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品信息表';

-- ----------------------------
--  Records of `product`
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('42f9924517974157e9606bd8203109da', '蓄电池', '1d1122cf61ba840b4cfb9a56a6595563', '强力发电<p>哈哈哈哈</p><p><img src=\"http://localhost:8082/manage/upload/2017127109645061.jpg\" style=\"max-width:100%;\"><br></p>', 'upload/2015810122612849.jpg', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-24 16:03:04', '2019-05-25 00:56:57', '中国', '200.99'), ('5aa34cd939abff4ea7864a3978593766', '大浪潜水服', '3081246e90f9c1abd1e60184648d9c51', '<p>厚薄均匀，流线型设计</p>', 'upload/4.jpg', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-24 23:29:44', '2019-05-25 00:58:40', '法国', '99.9');
COMMIT;

-- ----------------------------
--  Table structure for `product_type`
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` varchar(32) NOT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '商品类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `product_type`
-- ----------------------------
BEGIN;
INSERT INTO `product_type` VALUES ('1d1122cf61ba840b4cfb9a56a6595563', '蓄电池'), ('3081246e90f9c1abd1e60184648d9c51', '潜水服'), ('3c02bbe2fe379ae31daaca0d965de9ad', '救生圈'), ('5ecfcd5fd7cfaa4a8aaa2fde27c3f8f8', '淡水净化器');
COMMIT;

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
INSERT INTO `route` VALUES ('19b984e30fa8bd738af83975945c332d', '三亚港-三亚角 1动2静 3小时', '1200', '5f42965b32aba35d6257e173b51fabf6'), ('7c973d9182e898fe887a6755899e3337', '啊打死', '0', 'd30ed7c5aad8446107c908922ca0b02a'), ('b04ba7ebb02972b163a836f3fb82c84e', 'boolean routesSave = routeService.saveBatch(routes);', '12312', '5f42965b32aba35d6257e173b51fabf6');
COMMIT;

-- ----------------------------
--  Table structure for `slider_img`
-- ----------------------------
DROP TABLE IF EXISTS `slider_img`;
CREATE TABLE `slider_img` (
  `id` varchar(32) NOT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '轮播图路径',
  `num` int(2) DEFAULT '0' COMMENT '图片次序，默认0',
  `yacht_id` varchar(32) NOT NULL COMMENT '游艇id，外键',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `yacht_id` (`yacht_id`),
  CONSTRAINT `slider_img_ibfk_1` FOREIGN KEY (`yacht_id`) REFERENCES `yacht` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播图片表';

-- ----------------------------
--  Records of `slider_img`
-- ----------------------------
BEGIN;
INSERT INTO `slider_img` VALUES ('068a3d44c551b6a9d994d1b8d175ca12', 'upload/2017127109645061.jpg', '0', 'c58bcf7738c54280ab57e1ca0592ea11'), ('523b7304cd1b11947578c5b0daf40568', 'upload/2019326106480599.jpg', '0', 'a6759d1169147f1c4174bf9267def352'), ('6cf180e3ab19209601b56c11925bce46', 'upload/2018917127073778.jpg', '0', 'c58bcf7738c54280ab57e1ca0592ea11'), ('740d0f2c532c967c9513498ae9364ab0', 'upload/2018918957730346.jpg', '0', 'a6759d1169147f1c4174bf9267def352'), ('7ac84fd03b2d606f0a489512ac00d434', 'upload/2013115159364265.jpg', '0', '5f42965b32aba35d6257e173b51fabf6'), ('7ad4f30179d6665dec4d4a5bdd56818d', 'upload/1.png', '0', '5f42965b32aba35d6257e173b51fabf6'), ('a537e114124772aa060806aec6267778', 'upload/2018918957730346.jpg', '0', 'd30ed7c5aad8446107c908922ca0b02a'), ('ae8a2f4c2978d52e71c7f8e0951c9fb1', 'upload/2017824125423519.jpg', '0', '5f42965b32aba35d6257e173b51fabf6'), ('cd73a86d9f4db37ed9dc0f5e3d3732bd', 'upload/2017824125423519.jpg', '0', 'a6759d1169147f1c4174bf9267def352'), ('ffc7057d90f82b3b27f62579057afc8a', 'upload/2017127109645061.jpg', '0', 'd30ed7c5aad8446107c908922ca0b02a');
COMMIT;

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
INSERT INTO `stock` VALUES ('5f42965b32aba35d6257e173b51fabf6', '6'), ('d30ed7c5aad8446107c908922ca0b02a', '1');
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
INSERT INTO `user` VALUES ('53f7f03086981fb61a1d8fa5683fda70', 'zhangsan', '111', '张三', '1', '1', '2019-04-28 00:46:02', '2019-05-19 17:39:48'), ('dcce7b55d3c5a0de62503a888d833f95', 'admin', '123456', '田七', '1', '3', '2019-05-01 04:02:48', '2019-05-22 17:15:11'), ('dd30b6c4a0ec052a43cb2ac1db5babf3', 'xx', '111', 'xx', '2', '2', '2019-05-05 16:46:11', '2019-05-05 16:46:11'), ('ea8513a7c8fa4d0bf6b49429c2005345', 'lisi', '111', '李四', '1', '1', '2019-05-02 00:22:26', '2019-05-02 00:22:26');
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
INSERT INTO `yacht` VALUES ('3c86c85f0d89ecd3bf5e1695c086b9ad', '123', 'upload/2017824125423519.jpg', '123', null, '123', '2015', '123', '<p>豪华大气</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-24 10:47:37', '2019-05-24 18:10:36', '08f90a13fc27aada9b678cde84a4c058'), ('5f42965b32aba35d6257e173b51fabf6', 'Sky 001', 'upload/2017127109645061.jpg', '26', null, '法国', '2019', '66', '<p>豪华</p>', 'ea8513a7c8fa4d0bf6b49429c2005345', '1', '2019-05-20 00:06:29', '2019-05-24 03:17:31', '08f90a13fc27aada9b678cde84a4c058'), ('a6759d1169147f1c4174bf9267def352', 'Hanse 316', 'upload/2018917127073778.jpg', '8.12', null, '美国', '2018', '12.23', '<p>很好</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:21', '2019-05-18 02:02:21', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('a6759d1169147f1c4174bf9267def353', 'Hanse 316', 'upload/2018917127073778.jpg', '8.12', null, '美国', '2018', '12.23', '<p>很好</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:21', '2019-05-18 02:02:21', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('c58bcf7738c54280ab57e1ca0592ea11', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:00', '2019-05-18 02:06:00', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea12', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '英国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:14', '2019-05-18 16:47:49', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea13', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:14', '2019-05-18 02:06:14', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea15', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:06:00', '2019-05-18 02:06:00', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea20', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '中国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:04:09', '2019-05-18 16:48:01', '7bd516cdd705e9a87b15726bb0489a65'), ('c58bcf7738c54280ab57e1ca0592ea21', 'asdas21', 'upload/2015431743529268.jpg', '23', null, '美国', '2018', '23.74', '<p>哈哈哈哈</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:04:09', '2019-05-18 02:04:09', '7bd516cdd705e9a87b15726bb0489a65'), ('d30ed7c5aad8446107c908922ca0b02a', 'Hanse 700', 'upload/20178241241025587.jpg', '20', null, '日本', '2015', '66', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-24 10:54:14', '2019-05-24 10:54:14', '08f90a13fc27aada9b678cde84a4c058'), ('d3764c9d1582b50b7e85e064340afbf3', 'Hanse 315', 'upload/2017824125423519.jpg', '8.12', null, '美国', '2018', '23.74', '<p>奢华型，hanse315</p><p><span style=\"color: rgb(194, 79, 74);\">bang bang bang</span></p><p><img src=\"http://localhost:8082/manage/upload/2017824125423519.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(194, 79, 74);\"><br></span></p><p style=\"text-align: right;\">联系1888888888</p>', 'dcce7b55d3c5a0de62503a888d833f95', '2', '2019-05-16 13:42:21', '2019-05-19 17:18:01', 'a122a0b8e290598d926a0f42570a8512'), ('d3764c9d1582b50b7e85e064340afbf4', 'Hanse 315', 'upload/2017824125423519.jpg', '8.12', null, '法国', '2018', '23.74', '<p>奢华型，hanse315</p><p><span style=\"color: rgb(194, 79, 74);\">bang bang bang</span></p><p><img src=\"http://localhost:8082/manage/upload/2017824125423519.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(194, 79, 74);\"><br></span></p><p style=\"text-align: right;\">联系1888888888</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-16 13:42:21', '2019-05-18 16:48:05', 'a122a0b8e290598d926a0f42570a8512'), ('d3764c9d1582b50b7e85e064340afbfd', 'Hanse 315', 'upload/2017824125423519.jpg', '8.12', null, '美国', '2018', '23.74', '<p>奢华型，hanse315</p><p><span style=\"color: rgb(194, 79, 74);\">bang bang bang</span></p><p><img src=\"http://localhost:8082/manage/upload/2017824125423519.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(194, 79, 74);\"><br></span></p><p style=\"text-align: right;\">联系1888888888</p>', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-16 13:42:21', '2019-05-16 13:42:21', 'a122a0b8e290598d926a0f42570a8512'), ('e4922209fbbdbf24db52459ac1b792b2', 'Hanse 315', 'upload/2017824133297253.jpg', '23', null, '美国', '2015', '12.33', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:52', '2019-05-18 02:02:52', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('e4922209fbbdbf24db52459ac1b792b3', 'Hanse 315', 'upload/2017824133297253.jpg', '23', null, '美国', '2015', '12.33', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:52', '2019-05-18 02:02:52', '65dab9cf9f0a61a6d9671f7cec6f3e1b'), ('e4922209fbbdbf24db52459ac1b792b4', 'Hanse 315', 'upload/2017824133297253.jpg', '23', null, '日本', '2015', '12.33', '', 'dcce7b55d3c5a0de62503a888d833f95', '1', '2019-05-18 02:02:52', '2019-05-18 16:48:09', '65dab9cf9f0a61a6d9671f7cec6f3e1b');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
