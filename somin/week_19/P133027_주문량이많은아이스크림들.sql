# ������ ���� �; �����غ��ٰ� ���������� �� ���ڴٴ� ������  
# ������ ���̺� ���������� �ȴٴ� ���� ��
SELECT A.FLAVOR
FROM FIRST_HALF AS A , (SELECT FLAVOR, SUM(TOTAL_ORDER) AS JULY_T
    FROM JULY GROUP BY FLAVOR) AS B
WHERE A.FLAVOR = B.FLAVOR
ORDER BY (A.TOTAL_ORDER + B.JULY_T) DESC
LIMIT 3