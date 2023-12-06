# 2022년 1월의 카테고리 별 도서 판매량을 합산, 오름차순
SELECT B.CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM  BOOK_SALES AS S, BOOK AS B
WHERE B.BOOK_ID = S.BOOK_ID AND
        S.SALES_DATE LIKE "2022-01%"
GROUP BY CATEGORY
ORDER BY CATEGORY