CREATE DATABASE Movies;

USE Movies;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT);

INSERT INTO `directors` (`director_name`, `notes`) VALUES ('George', 'test');
INSERT INTO `directors` (`director_name`) VALUES ('Dreagan');
INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Peter', 'test1234');
INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Tom', 'testing123');
INSERT INTO `directors` (`director_name`) VALUES ('Alex');

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT);

INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('Drama', 'Sad');
INSERT INTO `genres` (`genre_name`) VALUES ('Mystery');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('Comedy', 'Fun');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('Romance', 'Love');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('Action', 'Fighting');

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT); 

INSERT INTO `categories` (`category_name`) VALUES ('Action Drama');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('Action Mystery', 'Fighting with mysteries');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('Action Comedy', 'Fighting with laugh');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('Fantasy Romance', 'Romance combined with Fantasy');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('Action Horror', 'Action combined with frightening scenes');

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT,
`copyright_year` VARCHAR(4),
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` INT,
`notes` TEXT);


INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`) VALUES ('John Wick', 1, '2014', 101, 2, 1, 10, 'Action Movie');
INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`) VALUES ('Morbius', 2, 1999, 3320, 1, 2, 9, 'Fantasy');
INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`) VALUES ('Avatar', 3, 2000, 3240, 4, 3, 8, 'Fantasy');
INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`) VALUES ('Eternals', 4, 2020, 3205, 3, 4, 7, 'Action');
INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `genre_id`, `category_id`) VALUES ('TEST', 5, 2021, 5, 5);


