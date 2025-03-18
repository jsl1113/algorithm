-- 사원별 성과금 정보를 조회
-- CASE 문 .. 헷갈리네 ...
SELECT B.EMP_NO, B.EMP_NAME,
       CASE
           WHEN AVG(C.SCORE) >= 96 THEN "S"
           WHEN AVG(C.SCORE) >= 90 THEN "A"
           WHEN AVG(C.SCORE) >= 80 THEN "B"
           ELSE "C"
           END AS GRADE,
       CASE
           WHEN AVG(C.SCORE) >= 96 THEN B.SAL * 0.2
           WHEN AVG(C.SCORE) >= 90 THEN B.SAL * 0.15
           WHEN AVG(C.SCORE) >= 80 THEN B.SAL * 0.1
           ELSE 0
           END AS BONUS
FROM HR_DEPARTMENT AS A
         JOIN HR_EMPLOYEES AS B ON B.DEPT_ID = A.DEPT_ID
         JOIN HR_GRADE AS C ON C.EMP_NO = B.EMP_NO
GROUP BY B.EMP_NO
ORDER BY B.EMP_NO