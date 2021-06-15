package pl.jacekplotnicki.PizzaCentre.services;

import pl.jacekplotnicki.PizzaCentre.pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Pizza>basketlist = new ArrayList<>();
    private double sum = 0;

    public List<Pizza> getBasketlist() {
        return basketlist;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setBasketlist(List<Pizza> basketlist) {
        this.basketlist = basketlist;
    }
}
