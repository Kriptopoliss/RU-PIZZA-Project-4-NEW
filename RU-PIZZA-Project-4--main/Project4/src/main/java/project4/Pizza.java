package project4;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce = false;
    protected boolean extraCheese = false;

    /**
     * Constructor for creating a pizza with specified size, sauce, toppings, extra sauce, and extra cheese.
     *
     * @param size        The size of the pizza (small, medium, large).
     * @param sauce       The type of sauce for the pizza.
     * @param extraSauce  Indicates whether extra sauce is added.
     * @param extraCheese Indicates whether extra cheese is added.
     * @param toppings    A list of toppings for the pizza.
     */
    public Pizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        this.toppings = toppings;
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
    }

    /**
     * Constructor for creating a pizza with specified size, sauce, and toppings.
     *
     * @param size     The size of the pizza (small, medium, large).
     * @param sauce    The type of sauce for the pizza.
     * @param toppings A list of toppings for the pizza.
     */
    public Pizza(Size size, Sauce sauce, ArrayList<Topping> toppings) {
        this.toppings = toppings;
        this.size = size;
        this.sauce = sauce;
    }

    /**
     * Abstract method to calculate the price of the pizza.
     *
     * @return The price of the pizza.
     */
    public abstract double getPrice();

    /**
     * Add a topping to the pizza.
     *
     * @param topping The topping to be added.
     */
    public void addTopping(Topping topping) {
        if (!toppings.contains(topping)) {
            toppings.add(topping);
        }
    }

    /**
     * Remove a topping from the pizza.
     *
     * @param topping The topping to be removed.
     */
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    /**
     * Set the extra sauce option for the pizza.
     *
     * @param extraSauce Indicates whether extra sauce is added.
     */
    public void extraSauceSetter(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }

    /**
     * Set the extra cheese option for the pizza.
     *
     * @param extraCheese Indicates whether extra cheese is added.
     */
    public void extraCheeseSetter(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    /**
     * Generate a string representation of the pizza, including its size, sauce, extra sauce, extra cheese, and toppings.
     *
     * @return A string representation of the pizza.
     */
    @Override
    public String toString() {
        return "Size: " + size + ", Sauce: " + sauce + ", Extra Sauce: " + extraSauce + ", Extra Cheese: " + extraCheese + ", Toppings: " + toppings;
    }

    /**
     * Calculate the additional cost for extra cheese or extra sauce.
     *
     * @return The additional cost for extra cheese or extra sauce.
     */
    protected double additionalCost() {
        int additionalPrice = 0;
        if (extraSauce || extraCheese) additionalPrice += 1;
        if (extraSauce && extraCheese) additionalPrice += 2;
        return additionalPrice;
    }
}
