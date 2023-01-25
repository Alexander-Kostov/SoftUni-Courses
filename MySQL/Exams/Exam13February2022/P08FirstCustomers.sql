SELECT concat_ws(' ', c.`first_name`, c.`last_name`) AS `full_name`, c.`address`, o.`order_datetime`
FROM `customers` as c
JOIN `orders` as o ON c.`id` = o.`customer_id`
WHERE YEAR(`order_datetime`) <= 2018
ORDER BY `full_name` DESC;