select A.USER_ID , A.NICKNAME, B.PRI AS TOTAL_SALES
from USED_GOODS_USER A JOIN 
(select BOARD_ID,WRITER_ID, SUM(PRICE) AS PRI ,STATUS
from USED_GOODS_BOARD
WHERE STATUS = "DONE"
GROUP BY WRITER_ID) B
ON B.WRITER_ID = A.USER_ID AND PRI>=700000
ORDER BY PRI 