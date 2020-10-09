CREATE TABLE IF NOT EXISTS `storm_route`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `role_id` INT NOT NULL ,
   `first_boss` VARCHAR(100) NOT NULL ,
   `second_boss` VARCHAR(100) NOT NULL ,
   `pass_time` DOUBLE NOT NULL ,
   `create_time` BIGINT,
   `update_time` BIGINT,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `storm_route` add unique index `role_two_boss_index`(`role_id`,`first_boss`,`second_boss`);