# SELECT count(distinct name)
# from animal_ins
# where name is not null

select count(*)
from(select name
     from animal_ins
     group by name
     having name is not null) a;