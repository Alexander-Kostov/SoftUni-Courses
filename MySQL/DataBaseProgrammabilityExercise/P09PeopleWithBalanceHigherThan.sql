DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(`number` DECIMAL(19,4))
BEGIN
SELECT ah.`first_name`, ah.`last_name`
FROM `account_holders` as ah
LEFT JOIN `accounts` as a
ON ah.`id` = a.`account_holder_id`
GROUP BY ah.`first_name`, ah.`last_name`
HAVING sum(a.`balance`) > `number`;
END$$ 
