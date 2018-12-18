package view;

import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowEntryController {

    private ProgramController programController;

    @FXML
    private Label date;

    @FXML
    private Label duration;

    @FXML
    private Label buddy1;

    @FXML
    private Label depth;

    @FXML
    private Label buddy2;

    @FXML
    private Label buddy3;

    @FXML
    private Label place;

    @FXML
    private Label time;

    @FXML
    private Button button;

    @FXML
    void done(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = fxmlLoader.load();

        MenuController menuController = fxmlLoader.getController();
        menuController.setProgramController(programController);

        Scene scene = new Scene(root);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(scene);
    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }

}
