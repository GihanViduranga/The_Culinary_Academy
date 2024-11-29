package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ly.pt.bo.BOFactory;
import ly.pt.bo.custom.AdminBO;

import java.io.IOException;

public class ForgetPasswordController {

    @FXML
    public TextField txtUserName;
    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtNewPassword;

    @FXML
    private TextField txtQuestion;

    @FXML
    private PasswordField txtReEnterPassword;

    AdminBO adminBO = (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADMIN);
    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        String userName = txtUserName.getText();
        String newPassword = txtNewPassword.getText();
        String question = txtQuestion.getText();
        String reEnterPassword = txtReEnterPassword.getText();

        if (newPassword .equals(reEnterPassword) ){
            boolean a = adminBO.updatePassword(newPassword,userName);
            if (a){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Password Changed Successfully");
                alert.setContentText("New Password Saved!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Password Change Failed");
                alert.setContentText("Please try again!");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Password Not Matched");
            alert.setContentText("Please try again!");
            alert.showAndWait();
            txtReEnterPassword.setText("");
            txtNewPassword.setText("");
        }
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        AnchorPane rootNode = null;
        try {
            rootNode = FXMLLoader.load(this.getClass().getResource("/view/Login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
    }

}
