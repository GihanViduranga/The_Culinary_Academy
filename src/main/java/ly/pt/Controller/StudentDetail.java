package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import ly.pt.bo.custom.StudentBO;
import ly.pt.bo.custom.impl.StudentBOImpl;
import ly.pt.model.StudentDTO;

public class StudentDetail {

    @FXML
    private DatePicker dtpDateOfBirth;

    @FXML
    private Label lblStudentID;

    @FXML
    private AnchorPane root;

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
    private TextField txtStudentID;

    @FXML
    private TextField txtStudentName;

    StudentBO studentBO = new StudentBOImpl();

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String dateOfBirth = dtpDateOfBirth.getValue().toString();
        String address = txtAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String email = txtEmail.getText();

        StudentDTO studentDTO = new StudentDTO(id, name, dateOfBirth, address, phoneNumber, email);

        try {
            boolean isSaved = studentBO.saveStudent(studentDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved!").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String dateOfBirth = dtpDateOfBirth.getValue().toString();
        String address = txtAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String email = txtEmail.getText();

        StudentDTO studentDTO = new StudentDTO(id, name, dateOfBirth, address, phoneNumber, email);

        try {
            boolean isUpdated = studentBO.updateStudent(studentDTO);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Student updated!").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
