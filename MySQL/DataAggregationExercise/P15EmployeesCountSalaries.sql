SELECT count(`employee_id`)
FROM `employees`
WHERE `manager_id` is NULL;