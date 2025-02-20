package tacho.data;

import java.util.List;
import java.util.Optional;

import tacho.models.Ingredient;

public interface IngredientRepository {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
