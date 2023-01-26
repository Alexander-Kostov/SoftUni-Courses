SELECT c.`name`, count(m.`id`) as `movies_count`
FROM `movies` as m
LEFT JOIN `countries` as c ON m.`country_id` = c.`id`
GROUP BY m.`country_id`
HAVING `movies_count` >= 7
ORDER BY c.`name` DESC