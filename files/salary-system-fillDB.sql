use salary_system;

INSERT  INTO `department_tbl`(`department_id`,`name`) VALUES
  (2001,'ALL'),
  (2002,'отдел кадров'),
  (2003,'отдел продаж'); 

INSERT  INTO `user_tbl`(`username`,`password`,`department_id`) VALUES
  ('admin','admin',2001),
  ('account1','account',2002),
  ('account2','account',2003); 