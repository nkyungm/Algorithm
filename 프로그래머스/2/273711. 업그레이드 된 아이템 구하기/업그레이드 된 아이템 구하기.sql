-- 코드를 작성해주세요
select item_id,item_name,rarity
from item_info
where item_id 
in (select it.item_id
from ITEM_INFO ii
join item_tree it
on ii.item_id = it.parent_item_id
where ii.rarity = 'RARE')
order by item_id desc;