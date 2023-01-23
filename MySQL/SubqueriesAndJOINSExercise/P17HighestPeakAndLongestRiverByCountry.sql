SELECT 
    `country_name`,
    (SELECT 
            MAX(p.`elevation`)
        FROM
            `mountains_countries` AS mc
                LEFT JOIN
            `mountains` AS m ON mc.mountain_id = m.id
                LEFT JOIN
            `peaks` AS p ON m.`id` = p.`mountain_id`
        WHERE
            c1.`country_code` = country_code) AS `highest_peak_elevation`,
    (SELECT 
            MAX(r.`length`)
        FROM
            `countries_rivers` AS cr
                LEFT JOIN
            `rivers` AS r ON cr.`river_id` = r.`id`
        WHERE
            c1.`country_code` = cr.country_code) AS `longest_river_length`
FROM
    `countries` AS c1
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c1.`country_name`
LIMIT 5;
