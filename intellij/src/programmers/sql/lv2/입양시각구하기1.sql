select h, count(*)
from (SELECT hour(datetime) as h
    from animal_outs) as ao
group by h
having h between 9 and 19
order by h asc