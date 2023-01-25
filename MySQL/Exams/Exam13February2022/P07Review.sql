SELECT * FROM `reviews` 
WHERE `content` LIKE 'My%' AND length(`content`) > 61
ORDER BY `rating` DESC;