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

    @FXML
    private void loadSpecialtyPizza(MouseEvent event) {
        loadScene("/project4/OrderSpecialty.fxml");
    }
    @FXML
    private void loadBuildYourOwn(MouseEvent event) {
        loadScene("/project4/BuildYourOwn.fxml");
    }
    @FXML
    private void loadCurrentOrder(MouseEvent event) {
        loadScene("/project4/CurrentOrder.fxml");
    }
    @FXML
    private void loadOrderDetails(MouseEvent event) {
        loadScene("/project4/OrderDetails.fxml");
    }

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
