-- 코드를 입력하세요

-- 원하는 대여기간에 포함된 car_id 찾기
-- select crh.car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY as crh
-- where crh.start_date >= '2022-11-01' and crh.start_date < '2022-11-30'
-- or crh.end_date > '2022-11-01';

SELECT DISTINCT cr.car_id,cr.car_type, FLOOR((cr.daily_fee-(cr.daily_fee*crp.discount_rate/100)) *30) as FEE
from car_rental_company_car as cr
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as crp 
on cr.car_type = crp.car_type
where cr.car_type in ('세단','SUV')
and cr.car_id not in (select crh.car_id 
                      from CAR_RENTAL_COMPANY_RENTAL_HISTORY as crh
where crh.start_date >= '2022-11-01' and crh.start_date < '2022-11-30'
or crh.end_date > '2022-11-01')
and crp.duration_type = '30일 이상'
and FLOOR((cr.daily_fee-(cr.daily_fee*crp.discount_rate/100)) *30) >= 500000
and FLOOR((cr.daily_fee-(cr.daily_fee*crp.discount_rate/100)) *30) < 2000000
order by FEE DESC, cr.car_type, cr.car_id DESC;

