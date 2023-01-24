SELECT `employee_id`, concat_ws(' ', `first_name`, `last_name`) AS `full_name`, d.department_id, d.name
FROM `employees` as e
JOIN `departments` as d
ON e.employee_id = d.manager_id
ORDER BY `employee_id`
LIMIT 5;