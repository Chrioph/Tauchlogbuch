package view;

import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchEntryController {

    private ProgramController programController;

    @FXML
    private TextField number;

    @FXML
    private TextField place;

    @FXML
    private TextField buddy;

    @FXML
    private Button button;

    @FXML
    void searchEntry(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
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
