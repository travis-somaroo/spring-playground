package com.travis.spring.playground.model.recipe;

import com.travis.spring.playground.model.BaseEntity;
import com.travis.spring.playground.model.category.Category;
import com.travis.spring.playground.model.difficulty.Difficulty;
import com.travis.spring.playground.model.ingredient.Ingredient;
import com.travis.spring.playground.model.notes.Notes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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
     * String persists as the name, ordinal persists as the number either 0,1,2 for example.
     */
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    /**
     * Recipe object will get stored in a property called 'recipe' on Ingredient, property name must match.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    /**
     * Recipes owns the cascading on notes.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();


    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
