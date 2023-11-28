package project4;

import java.util.ArrayList;

public class StoreOrders {
    private static StoreOrders instance = new StoreOrders();
    private ArrayList<Order> orders;

    public StoreOrders() {
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public static StoreOrders getInstance() {
        return instance;
    }

    public Order getOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Store Orders: " + orders;
    }
}
