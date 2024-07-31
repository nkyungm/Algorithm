-- 코드를 입력하세요
SELECT b.book_id BOOK_ID,a.author_name AUTHOR_NAME,
DATE_FORMAT(b.published_date,'%Y-%m-%d') PUBLISHED_DATE
from book as b left join author as a on b.author_id= a.author_id
where b.category = '경제'
order by b.published_date;