SELECT ai.animal_id, ai.animal_type, ai.name
from animal_ins ai
         inner join animal_outs ao
                    on ai.animal_id = ao.animal_id
where (ai.SEX_UPON_INTAKE not like 'Spayed%'
    and ai.SEX_UPON_INTAKE not like 'Neutered%')
  and (ao.SEX_UPON_OUTCOME like 'Spayed%'
    or ao.SEX_UPON_OUTCOME like 'Neutered%')
order by ai.animal_id asc