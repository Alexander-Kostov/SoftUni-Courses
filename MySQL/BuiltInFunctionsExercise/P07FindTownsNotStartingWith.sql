SELECT * FROM `towns`
WHERE left(`name`, 1) NOT IN ('R', 'B', 'D')
ORDER BY `name`;