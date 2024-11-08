package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import ly.pt.config.FactoryConfiguration;
import ly.pt.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label lblAdminCount;

    @FXML
    private Label lblClock;

    @FXML
    private Label lblCourseCount;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblStudentCount;

    @FXML
    void btnAdminRegistrationOnAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminRegistration.fxml"));
        Parent rootNode = null;
        try {
            rootNode = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().clear();
        root.getChildren().add(rootNode);
    }

    @FXML
    void btnCoordinatorRegistrationOnAction(ActionEvent event) {

    }

    @FXML
    void btnCulinaryProgramsOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnPaymentDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void btnStudentProfileOnAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/studentDetail.fxml"));
        Parent rootNode = null;
        try {
            rootNode = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().clear();
        root.getChildren().add(rootNode);
    }

    @FXML
    void btnStudentRegistrationOnAction(ActionEvent event) {

    }

}
