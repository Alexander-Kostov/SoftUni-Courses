SELECT e.`employee_id`, e.`first_name`, p.`name` AS `project_name`
FROM `employees` as e
JOIN `employees_projects` as ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` as p
ON p.`project_id` = ep.`project_id`
WHERE DATE(p.`start_date`) >= '2002-08-13' AND p.`end_date` IS NULL
ORDER BY e.`first_name` ASC, p.`name` ASC
LIMIT 5;