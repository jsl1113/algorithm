-- 코드를 작성해주세요
WITH RECURSIVE RC AS (
    SELECT ID, PARENT_ID, 1 GEN 
    FROM ECOLI_DATA A
    WHERE PARENT_ID IS NULL
    UNION ALL
    
    SELECT A.ID, A.PARENT_ID, GEN+1 AS GEN
    FROM ECOLI_DATA A JOIN RC B 
    ON A.PARENT_ID = B.ID
    
)

SELECT COUNT(R.ID) AS "COUNT", R.GEN AS "GENERATION"
FROM RC R LEFT JOIN ECOLI_DATA E 
ON R.ID = E.PARENT_ID
WHERE E.PARENT_ID IS NULL
GROUP BY GENERATION
ORDER BY GENERATION