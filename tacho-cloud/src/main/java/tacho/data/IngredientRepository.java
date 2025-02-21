package tacho.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tacho.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
