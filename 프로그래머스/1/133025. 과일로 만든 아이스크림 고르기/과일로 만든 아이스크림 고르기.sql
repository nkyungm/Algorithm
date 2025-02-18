-- 코드를 입력하세요
select fh.flavor
from first_half fh join icecream_info ii
on fh.flavor = ii.flavor
where total_order > 3000
and INGREDIENT_TYPE = 'fruit_based'
order by total_order desc;