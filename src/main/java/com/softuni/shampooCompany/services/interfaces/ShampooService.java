package com.softuni.shampooCompany.services.interfaces;

import com.softuni.shampooCompany.entities.Shampoo;
import com.softuni.shampooCompany.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> getAllShampoosWithSizeSortedById(Size size);

    List<Shampoo> getAllShampoosWithSizeOrLabelIdSortedByPrice(Size size, long labelId);

    List<Shampoo> getAllShampoosWithPriceHigherThanSortedByPriceDesc(BigDecimal price);

    long getShampoosCountWithPriceLowerThan(BigDecimal price);

    List<Shampoo> getAllShampoosWithIngredientsListContaining(List<String> ingredients);

    List<Shampoo> getAllShampoosWithIngredientsLessThan(int maxIngredients);
}
