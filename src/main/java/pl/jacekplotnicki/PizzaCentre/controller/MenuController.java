package pl.jacekplotnicki.PizzaCentre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplotnicki.PizzaCentre.pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

@Controller

public class MenuController {
    @RequestMapping(
            value = "/menu"
    )
    public String getmenu(Model model){
        model.addAttribute("list", getPizzaList());
        return "menu";

    }
private List<Pizza>getPizzaList(){
        List<Pizza>pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("Pizza Margherita", "Pizza with tomato sauce and cheese", 24.00, "pizza1"));
        pizzaList.add(new Pizza("Pizza Capricciosa", "Pizza with tomato sauce, cheese, ham, shrooms", 29.00, "pizza2"));
        pizzaList.add(new Pizza("Pizza Pepperoni", "Pizza with tomato sauce, cheese and pepperoni", 28.00, "pizza3"));
        pizzaList.add(new Pizza("Pizza Hawaii", "Pizza with tomato sauce, cheese, ham and pineapple", 29.00, "pizza4"));
        pizzaList.add(new Pizza("Pizza Carbonara", "Pizza with tomato sauce, cheese, bacon and onion", 30.00, "pizza5"));
        pizzaList.add(new Pizza("Pizza Cheese", "Pizza just cheese", 35.00, "pizza1"));
        return pizzaList;
}




}
