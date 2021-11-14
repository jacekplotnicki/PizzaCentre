package pl.jacekplotnicki.PizzaCentre.services;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.jacekplotnicki.PizzaCentre.models.Pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope //For each search session there is a different basket
@Data //It will generate getters and setters, required constructor and toString
public class Basket {
    private List<Pizza> basketList = new ArrayList<>();
    private BigDecimal sum = BigDecimal.ZERO;

    public void addToBasketList(Pizza pizza) {
        basketList.add(pizza);
        sum = sum.add(pizza.getPrice());
    }

    public void clearBasket(){
        basketList = new ArrayList<>();
        sum = BigDecimal.ZERO;
    }
}
