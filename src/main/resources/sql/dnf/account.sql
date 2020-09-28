CREATE TABLE IF NOT EXISTS `account`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `account` VARCHAR(100) NOT NULL,
   `create_time` BIGINT,
   `sys_user_id` INT,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;