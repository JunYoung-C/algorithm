WITH RECURSIVE hours AS(
    SELECT 0 AS hour
    UNION ALL
    SELECT hour+1 FROM hours where hour < 23
)

select hours.hour, ifNull(ao.count, 0)
from hours
         left join (
    select hour(datetime) as hour, count(datetime) as count
    from animal_outs
    group by hour(datetime)) as ao
                   on hours.hour = ao.hour
order by hours.hour asc