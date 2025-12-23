package com.example.tea_service.model;

public class Ingredient {

    private Long id;
    private String name;
    private boolean allergen;

    public Ingredient() {
    }

    public Ingredient(Long id, String name, boolean allergen) {
        this.id = id;
        this.name = name;
        this.allergen = allergen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllergen() {
        return allergen;
    }

    public void setAllergen(boolean allergen) {
        this.allergen = allergen;
    }
}
