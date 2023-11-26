package project4;

import java.util.ArrayList;

public class PizzaMaker {

    /**
     * Creates a pizza of the specified type, size, sauce, extra options, and toppings.
     *
     * @param type The type of pizza to create.
     * @param size The size of the pizza.
     * @param sauce The type of sauce for the pizza.
     * @param extraSauce Indicates if extra sauce is required.
     * @param extraCheese Indicates if extra cheese is required.
     * @param toppings The list of toppings for the pizza.
     * @return The created Pizza object.
     */
    public static Pizza createPizza(String type, Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        Pizza pizza = null;

        switch (type.toLowerCase()) {
            case "deluxe":
                pizza = new Deluxe(size); // Assuming Deluxe constructor
                break;
            case "supreme":
                pizza = new Supreme(size); // Assuming Supreme constructor
                break;
            case "meatzza":
                pizza = new Meatzza(size); // Assuming Meatzza constructor
                break;
            case "seafood":
                pizza = new Seafood(size); // Assuming Seafood constructor
                break;
            case "pepperoni":
                pizza = new Pepperoni(size); // Assuming Pepperoni constructor
                break;
            case "build your own":
                pizza = new BuildYourOwn(size, sauce, extraSauce, extraCheese, toppings);
                break;
            default:
                // Handle unknown pizza types
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }

        return pizza;
    }
}
