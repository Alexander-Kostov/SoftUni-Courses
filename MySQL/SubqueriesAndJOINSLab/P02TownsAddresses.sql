SELECT t.`town_id`, t.`name`, a.`address_text`
FROM `addresses` as a
JOIN `towns` as t
ON t.`town_id` = a.`town_id`
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY `town_id`, `address_id`
