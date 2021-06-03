package pl.jacekplotnicki.PizzaCentre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasketController {
    @RequestMapping(
            value = {"/basket"}
    )
    public String getbasket() {
        return "basket";
    }
}
