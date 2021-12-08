SET FOREIGN_KEY_CHECKS = 0;
USE `wrack-report`;
TRUNCATE TABLE `users`;
-- TRUNCATE TABLE `user_types`;
TRUNCATE TABLE `reports`;
TRUNCATE TABLE `metadata`;
TRUNCATE TABLE `media`;
TRUNCATE TABLE `categories`;
TRUNCATE TABLE `depth_categories`;
TRUNCATE TABLE `staff_users`;


INSERT INTO `staff_users`
VALUES(NULL, 'ROLE_STAFF', 'john', 'jones', 'john@gmail.com', "$2a$10$g4qzJA3h7.7vTfcxrBtV6eaR9TyhP.C6wbKT8zmAPrbibHp8riw8C", true);
INSERT INTO `staff_users`
VALUES(NULL, 'ROLE_ADMIN', 'admin', 'user', 'admin@gmail.com', "$2a$10$J.n9gEYayF9kTfQsqTT5u.KjH7JTpU57jImc1sX0/Em38kzHgTYoK", true);

INSERT INTO `users`
VALUES(3, 'ROLE_USER', 'John', 'Barnes', 'barnsey@gmail.com', "07888774635", NULL, true);
INSERT INTO `users`
VALUES(4, 'ROLE_USER', 'Stephen', "O'Keefe", 'stephen@gmail.com', NULL, NULL, true);
INSERT INTO `users`
VALUES(5, 'ROLE_USER', 'Sarah', 'Cross', 'sazcross@gmail.com', "07885746715", NULL, true);
INSERT INTO `users`
VALUES(6, 'ROLE_USER', 'Graham', 'Barker', 'gbarker@gmail.com', NULL, NULL, true);
INSERT INTO `users`
VALUES(7, 'ROLE_USER', 'Clare', 'Jones', 'clare_jones@gmail.com', NULL, NULL, true);
INSERT INTO `users`
VALUES(8, 'ROLE_USER', 'Tom', 'Brent', 'tombrent123@gmail.com', NULL, NULL, true);
INSERT INTO `users`
VALUES(9, 'ROLE_USER', 'Terry', 'Tibbs', 'thetibbs@gmail.co.uk', "07678874514", NULL, true);
INSERT INTO `users`
VALUES(12, 'ROLE_USER', 'Tommy', 'Taylor', 'tommyt@gmail.com', NULL, NULL, true);
INSERT INTO `users`
VALUES(13, 'ROLE_USER', 'Gemma', 'Banks', 'gbanks123@gmail.com', "07745667689", NULL, true);
INSERT INTO `users`
VALUES(14, 'ROLE_USER', 'John', 'Jenkins', 'jenkins_j@gmail.com', NULL, NULL, true);
INSERT INTO `users`
VALUES(15, 'ROLE_USER', 'Stacey', 'Chapman', 'staceyc@gmail.co.uk', "07665489765", NULL, true);
INSERT INTO `users`
VALUES(16, 'ROLE_USER', 'Steve', 'Wallace', 'swalls7@gmail.com', NULL, NULL, true);

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
VALUES (NULL, 3, 1, "Water is coming up from the drainage holes in the street", 6, 0.05, "52.422523, -3.554077", "2021-12-02  13:06:00", NULL, "Powys");
INSERT INTO `reports`
VALUES (NULL, 4, 4, "Debris left behind from flooding yesterday", 6, 0.02, "51.496361, -3.186669", "2021-12-02  09:09:00", "cf24 4lr", "Cardiff");
INSERT INTO `reports`
VALUES (NULL, 5, 5, "Huge flash flood in affecting the town. This is affecting travel and causing damage to homes", 3, 0.5, "52.047212, -3.958855", "2021-12-03  08:13:00", NULL, "Carmarthenshire");
INSERT INTO `reports`
VALUES (NULL, 6, 3, "Huge storm and waves last night. Some houses nearest to the sea have been damaged", 0.25, 0.3456, "52.251609, -4.229779", "2021-12-02  06:15:00", NULL, "Ceredigion");
INSERT INTO `reports`
VALUES (NULL, 7, 1, "Sewage drain unit near my house is bubbling and overflowing", 1, 0.3456, "51.856139, -4.290161", "2021-10-07  08:20:00", NULL, "Carmarthenshire");
INSERT INTO `reports`
VALUES (NULL, 8, 2, "River has completely overflowed and the flooding has reached the park", 1, 0.3456, "51.744038, -3.378296", "2021-11-29  14:17:00", NULL, "Merthyr Tydfil");
INSERT INTO `reports`
VALUES (NULL, 9, 4, "Lots of rubbish washed up near my shop from flood on 01/12/2021", 0, 0.3456, "51.500194, -3.562317", "2021-12-01  13:25:00", NULL, "Bridgend");
INSERT INTO `reports`
VALUES (NULL, 12, 4, "Plastic waste left behind after flooding", 6, 0, "53.131942, -4.265442", "2021-11-29  19:50:00", NULL, "Gwynedd");
INSERT INTO `reports`
VALUES (NULL, 13, 5, "Very bad flooding from storm", 2, 0.25, "52.218966, -3.931732", "2021-10-13  13:00:00", NULL, "Ceredigion");
INSERT INTO `reports`
VALUES (NULL, 14, 4, "Debris washed up from river", 6, 0.05, "52.14908, -3.413315", "2021-09-09  14:00:00", NULL, "Powys");
INSERT INTO `reports`
VALUES (NULL, 15, 1, "Sewer flooding - drains in street are overflowed", 1, 0.1, "52.717163, -3.696899", "2021-11-11  19:00:00", NULL, "Gwynedd");
INSERT INTO `reports`
VALUES (NULL, 16, 3, "Coastal flooding has reached some holiday homes on the beach", 3, 0.5, "51.650061, -4.761457", "2021-06-16  06:00:00", NULL, "Pembrokeshire");

INSERT INTO `media`
VALUES(NULL, 7, NULL, "debris", 1, "./test-data/LLFE0kQn10CVS9DaK7nu.jpeg");
INSERT INTO `media`
VALUES(NULL, 9, NULL, "waves from yesterday", 1, "./test-data/aShY7z8oejsIAhpgdFAz.jpg");
INSERT INTO `media`
VALUES(NULL, 10, NULL, "Sewer flood", 2, "./test-data/hL8SHyamFZVsWeXmbdqG.mp4");
INSERT INTO `media`
VALUES(NULL, 11, NULL, "trees in water", 1, "./test-data/HhRPnadTeS7diuaxW4jW.jpg");
INSERT INTO `media`
VALUES(NULL, 11, NULL, "benches partly covered", 1, "./test-data/2mh7Yyq5mB2Hx75BFofV.jpg");
INSERT INTO `media`
VALUES(NULL, 12, NULL, "rubbish", 1, "./test-data/qW1t93BTJD4jyv7zDqtk.jpg");
INSERT INTO `media`
VALUES(NULL, 13, NULL, "coastal flooding", 1, "./test-data/2imVP6Sy5shUMUBoTOiH.jpg");



INSERT INTO `metadata`
VALUES(NULL, NULL, NULL, NULL);
SET FOREIGN_KEY_CHECKS = 1;
