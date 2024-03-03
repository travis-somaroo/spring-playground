package com.travis.spring.playground.web.controller;

import com.travis.spring.playground.model.category.Category;
import com.travis.spring.playground.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public Category findByDescription(@RequestParam String description) {
        return categoryRepository.findByDescription(description)
            .orElseThrow(() -> new RuntimeException("Category not found for description: " + description));
    }
}
