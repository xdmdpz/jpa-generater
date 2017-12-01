DROP TABLE IF EXISTS project_info;
CREATE TABLE project_info (
  project_info_id varchar(32)  NOT NULL ,
  project_name varchar(50) DEFAULT NULL ,
  project_desc varchar(50) DEFAULT NULL ,
  create_time DATA DEFAULT NULL ,
  update_time DATA DEFAULT NULL ,;
  del_tag char(1) CHARACTER SET ascii NOT NULL DEFAULT '0',
  PRIMARY KEY (project_info_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
