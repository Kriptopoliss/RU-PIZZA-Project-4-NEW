package project4;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private Button backButtonBYO;
    private final int MAX_TOPPINGS = 7;


    @FXML
    public void initialize() {
        priceTextField.setEditable(false);
        sizeComboBox.getItems().addAll(Size.SMALL, Size.MEDIUM, Size.LARGE);    // Populate size choices
        // Adding toppings from the Topping enum
        for (Topping topping : Topping.values()) {
            toppingsListView.getItems().add(topping.name());
        }
        sizeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
        extraSauceCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
        extraCheeseCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
        selectedToppingListView.getItems().addListener(
                (ListChangeListener.Change<? extends String> change) -> calculatePrice());

    }

    @FXML
    private void addTopping() {
        String selectedTopping = toppingsListView.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){
            // No topping selected
            showAlert("Warning", "Please select a topping first.");
        }
        if (isPizzaValid() && selectedTopping!=null) {
            // Check if the maximum number of toppings has not been exceeded
            if (selectedToppingListView.getItems().size() < MAX_TOPPINGS
                    && !selectedToppingListView.getItems().contains(selectedTopping)) {
                selectedToppingListView.getItems().add(selectedTopping);
                toppingsListView.getItems().remove(selectedTopping);
            } else {
                // Maximum toppings exceeded
                showAlert("Warning", "Maximum number of toppings reached!");

            }
        }
    }


    @FXML
    private void removeTopping() {
        String selectedTopping = selectedToppingListView.getSelectionModel().getSelectedItem();

        if(selectedToppingListView.getItems().size()==0) showAlert("Topping Selection", "No toppings to remove");
        else if(selectedTopping==null) showAlert("Topping Selection", "Please select a topping to remove first.");

        if (selectedTopping != null) {

            selectedToppingListView.getItems().remove(selectedTopping);
            toppingsListView.getItems().add(selectedTopping);
        }

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
        if (isPizzaValid()) {
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

        Pizza pizza = null;                // Creating new instance of Pizza object

        if(selectedToppingListView.getItems().size()<3){
            showAlert("Insufficient Toppings", "Please select at least 3 toppings");
        } else pizza = PizzaMaker.createPizza("build your own", size, sauce, extraSauce, extraCheese, selectedToppings);

        calculatePrice(); // Update the price
        int orderNumber = (OrderNumberGenerator.getInstance().generateOrderNumber());
        Order order1 = new Order(orderNumber); // generates a unique order number
        order1.addPizza(pizza);
        showAlert("Success", "Order #" + orderNumber + " placed successfully");
    }

    private boolean isPizzaValid() {
        // Check if Size is selected
        if (sizeComboBox.getValue() == null) {
            showAlert("Size Selection", "Please select a pizza size.");
            return false;
        }

        // If everything is fine
        return true;
    }

    // Method to create a pop-up Alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void loadScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) backButtonBYO.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadMainMenu(MouseEvent event) {
        loadScene("/project4/MainMenu.fxml");
    }

}

