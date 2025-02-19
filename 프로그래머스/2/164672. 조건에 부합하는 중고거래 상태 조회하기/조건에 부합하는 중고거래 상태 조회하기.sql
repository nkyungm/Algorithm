-- 코드를 입력하세요
SELECT board_id,writer_id,title,price,
case 
    when status = 'SALE' then '판매중'
    when status = 'RESERVED' then '예약중'
    else '거래완료'
end as status
from USED_GOODS_BOARD
where date_format(created_date,'%Y-%m-%d') = '2022-10-05'
order by board_id desc;