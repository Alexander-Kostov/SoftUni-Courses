SELECT `starting_point`, `end_point`, `leader_id`, 
concat_ws(' ', `first_name`, `last_name`) AS `leader_name`
FROM `routes` 
JOIN `campers` AS c
ON `leader_id` = c.`id`;