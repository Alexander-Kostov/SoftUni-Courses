DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50)) 
RETURNS INT 
DETERMINISTIC
BEGIN
DECLARE `history_movies_count` INT;
SET `history_movies_count` := (
SELECT count(a.`id`)
 FROM `actors` as a
 JOIN `movies_actors` as ma
 ON a.`id` = ma.`actor_id`
 JOIN `movies` as m ON m.`id` = ma.`movie_id`
 JOIN `genres_movies` as gm ON gm.`movie_id` = m.`id`
 JOIN  `genres` as g ON gm.`genre_id` = g.`id`
 WHERE concat_ws(' ', `first_name`, `last_name`) = `full_name` AND g.`name` = 'history'
);
RETURN `history_movies_count`;
END$$