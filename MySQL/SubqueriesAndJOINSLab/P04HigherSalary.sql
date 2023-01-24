SELECT count(*) 
FROM `employees` AS e1
WHERE e1.`salary` > (SELECT AVG(`salary`) FROM `employees`);