CREATE DATABASE `Car_Rental_Database`;

USE `Car_Rental_Database`;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(50) NOT NULL,
`daily_rate` INT,
`weekly_rate` INT,
`monthly_rate` INT,
`weekend_rate` INT);

INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`) VALUES ('sport', 5, 5, 5, 5);
INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`) VALUES ('sedan', 2, 2, 2, 2);
INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`) VALUES ('coupe', 3, 3, 3, 5);

CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(10),
`make` VARCHAR(20),
`model` VARCHAR(30),
`car_year` INT,
`category_id` INT,
`doors` INT(1),
`picture` BLOB,
`car_condition` VARCHAR(30),
`available` BOOLEAN);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`, `picture`, `car_condition`, `available`)
VALUES ('CA 4422 CB', 'lambo', 'huracan', 2016, 1, 2, 'dsadasd', 'excellent', TRUE);
INSERT INTO `cars` (`plate_number`, `make`, `category_id`, `available`) VALUES ('PA 4545 CB', 'lambo', 2, TRUE);
INSERT INTO `cars` (`plate_number`, `make`, `category_id`, `available`) VALUES ('BA 7373 CV', 'lambo', 3, FALSE);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`title` VARCHAR(20),
`notes` TEXT); 

INSERT INTO `employees` (`first_name`, `last_name`, `title`, `notes`) VALUES ('Alex', 'Rogers', 'director', 'motivated person');
INSERT INTO `employees` (`first_name`, `last_name`, `title`, `notes`) VALUES ('Tom', 'Murdock', 'actor', 'active person');
INSERT INTO `employees` (`first_name`, `last_name`, `title`, `notes`) VALUES ('Oliver', 'Merlyn', 'maintance', 'lazy');

CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_license_number` INT,
`full_name` VARCHAR(50),
`adress` VARCHAR(50),
`city` VARCHAR(20),
`zip_code` INT(4),
`notes` TEXT);

INSERT INTO `customers` (`driver_license_number`, `full_name`, `adress`, `city`, `zip_code`, `notes`) VALUES (4432453, 'Tom Bodwick', 'Marshal Street', 'Sofia', 1000, 'good driver');
INSERT INTO `customers` (`driver_license_number`, `full_name`) VALUES (4437893, 'Alex Murdock');
INSERT INTO `customers` (`driver_license_number`, `full_name`) VALUES (2372846, 'Bill Cosby');

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(20),
`tank_level` VARCHAR(20),
`kilometrage_start` INT,
`kilometrage_end` INT,
`total_kilometrage` INT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` BOOLEAN,
`tax_rate` DOUBLE(4,2),
`order_status` VARCHAR(10),
`notes` TEXT);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`, `kilometrage_start`, `kilometrage_end`, `start_date`,
 `end_date`, `total_days`, `rate_applied`,`tax_rate`, `order_status`, `notes`) VALUES (1,1,1, 'Good', 'Full', 0, 240, '2022-07-07', '2022-07-17', 10, TRUE, 26.22, 'complete', 'all good');
 
INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `tank_level`, `kilometrage_start`, `start_date`, `tax_rate`)
 VALUES (2, 2, 2, 'HALF', 1000, '2022-01-01', 75.2);
 
 INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `tank_level`, `kilometrage_start`, `start_date`, `tax_rate`)
 VALUES (3, 3, 3, 'HALF', 1000, '2022-05-01', 71.2);







