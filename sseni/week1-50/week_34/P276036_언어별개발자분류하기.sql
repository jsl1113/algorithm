# skill code 는 2진수로 구성됨
# 프론트엔드에 해당하는 기술을 모두 더하고, 각 개발자의 보유 스킬과 & 비트 연산했을 때
# 하나라도 같은 부분이 있으면, True
# 예시에서,
# 400 = 256, 128, 16 스킬을 가짐 = b110010000
# b110010000 & b100000000 = True
SELECT (
           CASE
               WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY LIKE "Front End")
                   AND SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME LIKE "PYTHON") THEN "A"
               WHEN SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME LIKE "C#") THEN "B"
               WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY LIKE "Front End") THEN "C"
               ELSE NULL
               END
           ) AS GRADE, ID, EMAIL
FROM DEVELOPERS
GROUP BY GRADE, ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID