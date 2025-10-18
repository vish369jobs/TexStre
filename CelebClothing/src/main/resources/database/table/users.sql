CREATE TABLE `user_details` (
  `iduser_details` int NOT NULL AUTO_INCREMENT,
  `user_type` varchar(45) DEFAULT NULL,
  `contact_num` int DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `profile_pic_url` varchar(100) DEFAULT NULL,
  `gender` enum('Male','Female','Other') DEFAULT NULL,
  `email_id` varchar(60) DEFAULT NULL,
  `is_valid` tinyint NOT NULL DEFAULT '1',
  `botiqs_followed` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser_details`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci