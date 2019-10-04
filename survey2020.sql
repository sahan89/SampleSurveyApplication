/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : survey2020

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 04/10/2019 16:56:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answers
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `answer` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK3erw1a3t0r78st8ty27x6v3g1`(`question_id`) USING BTREE,
  CONSTRAINT `FK3erw1a3t0r78st8ty27x6v3g1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answers
-- ----------------------------


-- ----------------------------
-- Table structure for call_status
-- ----------------------------
DROP TABLE IF EXISTS `call_status`;
CREATE TABLE `call_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `call_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of call_status
-- ----------------------------
INSERT INTO `call_status` VALUES (1, 'Call');

-- ----------------------------
-- Table structure for district
-- ----------------------------
DROP TABLE IF EXISTS `district`;
CREATE TABLE `district`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of district
-- ----------------------------
INSERT INTO `district` VALUES (1, 'Any');
INSERT INTO `district` VALUES (2, 'Ampara');
INSERT INTO `district` VALUES (3, 'Anuradhapura');
INSERT INTO `district` VALUES (4, 'Badulla');
INSERT INTO `district` VALUES (5, 'Batticaloa');
INSERT INTO `district` VALUES (6, 'Colombo');
INSERT INTO `district` VALUES (7, 'Galle');
INSERT INTO `district` VALUES (8, 'Gampaha');
INSERT INTO `district` VALUES (9, 'Hambantota');
INSERT INTO `district` VALUES (10, 'Jaffna');
INSERT INTO `district` VALUES (11, 'Kalutara');
INSERT INTO `district` VALUES (12, 'Kandy');
INSERT INTO `district` VALUES (13, 'Kegalle');
INSERT INTO `district` VALUES (14, 'Kilinochchi');
INSERT INTO `district` VALUES (15, 'Kurunegala');
INSERT INTO `district` VALUES (16, 'Mannar');
INSERT INTO `district` VALUES (17, 'Matale');
INSERT INTO `district` VALUES (18, 'Matara');
INSERT INTO `district` VALUES (19, 'Moneragala');
INSERT INTO `district` VALUES (20, 'Mullaitivu');
INSERT INTO `district` VALUES (21, 'Nuwara Eliya');
INSERT INTO `district` VALUES (22, 'Polonnaruwa');
INSERT INTO `district` VALUES (23, 'Puttalam');
INSERT INTO `district` VALUES (24, 'Rathnapura');
INSERT INTO `district` VALUES (25, 'Trincomalee');
INSERT INTO `district` VALUES (26, 'Vavuniya');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES (1, 'ප්‍රශ්න අංක 1', 1);
INSERT INTO `questions` VALUES (2, 'ප්‍රශ්න අංක 2', 1);
INSERT INTO `questions` VALUES (3, 'ප්‍රශ්න අංක 3', 1);
INSERT INTO `questions` VALUES (4, 'Question 4', 0);
INSERT INTO `questions` VALUES (5, 'Question 5', 0);
INSERT INTO `questions` VALUES (6, 'Question 6', 0);

-- ----------------------------
-- Table structure for reserch_num
-- ----------------------------
DROP TABLE IF EXISTS `reserch_num`;
CREATE TABLE `reserch_num`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `mobile_number` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `district` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `checked` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `call_status` int(11) NULL DEFAULT NULL,
  `response_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reserch_num
-- ----------------------------
INSERT INTO `reserch_num` VALUES (1, '0716808027', 'Any', 0, 1, 0);
INSERT INTO `reserch_num` VALUES (2, '0112343453', 'Colombo', 0, 1, 0);
INSERT INTO `reserch_num` VALUES (3, '0113456434', 'Colombo', 0, 1, 0);
INSERT INTO `reserch_num` VALUES (4, '0115446754', 'Colombo', 0, 1, 0);
INSERT INTO `reserch_num` VALUES (5, '0123463453', 'Colombo', 0, 1, 0);
INSERT INTO `reserch_num` VALUES (6, '0456324532', 'Rathnapura', 0, 1, 0);

-- ----------------------------
-- Table structure for response_status
-- ----------------------------
DROP TABLE IF EXISTS `response_status`;
CREATE TABLE `response_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `response_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of response_status
-- ----------------------------
INSERT INTO `response_status` VALUES (1, 'Answered');
INSERT INTO `response_status` VALUES (2, 'Not Answered');
INSERT INTO `response_status` VALUES (3, 'Cancel');

-- ----------------------------
-- Table structure for survey_answers
-- ----------------------------
DROP TABLE IF EXISTS `survey_answers`;
CREATE TABLE `survey_answers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `survey_main_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for survey_main
-- ----------------------------
DROP TABLE IF EXISTS `survey_main`;
CREATE TABLE `survey_main`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `research_no_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '123', 1, 'Sahan');

SET FOREIGN_KEY_CHECKS = 1;
