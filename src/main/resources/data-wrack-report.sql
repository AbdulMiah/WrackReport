SET FOREIGN_KEY_CHECKS = 0;
USE `wrack-report`;
TRUNCATE TABLE `users`;
TRUNCATE TABLE `user_types`;
TRUNCATE TABLE `reports`;
TRUNCATE TABLE `metadata`;
TRUNCATE TABLE `media`;
TRUNCATE TABLE `categories`;
TRUNCATE TABLE `depth_categories`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user_types`
VALUES(1, 'user');
INSERT INTO `user_types`
VALUES(2, 'admin');

INSERT INTO `users`
VALUES(NULL, 1, 'john', 'jones', 'john@gmail.com', 01823445668, null);
INSERT INTO `users`
VALUES(NULL, 2, 'admin', 'user', 'admin@gmail.com', null, "pass");

INSERT INTO `categories`
VALUES(NULL, 'sewer flooding'); 
INSERT INTO `categories`
VALUES(NULL, 'river flooding');
INSERT INTO `categories`
VALUES(NULL, 'coastal flooding');
INSERT INTO `categories`
VALUES(NULL, 'debris');
INSERT INTO `categories`
VALUES(NULL, 'flash flooding');
INSERT INTO `categories`
VALUES(NULL, 'N/A');

INSERT INTO `depth_categories`
VALUES(NULL, 'Up to ground socket');
INSERT INTO `depth_categories`
VALUES(NULL, 'Up to my ankles');
INSERT INTO `depth_categories`
VALUES(NULL, 'Up to my knees');
INSERT INTO `depth_categories`
VALUES(NULL, 'Up to my chest');
INSERT INTO `depth_categories`
VALUES(NULL, 'Up to my light switch');
INSERT INTO `depth_categories`
VALUES(NULL, 'Other');
