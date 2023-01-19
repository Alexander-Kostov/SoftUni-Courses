DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(17,4), yearly_interest_rate DOUBLE(17,4), number_of_years INT)
RETURNS DECIMAL(17,4) 
DETERMINISTIC
BEGIN
DECLARE future_sum DECIMAL(17,4);
SET future_sum := initial_sum * POW(1 + yearly_interest_rate, number_of_years);
RETURN future_sum;
END$$
CREATE PROCEDURE usp_calculate_future_value_for_account(id INT, rate DOUBLE(17,4))
BEGIN
SELECT a.`id`, ah.`first_name`, ah.`last_name`, a.`balance` AS `current_balance`, ufn_calculate_future_value(a.`balance`, rate, 5) AS `balance_in_5_years`
FROM `accounts` as a
JOIN `account_holders` as ah 
ON ah.`id` = a.`account_holder_id`
WHERE a.`id` = id;
END$$

