SELECT 
    CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`,
    CONCAT(REVERSE(`last_name`),
            LENGTH(`last_name`),
            '@cast.com') AS `email`,
    2022 - YEAR(`birthdate`) AS `age`,
    `height`
FROM
    `actors` AS a
        LEFT JOIN
    `movies_actors` AS m ON a.`id` = m.`actor_id`
WHERE
    m.`actor_id` IS NULL
ORDER BY `height`;
    