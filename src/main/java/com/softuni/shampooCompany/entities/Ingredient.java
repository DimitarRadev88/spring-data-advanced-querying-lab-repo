package com.softuni.shampooCompany.entities;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@NamedQuery(
        name = "Ingredient.deleteByName",
        query = "DELETE FROM Ingredient i WHERE i.name = ?1"
)
@NamedQuery(
        name = "Ingredient.increasePriceBy",
        query = "UPDATE Ingredient i SET i.price = i.price + i.price * ?1 / 100"
)
public class Ingredient extends BaseEntity {

    private String name;
    private BigDecimal price;
    private Set<Shampoo> shampoos;

    public Ingredient() {
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "ingredients",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    public Set<Shampoo> getShampoos() {
        return this.shampoos;
    }

    public void setShampoos(Set<Shampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
