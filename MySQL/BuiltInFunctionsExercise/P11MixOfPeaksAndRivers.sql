SELECT peaks.peak_name, rivers.river_name, 
lower(concat(peaks.peak_name, Substring(rivers.river_name, 2))) AS `mix`
FROM `peaks`
INNER JOIN `rivers`
WHERE right(peak_name, 1) = left(river_name, 1)
ORDER BY `mix`; 
