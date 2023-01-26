SELECT 
    m.`title`,
    CASE
        WHEN ma.rating <= 4 THEN 'poor'
        WHEN ma.rating <= 7 THEN 'good'
        ELSE 'excellent'
    END AS `rating`,
    IF(ma.`has_subtitles`, 'english', '-') AS subtitles,
    ma.`budget`
FROM
    `movies` AS m
        JOIN
    `movies_additional_info` AS ma ON m.`movie_info_id` = ma.`id`
ORDER BY ma.`budget` DESC;