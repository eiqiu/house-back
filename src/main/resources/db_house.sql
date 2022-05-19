/*
 Navicat MySQL Data Transfer

 Source Server         : eiqiu
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : db_house

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 19/05/2022 15:47:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (2, '学区房');
INSERT INTO `category` VALUES (3, '医院房');
INSERT INTO `category` VALUES (4, '老年房');
INSERT INTO `category` VALUES (5, '急售房');
INSERT INTO `category` VALUES (7, '郊区房');
INSERT INTO `category` VALUES (8, '市区房');
INSERT INTO `category` VALUES (9, '市中心房');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `house_id` int NULL DEFAULT NULL,
  `collection_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`collection_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `house_id`(`house_id`) USING BTREE,
  CONSTRAINT `house_id` FOREIGN KEY (`house_id`) REFERENCES `house` (`house_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (13, 1, 3, '2022-05-19 02:37:30');
INSERT INTO `collection` VALUES (14, 1, 19, '2022-05-19 02:37:39');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `house_id` int NOT NULL AUTO_INCREMENT,
  `owner_id` int NULL DEFAULT NULL,
  `category_id` int NULL DEFAULT NULL,
  `house_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋主页的标题',
  `house_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋地址',
  `house_price` float NOT NULL COMMENT '房屋价格',
  `bargain` tinyint NULL DEFAULT NULL COMMENT '是否可议价',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `house_area` float NULL DEFAULT NULL COMMENT '房屋面积',
  `house_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋户型（2室2厅1厨1卫）',
  `house_structure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户型结构',
  `building_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑类型（板楼）',
  `building_structure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建筑结构（砖混结构）',
  `house_towards` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋朝向（南北）',
  `house_decoration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '装修情况（简装）',
  `house_ladder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '梯户比例（一梯三户）',
  `heating_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供暖方式',
  `elevator` tinyint NULL DEFAULT NULL COMMENT '是否配备电梯',
  `viewing_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '看房时间',
  `transportation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交通出行',
  `surrounding_facilities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '周边设施（医院、商场）',
  `house_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房屋描述，核心卖点',
  `house_state` tinyint NULL DEFAULT NULL COMMENT '房屋出售状态',
  `hot` tinyint NULL DEFAULT NULL COMMENT '是否是热门',
  `click_num` int NULL DEFAULT 0 COMMENT '用户点击量',
  PRIMARY KEY (`house_id`) USING BTREE,
  INDEX `category`(`category_id`) USING BTREE,
  INDEX `owner`(`owner_id`) USING BTREE,
  CONSTRAINT `category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `owner` FOREIGN KEY (`owner_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES (1, 1, 2, '学区房出租1', '山东省,烟台市,莱山区,新世界', 135.2, 0, '2022-04-25 19:39:30', 150.9, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 0, 3003);
INSERT INTO `house` VALUES (2, 2, 2, '学区房出租2', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 4500);
INSERT INTO `house` VALUES (3, 4, 3, '医院房出租1', '山东省,烟台市,莱山区,新世界', 99.5, 1, '2022-05-04 08:43:29', 160, '5室3厅1厨2卫1其他', '板房', '板楼', '钢混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '全天', '周围交通很好，公交方便，也有地铁', '绝对顺利', '绝对实惠，买的放心，住的安心', 0, 1, 6656);
INSERT INTO `house` VALUES (4, 5, 4, '老年房出租', '山东省,烟台市,莱山区,新世界', 99.5, 1, '2022-05-04 08:43:29', 160, '5室3厅1厨2卫1其他', '板房', '板楼', '钢混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '全天', '周围交通很好，公交方便，也有地铁', '绝对顺利', '绝对实惠，买的放心，住的安心', 0, 0, 1356);
INSERT INTO `house` VALUES (5, 6, 2, '学区房出租3', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 0, 1556);
INSERT INTO `house` VALUES (6, 7, 2, '学区房出租4', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 9855);
INSERT INTO `house` VALUES (7, 8, 2, '学区房出租5', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 6540);
INSERT INTO `house` VALUES (8, 9, 2, '学区房出租6', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '精装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 6588);
INSERT INTO `house` VALUES (9, 10, 2, '学区房出租7', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 0, 698);
INSERT INTO `house` VALUES (10, 11, 2, '学区房出租8', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 6500);
INSERT INTO `house` VALUES (11, 12, 2, '学区房出租9', '山东省,烟台市,莱山区,新世界', 65.9, 0, '2022-04-06 19:39:30', 200, '5室3厅1厨2卫1其他', '板房', '板楼', '砖混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 65897);
INSERT INTO `house` VALUES (12, 13, 3, '医院房出租2', '山东省,烟台市,莱山区,新世界', 99.5, 1, '2022-05-04 08:43:29', 160, '5室3厅1厨2卫1其他', '板房', '板楼', '钢混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '全天', '周围交通很好', '绝对顺利', '绝对实惠，买的放心，住的安心', 0, 1, 6587);
INSERT INTO `house` VALUES (13, 14, 3, '医院房出租3', '山东省,烟台市,莱山区,新世界', 99.5, 1, '2022-05-04 08:43:29', 160, '5室3厅1厨2卫1其他', '板房', '板楼', '钢混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '全天', '周围交通很好', '绝对顺利', '绝对实惠，买的放心，住的安心', 0, 0, 0);
INSERT INTO `house` VALUES (14, 15, 3, '医院房出租4', '山东省,烟台市,莱山区,新世界', 99.5, 1, '2022-05-04 08:43:29', 160, '5室3厅1厨2卫1其他', '板房', '板楼', '钢混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '全天', '周围交通很好', '绝对顺利', '绝对实惠，买的放心，住的安心', 0, 1, 4500);
INSERT INTO `house` VALUES (15, 16, 3, '医院房出租5', '山东省,烟台市,莱山区,新世界', 99.5, 1, '2022-05-04 08:43:29', 160, '5室3厅1厨2卫1其他', '板房', '板楼', '钢混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '全天', '周围交通很好', '有医院、学校、商场，设施基本齐全', '绝对实惠，买的放心，住的安心', 0, 0, 0);
INSERT INTO `house` VALUES (16, 1, 8, '河北房子', '河北省,秦皇岛市,北戴河区,北戴河区1', 135, 1, '2022-05-12 07:51:46', 1, '2室1厅1厨2卫0其他', '板房', '板楼', '钢混结构', '东西', '精修', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 0, 0);
INSERT INTO `house` VALUES (19, 1, 8, '美丽房子', '山东省,烟台市,莱山区,新世界', 198, 1, '2022-05-10 13:41:09', 1, '0室1厅0厨1卫1其他', '板房', '板楼', '钢混结构', '东西', '精修', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 0, 2);
INSERT INTO `house` VALUES (28, 1, 2, '呃呃呃呃', '河北省,秦皇岛市,山海关区,23', 23, 1, '2022-05-16 09:37:13', 23, '0室0厅0厨0卫0其他', '', '板楼', '钢混结构', '南北', '精装', '一梯两户', '集体供暖', 0, '白天9:00到下午6:00', '周围交通很好，公交方便，也有地铁', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 1, 6987);
INSERT INTO `house` VALUES (29, 1, 3, '测试热门', '黑龙江省,齐齐哈尔市,建华区,123', 123, 1, '2022-05-17 11:27:20', 123, '0室0厅0厨0卫0其他', '1', '板楼', '钢混结构', '南北', '简装', '一梯两户', '集体供暖', 1, '白天9:00到下午6:00', '周围交通很好', '有医院、学校、商场', '绝对实惠，买的放心，住的安心', 0, 0, 4480);

-- ----------------------------
-- Table structure for house_picture
-- ----------------------------
DROP TABLE IF EXISTS `house_picture`;
CREATE TABLE `house_picture`  (
  `picture_id` int NOT NULL AUTO_INCREMENT,
  `house_id` int NULL DEFAULT NULL,
  `src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`picture_id`) USING BTREE,
  INDEX `picture`(`house_id`) USING BTREE,
  CONSTRAINT `picture` FOREIGN KEY (`house_id`) REFERENCES `house` (`house_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_picture
-- ----------------------------
INSERT INTO `house_picture` VALUES (2, 1, '01.jpg');
INSERT INTO `house_picture` VALUES (3, 1, '02.jpg');
INSERT INTO `house_picture` VALUES (4, 1, '03.jpg');
INSERT INTO `house_picture` VALUES (5, 2, '01.jpg');
INSERT INTO `house_picture` VALUES (6, 2, '01.jpg');
INSERT INTO `house_picture` VALUES (7, 2, '01.jpg');
INSERT INTO `house_picture` VALUES (8, 3, '01.jpg');
INSERT INTO `house_picture` VALUES (9, 4, '01.jpg');
INSERT INTO `house_picture` VALUES (10, 5, '01.jpg');
INSERT INTO `house_picture` VALUES (11, 6, '01.jpg');
INSERT INTO `house_picture` VALUES (12, 7, '01.jpg');
INSERT INTO `house_picture` VALUES (13, 8, '01.jpg');
INSERT INTO `house_picture` VALUES (14, 9, '01.jpg');
INSERT INTO `house_picture` VALUES (15, 10, '01.jpg');
INSERT INTO `house_picture` VALUES (16, 11, '01.jpg');
INSERT INTO `house_picture` VALUES (17, 12, '01.jpg');
INSERT INTO `house_picture` VALUES (18, 13, '01.jpg');
INSERT INTO `house_picture` VALUES (19, 14, '01.jpg');
INSERT INTO `house_picture` VALUES (20, 1, '01.jpg');
INSERT INTO `house_picture` VALUES (24, 15, '03.jpg');
INSERT INTO `house_picture` VALUES (28, 19, '03.jpg');
INSERT INTO `house_picture` VALUES (33, 16, '52.jpg');
INSERT INTO `house_picture` VALUES (34, 16, '53.jpg');
INSERT INTO `house_picture` VALUES (45, 28, '661e5760-2406-4ee7-8ead-eb33110d64da.jpg');
INSERT INTO `house_picture` VALUES (46, 28, '38cdf2ea-248f-4448-b51a-1acb33afeca2.jpg');
INSERT INTO `house_picture` VALUES (47, 29, 'e3b144fb-ac36-42da-8ab4-c530a2f53c65.jpg');
INSERT INTO `house_picture` VALUES (48, 29, 'f7827c3d-2b9a-4277-923d-2d5d61d8329b.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `user_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `user_age` int NULL DEFAULT NULL COMMENT '年龄',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '15666699669', '李大爷', '15069910037', '男', 60, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (2, '17658085889', '张大爷', '10086', '男', 48, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (4, '15066699889', '用户15066', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (5, '15066699878', '王大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (6, '15066699899', '刘大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (7, '16978495956', '楚大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (8, '15066489489', '谢大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (9, '16524568944', '宋大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (10, '15579845478', '孔大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (11, '15068797545', '孟大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (12, '15879754545', '朱大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (13, '15989564575', '吴大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (14, '16598456874', '管大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (15, '13457545454', '秦大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');
INSERT INTO `user` VALUES (16, '17894654987', '孙大爷', '16599877898', '男', 36, '山东省,烟台市,莱山区,山东工商学院', 'a12345');

SET FOREIGN_KEY_CHECKS = 1;
