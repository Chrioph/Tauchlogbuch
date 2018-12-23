package view;

import control.ProgramController;
import control.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Entry;

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
    private TextArea Comment;

    @FXML
    private Label temperature;

    private Entry entry;


    @FXML
    public void initialize(){
        }

    @FXML
    void done(ActionEvent event) throws IOException {
        new Util().openMenu(programController, button);
    }



    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }

    public void setEntry(Entry entry){ this.entry = entry;}

    public void refresh() {
        try{
            date.setText(entry.getDate());
            duration.setText("" + entry.getDuration());
            buddy1.setText(entry.getBuddy(0));
            buddy2.setText(entry.getBuddy(1));
            buddy3.setText(entry.getBuddy(2));
            depth.setText("" + entry.getMaxDepth());
            place.setText(entry.getLocation());
            time.setText(entry.getTime());
            Comment.setText(entry.getComment());
            temperature.setText("" + entry.getTemperature());

        }catch(NullPointerException npe){
            new ErrorController().generateErrorFrame("Kein Eintrag übergeben");
        }
    }
}
