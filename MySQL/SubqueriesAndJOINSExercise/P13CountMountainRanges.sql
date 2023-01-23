SELECT c.`country_code`, count(`mountain_range`) AS `mountain_range`
FROM `countries` AS c
JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`
JOIN `mountains` AS m
ON mc.`mountain_id` = m.`id`
GROUP BY `country_code`
HAVING c.`country_code` IN ('BG', 'RU', 'US')
ORDER BY `mountain_range` DESC