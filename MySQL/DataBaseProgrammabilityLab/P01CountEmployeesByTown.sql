DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INT 
DETERMINISTIC
BEGIN
DECLARE e_count INT;
SET e_count := (SELECT COUNT(*) FROM `employees` as e
JOIN `addresses` as a
USING (`address_id`)
JOIN `towns` as t
USING (`town_id`)
WHERE t.`name` = town_name
GROUP BY t.`name`);
RETURN e_count;
END$$



