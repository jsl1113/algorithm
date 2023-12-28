-- �뿩 Ƚ���� ���� �ڵ������� ���� �뿩 Ƚ�� ���ϱ�
-- ó������ from�� ���������� �༭ �Ϸ��� �ߴµ� ���� �ʾҴ�. 
-- �����δ� �������� �Ӹ� �ƴ϶� where �÷� in ()�� �����ؾ߰ڴ�.

SELECT  MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE CAR_ID IN
(
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID 
    HAVING COUNT(HISTORY_ID) > 4
) AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
-- ���⼭ �ѹ��� AND ������ �ִ� ������ 8 9 10���� �ƴ� CAR_ID�� NULL�� ������ ���� ����
GROUP BY MONTH , CAR_ID
HAVING RECORDS >=1
ORDER BY MONTH , CAR_ID DESC