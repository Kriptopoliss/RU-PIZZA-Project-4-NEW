package project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Seafood extends Pizza {

    /**
     * Constructor for creating a Seafood pizza object.
     *
     * @param size       The size of the pizza (small, medium, large).
     * @param extraCheese Indicates whether extra cheese is added.
     * @param extraSauce Indicates whether extra sauce is added.
     */
    public Seafood(Size size, Boolean extraCheese, Boolean extraSauce) {
        super(size, Sauce.ALFREDO, extraSauce, extraCheese, new ArrayList<Topping>(Arrays.asList(Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEAT)));
    }

    /**
     * Calculate the price of the Seafood pizza based on its size and toppings.
     *
     * @return The price of the Seafood pizza.
     */
    @Override
    public double getPrice() {
        double basePrice = 17.99; // Small size base price for Seafood pizza
        if (this.extraCheese) basePrice += 1;
        if (this.extraSauce) basePrice += 1;
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
