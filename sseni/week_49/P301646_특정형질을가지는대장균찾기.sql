-- 2 = 0010 -> 2
-- 1과 3 = 0101 -> 5
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE !(GENOTYPE & 2) AND GENOTYPE & 5