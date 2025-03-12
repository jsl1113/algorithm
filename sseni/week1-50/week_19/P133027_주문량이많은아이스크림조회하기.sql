# 너무 오랜만에 해서 그런가?
# order by 문에 집계함수를 써도 되는 구나를 알았다
SELECT F.FLAVOR
FROM FIRST_HALF AS F
         JOIN JULY AS J
              ON F.FLAVOR = J.FLAVOR
GROUP BY F.FLAVOR
ORDER BY SUM(J.TOTAL_ORDER) + SUM(F.TOTAL_ORDER) DESC
LIMIT 3;