package com.travis.spring.playground.web.controller;

import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.service.RecipeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RecipeControllerTest {
    @Mock
    RecipeService recipeService;

    @InjectMocks
    RecipeController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetRecipe() throws Exception {
        when(recipeService.findById(anyLong())).thenReturn(Optional.of(new Recipe()));

        mockMvc.perform(get("/api/recipes/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").exists());

        verify(recipeService, times(1)).findById(anyLong());
    }


    @Test
    public void testGetAllRecipes() throws Exception {
        Set<Recipe> mockRecipes = new HashSet<>(List.of(new Recipe(), new Recipe()));
        when(recipeService.findAllRecipes()).thenReturn(mockRecipes);

        mockMvc.perform(get("/api/recipes")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", Matchers.hasSize(mockRecipes.size())));

        verify(recipeService, times(1)).findAllRecipes();
    }

    @Test
    public void testDeleteRecipe() throws Exception {
        mockMvc.perform(delete("/api/recipes/{id}/delete", 1L)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        verify(recipeService, times(1)).deleteById(anyLong());
    }
}
