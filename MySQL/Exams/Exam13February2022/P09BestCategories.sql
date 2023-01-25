SELECT count(p.`id`) as `items_count`, c.`name`, sum(`quantity_in_stock`) as `total_quantity` 
FROM `products` as p
JOIN `categories` as c 
ON c.`id` = p.`category_id`
GROUP BY p.`category_id`
ORDER BY `items_count` DESC, `total_quantity`
LIMIT 5;