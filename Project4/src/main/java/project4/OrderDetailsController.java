package project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;


public class OrderDetailsController {
    @FXML
    private Button exportButton;
    @FXML
    private Button cancelOrderButton;
    @FXML
    private ComboBox<String> orderNumbers;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView<String> orderDetailsListView;
    StoreOrders orders = new StoreOrders();

    int id = 0;

    @FXML
    public void initialize() {
        for(int i=0; i<orders.getLength();i++){
            orderNumbers.getItems().add(Integer.toString(orders.getOrders().get(i).getOrderNumber()));
        }

        orderTotal.setText("");
        orderNumbers.valueProperty().addListener((obs, oldVal, newVal) -> showPizza());
    }

    private void showPizza(){
        int id = orders.getOrderPos(Integer.parseInt(orderNumbers.getValue()));
        orderTotal.setText(String.format("$%.2f", orders.getOrders().get(id).getTotalPrice()));
        for(int i = 0; i<orders.getOrders().get(id).getPizzas().size();i++) {
            orderDetailsListView.getItems().add(orders.getOrders().get(id).getPizzas().get(i).toString());
        }
    }

}
