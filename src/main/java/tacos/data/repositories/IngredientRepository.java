package tacos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
