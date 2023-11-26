package project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pepperoni extends Pizza {

    public Pepperoni(Size size) {
        super(size, Sauce.TOMATO, (ArrayList<Topping>) Arrays.asList(Topping.SAUSAGE));
    }

    @Override
    public double getPrice() {
        double basePrice = 10.99; // Small size base price
        switch (this.size) {
            case MEDIUM:
                return basePrice + 2.00;
            case LARGE:
                return basePrice + 4.00;
            default:
                return basePrice;
        }
    }
}
