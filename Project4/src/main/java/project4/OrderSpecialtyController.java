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


public class OrderSpecialtyController {

    @FXML
    private ImageView pizzaImage;

    @FXML
    private ComboBox<String> pizzaType;

    @FXML
    private RadioButton smallSize, mediumSize, largeSize;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private ListView<Topping> toppingsListView;

    @FXML
    private TextField sauceTextField, totalPrice;

    @FXML
    private CheckBox extraSauce, extraCheese;

    @FXML
    private Button addToOrder;

    @FXML
    private Button backButton;

    @FXML
    private Label priceLabel;

    @FXML
    private ComboBox<Size> sizeComboBoxSpecial;



    @FXML
    public void initialize() {
        pizzaType.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");    // Populate size choices
        sizeComboBoxSpecial.getItems().addAll(Size.SMALL, Size.MEDIUM, Size.LARGE);    // Populate size choices

        pizzaType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateToppingsAndSauce(newValue);
        });

        sauceTextField.setEditable(false);
        totalPrice.setEditable(false);
        pizzaType.valueProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
        sizeComboBoxSpecial.valueProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
        extraSauce.selectedProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
        extraCheese.selectedProperty().addListener((obs, oldVal, newVal) -> calculatePrice());
    }

    private void calculatePrice() {
        if (isPizzaValid()) {
            String sauceText = sauceTextField.getText().toUpperCase();
            Size size = sizeComboBoxSpecial.getValue();
            Sauce sauce = Sauce.valueOf(sauceText);
            boolean eS = extraSauce.isSelected();
            boolean eC = extraCheese.isSelected();
            ArrayList<Topping> selectedToppings = new ArrayList<>();

        /// NEED TO IMPLEMENT SIZE BUTTONS TO GET SIZE
            Pizza pizza = PizzaMaker.createPizza("build your own", size, sauce, eS, eC, selectedToppings);
            double price = pizza.getPrice();

            totalPrice.setText(String.format("$%.2f", price));
        }
    }

    public void setDeluxe() {
        toppingsListView.getItems().clear();
        toppingsListView.getItems().addAll(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM);
        sauceTextField.setText("tomato");
        updatePizzaImage("Deluxe");
    }

    public void setSupreme() {
        toppingsListView.getItems().clear();
        toppingsListView.getItems().addAll(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER,
                Topping.ONION, Topping.MUSHROOM, Topping.BLACK_OLIVE, Topping.HAM);
        sauceTextField.setText("tomato");
        updatePizzaImage("Supreme");
    }

    public void setSeafood() {
        toppingsListView.getItems().clear();
        toppingsListView.getItems().addAll(Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEAT);
        sauceTextField.setText("alfredo");
        updatePizzaImage("SeaFood");
    }

    public void setMeatzza() {
        toppingsListView.getItems().clear();
        toppingsListView.getItems().addAll(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM);
        sauceTextField.setText("tomato");
        updatePizzaImage("Meatzza");
    }

    @FXML
    private void loadSpecialtyPizza(MouseEvent event) {
        loadScene("/project4/OrderSpecialty.fxml");
    }

    public void setPepperoni() {
        toppingsListView.getItems().clear();
        toppingsListView.getItems().addAll(Topping.PEPPERONI);
        sauceTextField.setText("tomato");
        updatePizzaImage("Pepperoni");
    }

    private void updateToppingsAndSauce(String pizzaType) {
        switch (pizzaType) {
            case "Deluxe":
                setDeluxe();
                break;
            case "Supreme":
                setSupreme();
                break;
            case "Seafood":
                setSeafood();
                break;
            case "Meatzza":
                setMeatzza();
                break;
            case "Pepperoni":
                setPepperoni();
                break;
            default:
                break;
        }
    }
    private void updatePizzaImage(String pizzaType) {
        if (pizzaType != null && !pizzaType.isEmpty()) {
            String imageName = pizzaType.substring(0, 1).toUpperCase() + pizzaType.substring(1).toLowerCase() + ".png";
            String imagePath = "/" + imageName; // Modify as per your image paths
            try {
                Image image = new Image(getClass().getResourceAsStream(imagePath));
                pizzaImage.setImage(image);
            } catch (Exception e) {
                System.out.println("Image not found: " + imagePath);
                pizzaImage.setImage(new Image("pizza.png"));
            }
        }
    }
    private boolean isPizzaValid() {
        // Check if Type is selected
        if (pizzaType.getValue() == null) {
            showAlert("Warning", "Please select a pizza type.");
            return false;
        }

        // If everything is fine
        return true;
    }
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
            Stage stage = (Stage) backButton.getScene().getWindow();
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