select p.id, p.name, p.host_id
from places p
         inner join (SELECT host_id, count(*) count
                     from places
                     group by host_id
                     having count >= 2) heavy
                    on p.host_id = heavy.host_id
order by p.id asc