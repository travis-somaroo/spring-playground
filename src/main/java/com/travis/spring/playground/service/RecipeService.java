package com.travis.spring.playground.service;

import com.travis.spring.playground.model.recipe.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAllRecipes();

    Optional<Recipe> findById(Long recipeId);

    void deleteById(Long recipeId);
}
