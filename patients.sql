/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : patients

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 10/08/2022 16:07:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Patients
-- ----------------------------
DROP TABLE IF EXISTS `Patients`;
CREATE TABLE `Patients` (
  `Patient_ID` int NOT NULL AUTO_INCREMENT,
  `Patient_Name` varchar(80) NOT NULL,
  `Age` int NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `SSN` varchar(50) NOT NULL,
  `Hospitalization_Date` varchar(40) NOT NULL,
  `Symptom` varchar(200) NOT NULL,
  `Treatment` varchar(200) NOT NULL,
  `Recovery_Date` varchar(40) NOT NULL,
  `After_Treatment` varchar(200) DEFAULT NULL,
  `Attending_Physician` varchar(80) NOT NULL,
  PRIMARY KEY (`Patient_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Patients
-- ----------------------------
BEGIN;
INSERT INTO `Patients` VALUES (1, 'Otte', 47, 'M', '1005 S Beaver St.', '520-491-0477', 'pl384@nau.edu', '123-45-6789', '07/28/2022', 'COVID-19', 'Tylenol', '08/01/2022', 'Fine', 'Jiasheng');
INSERT INTO `Patients` VALUES (2, 'Jiasheng', 2, 'M', '1005 S Beaver St.', '520-491-0477', 'jy445@nau.edu', '123-45-6789', '07/29/2022', 'COVID-19', 'Tylenol', '08/01/2022', 'Fine', 'Pengfei');
INSERT INTO `Patients` VALUES (3, 'Yike', 7, 'F', '1005 S Beaver St.', '520-491-0477', 'll843@nau.edu', '123-45-6789', '07/29/2022', 'COVID-19', 'Tylenol', '08/01/2022', 'Fine', 'Pengfei');
INSERT INTO `Patients` VALUES (4, 'Leo', 2, 'M', '1005 S Beaver St.', '520-491-0488', 'leo@nau.edu', '123-45-6789', '07/29/2022', 'COVID-19', 'Tylenol', '08/01/2022', 'Fine', 'Pengfei');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
