package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAdminId;

    @FXML
    private PasswordField txtPasswoard;

    @FXML
    void btnLoginInOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        AnchorPane anchorPane = loader.load();

        Stage stage = (Stage) root.getScene().getWindow();
        Scene scene = new Scene(anchorPane);

        stage.setScene(scene);
        stage.setTitle("Customer Form");
        stage.show();
    }

}
