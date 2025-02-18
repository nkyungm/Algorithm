-- 코드를 입력하세요
select date_format(sales_date,'%Y-%m-%d'),product_id,user_id,sales_amount
from
(select sales_date,product_id,user_id,sales_amount
from ONLINE_SALE
union
select sales_date,product_id,null,sales_amount
from OFFLINE_SALE) A
where date_format(A.sales_date,'%Y-%m') = '2022-03'
order by A.sales_date, A.product_id,A.user_id;