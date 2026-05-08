-- 코드를 입력하세요


select count(*) from USER_INFO
where YEAR(JOINED) =2021;

 SELECT YEAR(o.SALES_DATE) year,
 MONTH(o.SALES_DATE) month,
 count(distinct u.user_id),
 ROUND(count(distinct u.user_id)/ (select count(*) from USER_INFO
where YEAR(JOINED) =2021),1 ) from USER_INFO u
left join ONLINE_SALE o
on o.USER_ID = u.USER_ID
where YEAR(u.JOINED) =2021
and o.online_sale_id is not null
group by year,month
order by year,month;