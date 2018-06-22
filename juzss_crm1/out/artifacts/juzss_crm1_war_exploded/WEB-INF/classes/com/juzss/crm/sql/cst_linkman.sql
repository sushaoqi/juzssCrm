CREATE TABLE `cst_linkman` (
  `lkm_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
  `lkm_name` VARCHAR(16) DEFAULT NULL COMMENT '联系人姓名',
  `lkm_cust_id` BIGINT(32) NOT NULL COMMENT '客户id',
  `lkm_gender` CHAR(1) DEFAULT NULL COMMENT '联系人性别',
  `lkm_phone` VARCHAR(16) DEFAULT NULL COMMENT '联系人办公电话',
  `lkm_mobile` VARCHAR(16) DEFAULT NULL COMMENT '联系人手机',
  `lkm_email` VARCHAR(64) DEFAULT NULL COMMENT '联系人邮箱',
  `lkm_qq` VARCHAR(16) DEFAULT NULL COMMENT '联系人qq',
  `lkm_position` VARCHAR(16) DEFAULT NULL COMMENT '联系人职位',
  `lkm_memo` VARCHAR(512) DEFAULT NULL COMMENT '联系人备注',
  PRIMARY KEY (`lkm_id`),
  KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
  CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;