package pl.jacekplotnicki.PizzaCentre.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.jacekplotnicki.PizzaCentre.services.Basket;
import pl.jacekplotnicki.PizzaCentre.services.PizzaService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BasketController {
    private final Basket basket;
    private final PizzaService pizzaService;

    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("basketlist", pizzaService.getBasketList());
        model.addAttribute("sum", basket.getSum());
        return "basket";
    }
    @GetMapping("/basket/clear")
    public String clearBasket(){
        log.info("Clear Basket");
        basket.clearBasket();
        return "redirect:/basket";
    }

    @GetMapping("/success") //@GetMapping connects url link with html
    public String makeOrder(){
        basket.clearBasket();
        return "success";
    }

    @GetMapping("/basket/remove/{id}")
    public String remove1PizzaFromBasket(@PathVariable int id){
        pizzaService.remove1PizzaFromBasket(id);
        return "redirect:/basket";
    }
}
