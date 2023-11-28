package project4;

import java.util.ArrayList;

public class StoreOrders {
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

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public int getOrderPos(int id){
        for(int i=0; i<orders.size(); i++){
            if(orders.get(i).getOrderNumber() == id){
                return i;
            }
        }
        return -1;
    }

    public int getLength(){
        return orders.size();
    }

    @Override
    public String toString() {
        return "Store Orders: " + orders;
    }
}
