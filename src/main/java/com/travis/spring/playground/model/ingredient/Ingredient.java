package com.travis.spring.playground.model.ingredient;

import com.travis.spring.playground.model.BaseEntity;
import com.travis.spring.playground.model.recipe.Recipe;
import com.travis.spring.playground.model.unit_of_measure.UnitOfMeasure;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Ingredient extends BaseEntity {

    private String description;

    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;
}
