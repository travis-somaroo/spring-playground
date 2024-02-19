package com.travis.spring.playground.bootstrap;

import com.travis.spring.playground.model.category.Category;
import com.travis.spring.playground.model.unit_of_measure.UnitOfMeasure;
import com.travis.spring.playground.repository.CategoryRepository;
import com.travis.spring.playground.repository.UnitOfMeasureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class DummyDataRunner implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void run(String... args) {
        generateCategories();
        generateUnitOfMeasures();
        log.info("Dummy data loaded!");
    }

    private void generateCategories() {
        String[] categoryNames = {"American", "Italian", "Mexican", "Fast Food"};

        for (String categoryName : categoryNames) {
            createCategory(categoryName);
        }
    }

    private void createCategory(String categoryName) {
        Category category = new Category();
        category.setDescription(categoryName);
        categoryRepository.save(category);
    }

    private void generateUnitOfMeasures() {
        String[] unitOfMeasureDescriptions = {"Teaspoon", "Tablespoon", "Cup", "Pinch", "Ounce"};

        for (String description : unitOfMeasureDescriptions) {
            createUnitOfMeasure(description);
        }
    }

    private void createUnitOfMeasure(String description) {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(description);
        unitOfMeasureRepository.save(unitOfMeasure);
    }

}
