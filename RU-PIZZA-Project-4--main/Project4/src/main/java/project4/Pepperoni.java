package project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pepperoni extends Pizza {

    public Pepperoni(Size size, Boolean eC, Boolean eS) {
        super(size, Sauce.TOMATO,eS,eC, new ArrayList<Topping> (Arrays.asList(Topping.PEPPERONI)));
    }

    @Override
    public double getPrice() {
        double basePrice = 10.99; // Small size base price
        if(this.extraCheese) basePrice+=1;
        if(this.extraSauce) basePrice+=1;
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
