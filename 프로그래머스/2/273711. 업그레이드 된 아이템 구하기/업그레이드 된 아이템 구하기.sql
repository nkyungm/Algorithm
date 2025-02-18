-- 코드를 작성해주세요
select ii.item_id,ii.item_name,rarity
from item_info ii
join item_tree it
on it.item_id = ii.item_id
where it.parent_item_id 
in(select item_id from item_info 
  where rarity = 'RARE')
  order by ii.item_id desc;