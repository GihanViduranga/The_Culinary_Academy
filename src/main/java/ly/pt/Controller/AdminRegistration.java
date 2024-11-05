package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import ly.pt.bo.custom.AdminBO;
import ly.pt.bo.custom.impl.AdminBOImpl;
import ly.pt.model.AdminDTO;

public class AdminRegistration {

    public AnchorPane root;
    @FXML
    private Label lblAdminID;

    @FXML
    private TableColumn<?, ?> tblAdminID;

    @FXML
    private TextField txtAdminID;

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
        String useId = txtAdminID.getText();
        String username = txtAdminUsername.getText();
        String password = txtAdminPassword.getText();
        String securityQuestion = txtAdminSecurityQuestion.getText();

        String reEnter = txtAdminRePassword.getText();

        if (reEnter.equals(password)){
            AdminDTO admin = new AdminDTO(useId, username, password,securityQuestion);

            boolean isSaved = false;
            try {
                AdminBO adminBO = new AdminBOImpl();
                isSaved = adminBO.saveAdmin(admin);
            }catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                isSaved = false;
            }
            if (isSaved) {
                /*initialize();*/
                new Alert(Alert.AlertType.INFORMATION, "Admin saved successfully").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Admin saved Unsuccessfully").show();
            }
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Password Not Match").show();
            txtAdminPassword.setText("");
            txtAdminRePassword.setText("");
        }
    }

    @FXML
    void btnChangeUsernameAndPasswordOnAction(ActionEvent event) {

    }

}
