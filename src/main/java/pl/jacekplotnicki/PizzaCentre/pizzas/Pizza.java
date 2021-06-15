package pl.jacekplotnicki.PizzaCentre.pizzas;

public class Pizza {
    public String pizzaName;
    public String pizzaDescription;
    public double pizzaPrice;
    public String image;
    public int id;
    public Pizza(String pizzaName,String pizzaDescription, double pizzaPrice, String image, int id){
        this.pizzaName = pizzaName;
        this.pizzaDescription = pizzaDescription;
        this.pizzaPrice = pizzaPrice;
        this.image = image;
        this.id = id;
    }

    public Pizza(String pizzaName) {
        this.pizzaName = pizzaName;
    }
}
