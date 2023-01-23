SELECT e1.`employee_id`, e1.`first_name`, e1.`manager_id`, 
(SELECT e2.`first_name` 
FROM `employees` AS e2
WHERE e2.`employee_id` = e1.`manager_id`) AS `manager_name`
FROM `employees` AS e1
WHERE e1.`manager_id` IN (3,7)
ORDER BY e1.`first_name`;
