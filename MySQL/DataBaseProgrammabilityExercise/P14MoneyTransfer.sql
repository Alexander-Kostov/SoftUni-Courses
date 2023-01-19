DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF (amount <= 0) OR (SELECT count(`id`) FROM `accounts` WHERE `id` = from_account_id) <> 1 OR (SELECT count(`id`) FROM `accounts` WHERE `id` = to_account_id) <> 1
OR (SELECT `balance` FROM `accounts` WHERE `id` = from_account_id) <= amount OR (from_account_id = to_account_id) 
THEN ROLLBACK;
ELSE UPDATE `accounts`
SET `balance` = `balance` - amount
WHERE `id` = from_account_id;
UPDATE `accounts`
SET `balance` = `balance` + amount
WHERE `id` = to_account_id;
COMMIT;
END IF;
END$$

