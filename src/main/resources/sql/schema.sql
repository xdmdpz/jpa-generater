DROP TABLE IF EXISTS `project_info`;
CREATE TABLE `project_info` (
  `project_info_id` varchar(32) CHARACTER SET ascii NOT NULL COMMENT '主键',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `project_desc` varchar(50) DEFAULT NULL COMMENT '项目描述',
  `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET ascii DEFAULT NULL COMMENT '创建人',
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET ascii DEFAULT NULL COMMENT '更新人',
  `del_tag` char(1) CHARACTER SET ascii NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`project_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- DROP TABLE IF EXISTS `table_info`;
-- CREATE TABLE `table_info` (
--   `table_info_id` varchar(32) CHARACTER SET ascii NOT NULL COMMENT '主键',
--   `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
--   `create_by` varchar(32) CHARACTER SET ascii DEFAULT NULL COMMENT '创建人',
--   `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
--   `update_by` varchar(32) CHARACTER SET ascii DEFAULT NULL COMMENT '更新人',
--   `del_tag` char(1) CHARACTER SET ascii NOT NULL DEFAULT '0' COMMENT '删除标记',
--   PRIMARY KEY (`table_info_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;