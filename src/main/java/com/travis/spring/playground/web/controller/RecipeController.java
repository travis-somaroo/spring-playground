package com.travis.spring.playground.web.controller;

import com.travis.spring.playground.exception.NotFoundException;
import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public Set<Recipe> findAllRecipes() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("/{recipeId}")
    public Optional<Recipe> findRecipe(@PathVariable Long recipeId) {
        return recipeService.findById(recipeId);
    }

    @DeleteMapping("{recipeId}/delete")
    public String deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteById(recipeId);
        return "Recipe deleted";
    }

    // This is for testing purposes
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        String errorMessage = "Resource not found: " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
