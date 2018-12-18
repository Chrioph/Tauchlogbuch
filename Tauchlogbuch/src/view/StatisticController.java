package view;

import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StatisticController {

    private ProgramController programController;

    @FXML
    private Label maxDepth;

    @FXML
    private Label coldest;

    @FXML
    private Label sumTime;

    @FXML
    private Label longest;

    @FXML
    private Label avgTime;

    @FXML
    private Label warmest;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label count;

    @FXML
    private Label avgTemp;

    @FXML
    private Button button;

    @FXML
    void done(ActionEvent event) {

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
