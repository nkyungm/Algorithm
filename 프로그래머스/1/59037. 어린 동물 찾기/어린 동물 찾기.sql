-- 코드를 입력하세요
select animal_id,name
from ANIMAL_INS
where INTAKE_CONDITION != 'Aged'
order by animal_id;