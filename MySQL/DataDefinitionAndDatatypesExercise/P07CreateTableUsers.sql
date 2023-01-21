CREATE TABLE `users` (
 `id` INT PRIMARY KEY AUTO_INCREMENT,
 `username` VARCHAR(30),
 `password` VARCHAR(26),
 `profile_picture` BLOB,
 `last_login_Time` TIMESTAMP,
 `is_deleted` BOOLEAN);
 
  INSERT INTO `users` (`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) 
 VALUES ('Ivan', 'Ivan1234', 'dsadsafa', '2022-01-11 14:19', FALSE);
  INSERT INTO `users` (`username`, `password`, `is_deleted`) 
 VALUES ('George', 'djdjsaldjajl', TRUE);
  INSERT INTO `users` (`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) 
 VALUES ('Alex', 'jdsdahdash', 'dsadsafa', '2022-01-11 14:26', FALSE);
 INSERT INTO `users` (`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) 
 VALUES ('Peter', 'safasfas', 'ds213321', '2022-01-11 14:25', FALSE);
 INSERT INTO `users` (`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) 
 VALUES ('Mark', 'ldsjaj12', 'dsamj123', '2022-05-11 14:19', FALSE);
 