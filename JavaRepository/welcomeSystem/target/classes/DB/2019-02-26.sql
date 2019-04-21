CREATE TABLE `welcomeSystem`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `department_id` VARCHAR(45) NULL,
  `profession_id` VARCHAR(45) NULL,
  `ispay` INT NULL,
  `tuition` INT NULL,
  `classroom_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `welcomeSystem`.`classroom` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `profession_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `welcomeSystem`.`new_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `department_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  ALTER TABLE `welcomeSystem`.`new_table` 
RENAME TO  `welcomeSystem`.`profession` ;

CREATE TABLE `welcomeSystem`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

