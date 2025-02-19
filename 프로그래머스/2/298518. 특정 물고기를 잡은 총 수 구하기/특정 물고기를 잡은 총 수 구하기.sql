-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info fi
join fish_name_info fn
on fi.fish_type = fn.fish_type
where fn.fish_name in('BASS','SNAPPER');