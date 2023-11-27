package project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza {

    public Meatzza(Size size) {
        super(size, Sauce.TOMATO, new ArrayList<Topping> (Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM)));
    }

    @Override
    public double getPrice() {
        double basePrice = 16.99; // Small size base price
        switch(this.size){
            case LARGE:
                return basePrice + 4.00;
            case MEDIUM:
                return basePrice + 2.00;
            default:
                return basePrice;
        }
    }
}
