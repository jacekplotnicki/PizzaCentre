package pl.jacekplotnicki.PizzaCentre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jacekplotnicki.PizzaCentre.services.PizzaService;

@Controller

public class MenuController {

    PizzaService pizzaService;
    @Autowired
    public MenuController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

    @RequestMapping(value = "/menu")
    public String getmenu(Model model){
        model.addAttribute("list", pizzaService.getAll());
        return "menu";

    }





}
