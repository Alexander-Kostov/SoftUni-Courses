SELECT `deposit_group`, `magic_wand_creator`, min(`deposit_charge`) AS `deposit_charge`
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator`, `deposit_group`
