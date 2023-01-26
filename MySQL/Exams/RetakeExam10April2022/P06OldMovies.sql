SELECT ma.`id`, m.`title`, ma.`runtime`, ma.`budget`, ma.`release_date` 
FROM `movies_additional_info` as ma
JOIN `movies` as m ON m.`movie_info_id` = ma.`id`
WHERE YEAR(`release_date`) >= 1996 AND YEAR(`release_date`) <= 1999
ORDER BY ma.`runtime`, ma.`id`
LIMIT 20;
