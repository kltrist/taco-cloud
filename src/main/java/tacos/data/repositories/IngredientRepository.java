package tacos.data.repositories;

import tacos.entity.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save (Ingredient ingredient);
}
