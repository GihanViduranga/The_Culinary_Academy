package ly.pt.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import ly.pt.Utill.Regex;
import ly.pt.bo.BOFactory;
import ly.pt.bo.custom.StudentBo;
import ly.pt.entity.Registration;
import ly.pt.entity.Student;
import ly.pt.viewTm.StudentTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDetail {

    @FXML
    private TableView<StudentTM> StudentTable;

    @FXML
    private TextField addresstxt;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colfirstname;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> collastname;

    @FXML
    private TableColumn<?, ?> colnumber;

    @FXML
    private DatePicker datecombo;

    @FXML
    private TextField emailtxt;

    @FXML
    private TextField firstNametxt;

    @FXML
    private TextField idtxt;

    @FXML
    private TextField lastnametxt;

    @FXML
    private TextField phonenumbertxt;

    @FXML
    private AnchorPane root;

    private String userRole;


    StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

    public void initialize(){
        loadAllStudent();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colfirstname.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        collastname.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colnumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void loadAllStudent() {
        ObservableList<StudentTM> students = FXCollections.observableArrayList();
        List<Student> studentDTO = null;
        try {
            studentDTO = studentBo.getAllStudent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Student student : studentDTO){
            StudentTM studentTM =new StudentTM(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getPhoneNumber(),
                    student.getAddress(),
                    student.getEmail()
            );
            students.add(studentTM);
        }
        StudentTable.setItems(students);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        idtxt.setText("");
        firstNametxt.setText("");
        lastnametxt.setText("");
        addresstxt.setText("");
        phonenumbertxt.setText("");
        emailtxt.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());

        try {
            boolean b = studentBo.deleteStudent(id);
            if (b) {
                new Alert(Alert.AlertType.INFORMATION, "Student Delete Success").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student Delete Failed").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearTextFiled();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());
        String fn = firstNametxt.getText();
        String ln = lastnametxt.getText();
        String address = addresstxt.getText();
        String email = emailtxt.getText();
        String number = phonenumbertxt.getText();
        LocalDate enrollmentDate = datecombo.getValue();
        List<Registration> list = new ArrayList<>();


        Student student = new Student(id,fn,ln,address,email,number,enrollmentDate,list,userRole);


        boolean s = false;

        try {

            s = studentBo.updateStudent(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (s) {
            new Alert(Alert.AlertType.INFORMATION, "Student Update Success").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student Update Failed").show();
        }
        /*loadallvalues();*/
        clearTextFiled();
    }

    @FXML
    void saveOnActionStudent(ActionEvent event) {
        int id = 0;
        String fn = firstNametxt.getText();
        String ln = lastnametxt.getText();
        String address = addresstxt.getText();
        String email = emailtxt.getText();
        String number = phonenumbertxt.getText();
        LocalDate enrollmentDate = datecombo.getValue();
        List<Registration> list = new ArrayList<>();




        Student student = new Student(id,fn,ln,address,email,number,enrollmentDate,list,userRole);


        boolean s = false;

        try{

            s = studentBo.saveStudent(student);
            if (s) {
                new Alert(Alert.AlertType.INFORMATION, "Student Save Success").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Student save UnSuccess").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        clearTextFiled();


    }

    @FXML
    void txtStudentIdOnAction(ActionEvent event) {
        String id = String.valueOf(Integer.parseInt(idtxt.getText()));
        ArrayList<Student> students = null;
        try {
            students = (ArrayList<Student>) studentBo.SearchSID(Integer.parseInt(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        firstNametxt.setText(students.get(0).getFirstName());
        lastnametxt.setText(students.get(0).getLastName());
        addresstxt.setText(students.get(0).getAddress());
        phonenumbertxt.setText(students.get(0).getPhoneNumber());
        emailtxt.setText(students.get(0).getEmail());
    }
    public void clearTextFiled(){
        idtxt.setText("");
        firstNametxt.setText("");
        lastnametxt.setText("");
        addresstxt.setText("");
        phonenumbertxt.setText("");
        emailtxt.setText("");
    }
    public boolean isValied(){
        /*boolean IdValid = Regex.setTextColor(lk.gsbp.Utill.TextField.IDC, txtCustomerId);
        boolean nameValid = Regex.setTextColor(lk.gsbp.Utill.TextField.NAME, txtCustomerName);
        boolean addressValid = Regex.setTextColor(lk.gsbp.Utill.TextField.ADDRESS, txtCustomerAddress);
        boolean contactValid = Regex.setTextColor(lk.gsbp.Utill.TextField.CONTACT, txtCustomerContact);
        boolean emailValid = Regex.setTextColor(lk.gsbp.Utill.TextField.EMAIL, txtCustomerEmail);

        return IdValid && nameValid && addressValid && contactValid && emailValid;*/
        boolean IdValid = Regex.setTextColour(ly.pt.Utill.TextField.NUMBERS, idtxt);
        boolean FirstNameValid = Regex.setTextColour(ly.pt.Utill.TextField.NAME, firstNametxt);
        boolean LastNameValid = Regex.setTextColour(ly.pt.Utill.TextField.NAME, lastnametxt);
        boolean PhoneNumberValid = Regex.setTextColour(ly.pt.Utill.TextField.CONTACT, phonenumbertxt);
        boolean EmailValid = Regex.setTextColour(ly.pt.Utill.TextField.EMAIL, emailtxt);
        boolean AddressValid = Regex.setTextColour(ly.pt.Utill.TextField.ADDRESS, addresstxt);

        return IdValid && FirstNameValid && LastNameValid && PhoneNumberValid && EmailValid && AddressValid;
    }
    /*public void CustomerIdOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(lk.gsbp.Utill.TextField.IDC, txtCustomerId);
    }*/

    public void txtFirstNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(ly.pt.Utill.TextField.NAME, firstNametxt);
    }

    public void txtAddressOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(ly.pt.Utill.TextField.ADDRESS, addresstxt);
    }

    public void txtPhoneNumberOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(ly.pt.Utill.TextField.CONTACT, phonenumbertxt);
    }

    public void txtEmailOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(ly.pt.Utill.TextField.EMAIL, emailtxt);
    }

    public void txtStudentIdOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(ly.pt.Utill.TextField.NUMBERS, idtxt);
    }

    public void txtLastNameOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColour(ly.pt.Utill.TextField.NAME, lastnametxt);
    }
}
