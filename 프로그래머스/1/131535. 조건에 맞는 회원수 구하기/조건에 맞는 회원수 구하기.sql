-- 코드를 입력하세요
select count(*) as users
from user_info
where date_format(joined,'%Y') = '2021'
and age>=20 and age <= 29;