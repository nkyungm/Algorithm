-- 코드를 작성해주세요
select ed.id,count(ed2.id) as child_count
from ecoli_data ed
left join ecoli_data ed2
on ed.id = ed2.parent_id
group by ed.id
order by ed.id;