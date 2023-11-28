package project4;
import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza {

    public Deluxe(Size size, Boolean eC, Boolean eS) {
        super(size, Sauce.TOMATO,eS, eC, new ArrayList<Topping>(Arrays.asList(
                Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM)));
    }

    @Override
    public double getPrice() {
        double basePrice = 14.99;  // Base price for Deluxe small pizza
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
