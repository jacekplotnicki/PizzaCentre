package pl.jacekplotnicki.PizzaCentre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplotnicki.PizzaCentre.services.Basket;

@Controller
public class BasketController {
    Basket basket;

    @Autowired
    public BasketController(Basket basket) {
        this.basket = basket;
    }

    @RequestMapping(
            value = {"/basket"}
    )
    public String getBasket(Model model) {
        model.addAttribute("basketlist", basket.getBasketlist());
        return "basket";
    }
}
