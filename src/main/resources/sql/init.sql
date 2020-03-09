CREATE TABLE IF NOT EXISTS `role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `career` VARCHAR(40) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `role` (name, career) VALUES ('啊就是你把', '毁灭者');
INSERT INTO `role` (name, career) VALUES ('【元素】', '圣灵法师');

CREATE TABLE IF NOT EXISTS `sys_user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `password` VARCHAR(255) NOT NULL,
   `level` INT NOT NULL DEFAULT 1,
   `phone` VARCHAR(100),
   `email` VARCHAR(255),
   `active` tinyint default 1,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_user` (id, name, password, level, phone, email) VALUES (1, 'zwj', '123456', 1, '18120757510', '499930612@qq.com');
INSERT INTO `sys_user` (id, name, password, level, phone, email) VALUES (2, 'admin', '123456', 2, '10086', '54818931@qq.com');

CREATE TABLE IF NOT EXISTS `sys_role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_role` (id, name) VALUES (1, 'sys_admin');
INSERT INTO `sys_role` (id, name) VALUES (2, 'custom');

CREATE TABLE IF NOT EXISTS `sys_permission`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `permission` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_permission` (id, name) VALUES (1, 'system');
INSERT INTO `sys_permission` (id, name) VALUES (2, 'role');

CREATE TABLE IF NOT EXISTS `sys_user_role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_id` VARCHAR(100) NOT NULL,
   `role_id` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_user_role` (id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO `sys_user_role` (id, user_id, role_id) VALUES (1, 1, 2);
INSERT INTO `sys_user_role` (id, user_id, role_id) VALUES (1, 2, 1);
INSERT INTO `sys_user_role` (id, user_id, role_id) VALUES (1, 2, 2);

CREATE TABLE IF NOT EXISTS `sys_role_permission`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `role_id` VARCHAR(100) NOT NULL,
   `permission_id` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_role_permission` (id, role_id, permission_id) VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` (id, role_id, permission_id) VALUES (1, 1, 2);
INSERT INTO `sys_role_permission` (id, role_id, permission_id) VALUES (1, 2, 1);
INSERT INTO `sys_role_permission` (id, role_id, permission_id) VALUES (1, 2, 2);

CREATE TABLE IF NOT EXISTS `dungeons`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `descption` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dungeons` (id, name, descption) VALUES (1, '普雷', 2);

CREATE TABLE IF NOT EXISTS `dungeons_record`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `roleId` INT NOT NULL,
   `dungeonsId` INT NOT NULL,
   `throughTime` INT NOT NULL,
   `createTime` INT NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
