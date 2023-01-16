SELECT replace(`title`, 'The', '***')
AS `Title`
FROM `books`
WHERE substring(`title`, 1, 3) = 'The';