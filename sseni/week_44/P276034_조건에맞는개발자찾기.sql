-- DISTINCT 때문이었다. 이런
SELECT DISTINCT A.ID, A.EMAIL, A.FIRST_NAME, A.LAST_NAME
FROM DEVELOPERS AS A
         LEFT JOIN SKILLCODES AS B
                   ON A.SKILL_CODE & B.CODE
WHERE B.NAME IN ("C#", "Python")
ORDER BY A.ID