package project4;
import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza {

    public Deluxe(Size size) {
        super(size, Sauce.TOMATO, new ArrayList<Topping>(Arrays.asList(
                Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM)));
    }

    @Override
    public double getPrice() {
        double basePrice = 14.99;  // Base price for Deluxe small pizza
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
