package project4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {

    public BuildYourOwn(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        super(size, sauce, extraSauce, extraCheese, toppings);
    }

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
