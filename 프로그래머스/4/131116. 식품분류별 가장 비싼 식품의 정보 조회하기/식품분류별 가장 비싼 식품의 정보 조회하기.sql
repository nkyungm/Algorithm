-- 코드를 입력하세요
select category,price max_price,product_name
from (
SELECT *,
rank() over(
    partition by category
    order by price desc
) rk
from food_product
where category in ('과자','국','김치','식용유')) A
where rk = 1
order by price desc;