-- 생일이 3월인 여성 조회
select member_id,member_name,gender,
date_format(date_of_birth,'%Y-%m-%d') as date_of_birth
from member_profile
where date_format(date_of_birth,'%m') = '03'
and tlno is not null
and gender = 'W'
order by member_id;