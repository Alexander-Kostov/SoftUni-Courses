SELECT `continent_code`, `currency_code`, count(`currency_code`) as `currency_usage`
FROM `countries` as c1
GROUP BY `continent_code`, `currency_code`
HAVING `currency_usage` = (
SELECT count(`currency_code`) as `most_currency`
FROM `countries` AS c2
WHERE c2.`continent_code` = c1.`continent_code`
GROUP BY `currency_code`
ORDER BY `most_currency` DESC
LIMIT 1) AND `currency_usage` > 1
ORDER BY c1.`continent_code`, c1.`currency_code`
