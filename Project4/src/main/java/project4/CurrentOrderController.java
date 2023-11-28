package project4;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.List;

public class CurrentOrderController {

    @FXML
    private TextField orderNumberField;

    @FXML
    private ListView<String> orderListView;

    @FXML
    private TextField subtotalField;

    @FXML
    private TextField salesTaxField;

    @FXML
    private TextField orderTotalField;

    private Order currentOrder; // Store the current order

    @FXML
    private void initialize() {
        orderNumberField.setDisable(true);
        setCurrentOrder();

    }
    @FXML
    public void setCurrentOrder() {
        // Update the orderNumberField with the current order number
        orderNumberField.setText("Order #" + currentOrder.getOrderNumber());

        // Display the pizzas in the orderListView
        orderListView.getItems().clear(); // Clear existing items
        List<Pizza> pizzas = currentOrder.getPizzas();
        for (Pizza pizza : pizzas) {
            orderListView.getItems().add(pizza.toString()); // Display each pizza
        }
    }
}
