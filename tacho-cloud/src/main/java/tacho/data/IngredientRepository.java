package tacho.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tacho.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    
}
