package com.travis.spring.playground.web.controller;

import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public Set<Recipe> findAllRecipes() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("{recipeId}")
    public Optional<Recipe> findRecipe(@PathVariable Long recipeId) {
        return recipeService.findById(recipeId);
    }

    @GetMapping("{recipeId}/delete")
    public String deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteById(recipeId);
        return "Recipe deleted";
    }
}
