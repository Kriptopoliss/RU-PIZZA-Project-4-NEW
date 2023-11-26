package project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Seafood extends Pizza {

    public Seafood(Size size) {
        super(size, Sauce.ALFREDO, (ArrayList<Topping>) Arrays.asList(Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEAT));
    }

    @Override
    public double getPrice() {
        double basePrice = 17.99;   // Small size base price for SeaFood pizza
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
