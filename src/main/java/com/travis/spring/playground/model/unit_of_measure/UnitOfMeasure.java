package com.travis.spring.playground.model.unit_of_measure;

import com.travis.spring.playground.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UnitOfMeasure extends BaseEntity {

    private String description;
}
