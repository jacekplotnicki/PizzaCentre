package pl.jacekplotnicki.PizzaCentre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jacekplotnicki.PizzaCentre.services.PizzaService;

@RestController
public class RestPizzaController {
    PizzaService pizzaService;
    @Autowired
    public RestPizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;

    }
    @PostMapping("/rest/addToBasket")
    public void addPizzaToBasket(@RequestParam int id){
        System.out.println("Added to basket id: " + id);
        System.out.println(pizzaService.getPizzaById(id).toString());
        pizzaService.addPizzaToCart(id);
    }
}
