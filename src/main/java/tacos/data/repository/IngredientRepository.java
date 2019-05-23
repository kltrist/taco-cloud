package tacos.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.entity.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
