package com.softuni.shampooCompany.services.interfaces;

import com.softuni.shampooCompany.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredientsByNameStartingWith(String nameStart);

    List<Ingredient> getAllIngredientsWithNamesSortedByPrice(List<String> ingredientNames);

    void deleteIngredientsWithName(String name);

    void increasePriceByPercent(BigDecimal increasePercent);

    void increasePriceForIngredientsWithNamesByPercent(List<String> ingredientNames, BigDecimal price);
}
