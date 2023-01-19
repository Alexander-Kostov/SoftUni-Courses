DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(30))
BEGIN
SELECT e.`first_name`, e.`last_name`
FROM `employees` as e
JOIN `addresses` as a USING(`address_id`)
JOIN `towns` as t USING (`town_id`)
WHERE t.`name` = town_name
ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
END$$