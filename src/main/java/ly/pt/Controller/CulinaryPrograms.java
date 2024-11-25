package ly.pt.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import ly.pt.bo.custom.CulinaryProgramBO;
import ly.pt.bo.custom.impl.CulinaryProgramBOImpl;
import ly.pt.model.CulinaryProgramsDTO;
import ly.pt.viewTm.ProgramsTm;

import java.util.List;

public class CulinaryPrograms {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtProgramID;

    @FXML
    private TableColumn<?, ?> tblDuration;

    @FXML
    private TableColumn<?, ?> tblFee;

    @FXML
    private TableColumn<?, ?> tblProgramID;

    @FXML
    private TableColumn<?, ?> tblProgramName;

    @FXML
    private TableView<ProgramsTm> tblProgramTable;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtProgramName;

    CulinaryProgramBO culinaryProgramBO = new CulinaryProgramBOImpl();

    public void initialize(){
        System.out.println("Initializing");
        loadAllPrograms();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        tblProgramID.setCellValueFactory(new PropertyValueFactory<>("programId"));
        tblProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        tblDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private void loadAllPrograms() {
        ObservableList<ProgramsTm> programs = FXCollections.observableArrayList();

        List<CulinaryProgramsDTO> programsDTOs = culinaryProgramBO.getAllPrograms();

        for (CulinaryProgramsDTO program : programsDTOs) {
            ProgramsTm programTm = new ProgramsTm(
                    program.getProgramId(),
                    program.getProgramName(),
                    program.getDuration(),
                    program.getFee()
            );
            programs.add(programTm);
        }
        tblProgramTable.setItems(programs);
        System.out.println(programs);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtProgramID.getText();
        String programName = txtProgramName.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();

        CulinaryProgramsDTO culinaryProgramsDTO = new CulinaryProgramsDTO(id, programName, duration, fee);

        try{
            boolean isDeleted = culinaryProgramBO.DeleteProgram(id,culinaryProgramsDTO);
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION, "Program deleted!").show();
            } else{
                new Alert(Alert.AlertType.INFORMATION, "The program with ID: " + id + " does not exist").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtProgramID.getText();
        String programName = txtProgramName.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();

        CulinaryProgramsDTO culinaryProgramsDTO = new CulinaryProgramsDTO(id, programName, duration, fee);

        try{
            boolean isSaved = culinaryProgramBO.SaveProgram(culinaryProgramsDTO);
            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION, "Program saved!").show();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtProgramID.getText();
        String programName = txtProgramName.getText();
        String duration = txtDuration.getText();
        String fee = txtFee.getText();

        CulinaryProgramsDTO culinaryProgramsDTO = new CulinaryProgramsDTO(id, programName, duration, fee);

        try{
            boolean isUpdated = culinaryProgramBO.UpdateProgram(culinaryProgramsDTO);
            if(isUpdated){
                new Alert(Alert.AlertType.INFORMATION, "Program updated!").show();
            } else{
                new Alert(Alert.AlertType.INFORMATION, "The data you entered is incorrect").show();
            }
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
