package pl.jacekplotnicki.PizzaCentre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplotnicki.PizzaCentre.pizzas.Pizza;
import pl.jacekplotnicki.PizzaCentre.services.PizzaService;

import java.util.ArrayList;
import java.util.List;

@Controller

public class MenuController {

    PizzaService pizzaService;
    @Autowired
    public MenuController(PizzaService pizzaService){
        this.pizzaService = pizzaService;

    }
    @RequestMapping(
            value = "/menu"
    )
    public String getmenu(Model model){
        model.addAttribute("list", pizzaService.getPizzaList());
        return "menu";

    }





}
