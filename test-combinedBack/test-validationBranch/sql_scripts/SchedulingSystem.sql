CREATE DATABASE  IF NOT EXISTS `scheduling_system`;
USE `scheduling_system`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `teacher`;
DROP TABLE IF EXISTS `lesson`;
DROP TABLE IF EXISTS `lesson_centre`;
DROP TABLE IF EXISTS `request`;
DROP TABLE IF EXISTS `user_contacts`;
DROP TABLE IF EXISTS `messages`;

CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `identifiernumber` varchar(45) NOT NULL,
                         `first` varchar(45) DEFAULT NULL,
                         `last` varchar(45) DEFAULT NULL,
                         `pwd` varchar(45) DEFAULT NULL,
                         `enabled` tinyint NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `authorities` (

                               `id` int NOT NULL AUTO_INCREMENT,
                               `identifiernumber` varchar(45) NOT NULL,
                               `authority` varchar(45) DEFAULT NULL,

                               UNIQUE KEY `authorities_idx_1` (`id`, `identifiernumber`, `authority`),

                               CONSTRAINT `authorities_ibfk_1`
                                   FOREIGN KEY (`id`)
                                       REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `student` (

                           `id` int NOT NULL AUTO_INCREMENT,
                           `snum` varchar(60) DEFAULT NULL,
                           `first` varchar(45) DEFAULT NULL,
                           `last` varchar(45) DEFAULT NULL,
                           `address` varchar(60) DEFAULT NULL,
                           `pcode` varchar(10) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           `played` varchar(255) DEFAULT NULL,
                           `experience` varchar(45) DEFAULT NULL,
                           `yob` DATE DEFAULT NULL, -- Changed from VARCHAR(4) to DATE
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `teacher` (

                           `id` int NOT NULL AUTO_INCREMENT,
                           `teachernum` varchar(60) DEFAULT NULL,
                           `first` varchar(45) DEFAULT NULL,
                           `last` varchar(45) DEFAULT NULL,
                           `address` varchar(60) DEFAULT NULL,
                           `postcode` varchar(10) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           `instruments` varchar(255) DEFAULT NULL,
                           `starttime` varchar(45) DEFAULT NULL,
                           `endtime` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `lesson` (

                          `id` int NOT NULL AUTO_INCREMENT,
                          `lessonnum` varchar(60) DEFAULT NULL,
                          `snum` varchar(45) DEFAULT NULL,
                          `tnum` varchar(45) DEFAULT NULL,
                          `centrenum` varchar(45) DEFAULT NULL,
                          `starttime` varchar(60) DEFAULT NULL,
                          `endtime` varchar(10) DEFAULT NULL,
                          `roomnumber` varchar(10) DEFAULT NULL,
                          `date` varchar(255) DEFAULT NULL,
                          `dayofweek` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `lesson_centre` (

                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `city` varchar(60) DEFAULT NULL,
                                 `phonnum` varchar(45) DEFAULT NULL,
                                 `email` varchar(45) DEFAULT NULL,
                                 `address` varchar(45) DEFAULT NULL,
                                 `postcode` varchar(60) DEFAULT NULL,
                                 `numofrooms` int DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=latin1;

CREATE TABLE `request` (

                           `id` int NOT NULL AUTO_INCREMENT,
                           `identificationnumber` varchar(60) DEFAULT NULL,
                           `message` varchar(45) DEFAULT NULL,
                           `status` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `user_contacts` (

                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `identifiernumber` varchar(45) NOT NULL,
                                 `contact_id_num` varchar(45) NOT NULL,
                                 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `messages` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `sender_id` varchar(60) DEFAULT NULL,
                            `recipient_id` varchar(45) DEFAULT NULL,
                            `msg` varchar(45) DEFAULT NULL,
                            `time_stamp` TIMESTAMP,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=latin1;



INSERT INTO `users` VALUES
    (NULL, 'A1','momo', 'momo', 'admin', 1);

INSERT INTO `authorities` VALUES
    (NULL, 'A1', 'ADMIN') ;

INSERT INTO `student` VALUES
    (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO `teacher` VALUES
    (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
