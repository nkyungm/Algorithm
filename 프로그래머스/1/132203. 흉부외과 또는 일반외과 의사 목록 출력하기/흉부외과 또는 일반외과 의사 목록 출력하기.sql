-- 코드를 입력하세요
SELECT dr_name,dr_id,mcdp_cd,TO_CHAR(hire_ymd,'YYYY-mm-dd') HIRE_YMD
from doctor
where MCDP_CD='CS' or MCDP_CD='GS'
order by HIRE_YMD desc,dr_name;