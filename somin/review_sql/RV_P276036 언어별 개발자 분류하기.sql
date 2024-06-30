-- BIT_OR.. 생각치 못했다!!
-- 그리고 FRONT END는 다 합쳐서 체크하는 방법으로 해야한다.

WITH SK AS (
    SELECT BIT_OR(CODE) AS SCODE
    FROM SKILLCODES S
    GROUP BY CATEGORY
    HAVING CATEGORY = "Front End"
), DV AS(
    SELECT D.ID, EMAIL,
    CASE 
      WHEN D.SKILL_CODE & S.SCODE AND D.SKILL_CODE & (SELECT CODE 
                                                     FROM SKILLCODES
                                                     WHERE NAME = "Python") THEN "A"
      WHEN D.SKILL_CODE & (SELECT CODE 
                            FROM SKILLCODES
                          WHERE NAME = "C#") THEN "B"
      WHEN D.SKILL_CODE & S.SCODE THEN "C"
      ELSE NULL END AS GRADE
    FROM SK S, DEVELOPERS D
)

SELECT GRADE, ID, EMAIL
FROM DV
WHERE GRADE IS NOT NULL
ORDER BY 1,2