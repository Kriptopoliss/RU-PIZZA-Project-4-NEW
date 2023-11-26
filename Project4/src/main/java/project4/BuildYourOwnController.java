package project4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class BuildYourOwnController {

    @FXML
    private ComboBox<Size> sizeComboBox;
    @FXML
    private RadioButton tomatoSauce, alfredoSauce;
    @FXML
    private CheckBox extraSauceCheckBox, extraCheeseCheckBox;
    @FXML
    private ListView<String> toppingsListView, selectedToppingListView;
    @FXML
    private TextField priceTextField;
    @FXML
    private Button addToOrderButton;
    @FXML
    private ImageView pizzaImage;


    @FXML
    public void initialize() {
        sizeComboBox.getItems().addAll(Size.SMALL, Size.MEDIUM, Size.LARGE);    // Populate size choices
        // Adding toppings from the Topping enum
        for (Topping topping : Topping.values()) {
            toppingsListView.getItems().add(topping.name());
        }

    }

    @FXML
    private void addTopping() {
        String selectedTopping = toppingsListView.getSelectionModel().getSelectedItem();
        if (selectedTopping != null && !selectedToppingListView.getItems().contains(selectedTopping)) {
            selectedToppingListView.getItems().add(selectedTopping);
        }
        toppingsListView.getItems().remove(selectedTopping);
    }

    @FXML
    private void removeTopping() {
        String selectedTopping = selectedToppingListView.getSelectionModel().getSelectedItem();
        if (selectedTopping != null) {
            selectedToppingListView.getItems().remove(selectedTopping);
        }
        toppingsListView.getItems().add(selectedTopping);
    }

    private Sauce getSauceSelection() {
        if (tomatoSauce.isSelected()) {
            return Sauce.TOMATO;
        } else if (alfredoSauce.isSelected()) {
            return Sauce.ALFREDO;
        }
        return null;                            // Default or error handling
    }

    private void calculatePrice() {
        Size size = sizeComboBox.getValue();
        Sauce sauce = getSauceSelection();
        boolean extraSauce = extraSauceCheckBox.isSelected();
        boolean extraCheese = extraCheeseCheckBox.isSelected();
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        for (String toppingName : selectedToppingListView.getItems()) {
            selectedToppings.add(Topping.valueOf(toppingName.toUpperCase()));
        }

        Pizza pizza = PizzaMaker.createPizza("build your own", size, sauce, extraSauce, extraCheese, selectedToppings);
        double price = pizza.getPrice();

        priceTextField.setText(String.format("$%.2f", price));
    }

    @FXML
    private void handleAddToOrder() {
        Size size = sizeComboBox.getValue();
        Sauce sauce = getSauceSelection();
        boolean extraSauce = extraSauceCheckBox.isSelected();
        boolean extraCheese = extraCheeseCheckBox.isSelected();
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        for (String toppingName : selectedToppingListView.getItems()) {
            selectedToppings.add(Topping.valueOf(toppingName.toUpperCase()));
        }

        Pizza pizza = PizzaMaker.createPizza("build your own", size, sauce, extraSauce, extraCheese, selectedToppings);

        // Assuming you have a method to add the pizza to the order
        // order.addPizza(pizza);

        calculatePrice(); // Update the price
    }
}

