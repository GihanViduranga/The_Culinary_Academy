package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StudentRegistration {

    @FXML
    private ComboBox<?> cmbProgramName;

    @FXML
    private ComboBox<?> cmbSelectStatus;

    @FXML
    private ComboBox<?> cmbStudentID;

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colPaidAmount;

    @FXML
    private TableColumn<?, ?> colProgramFee;

    @FXML
    private TableColumn<?, ?> colProgramID;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblBalance;

    @FXML
    private Label lblDateOfBirth;

    @FXML
    private Label lblDuration;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblProgramFee;

    @FXML
    private Label lblProgramID;

    @FXML
    private Label lblStudentName;

    @FXML
    private Label lblTotal;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblStudentRegistration;

    @FXML
    private TextField txtPaidAmount;

    @FXML
    void btnAddNewOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddToTableOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

    }

    @FXML
    void cmbProgramNameOnAction(ActionEvent event) {

    }

    @FXML
    void cmbSelectStatusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbStudentIdOnAction(ActionEvent event) {

    }

}
