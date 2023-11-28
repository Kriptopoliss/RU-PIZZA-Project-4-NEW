package project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza {

    public Meatzza(Size size, Boolean eC, Boolean eS) {
        super(size, Sauce.TOMATO,eS,eC, new ArrayList<Topping> (Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM)));
    }

    @Override
    public double getPrice() {
        double basePrice = 16.99; // Small size base price
        if(this.extraCheese) basePrice+=1;
        if(this.extraSauce) basePrice+=1;
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
