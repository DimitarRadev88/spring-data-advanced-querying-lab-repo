package com.softuni.shampooCompany.services;

import com.softuni.shampooCompany.entities.Shampoo;
import com.softuni.shampooCompany.entities.Size;
import com.softuni.shampooCompany.repositories.ShampooRepository;
import com.softuni.shampooCompany.services.interfaces.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> getAllShampoosWithSizeSortedById(Size size) {
        return shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> getAllShampoosWithSizeOrLabelIdSortedByPrice(Size size, long labelId) {
        return shampooRepository.findAllBySizeOrLabel_IdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> getAllShampoosWithPriceHigherThanSortedByPriceDesc(BigDecimal price) {
        return shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public long getShampoosCountWithPriceLowerThan(BigDecimal price) {
        return shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> getAllShampoosWithIngredientsListContaining(List<String> ingredients) {
        return shampooRepository.findAllByIngredientsNamesIn(ingredients);
    }

    @Override
    public List<Shampoo> getAllShampoosWithIngredientsLessThan(int maxIngredients) {
        return shampooRepository.findAllByIngredientsCountLessThan(maxIngredients);
    }

}
