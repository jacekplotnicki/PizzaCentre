package pl.jacekplotnicki.PizzaCentre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jacekplotnicki.PizzaCentre.pizzas.Pizza;
import java.util.ArrayList;
import java.util.List;
@Service
public class PizzaService {
    Basket basket;
    @Autowired
    public PizzaService(Basket basket){
        this.basket = basket;

    }
    public List<Pizza> getPizzaList(){
        List<Pizza>pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("Pizza Margherita", "Pizza with tomato sauce and cheese", 24.00, "pizza1", 1));
        pizzaList.add(new Pizza("Pizza Capricciosa", "Pizza with tomato sauce, cheese, ham, shrooms", 29.00, "pizza2", 2));
        pizzaList.add(new Pizza("Pizza Pepperoni", "Pizza with tomato sauce, cheese and pepperoni", 28.00, "pizza3", 3));
        pizzaList.add(new Pizza("Pizza Hawaii", "Pizza with tomato sauce, cheese, ham and pineapple", 29.00, "pizza4", 4));
        pizzaList.add(new Pizza("Pizza Carbonara", "Pizza with tomato sauce, cheese, bacon and onion", 30.00, "pizza5", 5));
        pizzaList.add(new Pizza("Pizza Cheese", "Pizza just cheese", 35.00, "pizza1", 6));
        return pizzaList;
    }
    public Pizza getPizzaById(int id){
        List<Pizza> productList = getPizzaList();
        Pizza not_found = productList.stream().filter(element -> element.id == id).findFirst().orElse(new Pizza("not found"));
        System.out.println(not_found);
        return not_found;
    }

    public void addPizzaToCart(int id){
        Pizza element = getPizzaById(id);
        basket.getBasketlist().add(element);
    }
}
