-- 코드를 입력하세요
SELECT b.book_id,a.author_name,b.published_date from BOOK b
join AUTHOR a
on b.author_id = a.author_id
where b.category = '경제'
order by b.published_date