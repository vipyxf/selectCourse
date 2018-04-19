/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50015
Source Host           : localhost:3306
Source Database       : selectcourse

Target Server Type    : MYSQL
Target Server Version : 50015
File Encoding         : 65001

Date: 2018-03-13 12:58:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` varchar(22) NOT NULL,
  `cname` varchar(22) default NULL,
  `type` varchar(22) default NULL,
  `credit` int(11) default NULL,
  `tid` int(11) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('123', ' 的', '啊', '5', '1233');
INSERT INTO `course` VALUES ('1312313', 'dsd', 'dasd', '12131', '312');
INSERT INTO `course` VALUES ('k01', '高数', '公共课', '6', '2001');
INSERT INTO `course` VALUES ('k02', 'java基础', '选修课', '2', '2002');
INSERT INTO `course` VALUES ('k03', 'MySQL', '必修课', '4', '2003');
INSERT INTO `course` VALUES ('k04', 'web前端', '选修课', '4', '2004');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL,
  `name` varchar(22) default NULL,
  `password` varchar(22) default NULL,
  `age` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1000', '董霞君', '123', '24');
INSERT INTO `manager` VALUES ('1001', '侯亮平', '123', '42');
INSERT INTO `manager` VALUES ('1002', '李达康', '123', '48');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `sid` int(11) NOT NULL auto_increment,
  `stuId` int(11) default NULL,
  `stuname` varchar(22) default NULL,
  `banji` varchar(22) default NULL,
  `cid` varchar(11) default NULL,
  `cname` varchar(11) default NULL,
  `fenshu` int(11) default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '3001', '钟小艾', '1班', 'k01', '高数', '78');
INSERT INTO `score` VALUES ('2', '3001', '钟小艾', '1班', 'k02', 'java基础', '84');
INSERT INTO `score` VALUES ('3', '3001', '钟小艾', '1班', 'k03', 'MySQL', '46');
INSERT INTO `score` VALUES ('4', '3001', '钟小艾', '1班', 'k02', 'web前端', '92');
INSERT INTO `score` VALUES ('5', '3002', '沙瑞金', '2班', 'k01', '高数', '67');
INSERT INTO `score` VALUES ('6', '3002', '沙瑞金', '2班', 'k02', 'java基础', '78');
INSERT INTO `score` VALUES ('7', '3002', '沙瑞金', '2班', 'k03', 'MySQL', '71');
INSERT INTO `score` VALUES ('8', '3002', '沙瑞金', '2班', 'k04', 'web前端', '92');
INSERT INTO `score` VALUES ('9', '3003', '陈岩石', '3班', 'k01', '高数', '67');
INSERT INTO `score` VALUES ('10', '3003', '陈岩石', '3班', 'k02', 'java基础', '88');
INSERT INTO `score` VALUES ('11', '3003', '陈岩石', '3班', 'k03', 'MySQL', '83');
INSERT INTO `score` VALUES ('12', '3003', '陈岩石', '3班', 'k04', 'web前端', '90');
INSERT INTO `score` VALUES ('13', '3004', '郑西坡', '4班', 'k01', '高数', '78');
INSERT INTO `score` VALUES ('14', '3004', '郑西坡', '4班', 'k02', 'java基础', '56');
INSERT INTO `score` VALUES ('15', '3004', '郑西坡', '4班', 'k03', 'MySQL', '78');
INSERT INTO `score` VALUES ('16', '3004', '郑西坡', '4班', 'k04', 'web前端', '66');
INSERT INTO `score` VALUES ('17', '3005', '宋江', '1班', 'k01', '高数', '98');
INSERT INTO `score` VALUES ('18', '3005', '宋江', '1班', 'k02', 'java基础', '91');
INSERT INTO `score` VALUES ('19', '3005', '宋江', '1班', 'k03', 'MySQL', '98');
INSERT INTO `score` VALUES ('20', '3005', '宋江', '1班', 'k04', 'web前端', '98');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment,
  `sname` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `banji` varchar(20) default NULL,
  `home` varchar(20) default NULL,
  `phone` int(11) default NULL,
  `email` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '任向东', '123', '1班', '甘肃', '123334', '111@qq.com');
INSERT INTO `student` VALUES ('123', '大小', '111', '啊', '啊', '12121', '111@qq.com');
INSERT INTO `student` VALUES ('3001', '钟小艾', '345', '1班', '北京', '111', '123@qq.com');
INSERT INTO `student` VALUES ('3002', '沙瑞金', '345', '2班', '南京', '222', '123@qq.com');
INSERT INTO `student` VALUES ('3003', '陈岩石', '345', '3班', '平城', '333', '123@qq.com');
INSERT INTO `student` VALUES ('3004', '郑西坡', '345', '4班', '洛阳', '444', '123@qq.com');
INSERT INTO `student` VALUES ('3005', '宋江', '345', '1班', '梁山', '555', '123@qq.com');
INSERT INTO `student` VALUES ('3006', '武松', '345', '2班', '梁山', '555', '123@qq.com');
INSERT INTO `student` VALUES ('3007', '鲁智深', '345', '3班', '梁山', '555', '123@qq.com');
INSERT INTO `student` VALUES ('3008', '李逵', '345', '4班', '梁山', '555', '123@qq.com');
INSERT INTO `student` VALUES ('3009', '111', '11', '11', '11', '1', '122');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `tname` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `title` varchar(20) default NULL,
  `department` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('3', '家', '', '', '');
INSERT INTO `teacher` VALUES ('12', '', '', '', '');
INSERT INTO `teacher` VALUES ('111', '啊啊', 'null', 'null', 'null');
INSERT INTO `teacher` VALUES ('2001', '李福锐', '234', '教授', '计算机系');
INSERT INTO `teacher` VALUES ('2002', '王文军', '234', '教师', '软件工程系');
INSERT INTO `teacher` VALUES ('2003', '杨刚', '234', '副教授', '通信系');
INSERT INTO `teacher` VALUES ('2004', '任向东', '234', '教授', '电子商务系');
