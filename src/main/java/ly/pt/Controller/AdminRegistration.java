package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminRegistration {

    @FXML
    private Label lblAdminID;

    @FXML
    private TableColumn<?, ?> tblAdminID;

    @FXML
    private TableColumn<?, ?> tblAdminUsername;

    @FXML
    private TableView<?> tblCoordinatorTable;

    @FXML
    private PasswordField txtAdminPassword;

    @FXML
    private PasswordField txtAdminRePassword;

    @FXML
    private TextField txtAdminSecurityQuestion;

    @FXML
    private TextField txtAdminUsername;

    @FXML
    void btnConfirmOnAction(ActionEvent event) {

    }

}
