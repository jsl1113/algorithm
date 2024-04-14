-- 로우넘버 번호 매겨서 그 번호를 토대로 비율계산해서 하는 법을 생각했다.
-- ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) 내림차순으로 ROW_NUMBER 지정
-- CNT의 C를 쓰기 위해서는 저렇게 WITH 문을 써야했다.. 안쓰고 하는 법 모르겠음 .

WITH RANK_LIST AS 
(SELECT ID, SIZE_OF_COLONY, ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS R
FROM ECOLI_DATA
), CNT AS (SELECT COUNT(*) AS C
          FROM RANK_LIST)

SELECT A.ID, 
CASE 
  WHEN A.R <= B.C*0.25 THEN 'CRITICAL'
  WHEN A.R <= B.C*0.5 THEN 'HIGH'
  WHEN A.R <= B.C*0.75 THEN 'MEDIUM'
  ELSE 'LOW' END AS COLONY_NAME
FROM RANK_LIST A ,CNT B
ORDER BY A.ID
