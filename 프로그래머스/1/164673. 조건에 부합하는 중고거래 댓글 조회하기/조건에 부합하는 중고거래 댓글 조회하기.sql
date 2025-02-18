-- 코드를 입력하세요
SELECT title,gb.board_id,reply_id,gr.writer_id,gr.contents,
date_format(gr.created_date,'%Y-%m-%d') as created_date
from USED_GOODS_BOARD gb
join USED_GOODS_REPLY gr
on gb.board_id = gr.board_id
where date_format(gb.created_date,'%Y-%m') = '2022-10'
order by gr.created_date, title;