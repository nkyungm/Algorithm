select ri.rest_id,ri.rest_name,food_type,favorites
,address,round(avg(review_score),2) as score
from rest_info ri
join rest_review rr on ri.rest_id = rr.rest_id
where ri.address like '서울%'
group by ri.rest_id
order by score desc,favorites desc;