-- WITH RECURSIVE : 재귀적으로 데이터 조회
-- 최종적으로 각 세대에 대한 카운트 계산
-- 부모 ID 가 NULL 인 루트 노드 선택 (초기 쿼리)
-- 다음 단계에서, 부모 ID가 WR의 ID 와 일치하는 노드 선택
-- 새롭게 선택된 노드는 이전 노드의 세대 번호 + 1 로 처리
-- LEFT JOIN 으로,
-- B.ID 가 NULL 이면, 자식이 없는 개체

WITH RECURSIVE WR AS (
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    UNION ALL
    SELECT A.ID, A.PARENT_ID, W.GENERATION + 1
    FROM ECOLI_DATA A
             INNER JOIN WR W
                        ON A.PARENT_ID = W.ID
)

SELECT COUNT(*) AS COUNT, A.GENERATION
FROM WR A
         LEFT JOIN ECOLI_DATA B
                   ON A.ID = B.PARENT_ID
WHERE B.ID IS NULL
GROUP BY A.GENERATION
ORDER BY A.GENERATION