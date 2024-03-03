package com.travis.spring.playground.web.controller;

import com.travis.spring.playground.exception.NotFoundException;
import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class RecipeControllerIntegrationTest {

    @Mock
    RecipeService recipeService;

    RecipeController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void givenRecipeId_whenMockMVC_thenResponseOK() throws Exception {
        Recipe recipe = new Recipe();

        recipe.setId(1L);

        when(recipeService.findById(1L)).thenReturn(Optional.of(recipe));

        mockMvc.perform(get("/api/recipes/{recipeId}", 1L))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void givenInvalidRecipeId_whenMockMVC_thenResponseNotFound() throws Exception {
        when(recipeService.findById(100L)).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/api/recipes/100"))
            .andExpect(status().isNotFound());
    }
}
