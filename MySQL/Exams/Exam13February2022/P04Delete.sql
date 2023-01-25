DELETE c FROM `customers` as c
LEFT JOIN `orders` as o ON c.`id` = o.`customer_id`
WHERE `customer_id` IS NULL;