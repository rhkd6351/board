CREATE TABLE `board`.`posts` (
                                 `post_id` INT NOT NULL AUTO_INCREMENT,
                                 `title` VARCHAR(100) NOT NULL,
                                 `content` VARCHAR(1000) NOT NULL,
                                 `reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `mod_date` DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
                                 `read_count` INT NOT NULL DEFAULT 0,
                                 PRIMARY KEY (`post_id`));
