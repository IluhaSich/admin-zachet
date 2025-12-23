package com.example.tea_service;

import com.example.tea_service.model.Ingredient;
import com.example.tea_service.model.Tea;
import com.example.tea_service.service.IngredientService;
import com.example.tea_service.service.TeaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TeaService teaService;
    private final IngredientService ingredientService;

    public DataInitializer(TeaService teaService, IngredientService ingredientService) {
        this.teaService = teaService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) {

        teaService.create(new Tea(null, "Green Sencha", "green", 30));
        teaService.create(new Tea(null, "Assam Black", "black", 60));
        teaService.create(new Tea(null, "Oolong Classic", "oolong", 45));
        teaService.create(new Tea(null, "Herbal Mint", "herbal", 0));

        ingredientService.create(new Ingredient(null, "Mint", false));
        ingredientService.create(new Ingredient(null, "Lemon", false));
        ingredientService.create(new Ingredient(null, "Ginger", false));
        ingredientService.create(new Ingredient(null, "Honey", true));
    }
}
