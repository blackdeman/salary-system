USE `salary_system` ;

CREATE TABLE `salary_system`.`users` (
`user_name` varchar(255) NOT NULL,
`user_pswd` varchar(255) DEFAULT NULL,
PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `salary_system`.`groups` (
`user_name` varchar(255) DEFAULT NULL,
`group_name` varchar(255) DEFAULT NULL)
ENGINE=InnoDB DEFAULT CHARSET=utf8; 
CREATE INDEX groups_users_FK1 ON groups(username ASC);
