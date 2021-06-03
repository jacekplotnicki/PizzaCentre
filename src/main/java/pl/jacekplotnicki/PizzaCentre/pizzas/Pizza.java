package pl.jacekplotnicki.PizzaCentre.pizzas;

public class Pizza {
    public String pizzaName;
    public String pizzaDescription;
    public double pizzaPrice;
    public String image;
    public Pizza(String pizzaName,String pizzaDescription, double pizzaPrice, String image){
        this.pizzaName = pizzaName;
        this.pizzaDescription = pizzaDescription;
        this.pizzaPrice = pizzaPrice;
        this.image = image;
    }
}
