/*
SQLyog v10.2 
MySQL - 5.5.53 : Database - sandwich_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sandwich_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sandwich_test`;

/*Table structure for table `discern_column` */

DROP TABLE IF EXISTS `discern_column`;

CREATE TABLE `discern_column` (
  `id` int(11) DEFAULT NULL COMMENT 'id',
  `case_id` int(11) DEFAULT NULL COMMENT '案例id',
  `discern_name` varchar(50) DEFAULT NULL COMMENT '识别字段名称',
  `discernType_id` int(11) DEFAULT NULL COMMENT '识别字段方式id',
  `discern_value` varchar(100) DEFAULT NULL COMMENT '特征字段值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `discern_type` */

DROP TABLE IF EXISTS `discern_type`;

CREATE TABLE `discern_type` (
  `discern_key` int(11) DEFAULT NULL COMMENT 'id',
  `description` varchar(50) DEFAULT NULL COMMENT '识别方式描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*增加两个字段*/
ALTER TABLE `case` ADD creater VARCHAR(50) COMMENT '创建人';
ALTER TABLE `case` ADD create_time VARCHAR(30) COMMENT '创建时间';
COMMIT;
