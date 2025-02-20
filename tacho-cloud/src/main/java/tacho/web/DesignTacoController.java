package tacho.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacho.data.IngredientRepository;
import tacho.models.Ingredient;
import tacho.models.Ingredient.Type;
import tacho.models.Taco;
import tacho.models.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

	private final IngredientRepository ingredientRepo;

	@Autowired
	public DesignTacoController(
			IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = ingredientRepo.findAll();
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}
	}

	

	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order() {
		return new TacoOrder();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	@GetMapping
	public String showDesignForm() {
		return "design";
	}

	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
		log.info("Processing Taco:{}", taco);

		tacoOrder.addTaco(taco);



		if (errors.hasErrors()) {
			return "design";
		}

		return "redirect:/orders/current";
	}

	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}
}

// what is happening here?

// The DesignTacoController class is a Spring MVC controller that handles
// requests to the /design path.
// The class is annotated with @Controller to indicate that it is a Spring MVC
// controller.
// The @RequestMapping annotation is used to specify the path that this
// controller will handle.
// The @SessionAttributes annotation is used to specify that the tacoOrder model
// attribute should be stored in the session.
// The addIngredientsToModel method is annotated with @ModelAttribute to
// indicate that it should be called before the handler methods to add
// ingredients to the model.
// The method creates a list of Ingredient objects and adds them to the model,
// grouped by type.
// The order method is annotated with @ModelAttribute to indicate that it should
// be called to create a new TacoOrder object.
// The taco method is annotated with @ModelAttribute to indicate that it should
// be called to create a new Taco object.
// The showDesignForm method is a handler method that returns the name of the
// view that should be rendered when a GET request is made to the /design path.
// The filterByType method is a helper method that filters a list of ingredients
// by type.

// how does templets get the values from the controller?
// The template can access the model attributes by using the Thymeleaf
// expression language. For example, to access the list of ingredients for a
// specific type, you can use the following expression:
// <div th:each="ingredient : ${veggies}">
// <input type="checkbox" th:value="${ingredient.id}"
// th:text="${ingredient.name}"/>
// </div>