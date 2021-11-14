package pl.jacekplotnicki.PizzaCentre.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@Builder //Helps building objects with hard contructors
public class Pizza {
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private int id;

    public Pizza(String pizzaName) {
        this.name = pizzaName;
    }
}
