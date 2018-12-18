package view;

import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryListController {

    private ProgramController programController;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> number;

    @FXML
    private TableColumn<?, ?> place;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableView<?> table;

    @FXML
    private Button button;

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

    @FXML
    void show(ActionEvent event) {

    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }

}
