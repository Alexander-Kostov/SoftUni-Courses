DELIMITER $$
CREATE PROCEDURE udp_award_movie (`movie_title` VARCHAR(50))
BEGIN
UPDATE `actors` as a
JOIN `movies_actors` as ma ON ma.`actor_id` = a.`id`
JOIN `movies` as m ON m.`id` = ma.`movie_id`
SET `awards` = `awards` + 1
WHERE m.`title` = `movie_title`;
END$$