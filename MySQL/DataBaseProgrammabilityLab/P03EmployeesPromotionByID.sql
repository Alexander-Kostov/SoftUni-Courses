DELIMITER $$

CREATE PROCEDURE usp_raise_salary_by_id(id INT)  
BEGIN
	UPDATE employees
		SET salary = salary * 1.05
		WHERE employee_id = id;
	START TRANSACTION;
		IF((SELECT count(employee_id) FROM employees WHERE employee_id = id) <> 1) 
	THEN ROLLBACK;
    ELSE COMMIT;
	END IF;
END$$



