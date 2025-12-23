package com.example.tea_service.controller;

import com.example.tea_service.model.Ingredient;
import com.example.tea_service.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    @PostMapping
    public Ingredient create(@RequestBody Ingredient ingredient) {
        return service.create(ingredient);
    }

    @GetMapping
    public Collection<Ingredient> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Ingredient getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Ingredient update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return service.update(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
