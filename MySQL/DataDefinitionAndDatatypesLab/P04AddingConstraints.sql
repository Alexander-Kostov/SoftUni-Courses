ALTER TABLE `products` 
ADD CONSTRAINT `fk_id_p_c`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);