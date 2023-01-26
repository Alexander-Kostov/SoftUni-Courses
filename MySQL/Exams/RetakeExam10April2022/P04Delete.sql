DELETE c
FROM `countries` as c
LEFT JOIN `movies` as m
ON c.`id` = m.`country_id`
WHERE m.`country_id` IS NULL;