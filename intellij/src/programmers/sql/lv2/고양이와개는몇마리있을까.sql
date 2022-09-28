SELECT animal_type, count(*)
from animal_ins
group by animal_type
having animal_type in ('Cat', 'Dog')
order by animal_type asc