package com.travis.spring.playground.bootstrap;

import com.travis.spring.playground.model.category.Category;
import com.travis.spring.playground.model.difficulty.Difficulty;
import com.travis.spring.playground.model.ingredient.Ingredient;
import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.model.unit_of_measure.UnitOfMeasure;
import com.travis.spring.playground.repository.CategoryRepository;
import com.travis.spring.playground.repository.RecipeRepository;
import com.travis.spring.playground.repository.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class DummyDataRunner implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    private final RecipeRepository recipeRepository;


    @Override
    public void run(String... args) {
        generateCategories();
        generateUnitOfMeasures();
        generateRecipes();
        log.info("Dummy data loaded!");
    }

    private void generateCategories() {
        String[] categoryNames = {"American", "Italian", "Mexican", "Fast Food"};

        for (String categoryName : categoryNames) {
            createCategory(categoryName);
        }
    }

    private void createCategory(String categoryName) {
        Category category = new Category();
        category.setDescription(categoryName);
        categoryRepository.save(category);
    }

    private void generateUnitOfMeasures() {
        String[] unitOfMeasureDescriptions = {"Teaspoon", "Tablespoon", "Cup", "Pinch", "Ounce", "Each", "Dash", "Pint"};

        for (String description : unitOfMeasureDescriptions) {
            createUnitOfMeasure(description);
        }
    }

    private void createUnitOfMeasure(String description) {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(description);
        unitOfMeasureRepository.save(unitOfMeasure);
    }

    private void generateRecipes() {
        Recipe recipe = new Recipe();
        recipe.setDescription("A simple pasta");
        recipe.setPrepTime(15);
        recipe.setCookTime(30);
        recipe.setServings(4);
        recipe.setSource("Source");
        recipe.setUrl("Url");
        recipe.setDirections("Directions");

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        Ingredient ingredient = new Ingredient("Pasta", new BigDecimal(1), unitOfMeasureOptional.get());
        recipe.addIngredient(ingredient);
        recipe.setDifficulty(Difficulty.EASY);
        recipeRepository.save(recipe);
    }
}
