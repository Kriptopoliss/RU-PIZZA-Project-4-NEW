package project4;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    /**
     * Constructor for creating an Order object with a specified order number.
     *
     * @param orderNumber The unique order number associated with this order.
     */
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.pizzas = new ArrayList<Pizza>();
    }

    /**
     * Add a pizza to the order.
     *
     * @param pizza The pizza to be added to the order.
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * Remove a pizza from the order.
     *
     * @param pizza The pizza to be removed from the order.
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Calculate the total price of the order based on the prices of individual pizzas.
     *
     * @return The total price of the order.
     */
    public double getTotalPrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        return total;
    }

    /**
     * Get the order number associated with this order.
     *
     * @return The order number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Generate a string representation of the order, including its order number and list of pizzas.
     *
     * @return A string representation of the order.
     */
    @Override
    public String toString() {
        return "Order Number: " + orderNumber + ", Pizzas: " + pizzas;
    }
}
