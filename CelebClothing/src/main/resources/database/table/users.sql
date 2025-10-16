CREATE TABLE `texstre_schema`.`user_details` (
  `iduser_details` INT NOT NULL,
  `user_type` VARCHAR(45) NULL,
  `contact_num` INT NULL,
  `user_name` VARCHAR(50) NULL,
  `profile_pic_url` VARCHAR(100) NULL,
  `gender` ENUM('Male', 'Female', 'Other') NULL,
  `email_id` VARCHAR(60) NULL,
  `is_valid` TINYINT NULL,
  `botiqs_followed` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser_details`));