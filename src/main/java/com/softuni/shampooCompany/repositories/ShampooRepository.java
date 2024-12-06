package com.softuni.shampooCompany.repositories;

import com.softuni.shampooCompany.entities.Shampoo;
import com.softuni.shampooCompany.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, long labelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    long countByPriceLessThan(BigDecimal price);

    @Query("""
            FROM Shampoo s
            WHERE s.id IN (
                SELECT min(s.id) FROM Shampoo s
                JOIN s.ingredients i
                WHERE i.name in ?1
                GROUP BY s.brand
            )
            """)
    List<Shampoo> findAllByIngredientsNamesIn(List<String> ingredients);

    @Query("""
            FROM Shampoo s
            WHERE size(s.ingredients) < ?1
            """)
    List<Shampoo> findAllByIngredientsCountLessThan(int maxIngredients);

}
