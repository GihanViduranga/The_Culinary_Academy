package ly.pt.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CulinaryPrograms {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblProgramID;

    @FXML
    private TableColumn<?, ?> tblDuration;

    @FXML
    private TableColumn<?, ?> tblFee;

    @FXML
    private TableColumn<?, ?> tblProgramID;

    @FXML
    private TableColumn<?, ?> tblProgramName;

    @FXML
    private TableView<?> tblProgramTable;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtProgramName;

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
