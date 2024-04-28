# C의 parent_id 가 null = 최초의 대장균 개체
# left join 하게 되므로, c의 id 가 null 이 아니라는 조건도 필요
SELECT A.ID
FROM ECOLI_DATA AS A
         LEFT JOIN ECOLI_DATA AS B ON A.PARENT_ID = B.ID
         LEFT JOIN ECOLI_DATA AS C ON B.PARENT_ID = C.ID
WHERE C.PARENT_ID IS NULL
  AND C.ID IS NOT NULL
ORDER BY A.ID