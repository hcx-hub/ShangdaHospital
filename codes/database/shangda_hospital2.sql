/*
 Navicat Premium Data Transfer

 Source Server         : gaogao
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : shangda_hospital2

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/05/2022 00:56:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '科室',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '内科');
INSERT INTO `department` VALUES (2, '妇科');
INSERT INTO `department` VALUES (3, '骨科');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `doctor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '科室',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, 'admin', '123', '管理员', '', NULL);
INSERT INTO `doctor` VALUES (2, 'lihua', '123', '李华', '内科', '男');
INSERT INTO `doctor` VALUES (3, 'haha', '123', '哈哈', '妇科', '男');
INSERT INTO `doctor` VALUES (4, 'huhu', '123', '呼呼', '妇科', '女');
INSERT INTO `doctor` VALUES (5, 'wohenqiang', '123', '我很强', '内科', '男');
INSERT INTO `doctor` VALUES (6, 'xiaoli', '123', '小李', '妇科', '男');
INSERT INTO `doctor` VALUES (7, 'laowang', '123', '老王', '骨科', '男');
INSERT INTO `doctor` VALUES (9, 'daoge', '123', '刀哥', '妇科', '男');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `patient_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '患者姓名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (1, 'gaogao', '123', '糕糕', '男');
INSERT INTO `patient` VALUES (2, 'baozi', '123', '包子', '女');
INSERT INTO `patient` VALUES (3, 'guagua', '123', '瓜瓜', '男');

-- ----------------------------
-- Table structure for yuyue
-- ----------------------------
DROP TABLE IF EXISTS `yuyue`;
CREATE TABLE `yuyue`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `patient_id` int(0) NULL DEFAULT NULL COMMENT '病人id',
  `doctor_id` int(0) NULL DEFAULT NULL COMMENT '医生id',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '诊断结果',
  `statue` int(0) NULL DEFAULT NULL COMMENT '状态（1结束0未结束）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuyue
-- ----------------------------
INSERT INTO `yuyue` VALUES (1, 2, 2, '2022-04-26 20:52:00', '玩玩', 1);
INSERT INTO `yuyue` VALUES (3, 1, 2, '2022-04-26 21:41:02', NULL, 0);
INSERT INTO `yuyue` VALUES (5, 1, 3, '2022-04-27 10:51:21', NULL, 0);
INSERT INTO `yuyue` VALUES (7, 1, 2, '2022-04-28 14:50:22', NULL, 1);
INSERT INTO `yuyue` VALUES (8, 2, 2, '2022-04-28 14:50:37', NULL, 1);

-- ----------------------------
-- Table structure for yuyue_copy2
-- ----------------------------
DROP TABLE IF EXISTS `yuyue_copy2`;
CREATE TABLE `yuyue_copy2`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `patient_id` int(0) NULL DEFAULT NULL COMMENT '病人id',
  `patient_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '病人姓名',
  `doctor_id` int(0) NULL DEFAULT NULL COMMENT '医生id',
  `doctor_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '科室',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuyue_copy2
-- ----------------------------
INSERT INTO `yuyue_copy2` VALUES (1, 123, '给瓜瓜', 2, '李华', '2022-04-26 20:52:13', '内科');
INSERT INTO `yuyue_copy2` VALUES (3, 111, '而且', 23, '啦啦', '2022-04-26 21:41:02', '内科');

SET FOREIGN_KEY_CHECKS = 1;
