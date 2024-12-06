package com.softuni.shampooCompany.repositories;

import com.softuni.shampooCompany.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartsWith(String nameStart);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> names);

    @Modifying
    @Transactional
    void deleteByName(String name);

    @Modifying
    @Transactional
    void increasePriceBy(BigDecimal increasePercent);

    @Modifying
    @Transactional
    @Query("""
           UPDATE Ingredient i
           SET i.price = i.price + i.price * ?2 / 100
           WHERE i.name IN ?1""")
    void updateByNameIncreasePriceBy(List<String> names, BigDecimal increasePercent);

}
