-- LEFT JOIN
SELECT A.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO A LEFT JOIN ITEM_TREE B
ON A.ITEM_ID = B.PARENT_ITEM_ID
WHERE PARENT_ITEM_ID IS NULL
ORDER BY 1 DESC