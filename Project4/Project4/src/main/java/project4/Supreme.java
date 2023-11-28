package project4;
import java.util.ArrayList;
import java.util.Arrays;

public class Supreme extends Pizza {

    public Supreme(Size size, Boolean eC, Boolean eS) {
        super(size, Sauce.TOMATO,eS,eC, new ArrayList<Topping>(Arrays.asList(
                Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER,
                Topping.ONION, Topping.MUSHROOM, Topping.BLACK_OLIVE, Topping.HAM)));
    }
    @Override
    public double getPrice() {
        double basePrice = 15.99; // Base price for Supreme small
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
