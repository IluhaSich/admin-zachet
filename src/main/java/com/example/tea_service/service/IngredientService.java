package com.example.tea_service.service;

import com.example.tea_service.model.Ingredient;
import com.example.tea_service.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public Ingredient create(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public Collection<Ingredient> getAll() {
        return repository.findAll();
    }

    public Ingredient getById(Long id) {
        return repository.findById(id);
    }

    public Ingredient update(Long id, Ingredient ingredient) {
        ingredient.setId(id);
        return repository.save(ingredient);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
