package view;

import control.ProgramController;
import control.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Entry;

import java.io.IOException;
import java.util.ArrayList;

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
    private TextField day;

    @FXML
    void searchEntry(ActionEvent event) {
        //Es darf entweder nach Nummer oder nach anderen Kriterien gesucht werden
        if(!number.getText().equals("") && (!place.getText().equals("") || !buddy.getText().equals("") || !day.getText().equals(""))){
            new ErrorController().generateErrorFrame("Bitte geben Sie ENTWEDER eine Nummer oder andere Suchkriterien ein");
            return;
        }

        //Es muss mindestens ein Suchkriterium eingegeben werden

        if(number.getText().equals("") && place.getText().equals("") && buddy.getText().equals("") && day.getText().equals("")){
            new ErrorController().generateErrorFrame("Bitte geben Sie mindestens ein Suchkriterium ein");
            return;
        }


        //Nummer muss gültigen Index enthalten


        ArrayList<Entry> entryList= new ArrayList<Entry>();

        //Wenn nach Nummer gesucht wird, muss sichergestellt sein, dass es sich um ein Int handelt
        if(!number.getText().equals("")) {
            try {
                entryList.add(programController.getEntryController().searchEntryByNumber(Integer.parseInt(number.getText())));

            }catch (NumberFormatException nfe){
                new ErrorController().generateErrorFrame("Bitte geben Sie in dem Nummerfeld eine ganzahlige Nummer ein");
            }
            //Nummer muss gültigen Index enthalten
            catch (IndexOutOfBoundsException ioobe){
            }
        }

        //Faelle fuer alle Suchkriteriumszusammensetzungen
        else {
            if(!place.getText().equals("")){
                if (!day.equals("")){
                    if(!buddy.getText().equals("")){
                        //Wenn nach allen Kriterien gesucht wird
                        entryList = programController.getEntryController().mergeSearchCriteria(day.getText() , place.getText() , buddy.getText());
                    }
                    else {
                        //Wenn nach Ort und Tag gesucht wird
                        entryList = programController.getEntryController().intersect(programController.getEntryController().searchEntryByLocation(place.getText()) , programController.getEntryController().searchEntryByDate(day.getText()));
                    }
                }
                else{
                    if(!buddy.getText().equals("")){
                        //Wenn nach Buddy und Ort gesucht wird
                        entryList = programController.getEntryController().intersect(programController.getEntryController().searchEntryByLocation(place.getText()) , programController.getEntryController().searchEntryByDate(buddy.getText()));
                    }
                    else {
                        //Wenn nach Ort gesucht wird
                        entryList = programController.getEntryController().searchEntryByLocation(place.getText());
                    }
                }
            }
            //Nicht nach Ort
            else{
                if (!day.getText().equals("")) {
                    if (!buddy.getText().equals("")) {
                        //Wenn nach Tag und Buddy gesucht wird
                        entryList = programController.getEntryController().intersect(programController.getEntryController().searchEntryByDate(day.getText()), programController.getEntryController().searchEntryByBuddy(buddy.getText()));
                    } else {
                        //Wenn nach Tag gesucht wird
                        entryList = programController.getEntryController().searchEntryByDate(day.getText());
                    }
                }
                //Nicht nach Tag
                else{
                    //Wenn nur nach Buddy gesucht wird
                    entryList = programController.getEntryController().searchEntryByBuddy(buddy.getText());
                }
            }
        }
        showEntry(entryList);

    }

    //Stellt gefundene Eintraege dar
    private void showEntry(ArrayList<Entry> entryList) {
        //Wenn nur ein Eintrag gefunden wird, geht man direkt in den Show-Entry Screen
        if(entryList.size()==1){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ShowEntry.fxml"));
                Parent root = fxmlLoader.load();

                ShowEntryController showEntryController = fxmlLoader.getController();
                showEntryController.setProgramController(programController);
                showEntryController.setEntry(entryList.get(0));
                showEntryController.refresh();

                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) button.getScene().getWindow();
                primaryStage.setTitle("Suche Einträge");
                primaryStage.setScene(scene);
                primaryStage.show();


            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        //Wenn kein Eintrag gefunden wird, soll ein Fenster dies anzeigen
        else if (entryList.size()==0){
            new ErrorController().generateErrorFrame("Keine Eintraege gefunden");
        }
        //Wenn mehrere Einträge gefunden wurden, sollen diese in dem EntryList-Screen angezeigt werden
        else {
            try {
                new Util().openEntryList(programController, button, entryList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        new Util().openMenu(programController, button);
    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }

}
