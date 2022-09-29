SELECT ANIMAL_ID, name, if (
                SEX_UPON_INTAKE like ('Neutered%') or
                SEX_UPON_INTAKE like ('Spayed%'), 'O', 'X'
    )
from animal_ins