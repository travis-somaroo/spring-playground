package com.travis.spring.playground.service;

import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> findAllRecipes() {
        return new HashSet<>(recipeRepository.findAll());
    }

    @Override
    public Optional<Recipe> findById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }

    @Override
    public void deleteById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }
}