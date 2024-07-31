-- 코드를 입력하세요
SELECT p.product_code,sum(os.sales_amount)*p.price sales from product p
join offline_sale os 
on p.product_id = os.product_id
group by p.product_code
order by sum(os.sales_amount)*p.price desc
,p.product_code;