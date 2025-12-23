package com.example.tea_service.repository;

import com.example.tea_service.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class IngredientRepository {

    private final Map<Long, Ingredient> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Ingredient save(Ingredient ingredient) {
        if (ingredient.getId() == null) {
            ingredient.setId(idGenerator.getAndIncrement());
        }
        storage.put(ingredient.getId(), ingredient);
        return ingredient;
    }

    public Ingredient findById(Long id) {
        return storage.get(id);
    }

    public Collection<Ingredient> findAll() {
        return storage.values();
    }

    public void delete(Long id) {
        storage.remove(id);
    }
}
