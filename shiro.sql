/*
Navicat MySQL Data Transfer

Source Server         : loacl11
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2015-12-11 18:03:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionId` int(11) NOT NULL DEFAULT '0',
  `permissionName` varchar(255) DEFAULT NULL,
  `permissionDesc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'user:zfx', 'user:zfx');
INSERT INTO `permission` VALUES ('1', 'user:add', 'user:add');
INSERT INTO `permission` VALUES ('1', 'account:create', 'account:create');
INSERT INTO `permission` VALUES ('1', 'user:del', 'user:del');
INSERT INTO `permission` VALUES ('1', 'user:add', 'user:add');

-- ----------------------------
-- Table structure for `rolepermission`
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `roleId` int(11) NOT NULL DEFAULT '0',
  `permissionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL DEFAULT '0',
  `userName` varchar(255) DEFAULT NULL,
  `userPsw` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'zfx', 'zfx', '1');
