package project4;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.pizzas = new ArrayList<Pizza>();
    }

    private int generateOrderNumber(){

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

    public int getOrderNumber(){
        return orderNumber;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderNumber + ", Pizzas: " + pizzas;
    }
}
