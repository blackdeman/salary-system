CREATE VIEW `user_role_view` AS
    select 
        `salary_system`.`USER_TBL`.`username` AS `username`,
        `salary_system`.`USER_TBL`.`password` AS `password`,
        `salary_system`.`ROLE_TBL`.`name` AS `rolename`
    from
        `salary_system`.`USER_TBL`
            join
        `salary_system`.`ROLE_TBL` ON `salary_system`.`USER_TBL`.`role_id` = `salary_system`.`ROLE_TBL`.`role_id`