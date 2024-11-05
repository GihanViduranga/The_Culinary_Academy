package ly.pt.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import ly.pt.bo.custom.StudentBO;
import ly.pt.bo.custom.impl.StudentBOImpl;
import ly.pt.model.StudentDTO;
import ly.pt.viewTm.StudentTm;

import java.time.LocalDate;
import java.util.List;

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
    private TableView<StudentTm> tblStudentTable;

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

    public void initialize(){
        loadAllStudents();
        setCellValueFactory();
    }

    private void setCellValueFactory(){
        tblStudentID.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    }

    private void loadAllStudents() {
        ObservableList<StudentTm> students = FXCollections.observableArrayList();

        List<StudentDTO> studentsDTO = studentBO.getAllStudents();

        for (StudentDTO student : studentsDTO) {
            StudentTm studentTm = new StudentTm(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getDateOfBirth().toString(),
                    student.getAddress(),
                    student.getPhoneNumber(),
                    student.getEmail()
            );
            students.add(studentTm);
        }
        tblStudentTable.setItems(students);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String dateOfBirth = dtpDateOfBirth.getValue().toString();
        String address = txtAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String email = txtEmail.getText();

        StudentDTO studentDTO = new StudentDTO(id, name, dateOfBirth, address, phoneNumber, email);

        try {
            boolean isDeleted = studentBO.deleteStudent(id, studentDTO);
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Student deleted!").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "The student you selected does not exist").show();
            }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String dateOfBirth = String.valueOf(dtpDateOfBirth.getValue());
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

public void searchStudent(){
        String id = txtStudentID.getText();

        try {
            StudentDTO studentDTO = studentBO.search(id);
            if (studentDTO!= null) {
                txtStudentName.setText(studentDTO.getStudentName());
                dtpDateOfBirth.setValue(LocalDate.parse(studentDTO.getDateOfBirth()));
                txtAddress.setText(studentDTO.getAddress());
                txtPhoneNumber.setText(studentDTO.getPhoneNumber());
                txtEmail.setText(studentDTO.getEmail());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "The student you selected does not exist").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

}
    @FXML
    void txtStudentIdOnAction(ActionEvent event) {
        searchStudent();
    }
}
