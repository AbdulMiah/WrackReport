SET FOREIGN_KEY_CHECKS = 0;
USE `wrack-report`;
TRUNCATE TABLE `users`;
-- TRUNCATE TABLE `user_types`;
TRUNCATE TABLE `reports`;
TRUNCATE TABLE `metadata`;
TRUNCATE TABLE `media`;
TRUNCATE TABLE `categories`;
TRUNCATE TABLE `depth_categories`;


-- INSERT INTO `user_types`
-- VALUES(1, 'user');
-- INSERT INTO `user_types`
-- VALUES(2, 'admin');

INSERT INTO `users`
VALUES(NULL, 'ROLE_USER', 'john', 'jones', 'john@gmail.com', 01823445668, "$2a$10$g4qzJA3h7.7vTfcxrBtV6eaR9TyhP.C6wbKT8zmAPrbibHp8riw8C", true);
INSERT INTO `users`
VALUES(NULL, 'ROLE_ADMIN', 'admin', 'user', 'admin@gmail.com', null, "$2a$10$J.n9gEYayF9kTfQsqTT5u.KjH7JTpU57jImc1sX0/Em38kzHgTYoK", true);
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
VALUES (NULL, 3, 1, "Water is coming up from the drainage holes in the street", 6, 0.05, "52.422523, -3.554077", "2021-12-02  13:06:00", NULL);
INSERT INTO `reports`
VALUES (NULL, 4, 4, "Debris left behind from flooding yesterday", 6, 0.02, "51.496361, -3.186669", "2021-12-02  09:09:00", "cf24 4lr");
INSERT INTO `reports`
VALUES (NULL, 5, 5, "Huge flash flood in affecting the town. This is affecting travel and causing damage to homes", 3, 0.5, "52.047212, -3.958855", "2021-12-03  08:13:00", NULL);
INSERT INTO `reports`
VALUES (NULL, 6, 3, "Huge storm and waves last night. Some houses nearest to the sea have been damaged", 0.25, 0.3456, "52.251609, -4.229779", "2021-12-02  06:15:00", NULL);
INSERT INTO `reports`
VALUES (NULL, 7, 1, "Sewage drain unit near my house is bubbling and overflowing", 1, 0.3456, "51.856139, -4.290161", "2021-10-07  08:20:00", NULL);
INSERT INTO `reports`
VALUES (NULL, 8, 2, "River has completely overflowed and the flooding has reached the park", 1, 0.3456, "51.744038, -3.378296", "2021-11-29  14:17:00", NULL);
INSERT INTO `reports`
VALUES (NULL, 9, 4, "Lots of rubbish washed up near my shop from flood on 01/12/2021", 0, 0.3456, "51.500194, -3.562317", "2021-12-01  13:25:00", NULL);

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

INSERT INTO `metadata`
VALUES(NULL, NULL, NULL, NULL);
SET FOREIGN_KEY_CHECKS = 1;
