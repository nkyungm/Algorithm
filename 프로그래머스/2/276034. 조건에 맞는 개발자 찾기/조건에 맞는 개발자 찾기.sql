-- 코드를 작성해주세요
# 400 = 110010000 && 해서 256나오면
# 256 = 100000000
select distinct(id),email,first_name,last_name
from DEVELOPERS d
join skillcodes s
on (d.skill_code & s.code) = s.code
where s.name in ('Python','C#')
order by id;