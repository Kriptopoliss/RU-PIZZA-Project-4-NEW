package project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza {

    /**
     * Constructor for creating a Meatzza pizza object.
     *
     * @param size       The size of the pizza (small, medium, large).
     * @param extraCheese Indicates whether extra cheese is added.
     * @param extraSauce Indicates whether extra sauce is added.
     */
    public Meatzza(Size size, Boolean extraCheese, Boolean extraSauce) {
        super(size, Sauce.TOMATO, extraSauce, extraCheese, new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM)));
    }

    /**
     * Calculate the price of the Meatzza pizza based on its size and toppings.
     *
     * @return The price of the Meatzza pizza.
     */
    @Override
    public double getPrice() {
        double basePrice = 16.99; // Small size base price
        if (this.extraCheese) basePrice += 1;
        if (this.extraSauce) basePrice += 1;
        switch (this.size) {
            case LARGE:
                return basePrice + 4.00;
            case MEDIUM:
                return basePrice + 2.00;
            default:
                return basePrice;
        }
    }
}
