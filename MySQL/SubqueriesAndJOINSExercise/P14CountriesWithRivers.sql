SELECT c.`country_name`, r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` as cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON r.`id` = cr.`river_id`
WHERE `continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5