CREATE TABLE IF NOT EXISTS `patient` (
  `patientid` int AUTO_INCREMENT  PRIMARY KEY,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int AUTO_INCREMENT  PRIMARY KEY,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255)
);
