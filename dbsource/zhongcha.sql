-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `phone` text NOT NULL,
  `password` text,
  `nickname` text,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ----------------------------
--  Table structure for 'goods'
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT,
  `goods_ecode` text,
  `goodsname` text,
  `price` decimal(15,2) DEFAULT NULL,
  `pic` text DEFAULT NULL,
  `classid` int(11) NOT NULL,
  `shopid` int(11) NOT NULL,
  `last_refeash_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `last_refeash_user` int(11) NOT NULL,
  PRIMARY KEY(`goodsid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ---------------------------
-- Table shop
-- ---------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopid` int(11) NOT NULL AUTO_INCREMENT,
  `shopname` text,
  `pic` text DEFAULT NULL,
  `longitude` double(10,3) NOT NULL,
  `latitude` double(10,3) NOT NULL,
  `jointime` timestamp DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`shopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ---------------------------
-- Tables structure for unit
-- ---------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE  `unit` (
  `unitid` int(11),
  `unitname` text,
  PRIMARY KEY(`unitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ---------------------------
-- Table for class
-- ---------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classid` int(11) ,
  `fatherid` int(11),
  `classname` text,
  `unitid` int(11) NOT NULL,
  PRIMARY KEY(`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

