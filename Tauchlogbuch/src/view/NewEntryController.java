package view;

import control.ProgramController;
import control.Util;
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
        new Util().openMenu(programController, button);
    }

    @FXML
    void done(ActionEvent event) throws IOException {
        String[] buddies ={buddy1.getText(), buddy2.getText(), buddy3.getText()};
        if(buddy1.getText().equals("")){
            new ErrorController().generateErrorFrame("Bitte geben Sie einen Tauchpartner an");
            return;
        }
        else if(place.getText().equals("")){
            new ErrorController().generateErrorFrame("Bitte geben Sie einen Ort ein");
            return;
        }
        else if (date.getText().equals("")){
            new ErrorController().generateErrorFrame("Bitte geben Sie ein Datum ein");
            return;
        }
        else if (time.getText().equals("")){
            new ErrorController().generateErrorFrame("Bitte geben Sie eine Zeit ein");
            return;
        }
        try {
            Entry entry = new Entry(programController.getProgram().getEntries().size(), date.getText(), time.getText(),
                    place.getText(), Integer.parseInt(duration.getText()), Float.parseFloat(depth.getText()),
                    Integer.parseInt(temperature.getText()), buddies, comment.getText());
            programController.getEntryController().addEntry(entry);

        }catch (NumberFormatException nfe){
            new ErrorController().generateErrorFrame("Bitte geben Sie in den Feldern Tiefe und Temperatur Kommzahlen und in dem Feld Dauer die Dauer in Minuten ein !");
        }catch (NullPointerException npe){
            new ErrorController().generateErrorFrame("Bitte geben Sie in allen Feldern außer Tauchpartner 2 und 3, sowie Kommentar einen Wert ein !");
        }

        back(null);
    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }


}
