SELECT c.id AS `driver_id`, v.vehicle_type, 
concat(`first_name`, ' ', `last_name`) AS `driver_name`
FROM `campers` AS c
Join `vehicles` AS v
ON v.driver_id = c.id;


