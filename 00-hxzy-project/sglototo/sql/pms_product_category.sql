/*
 Navicat Premium Data Transfer

 Source Server         : localhsot
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 12/01/2022 09:57:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(1) NULL DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `product_count` int(11) NULL DEFAULT NULL,
  `product_unit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nav_status` int(1) NULL DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
INSERT INTO `pms_product_category` VALUES (1, 0, '服装', 0, 100, '件', 1, 1, 1, NULL, '服装', '服装分类');
INSERT INTO `pms_product_category` VALUES (2, 0, '手机数码', 0, 100, '件', 1, 1, 1, NULL, '手机数码', '手机数码');
INSERT INTO `pms_product_category` VALUES (3, 0, '家用电器', 0, 100, '件', 1, 1, 1, NULL, '家用电器', '家用电器');
INSERT INTO `pms_product_category` VALUES (4, 0, '家具家装', 0, 100, '件', 1, 1, 1, NULL, '家具家装', '家具家装');
INSERT INTO `pms_product_category` VALUES (5, 0, '汽车用品', 0, 100, '件', 1, 1, 1, NULL, '汽车用品', '汽车用品');
INSERT INTO `pms_product_category` VALUES (7, 1, '外套', 1, 100, '件', 1, 1, 0, '', '外套', '外套');
INSERT INTO `pms_product_category` VALUES (8, 1, 'T恤', 1, 100, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'T恤', 'T恤');
INSERT INTO `pms_product_category` VALUES (9, 1, '休闲裤', 1, 100, '件', 1, 1, 0, NULL, '休闲裤', '休闲裤');
INSERT INTO `pms_product_category` VALUES (10, 1, '牛仔裤', 1, 100, '件', 1, 1, 0, NULL, '牛仔裤', '牛仔裤');
INSERT INTO `pms_product_category` VALUES (11, 1, '衬衫', 1, 100, '件', 1, 1, 0, NULL, '衬衫', '衬衫分类');
INSERT INTO `pms_product_category` VALUES (13, 12, '家电子分类1', 1, 1, 'string', 0, 1, 0, 'string', 'string', 'string');
INSERT INTO `pms_product_category` VALUES (14, 12, '家电子分类2', 1, 1, 'string', 0, 1, 0, 'string', 'string', 'string');
INSERT INTO `pms_product_category` VALUES (19, 2, '手机通讯', 1, 0, '件', 0, 0, 0, '', '手机通讯', '手机通讯');
INSERT INTO `pms_product_category` VALUES (29, 1, '男鞋', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (30, 2, '手机配件', 1, 0, '', 0, 0, 0, '', '手机配件', '手机配件');
INSERT INTO `pms_product_category` VALUES (31, 2, '摄影摄像', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (32, 2, '影音娱乐', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (33, 2, '数码配件', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (34, 2, '智能设备', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (35, 3, '电视', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (36, 3, '空调', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (37, 3, '洗衣机', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (38, 3, '冰箱', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (39, 3, '厨卫大电', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (40, 3, '厨房小电', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (41, 3, '生活电器', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (42, 3, '个护健康', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (43, 4, '厨房卫浴', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (44, 4, '灯饰照明', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (45, 4, '五金工具', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (46, 4, '卧室家具', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (47, 4, '客厅家具', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (48, 5, '全新整车', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (49, 5, '车载电器', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (50, 5, '维修保养', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (51, 5, '汽车装饰', 1, 0, '', 0, 0, 0, '', '', '');

SET FOREIGN_KEY_CHECKS = 1;
