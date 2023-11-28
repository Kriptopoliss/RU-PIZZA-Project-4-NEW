package project4;

import java.util.ArrayList;
import java.util.Arrays;

public class Supreme extends Pizza {

    /**
     * Constructor for creating a Supreme pizza object.
     *
     * @param size       The size of the pizza (small, medium, large).
     * @param extraCheese Indicates whether extra cheese is added.
     * @param extraSauce Indicates whether extra sauce is added.
     */
    public Supreme(Size size, Boolean extraCheese, Boolean extraSauce) {
        super(size, Sauce.TOMATO, extraSauce, extraCheese, new ArrayList<Topping>(Arrays.asList(
                Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER,
                Topping.ONION, Topping.MUSHROOM, Topping.BLACK_OLIVE, Topping.HAM)));
    }

    /**
     * Calculate the price of the Supreme pizza based on its size and toppings.
     *
     * @return The price of the Supreme pizza.
     */
    @Override
    public double getPrice() {
        double basePrice = 15.99; // Base price for Supreme small
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
