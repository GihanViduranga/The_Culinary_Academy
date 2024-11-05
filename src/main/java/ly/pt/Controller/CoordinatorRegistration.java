package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CoordinatorRegistration {

    public AnchorPane root;
    @FXML
    private Label lblCoordinatorID;

    @FXML
    private TableView<?> tblCoordinatorTable;

    @FXML
    private TableColumn<?, ?> tblCoordinatorUsername;

    @FXML
    private TableColumn<?, ?> tblCoordinatorID;

    @FXML
    private PasswordField txtCoordinatorPassword;

    @FXML
    private PasswordField txtCoordinatorRePassword;

    @FXML
    private TextField txtCoordinatorSecurityQuestion;

    @FXML
    private TextField txtCoordinatorUsername;

    @FXML
    void btnConfirmOnAction(ActionEvent event) {

    }

}
