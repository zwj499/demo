CREATE TABLE IF NOT EXISTS `damage`(
   `id` INT UNSIGNED AUTO_INCREMENT COMMENT '主键',
   `monster` VARCHAR(100) NOT NULL COMMENT '怪物',
   `duration` VARCHAR(100) NOT NULL COMMENT '时长',
   `role_id` INT NOT NULL COMMENT '角色id',
   `damage` BIGINT NOT NULL COMMENT '伤害',
   `create_time` BIGINT COMMENT '创建时间',
   `update_time` BIGINT COMMENT '更新时间',
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `damage` add unique index `monster_duration_role_index`(`monster`,`duration`,`role_id`);