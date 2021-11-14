package pl.jacekplotnicki.PizzaCentre.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@AllArgsConstructor
@Builder
@Setter
@ToString

public class PizzaInBasket {
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private int id;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaInBasket that = (PizzaInBasket) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

