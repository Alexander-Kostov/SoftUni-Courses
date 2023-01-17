SELECT DISTINCT left(`first_name`, 1)
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
ORDER BY `first_name`;