SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM PATIENT AS P, DOCTOR AS D, APPOINTMENT AS A
WHERE P.PT_NO = A.PT_NO AND
        D.DR_ID = A.MDDR_ID AND
        A.MCDP_CD LIKE "CS" AND
        A.APNT_CNCL_YMD IS NULL AND
        A.APNT_YMD LIKE "2022-04-13%"
ORDER BY A.APNT_YMD