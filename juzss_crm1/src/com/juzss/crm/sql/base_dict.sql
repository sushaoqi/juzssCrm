CREATE TABLE `base_dict` (
  `dict_id` VARCHAR(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` VARCHAR(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` VARCHAR(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` VARCHAR(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` VARCHAR(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` INT(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` CHAR(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` VARCHAR(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;