package project4;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;
    private ArrayList<Integer> numbers = new ArrayList<>();
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.pizzas = new ArrayList<Pizza>();
    }



    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        return total;
    }

    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderNumber + ", Pizzas: " + pizzas;
    }
}
