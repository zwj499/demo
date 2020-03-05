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
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sys_user` (name, password) VALUES ('zwj', '123456');
INSERT INTO `sys_user` (name, password) VALUES ('admin', '123456');

CREATE TABLE IF NOT EXISTS `sys_role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sys_permission`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `permission` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sys_user_role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_id` VARCHAR(100) NOT NULL,
   `role_id` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sys_role_permission`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `role_id` VARCHAR(100) NOT NULL,
   `permission_id` VARCHAR(255) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

