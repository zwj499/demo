CREATE TABLE IF NOT EXISTS `dnf_role`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `career` VARCHAR(40) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dnf_role` (name, career) VALUES ('啊就是你把', '毁灭者');
INSERT INTO `dnf_role` (name, career) VALUES ('【元素】', '圣灵法师');