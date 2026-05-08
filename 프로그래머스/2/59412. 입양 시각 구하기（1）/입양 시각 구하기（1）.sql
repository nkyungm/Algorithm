-- 코드를 입력하세요
SELECT cast(date_format(datetime,'%H') as signed) HOUR ,count(*) COUNT from ANIMAL_OUTS
group by HOUR
having HOUR >= 9 && HOUR <= 19
order by HOUR;

-- select cast(date_format(datetime,'%H') as signed) from ANIMAL_OUTS;