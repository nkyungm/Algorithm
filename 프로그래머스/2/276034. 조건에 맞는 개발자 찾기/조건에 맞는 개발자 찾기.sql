-- 코드를 작성해주세요
# 400 = 110010000 && 해서 256나오면
# 256 = 100000000
select id,email,first_name,last_name
from DEVELOPERS
where
(skill_code & (select code from SKILLCODES where name in ('Python')))
= (select code from SKILLCODES where name in ('Python')) or
(skill_code & (select code from SKILLCODES where name in ('C#')))
= (select code from SKILLCODES where name in ('C#'))
order by id;