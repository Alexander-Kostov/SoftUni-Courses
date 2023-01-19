DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(starting_symbols VARCHAR(20))
BEGIN
SELECT `name`
FROM `towns`
WHERE lower(`name`) LIKE lower(concat (starting_symbols, '%'))
ORDER BY `name`;
END$$
