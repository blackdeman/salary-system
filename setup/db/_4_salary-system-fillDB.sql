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

INSERT  INTO `employee_tbl`(`employee_id`,`surname`,`name`,`patronymic`,`address`,
							`post`,`payway`,`department_id`) VALUES
  (3001,'surname1','name1','patronymic1','address1','post1',1,2001),
  (3002,'surname2','name2','patronymic2','address2','post2',1,2002),
  (3003,'surname3','name3','patronymic3','address3','post3',1,2001),
  (3004,'surname4','name4','patronymic4','address4','post4',1,2002);