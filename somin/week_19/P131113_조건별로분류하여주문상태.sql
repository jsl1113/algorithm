-- �ڵ带 �Է��ϼ���
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE , "%Y-%m-%d") as "OUT_DATE", 
    CASE
        WHEN (OUT_DATE <= '2022-05-01') THEN '���Ϸ�'
        WHEN (OUT_DATE > '2022-05-01') THEN '�����'
        ELSE '������'
    END AS �����
FROM FOOD_ORDER
ORDER BY ORDER_ID