#ALTER TABLE `towns` RENAME COLUMN `town_id` TO `id`;

ALTER TABLE `minions`ADD COLUMN `town_id` INT NOT NULL;
ALTER TABLE `minions`
ADD CONSTRAINT `fk_id_m_t`
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`);

