SET FOREIGN_KEY_CHECKS = 0;
USE `wrack-report`;
TRUNCATE TABLE `users`;
-- TRUNCATE TABLE `user_types`;
TRUNCATE TABLE `reports`;
TRUNCATE TABLE `metadata`;
TRUNCATE TABLE `media`;
TRUNCATE TABLE `categories`;
TRUNCATE TABLE `depth_categories`;
SET FOREIGN_KEY_CHECKS = 1;

-- INSERT INTO `user_types`
-- VALUES(1, 'user');
-- INSERT INTO `user_types`
-- VALUES(2, 'admin');

INSERT INTO `users`
VALUES(NULL, 'ROLE_USER', 'john', 'jones', 'john@gmail.com', 01823445668, "$2a$10$g4qzJA3h7.7vTfcxrBtV6eaR9TyhP.C6wbKT8zmAPrbibHp8riw8C", true);
INSERT INTO `users`
VALUES(NULL, 'ROLE_ADMIN', 'admin', 'user', 'admin@gmail.com', null, "$2a$10$J.n9gEYayF9kTfQsqTT5u.KjH7JTpU57jImc1sX0/Em38kzHgTYoK", true);

INSERT INTO `categories`
VALUES(NULL, 'Sewer flooding');
INSERT INTO `categories`
VALUES(NULL, 'River flooding');
INSERT INTO `categories`
VALUES(NULL, 'Coastal flooding');
INSERT INTO `categories`
VALUES(NULL, 'Debris');
INSERT INTO `categories`
VALUES(NULL, 'Flash flooding');
INSERT INTO `categories`
VALUES(NULL, 'N/A');

INSERT INTO `depth_categories`
VALUES(NULL, '10cm');
INSERT INTO `depth_categories`
VALUES(NULL, '25cm');
INSERT INTO `depth_categories`
VALUES(NULL, '50cm');
INSERT INTO `depth_categories`
VALUES(NULL, '1m');
INSERT INTO `depth_categories`
VALUES(NULL, '3m');
INSERT INTO `depth_categories`
VALUES(NULL, 'Other');

INSERT INTO `reports`
VALUES (NULL, 1, 2, "Overflowing river", 6, 0.5512, "53.0685, -4.0763", "2021-10-25 23:11:59", NULL);
INSERT INTO `reports`
VALUES (NULL, 1, 4, "A lot of debris", 6, 2.5464, "53.2801, -3.8256", "2021-5-15 20:01:09", NULL);
INSERT INTO `reports`
VALUES (NULL, 1, 6, "Car filled with water caused by flood", 2, 6.5464, "51.4822, -3.1812", "2021-08-25 18:23:43", NULL);
INSERT INTO `reports`
VALUES (NULL, 1, 5, "First floor on my house destroyed by flood", 5, 4.0544, "51.4846, -3.1853", "2021-01-05 17:30:11", NULL);
INSERT INTO `reports`
VALUES (NULL, 1, 1, "Sewer clogged. Flooding on street", 2, 0.3456, "51.4857, -3.1768", "2021-06-15 07:40:10", NULL);

INSERT INTO `metadata`
VALUES(NULL, NULL, NULL, NULL);
