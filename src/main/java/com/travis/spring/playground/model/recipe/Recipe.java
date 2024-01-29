package com.travis.spring.playground.model.recipe;

import com.travis.spring.playground.model.BaseEntity;
import com.travis.spring.playground.model.ingredient.Ingredient;
import com.travis.spring.playground.model.notes.Notes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Recipe extends BaseEntity {

    private String description;

    private Integer prepTime;

    private Integer cookTime;

    private Integer servings;

    private String source;

    private String url;

    private String directions;

    @Lob
    private Byte[] image;

    /**
     * Recipe object will get stored in a property called 'recipe' on Ingredient.
     * This establishes a bidirectional relationship where Recipe is the owning side,
     * and Ingredient is the inverse side. The mappedBy = "recipe" attribute indicates
     * that the 'recipe' property in Ingredient is responsible for managing the association.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    /**
     * Recipes owns the cascading on notes.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

}
