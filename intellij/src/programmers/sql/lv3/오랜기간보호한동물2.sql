SELECT ao.ANIMAL_ID, ao.NAME
from ANIMAL_OUTS as ao
         inner join ANIMAL_INS ai
                    on ao.animal_id = ai.animal_id
order by ao.DATETIME - ai.DATETIME desc
limit 2;