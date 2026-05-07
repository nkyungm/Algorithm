-- 코드를 입력하세요
SELECT ao.animal_id,ao.name from ANIMAL_OUTS ao
left join ANIMAL_INS ai
on ao.animal_id = ai.animal_id
where ai.animal_id is null;