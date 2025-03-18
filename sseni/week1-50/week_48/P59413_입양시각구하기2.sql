-- 코드를 입력하세요
WITH RECURSIVE CTE AS (SELECT 0 AS NUM
                       UNION ALL
                       SELECT NUM + 1
                       FROM CTE
                       WHERE NUM < 23)

SELECT CTE.NUM AS HOUR, IFNULL(ANIMAL_OUTS.COUNT, 0) AS COUNT
FROM CTE
         LEFT JOIN (SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
                    FROM ANIMAL_OUTS
                    GROUP BY HOUR) AS ANIMAL_OUTS
                   ON CTE.NUM = ANIMAL_OUTS.HOUR
ORDER BY HOUR;