-- 코드를 입력하세요
SELECT A.CART_ID
FROM CART_PRODUCTS A JOIN (
    SELECT CART_ID AS Y_ID
    FROM CART_PRODUCTS
    WHERE NAME = "Yogurt"
    GROUP BY CART_ID
) B
ON A.CART_ID = B.Y_ID
WHERE NAME = "Milk"
GROUP BY A.CART_ID
ORDER BY 1