-- 코드를 입력하세요
SELECT * from USED_GOODS_BOARD ub
join USED_GOODS_USER uu
on ub.writer_id = uu.user_id;


select WRITER_ID,nickname,sum(price) TOTAL_SALES from USED_GOODS_BOARD
join USED_GOODS_USER
on writer_id = user_id
where STATUS = 'DONE'
group by WRITER_ID
having TOTAL_SALES >=700000
order by TOTAL_SALES;