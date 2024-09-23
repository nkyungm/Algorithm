-- 코드를 입력하세요
SELECT ao.animal_id,ao.animal_type,ao.name from animal_outs ao
join animal_ins ai on ao.animal_id = ai.animal_id
where ao.SEX_UPON_OUTCOME not like '%Intact%' and 
ai.SEX_UPON_INTAKE like '%Intact%';
