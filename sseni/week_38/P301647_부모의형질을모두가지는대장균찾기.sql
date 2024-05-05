-- 코드를 작성해주세요
SELECT A.ID, A.GENOTYPE, B.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS A, ECOLI_DATA AS B
WHERE A.GENOTYPE & B.GENOTYPE = B.GENOTYPE
  AND A.PARENT_ID = B.ID
ORDER BY A.ID