package view;

import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewEntryController {

    private Stage stage;

    public NewEntryController(ProgramController programController){

    }

    @FXML
    private TextField duration;

    @FXML
    private TextField date;

    @FXML
    private TextField buddy1;

    @FXML
    private TextField buddy2;

    @FXML
    private AnchorPane buddy3;

    @FXML
    private TextField temperature;

    @FXML
    private TextField place;

    @FXML
    private TextField time;

    @FXML
    void done(ActionEvent event) {

    }

}

