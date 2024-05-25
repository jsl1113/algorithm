# 2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수
SELECT YEAR(B.SALES_DATE) AS YEAR
     , MONTH(B.SALES_DATE) AS MONTH
     , COUNT(DISTINCT B.USER_ID) AS PURCHASED_USERS
     , ROUND(COUNT(DISTINCT B.USER_ID) / (
        SELECT COUNT(DISTINCT USER_ID)
        FROM USER_INFO
        WHERE YEAR(JOINED) = 2021), 1
    ) AS PURCHASED_RATIO
FROM USER_INFO AS A
         INNER JOIN ONLINE_SALE AS B
                    ON A.USER_ID = B.USER_ID
WHERE YEAR(A.JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH