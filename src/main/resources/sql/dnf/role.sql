CREATE TABLE IF NOT EXISTS `role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `account_id` INT NOT NULL ,
   `name` VARCHAR(100) NOT NULL ,
   `level` INT NOT NULL ,
   `career` VARCHAR(100) NOT NULL,
   `create_time` BIGINT,
   `update_time` BIGINT,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;