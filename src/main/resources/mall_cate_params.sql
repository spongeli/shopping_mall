/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : tcb

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 22/04/2020 14:19:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_card
-- ----------------------------
DROP TABLE IF EXISTS `mall_card`;
CREATE TABLE `mall_card`  (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `select_style` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '选择的样式',
  `number` int(11) NOT NULL COMMENT '购买数量',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_card
-- ----------------------------
INSERT INTO `mall_card` VALUES (7, 3, 12, '大众 XLL', 3, '2020-04-21 14:57:13');
INSERT INTO `mall_card` VALUES (9, 3, 12, '桑塔纳 XL', 7, '2020-04-21 14:58:14');
INSERT INTO `mall_card` VALUES (11, 3, 15, '绿色', 2, '2020-04-21 15:02:51');
INSERT INTO `mall_card` VALUES (12, 3, 15, '蓝色', 1, '2020-04-21 15:27:21');
INSERT INTO `mall_card` VALUES (19, 3, 16, '蓝色', 1, '2020-04-21 16:23:14');

-- ----------------------------
-- Table structure for mall_cate_params
-- ----------------------------
DROP TABLE IF EXISTS `mall_cate_params`;
CREATE TABLE `mall_cate_params`  (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `attr_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '参数类型<>statics=静态的&dynamic=动态的&service=服务',
  `attr_status` tinyint(255) NULL DEFAULT NULL,
  `attr_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`attr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_cate_params
-- ----------------------------
INSERT INTO `mall_cate_params` VALUES (1, '型号', 'dynamic', 0, '桑塔纳,大众', '2020-04-15 00:00:00');
INSERT INTO `mall_cate_params` VALUES (2, '颜色', 'statics', NULL, '红色,黄色,蓝色', '2020-04-15 00:00:00');
INSERT INTO `mall_cate_params` VALUES (3, '尺寸', 'dynamic', 0, 'X,XL,XLL', '2020-04-15 00:00:00');
INSERT INTO `mall_cate_params` VALUES (4, '产地', 'statics', 0, '酒泉', '2020-04-15 00:00:00');
INSERT INTO `mall_cate_params` VALUES (5, '颜色', 'dynamic', 0, '蓝色,红色,白色,绿色', '2020-04-15 00:00:00');
INSERT INTO `mall_cate_params` VALUES (6, '假一赔十', 'service', 0, '假一赔十', '2020-04-16 09:52:46');
INSERT INTO `mall_cate_params` VALUES (7, '七天包换', 'service', 0, '七天包换,上门服务,1,123,123,124,123,1231,12414', '2020-04-16 17:49:04');

-- ----------------------------
-- Table structure for mall_category
-- ----------------------------
DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_parent_id` int(11) NULL DEFAULT NULL,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `category_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `category_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `category_order` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` tinyint(255) NULL DEFAULT NULL COMMENT '分类发布状态<>0=发布&1=不发布',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_category
-- ----------------------------
INSERT INTO `mall_category` VALUES (1, 0, '汽车租赁', '', '汽车租赁服务', '9', '2020-04-15 09:54:28', 0);
INSERT INTO `mall_category` VALUES (2, 0, '杂货', '', '杂货', '9', '2020-04-15 10:07:33', 0);
INSERT INTO `mall_category` VALUES (3, 2, '衣服', 'http://127.0.0.1:9000/upload/3f47878d-a8e7-41ef-8362-ec23bb6accaf.jpg', '衣服', '9', '2020-04-15 10:08:12', 0);

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `cate_id` int(255) NULL DEFAULT NULL COMMENT '分类ID',
  `cate_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分类名称',
  `goods_hots_label` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '热卖标签',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名字',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `goods_weight` double NULL DEFAULT NULL COMMENT '重量(g)',
  `goods_original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '原价',
  `goods_header_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头图（多个用,隔开）',
  `goods_detail` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述',
  `goods_count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `scan_count` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '浏览量',
  `sales_count` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT ' 销售量',
  `goods_status` tinyint(255) NULL DEFAULT NULL COMMENT '状态 0 上架',
  `dynamic_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '动态参数',
  `service_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '服务参数',
  `statics_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '静态参数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_goods
-- ----------------------------
INSERT INTO `mall_goods` VALUES (12, 3, '衣服', NULL, '衣服', 88.80, 1, 99.80, 'http://127.0.0.1:9000/upload/1b3fec39-27f1-4a80-aaf0-a3d7c1c56d44.jpg', '<p><br></p><p><img src=\"http://127.0.0.1:9000/upload/f4630ba8-c15c-47ce-9a6e-b2acdc7c4297.jpg\"></p>', 99, 00000000034, 00000000000, 0, '[1,3]', '[7]', '[4]', '2020-04-16 16:54:29');
INSERT INTO `mall_goods` VALUES (15, 3, '衣服', NULL, '汉服', 88.90, 200, 99.90, 'http://127.0.0.1:9000/upload/66d06d94-a01e-4d9d-adaa-5b5c9707deec.png', '<p><br></p><p><img src=\"http://127.0.0.1:9000/upload/039f3869-9e67-4898-9af6-53c705cb7d94.png\"></p>', 200, 00000000010, 00000000000, 1, '[5]', '[7]', '[2]', '2020-04-21 15:02:17');
INSERT INTO `mall_goods` VALUES (16, 3, '衣服', NULL, '酒泉', 366.00, 300, 998.00, 'http://127.0.0.1:9000/upload/f3e3c55d-9957-48fd-a9d4-398df48e72db.jpg', '<p><br></p><p><img src=\"http://127.0.0.1:9000/upload/826fac39-6606-4c38-b7c8-00be8543bf88.jpg\"></p>', 50, 00000000036, 00000000000, 0, '[5]', '[7]', '[2]', '2020-04-21 15:57:57');

-- ----------------------------
-- Table structure for mall_index_set_up
-- ----------------------------
DROP TABLE IF EXISTS `mall_index_set_up`;
CREATE TABLE `mall_index_set_up`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` tinyint(255) NULL DEFAULT NULL,
  `activity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `activity_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `goods_id` int(11) NULL DEFAULT NULL,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `back_ground_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `level` int(255) NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `click_status` tinyint(4) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_index_set_up
-- ----------------------------
INSERT INTO `mall_index_set_up` VALUES (1, 'http://127.0.0.1:9000/upload/fc472919-f6f7-45b3-896d-eb95834ef8a9.jpg', 0, NULL, NULL, NULL, NULL, 'red', 9, 0, 0, '2020-04-15 10:29:25');
INSERT INTO `mall_index_set_up` VALUES (2, 'http://127.0.0.1:9000/upload/d184bf1d-524b-4ead-9d35-2e957bbf4daf.jpg', 0, NULL, NULL, NULL, NULL, '#EEF6F8', 9, 0, 0, '2020-04-15 10:29:47');
INSERT INTO `mall_index_set_up` VALUES (3, 'http://127.0.0.1:9000/upload/23b84ee0-d5d3-4b7d-8e49-e7859df13500.jpg', 0, NULL, NULL, NULL, NULL, '#FF7A3F', 7, 0, 0, '2020-04-15 10:30:10');
INSERT INTO `mall_index_set_up` VALUES (5, 'http://127.0.0.1:9000/upload/0b11c192-0416-48eb-be28-ad15ea195a61.jpg', 1, NULL, NULL, NULL, NULL, '', 9, 0, 0, '2020-04-15 10:31:57');
INSERT INTO `mall_index_set_up` VALUES (6, 'http://127.0.0.1:9000/upload/5cb6e779-2395-459c-a744-26255ebe658f.png', 2, '特价秒杀', NULL, NULL, NULL, '', 9, 0, 0, '2020-04-15 10:32:13');
INSERT INTO `mall_index_set_up` VALUES (7, 'http://127.0.0.1:9000/upload/83c71ae5-fe80-4ead-8ba7-73b22c671d4a.jpg', 1, '特价秒杀', NULL, NULL, NULL, '', 8, 0, 0, '2020-04-15 10:32:52');
INSERT INTO `mall_index_set_up` VALUES (8, 'http://127.0.0.1:9000/upload/befc22ad-72f0-4ff0-b0d5-d9b1e5b9be44.png', 2, '特效', NULL, NULL, NULL, '', 8, 0, 0, '2020-04-15 10:33:29');

-- ----------------------------
-- Table structure for mall_menus
-- ----------------------------
DROP TABLE IF EXISTS `mall_menus`;
CREATE TABLE `mall_menus`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL,
  `icon_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_menus
-- ----------------------------
INSERT INTO `mall_menus` VALUES (1, '用户管理', 0, 9, 'user_list', 0, 'icon-yonghuguanli');
INSERT INTO `mall_menus` VALUES (2, '权限管理', 0, 8, '--', 1, 'icon-quanxianguanli\r\n');
INSERT INTO `mall_menus` VALUES (3, '商品管理', 0, 7, 'goods_list', 0, 'icon-iconsp1\r\n');
INSERT INTO `mall_menus` VALUES (4, '订单管理', 0, 6, 'order_list', 0, 'icon-dingdan\r\n');
INSERT INTO `mall_menus` VALUES (5, '数据管理', 0, 5, NULL, 0, 'icon-data');
INSERT INTO `mall_menus` VALUES (6, '用户列表', 1, 9, 'user_list', 0, 'icon-caidan\r\nicon-caidan\r\nicon-caidan');
INSERT INTO `mall_menus` VALUES (7, '商品列表', 3, 9, 'goods_list', 0, 'icon-caidan\r\nicon-caidan\r\nicon-caidan');
INSERT INTO `mall_menus` VALUES (8, '分类参数', 3, 8, 'goods_classes', 0, 'icon-caidan');
INSERT INTO `mall_menus` VALUES (9, '商品参数', 3, 7, 'goods_param', 0, 'icon-caidan');
INSERT INTO `mall_menus` VALUES (10, '订单列表', 4, 9, 'order_list', 0, 'icon-caidan');
INSERT INTO `mall_menus` VALUES (11, '系统配置', 0, 4, 'system', 0, 'icon-peizhi');
INSERT INTO `mall_menus` VALUES (12, '商城首页配置', 11, 9, 'index_config', 0, 'icon-caidan');

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `good_id` int(11) NULL DEFAULT NULL,
  `good_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `money` decimal(11, 4) NULL DEFAULT NULL,
  `favorable_price` decimal(10, 2) NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `address_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `pay_time` datetime(0) NULL DEFAULT NULL,
  `confirm_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_order
-- ----------------------------

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user`  (
  `userid` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` time(6) NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `last_login_time` time(6) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES (1, 'admin', 'bfa7295d0bc030ff892fac639e1720fe', '17:57:37.000000', 0, '17:57:44.000000');

-- ----------------------------
-- Table structure for mall_user_address
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_address`;
CREATE TABLE `mall_user_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `address_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address_status` tinyint(4) NULL DEFAULT NULL COMMENT '1=默认地址',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系人',
  `contacts_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系人电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for mall_user_scan
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_scan`;
CREATE TABLE `mall_user_scan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品Id',
  `scan_time` datetime(0) NULL DEFAULT NULL,
  `goods_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品的头图',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户浏览产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_user_scan
-- ----------------------------
INSERT INTO `mall_user_scan` VALUES (7, 3, 12, '2020-04-21 22:10:15', 'http://127.0.0.1:9000/upload/9f5e225b-ecda-4c89-8cfd-6c90459b2a66.png', '2020-04-21 17:26:48');
INSERT INTO `mall_user_scan` VALUES (8, 3, 16, '2020-04-21 22:03:23', 'http://127.0.0.1:9000/upload/7039f389-db7f-4425-91c4-b4bb88180ed1.jpg', '2020-04-21 17:26:48');
INSERT INTO `mall_user_scan` VALUES (9, 3, 15, '2020-04-21 22:09:59', 'http://127.0.0.1:9000/upload/66d06d94-a01e-4d9d-adaa-5b5c9707deec.png', '2020-04-21 22:09:59');

-- ----------------------------
-- Table structure for shopping_user
-- ----------------------------
DROP TABLE IF EXISTS `shopping_user`;
CREATE TABLE `shopping_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `wx_openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `userpic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `login_last_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_user
-- ----------------------------
INSERT INTO `shopping_user` VALUES (1, 'orhZe5UPLD68g0aPcTk0FijhkOKc', 'lc', 'https://wx.qlogo.cn/mmopen/vi_32/XWicesX6HY2wGyArfVqjL7HXiaQzXLdfPrrhAve1LqjGYhgJQ13hQfX5bBxBKkG4nemy1UJZb4DDQkK4KAia7ibSPg/132', NULL, NULL, NULL, 0, '2020-04-17 09:53:42', '2020-04-17 11:56:29');
INSERT INTO `shopping_user` VALUES (3, NULL, 'TCB2020042000002', 'http://127.0.0.1:9000/upload/header.jpg', 'spongeli_lc@sina.com', NULL, 'b58ff0dfcd4a36889184e187dd5c197e', 0, '2020-04-20 21:43:21', '2020-04-21 22:03:23');

SET FOREIGN_KEY_CHECKS = 1;
