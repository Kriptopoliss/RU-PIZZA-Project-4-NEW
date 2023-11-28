//@authors Ethan and Mykola
package project4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    /**
     * Constructor for creating a BuildYourOwn pizza object.
     *
     * @param size The size of the pizza (small, medium, large).
     * @param sauce The type of sauce for the pizza.
     * @param extraSauce Indicates whether extra sauce is added.
     * @param extraCheese Indicates whether extra cheese is added.
     * @param toppings A list of toppings for the pizza.
     */
    public BuildYourOwn(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        super(size, sauce, extraSauce, extraCheese, toppings);
    }
    /**
     * Calculates and returns the price of the BuildYourOwn pizza.
     * This price is based on the size of the pizza, the number of toppings (beyond the included three),
     * and any additional costs for extra sauce or cheese.
     *
     * @return The total price of the pizza.
     */
    @Override
    public double getPrice() {
        double basePrice;

        switch (this.size) {
            case MEDIUM:
                basePrice = 10.99; // Base price for medium
                break;
            case LARGE:
                basePrice = 12.99; // Base price for large
                break;
            default:
                basePrice = 8.99; // Base price for small
        }

        double toppingPrice = 1.49; // Price per additional topping
        int includedToppings = 3; // The first three toppings are included in base price
        int extraToppings = Math.max(this.toppings.size() - includedToppings, 0);

        return basePrice + (extraToppings * toppingPrice) + super.additionalCost();
    }
}
