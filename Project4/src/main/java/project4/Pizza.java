package project4;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce = false;
    protected boolean extraCheese = false;

    // Constructor
    public Pizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        this.toppings = toppings;
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }
    public Pizza(Size size, Sauce sauce, ArrayList<Topping> toppings) {
        this.toppings = toppings;
        this.size = size;
        this.sauce = sauce;
    }

    // Abstract method to calculate the price
    public abstract double getPrice();

    // Method to add a topping
    public void addTopping(Topping topping) {
        if (!toppings.contains(topping)) {
            toppings.add(topping);
        }
    }

    // Method to remove a topping
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public void extraSauceSetter(boolean s){
        this.extraSauce = s;
    }
    public void extraCheeseSetter(boolean c){
        this.extraCheese = c;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", toppings,size,sauce,getPrice());
    }

    // Calculates additional price for extra Cheese or Sauce
    protected double additionalCost() {
        int additionalPrice = 0;
        if(extraSauce) additionalPrice+=1;
        if(extraCheese) additionalPrice+=1;
        return additionalPrice;
    }
}
