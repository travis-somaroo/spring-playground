package com.travis.spring.playground.model.notes;

import com.travis.spring.playground.model.BaseEntity;
import com.travis.spring.playground.model.recipe.Recipe;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Notes extends BaseEntity {

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
