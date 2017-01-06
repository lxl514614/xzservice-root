CREATE TABLE IF NOT EXISTS td_operate (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  name VARCHAR(60) NOT NULL COMMENT '操作名称',
  code VARCHAR(60) NOT NULL COMMENT '操作编码',
  menu_code VARCHAR(60) NULL COMMENT '菜单编码',
  action VARCHAR(100) NULL COMMENT '对应的action',
  is_role TINYINT(4) NOT NULL DEFAULT '1' COMMENT '是否纳入权限管理',
  PRIMARY KEY (id))
ENGINE = InnoDB DEFAULT CHARSET = utf8
COMMENT = '系统操作url表';

CREATE TABLE IF NOT EXISTS td_role (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  name VARCHAR(60) NOT NULL COMMENT '角色名称',
  code VARCHAR(60) NOT NULL COMMENT '角色编码',
  PRIMARY KEY (id))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统角色表';


CREATE TABLE `td_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `crt_ts` datetime DEFAULT NULL COMMENT '创建时间',
  `email` varchar(128) DEFAULT NULL COMMENT '邮件',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `realname` varchar(32) NOT NULL COMMENT '真实姓名',
  `salt` varchar(32) NOT NULL COMMENT '盐值',
  `status` varchar(16) NOT NULL COMMENT '用户状态',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8 COMMENT = '系统用户表';

CREATE TABLE IF NOT EXISTS td_menu (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  name VARCHAR(60) NOT NULL COMMENT '菜单名称',
  code VARCHAR(60) NOT NULL COMMENT '菜单编码',
  level TINYINT(4) NOT NULL COMMENT '菜单级别',
  data_trigger VARCHAR(60) NULL COMMENT '操作标志',
  parent_code VARCHAR(60) NULL COMMENT '父级编码',
  action VARCHAR(100) NULL COMMENT '对应的action',
  status TINYINT(4) NOT NULL DEFAULT '1' COMMENT '启用状态',
  sort TINYINT(4) NULL COMMENT '顺序',
  icon VARCHAR(256) NULL COMMENT '前置图标',
  foot_icon VARCHAR(256) NULL COMMENT '尾部图标',
  src_type VARCHAR(45) NULL COMMENT '数据来源方式',
  exec_exp VARCHAR(100) NULL COMMENT '数据来源规则',
  PRIMARY KEY (id))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统菜单表';

CREATE TABLE IF NOT EXISTS tr_role_operator (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  role_id BIGINT(20) NOT NULL COMMENT '角色id',
  op_id BIGINT(20) NOT NULL COMMENT '操作id',
  PRIMARY KEY (id))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统角色操作关系表';

CREATE TABLE IF NOT EXISTS tr_user_role (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  role_id BIGINT(20) NOT NULL COMMENT '角色id',
  user_id BIGINT(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (id))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统用户角色关系表';

CREATE TABLE IF NOT EXISTS tr_user_menu (
  id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  crt_ts TIMESTAMP NULL COMMENT '创建时间',
  update_ts TIMESTAMP NULL COMMENT '更新时间',
  menu_id BIGINT(20) NOT NULL COMMENT '菜单id',
  user_id BIGINT(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (id))
  ENGINE = InnoDB DEFAULT CHARSET = utf8
  COMMENT = '系统用户菜单关系表';
