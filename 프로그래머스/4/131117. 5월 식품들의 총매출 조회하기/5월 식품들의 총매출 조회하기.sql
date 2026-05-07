-- 코드를 입력하세
SELECT fo.PRODUCT_ID,fp.product_name,sum(AMOUNT)*fp.PRICE TOTAL_SALES
from FOOD_ORDER fo
join FOOD_PRODUCT fp
on fo.product_id = fp.product_id
where PRODUCE_DATE >= '2022-05-01' and PRODUCE_DATE <= '2022-05-31'
group by fo.product_id
order by sum(AMOUNT)*fp.PRICE desc,PRODUCT_ID

