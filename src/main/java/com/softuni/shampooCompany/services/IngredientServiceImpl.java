package com.softuni.shampooCompany.services;

import com.softuni.shampooCompany.entities.Ingredient;
import com.softuni.shampooCompany.repositories.IngredientRepository;
import com.softuni.shampooCompany.services.interfaces.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<Ingredient> getAllIngredientsByNameStartingWith(String nameStart) {
        return ingredientRepository.findAllByNameStartsWith(nameStart);
    }

    @Override
    public List<Ingredient> getAllIngredientsWithNamesSortedByPrice(List<String> ingredientNames) {
        return ingredientRepository.findAllByNameInOrderByPrice(ingredientNames);
    }

    @Override
    public void deleteIngredientsWithName(String name) {
        ingredientRepository.deleteByName(name);
    }

    @Override
    public void increasePriceByPercent(BigDecimal increasePercent) {
        ingredientRepository.increasePriceBy(increasePercent);
    }

    @Override
    public void increasePriceForIngredientsWithNamesByPercent(List<String> ingredientNames, BigDecimal price) {
        ingredientRepository.updateByNameIncreasePriceBy(ingredientNames, price);
    }


}
