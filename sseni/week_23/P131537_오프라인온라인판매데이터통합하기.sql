-- 코드를 입력하세요
SELECT *
FROM (
         SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") 'SALES_DATE', PRODUCT_ID, USER_ID, SALES_AMOUNT
         FROM ONLINE_SALE
         WHERE MONTH(SALES_DATE) = 3
         UNION
         SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") 'SALES_DATE', PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
         FROM OFFLINE_SALE
         WHERE MONTH(SALES_DATE) = 3
     ) AS O
ORDER BY O.SALES_DATE, O.PRODUCT_ID, O.USER_ID