
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count
FROM ANIMAL_INS 
WHERE ANIMAL_TYPE = "Cat"
UNION ALL
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count
FROM ANIMAL_INS 
WHERE ANIMAL_TYPE = "Dog"