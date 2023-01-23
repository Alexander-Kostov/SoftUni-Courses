SELECT c.`country_code`, `mountain_range`, `peak_name`, `elevation`
FROM `countries` as c
JOIN `mountains_countries` as mc
ON c.`country_code` = mc.`country_code`
JOIN `mountains` AS m
ON mc.`mountain_id` = m.`id`
JOIN `peaks` AS p
ON m.`id` = p.`mountain_id`
WHERE c.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY `elevation` DESC;
