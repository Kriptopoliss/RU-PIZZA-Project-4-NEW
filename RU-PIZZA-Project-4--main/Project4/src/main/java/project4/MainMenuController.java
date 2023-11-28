package project4;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private ImageView specialtyPizza, buildYourOwn, currentOrder, orderDetails;

    /**
     * Load the Specialty Pizza scene when the specialty pizza image is clicked.
     *
     * @param event The mouse event indicating a click on the specialty pizza image.
     */
    @FXML
    private void loadSpecialtyPizza(MouseEvent event) {
        loadScene("/project4/OrderSpecialty.fxml");
    }

    /**
     * Load the Build Your Own Pizza scene when the build your own image is clicked.
     *
     * @param event The mouse event indicating a click on the build your own image.
     */
    @FXML
    private void loadBuildYourOwn(MouseEvent event) {
        loadScene("/project4/BuildYourOwn.fxml");
    }

    /**
     * Load the Current Order scene when the current order image is clicked.
     *
     * @param event The mouse event indicating a click on the current order image.
     */
    @FXML
    private void loadCurrentOrder(MouseEvent event) {
        loadScene("/project4/CurrentOrder.fxml");
    }

    /**
     * Load the Order Details scene when the order details image is clicked.
     *
     * @param event The mouse event indicating a click on the order details image.
     */
    @FXML
    private void loadOrderDetails(MouseEvent event) {
        loadScene("/project4/OrderDetails.fxml");
    }

    /**
     * Load a new scene using the provided FXML file path.
     *
     * @param fxmlPath The path to the FXML file of the scene to be loaded.
     */
    private void loadScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) specialtyPizza.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
