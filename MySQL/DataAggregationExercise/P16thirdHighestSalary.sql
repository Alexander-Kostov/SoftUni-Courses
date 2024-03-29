SELECT DISTINCT e.`department_id`,
	(
     SELECT DISTINCT e2.`salary` FROM `employees` AS `e2`
     WHERE e2.`department_id` = e.`department_id`
     ORDER BY e2.`salary` DESC
     LIMIT 1 OFFSET 2
    ) AS `ths`
FROM `employees` AS e
GROUP BY e.`department_id`
HAVING `ths` IS NOT NULL
ORDER BY e.`department_id`;
