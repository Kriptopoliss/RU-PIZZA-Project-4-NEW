package project4;

import java.util.ArrayList;

public class StoreOrders {
    private static StoreOrders instance = new StoreOrders();
    private ArrayList<Order> orders;

    /**
     * Private constructor for the StoreOrders class (Singleton pattern).
     */
    private StoreOrders() {
        orders = new ArrayList<Order>();
    }

    /**
     * Add an order to the list of store orders.
     *
     * @param order The order to be added.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Remove an order from the list of store orders.
     *
     * @param order The order to be removed.
     */
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    /**
     * Get the singleton instance of the StoreOrders class.
     *
     * @return The singleton instance of StoreOrders.
     */
    public static StoreOrders getInstance() {
        return instance;
    }

    /**
     * Get an order by its order number.
     *
     * @param orderNumber The order number to search for.
     * @return The order with the specified order number, or null if not found.
     */
    public Order getOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    /**
     * Generate a string representation of the store's orders.
     *
     * @return A string representation of the store's orders.
     */
    @Override
    public String toString() {
        return "Store Orders: " + orders;
    }
}
