-- 코드를 작성해주세요
SELECT COUNT(LE) AS FISH_COUNT, MAX(LE) AS MAX_LENGTH, FISH_TYPE 
FROM 
(
    SELECT IFNULL(LENGTH, 10) AS LE, FISH_TYPE
    FROM FISH_INFO 
) B
GROUP BY FISH_TYPE
HAVING AVG(LE) >= 33
ORDER BY FISH_TYPE