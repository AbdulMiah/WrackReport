DROP DATABASE IF EXISTS `wrack-report`;
CREATE DATABASE IF NOT EXISTS `wrack-report`;
USE `wrack-report`;

CREATE TABLE `users` (
	`user_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
    `roles` VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(30) NOT NULL,
    `surname` VARCHAR(30) NOT NULL,
    `email` VARCHAR(75) NOT NULL,
    `phone_number` VARCHAR(15),
    `password` VARCHAR(100),
    `active` BOOLEAN,
    CONSTRAINT `PK_users` PRIMARY KEY (`user_id`)
); 

CREATE TABLE `staff_users` (
	`user_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
    `roles` VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(30) NOT NULL,
    `surname` VARCHAR(30) NOT NULL,
    `email` VARCHAR(75) NOT NULL,
    `password` VARCHAR(100),
    `active` BOOLEAN,
    CONSTRAINT `PK_staff_users` PRIMARY KEY (`user_id`)
); 

-- CREATE TABLE `user_types` (
-- 	`user_type_id` INT NOT NULL AUTO_INCREMENT,
--     `user_type` VARCHAR(45),
--     CONSTRAINT `PK_user_types` PRIMARY KEY (`user_type_id`)
-- );

CREATE TABLE `reports` (
	`report_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
    `user_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `description` VARCHAR(2500) NOT NULL,
    `depth_category_id` INT NOT NULL,
    `depth_meters` DECIMAL(6,4) NOT NULL,
    `lat_long` VARCHAR(50) NOT NULL,
    `datetime` DATETIME NOT NULL,
    `postcode` VARCHAR(15),
    `local_authority` VARCHAR(50) NOT NULL,
    `status` INT NOT NULL,
    CONSTRAINT `PK_reports` PRIMARY KEY (`report_id`)
);

CREATE TABLE `categories` (
	`category_id` INT NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(30),
    CONSTRAINT `PK_categories` PRIMARY KEY (`category_id`)
);

CREATE TABLE `depth_categories` (
	`depth_category_id` INT NOT NULL AUTO_INCREMENT,
    `depth_name` VARCHAR(30),
    CONSTRAINT `PK_depth_categories` PRIMARY KEY (`depth_category_id`)
);

CREATE TABLE `media` (
	`media_id` INT NOT NULL AUTO_INCREMENT,
    `report_id` INT,
    `metadata_id` INT,
    `title` VARCHAR(100) NOT NULL,
    `type` INT NOT NULL,
    `media_path` VARCHAR(500),
    CONSTRAINT `PK_media` PRIMARY KEY (`media_id`)
);

CREATE TABLE `metadata` (
	`metadata_id` INT NOT NULL AUTO_INCREMENT,
    `lat_long` VARCHAR(50),
    `elevation` VARCHAR(45),
    `datetime` DATETIME,
    CONSTRAINT `PK_metadata` PRIMARY KEY (`metadata_id`)
);

ALTER TABLE `reports`
ADD FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);

ALTER TABLE `reports`
ADD FOREIGN KEY (`category_id`) REFERENCES `categories`(`category_id`);

ALTER TABLE `reports`
ADD FOREIGN KEY (`depth_category_id`) REFERENCES `depth_categories`(`depth_category_id`);

ALTER TABLE `media`
ADD FOREIGN KEY (`report_id`) REFERENCES `reports`(`report_id`);

ALTER TABLE `media`
ADD FOREIGN KEY (`metadata_id`) REFERENCES `metadata`(`metadata_id`);

-- ALTER TABLE `users`
-- ADD FOREIGN KEY (`user_type_id`) REFERENCES `user_types`(`user_type_id`);

-- Views --

CREATE VIEW report_overview AS
SELECT r.report_id, r.datetime, c.category_name, r.depth_meters, r.postcode, r.local_authority, r.status
FROM reports r
INNER JOIN categories c
ON r.category_id = c.category_id;
-- SELECT * FROM report_overview;

CREATE VIEW detailed_report AS
SELECT r.report_id, r.datetime, r.local_authority, r.postcode, c.category_name, r.depth_meters, r.description, u.first_name, u.surname, u.email, u.phone_number
FROM reports r
INNER JOIN categories c
ON r.category_id = c.category_id
INNER JOIN users u
ON r.user_id = u.user_id;
-- SELECT * FROM detailed_report;