DELIMITER $$

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN 
UPDATE `employees` as e
JOIN `departments` as d
USING (`department_id`)
SET e.`salary` = e.`salary` * 1.05
WHERE d.`name` = department_name;
END$$

