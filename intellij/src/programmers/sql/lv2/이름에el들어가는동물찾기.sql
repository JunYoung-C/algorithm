SELECT ANIMAL_ID, NAME
from animal_ins
where name like '%El%' and ANIMAL_TYPE = 'Dog'
order by name asc;