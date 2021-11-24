package pl.jacekplotnicki.PizzaCentre.models;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaRepository {

    private List<Pizza> pizzaList = new ArrayList<>();

    @PostConstruct
    public void init() {
        pizzaList.add(Pizza.builder().id(1).name("Margherita").description("Pizza with tomato sauce and cheese")
                .price(new BigDecimal("24.99")).image("pizza1").build());
        pizzaList.add(Pizza.builder().id(2).name("Capricciosa").description("Pizza with tomato sauce and cheese")
                .price(new BigDecimal("29.99")).image("pizza2").build());
        pizzaList.add(Pizza.builder().id(3).name("Pepperoni").description("Pizza with tomato sauce and cheese")
                .price(new BigDecimal("28.99")).image("pizza3").build());
        pizzaList.add(Pizza.builder().id(4).name("Hawaii").description("Pizza with tomato sauce and cheese")
                .price(new BigDecimal("29.99")).image("pizza4").build());
        pizzaList.add(Pizza.builder().id(5).name("Carbonara").description("Pizza with tomato sauce and cheese")
                .price(new BigDecimal("30.99")).image("pizza5").build());
        pizzaList.add(Pizza.builder().id(6).name("Cheese").description("Pizza with tomato sauce and cheese")
                .price(new BigDecimal("35.99")).image("pizza3").build());
    }

    public List<Pizza> getAll() {
        return pizzaList;
    }
}
