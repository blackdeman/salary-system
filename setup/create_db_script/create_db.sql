create database salary_system;

use salary_system;

CREATE TABLE `group_tbl` (
 
  `group_id` int(10) NOT NULL,
 
  `group_name` varchar(20) NOT NULL,
 
  PRIMARY KEY (`group_id`)
 
);
 
CREATE TABLE `user_tbl` (
 
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
 
  `username` varchar(20) NOT NULL,
 
  `password` char(32) NOT NULL,
 
  PRIMARY KEY (`user_id`)
 
);
 
CREATE TABLE `user_group_tbl` (
 
  `user_id` int(10) NOT NULL,
 
  `group_id` int(10) NOT NULL,
 
  PRIMARY KEY (`user_id`,`group_id`),
 
  KEY `fk_users_has_groups_groups` (`group_id`),
 
  KEY `fk_users_has_groups_users` (`user_id`),
 
  CONSTRAINT `fk_groups` FOREIGN KEY (`group_id`) REFERENCES `group_tbl` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
 
  CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 
); 
 
CREATE VIEW `user_role_view` AS
 
SELECT  u.username, u.password, g.group_name
 
 FROM `user_group_tbl` ug
 
 INNER JOIN `user_tbl` u ON u.user_id = ug.user_id
 
 INNER JOIN `group_tbl` g ON g.group_id =  ug.group_id; 
 
INSERT  INTO `group_tbl`(`group_id`,`group_name`) VALUES
  (1001,'SUPERADMIN'),
  (1002,'ADMINISTRATOR'),
  (1003,'ACCOUNTANT');
   
INSERT  INTO `user_tbl`(`user_id`,`username`,`password`) VALUES
  (2001,'admin','21232f297a57a5a743894a0e4a801fc3'), /*admin*/
  (2002,'administrator','21232f297a57a5a743894a0e4a801fc3'), /*admin*/
  (2003,'accountant','21232f297a57a5a743894a0e4a801fc3'); /*admin*/
   
INSERT  INTO `user_group_tbl`(`user_id`,`group_id`) VALUES 
  (2001,1001),(2001,1002),(2001,1003),(2002,1002),(2003,1003);