package by.grsu.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.grsu.edu.entity.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
