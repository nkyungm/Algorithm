-- 코드를 입력하세요
select round(avg(daily_fee),0) as average_fee
from car_rental_company_car
where car_type = 'SUV'
group by car_type;