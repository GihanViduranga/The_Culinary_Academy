package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StudentDetail {

    @FXML
    private AnchorPane root;

    @FXML
    private DatePicker dtpDateOfBirth;

    @FXML
    private Label lblStudentID;

    @FXML
    private TableColumn<?, ?> tblAddress;

    @FXML
    private TableColumn<?, ?> tblDateOfBirth;

    @FXML
    private TableColumn<?, ?> tblEmail;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblPhoneNumber;

    @FXML
    private TableView<?> tblProgramTable;

    @FXML
    private TableColumn<?, ?> tblStudentID;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtStudentName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
