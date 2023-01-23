SELECT avg(`salary`) AS `min_avg_salary`FROM `employees`
GROUP BY `department_id`
ORDER BY `min_avg_salary` ASC
LIMIT 1;