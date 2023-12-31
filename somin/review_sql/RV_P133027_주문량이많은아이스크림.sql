
SELECT F.FLAVOR -- #, SUM(F.TOTAL_ORDER+J.TOTAL_ORDER) AS SUM
FROM FIRST_HALF AS F JOIN (SELECT FLAVOR, SUM(J.TOTAL_ORDER) AS J_SUM FROM JULY AS J GROUP BY FLAVOR) AS A
ON F.FLAVOR = A.FLAVOR
GROUP BY F.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER+ A.J_SUM) DESC
LIMIT 3
