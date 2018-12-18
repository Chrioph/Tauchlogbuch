package view;

import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Entry;

import java.io.IOException;

public class NewEntryController {

    private ProgramController programController;

    private Stage stage;

    @FXML
    private TextField duration;

    @FXML
    private TextField date;

    @FXML
    private TextField depth;

    @FXML
    private TextField buddy1;

    @FXML
    private TextField buddy2;

    @FXML
    private TextField buddy3;

    @FXML
    private TextField temperature;

    @FXML
    private TextArea comment;

    @FXML
    private TextField place;

    @FXML
    private TextField time;

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
    void done(ActionEvent event) throws IOException {
        String[] buddies ={buddy1.getText(), buddy2.getText(), buddy3.getText()};
        try {
            Entry entry = new Entry(programController.getProgram().getEntries().size(), date.getText(), time.getText(),
                    place.getText(), Integer.parseInt(duration.getText()), Float.parseFloat(depth.getText()),
                    Integer.parseInt(temperature.getText()), buddies, comment.getText());
            programController.getEntryController().addEntry(entry);

        }catch (NumberFormatException nfe){
            System.out.println("Geben Sie ein gültiges Format an");
        }

        back(null);
    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }


}
