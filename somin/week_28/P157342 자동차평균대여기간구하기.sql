# DATEDIFF 함수 : 날짜 차이 근데 +1해야함

SELECT CR.CAR_ID, CR.AVERAGE_DURATION
FROM (
SELECT CAR_ID, ROUND( AVG( DATEDIFF(END_DATE, START_DATE)+1 ), 1 ) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC
    ) CR
    WHERE CR.AVERAGE_DURATION >=7