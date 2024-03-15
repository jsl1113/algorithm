-- 코드를 입력하세요
-- 서브쿼리로 두 번 이상 등록한 host_id 리스트
-- 그 아이디 리스트 안에 있으면 결과 출력
SELECT *
FROM PLACES AS A
WHERE A.HOST_ID IN (
    SELECT B.HOST_ID
    FROM PLACES AS B
    GROUP BY B.HOST_ID
    HAVING COUNT(*) >= 2
)
ORDER BY A.ID
