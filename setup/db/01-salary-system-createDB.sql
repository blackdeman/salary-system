SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema salary_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `salary_system` DEFAULT CHARACTER SET cp1251 COLLATE cp1251_general_ci ;
USE `salary_system` ;

-- -----------------------------------------------------
-- Table `salary_system`.`DEPARTMENT_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`DEPARTMENT_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`DEPARTMENT_TBL` (
  `department_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salary_system`.`ROLE_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`ROLE_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`ROLE_TBL` (
  `role_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salary_system`.`USER_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`USER_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`USER_TBL` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  `department_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`username`),
  INDEX `fk_USER_TBL_DEPARTMENT_TBL1_idx` (`department_id` ASC),
  INDEX `fk_USER_TBL_ROLE_TBL1_idx` (`role_id` ASC),
  CONSTRAINT `fk_USER_TBL_DEPARTMENT_TBL1`
    FOREIGN KEY (`department_id`)
    REFERENCES `salary_system`.`DEPARTMENT_TBL` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_TBL_ROLE_TBL1`
    FOREIGN KEY (`role_id`)
    REFERENCES `salary_system`.`ROLE_TBL` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salary_system`.`EMPLOYEE_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`EMPLOYEE_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`EMPLOYEE_TBL` (
  `employee_id` INT NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NOT NULL,
  `address` VARCHAR(60) NULL,
  `post` VARCHAR(45) NULL,
  `payway` INT NOT NULL,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`employee_id`),
  INDEX `fk_EMPLOYEE_TBL_DEPARTMENT_TBL1_idx` (`department_id` ASC),
  CONSTRAINT `fk_EMPLOYEE_TBL_DEPARTMENT_TBL1`
    FOREIGN KEY (`department_id`)
    REFERENCES `salary_system`.`DEPARTMENT_TBL` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salary_system`.`CARD_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`CARD_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`CARD_TBL` (
  `employee_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `hours` INT NOT NULL DEFAULT 0,
  `rate_per_hour` DECIMAL(20) NOT NULL,
  PRIMARY KEY (`employee_id`, `date`),
  CONSTRAINT `fk_CARD_TBL_EMPLOYEE_TBL1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `salary_system`.`EMPLOYEE_TBL` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salary_system`.`PAYMENT_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`PAYMENT_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`PAYMENT_TBL` (
  `employee_id` INT NOT NULL,
  `month_year` DATE NOT NULL,
  `salary` DECIMAL(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`employee_id`, `month_year`),
  CONSTRAINT `fk_PAYMENT_TBL_EMPLOYEE_TBL1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `salary_system`.`EMPLOYEE_TBL` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `salary_system`.`REPORT_TBL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `salary_system`.`REPORT_TBL` ;

CREATE TABLE IF NOT EXISTS `salary_system`.`REPORT_TBL` (
  `report_id` INT NOT NULL,
  `report_name` VARCHAR(45) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `average_salary` DECIMAL(20) NOT NULL DEFAULT 0,
  `department_id` INT NOT NULL,
  PRIMARY KEY (`report_id`),
  INDEX `fk_REPORT_TBL_DEPARTMENT_TBL1_idx` (`department_id` ASC),
  CONSTRAINT `fk_REPORT_TBL_DEPARTMENT_TBL1`
    FOREIGN KEY (`department_id`)
    REFERENCES `salary_system`.`DEPARTMENT_TBL` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `salary_system` ;

-- -----------------------------------------------------
-- View `salary_system`.`user_role_view`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `salary_system`.`user_role_view` ;
USE `salary_system`;
CREATE  OR REPLACE VIEW `user_role_view` AS
    select 
        `salary_system`.`USER_TBL`.`username` AS `username`,
        `salary_system`.`USER_TBL`.`password` AS `password`,
        `salary_system`.`ROLE_TBL`.`name` AS `rolename`
    from
        `salary_system`.`USER_TBL`
            join
        `salary_system`.`ROLE_TBL` ON `salary_system`.`USER_TBL`.`role_id` = `salary_system`.`ROLE_TBL`.`role_id`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
