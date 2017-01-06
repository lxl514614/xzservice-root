CREATE TABLE IF NOT EXISTS td_operate (
  uid VARCHAR(60) NOT NULL COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  name VARCHAR(60) NOT NULL COMMENT '操作名称',
  code VARCHAR(60) NOT NULL COMMENT '操作编码',
  menu_code VARCHAR(60) NULL COMMENT '菜单编码',
  action VARCHAR(100) NULL COMMENT '对应的action',
  is_role TINYINT(4) NOT NULL DEFAULT '1' COMMENT '是否纳入权限管理',
  PRIMARY KEY (uid))
ENGINE = InnoDB DEFAULT CHARSET = utf8
COMMENT = '系统操作url表';

CREATE TABLE IF NOT EXISTS td_role (
  uid VARCHAR(60) NOT NULL COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  name VARCHAR(60) NOT NULL COMMENT '角色名称',
  code VARCHAR(60) NOT NULL COMMENT '角色编码',
  PRIMARY KEY (uid))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统角色表';

CREATE TABLE IF NOT EXISTS tr_role_operator (
  uid VARCHAR(60) NOT NULL COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  role_id VARCHAR(60) NOT NULL COMMENT '角色id',
  op_id VARCHAR(60) NOT NULL COMMENT '操作id',
  PRIMARY KEY (uid))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统角色操作关系表';

CREATE TABLE IF NOT EXISTS tr_user_role (
  uid VARCHAR(60) NOT NULL COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  role_id VARCHAR(60) NOT NULL COMMENT '角色id',
  user_id VARCHAR(60) NOT NULL COMMENT '用户id',
  PRIMARY KEY (uid))
  ENGINE = InnoDB DEFAULT CHARSET = utf8 
  COMMENT = '系统用户角色关系表';

CREATE TABLE IF NOT EXISTS tr_user_menu (
  uid VARCHAR(60) NOT NULL COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  menu_id VARCHAR(60) NOT NULL COMMENT '菜单id',
  user_id VARCHAR(60) NOT NULL COMMENT '用户id',
  PRIMARY KEY (uid))
  ENGINE = InnoDB DEFAULT CHARSET = utf8 
  COMMENT = '系统用户菜单关系表';

CREATE TABLE IF NOT EXISTS tr_user_level (
  uid VARCHAR(60) NOT NULL COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  level VARCHAR(60) NOT NULL COMMENT '用户级别',
  user_id VARCHAR(60) NOT NULL COMMENT '用户id',
  PRIMARY KEY (uid))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统用户级别表';

CREATE TABLE `td_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `realname` varchar(32) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `status` varchar(16) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8 COMMENT = '系统用户表';