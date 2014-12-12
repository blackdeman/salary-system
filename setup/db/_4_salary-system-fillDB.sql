USE `salary_system`;

INSERT  INTO `department_tbl`(`department_id`,`name`) VALUES
  (2001,'personnel department'),
  (2002,'sales department'); 

INSERT  INTO `role_tbl`(`role_id`,`name`) VALUES
  (1001,'admin'),
  (1002,'accountant'); 

INSERT  INTO `user_tbl`(`username`,`password`,`role_id`) VALUES
  ('admin','admin',1001);

INSERT  INTO `user_tbl`(`username`,`password`,`role_id`,`department_id`) VALUES
  ('account1','account',1002,2001),
  ('account2','account',1002,2002);