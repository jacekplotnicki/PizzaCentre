package pl.jacekplotnicki.PizzaCentre.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jacekplotnicki.PizzaCentre.models.Pizza;
import pl.jacekplotnicki.PizzaCentre.models.PizzaInBasket;
import pl.jacekplotnicki.PizzaCentre.models.PizzaRepository;
import pl.jacekplotnicki.PizzaCentre.models.UserForm;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private final Basket basket;
    private final PizzaRepository pizzaRepository;
    private final MailSerivce mailSerivce;

    public Pizza getPizzaById(int id) {
        List<Pizza> productList = pizzaRepository.getAll();
        Pizza not_found = productList.stream().filter(element -> element.getId() == id).findFirst().orElse(new Pizza("not found"));
        System.out.println(not_found);
        return not_found;
    }

    public void addPizzaToCart(int id) {
        Pizza pizza = getPizzaById(id);
        basket.addToBasketList(pizza);
    }

    public List<Pizza> getAll() {
        return pizzaRepository.getAll();
    }

    public void clearBasket() {
        basket.clearBasket();
    }

    public List<PizzaInBasket> getBasketList() {
        List<Pizza> basketList = basket.getBasketList();
        List<PizzaInBasket> pizzaInBasketList = new ArrayList<>();
        for (Pizza pizza : basketList) {
            PizzaInBasket pizzaInBasket = PizzaInBasket.builder()
                    .id(pizza.getId())
                    .name(pizza.getName())
                    .description(pizza.getDescription())
                    .image(pizza.getImage())
                    .price(pizza.getPrice())
                    .build();
            if (!pizzaInBasketList.contains(pizzaInBasket)) {
                pizzaInBasket.setQuantity(1);
                pizzaInBasketList.add(pizzaInBasket);
            } else {
                int index = pizzaInBasketList.indexOf(pizzaInBasket); //Algorithm checks quantity of pizzas and adds +1 and sum price.
                PizzaInBasket pizzaInBasket1 = pizzaInBasketList.get(index);
                pizzaInBasket.setQuantity(pizzaInBasket1.getQuantity() + 1);
                pizzaInBasket.setPrice(pizzaInBasket1.getPrice().add(pizzaInBasket.getPrice()));
                pizzaInBasketList.set(index, pizzaInBasket);
            }

        }
        return pizzaInBasketList;
    }

    public void removePizzaFromBasket(int id){
        basket.getBasketList().remove(getPizzaById(id));
        basket.setSum(basket.getSum().subtract(getPizzaById(id).getPrice()));
    }

    public void addPizzaFromBasket(int id){
        basket.getBasketList().add(getPizzaById(id));
        basket.setSum(basket.getSum().add(getPizzaById(id).getPrice()));
    }

    public void sendMailOrder(UserForm userForm){
        try {
            mailSerivce.sendMail(userForm, getBasketList(), basket.getSum(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
