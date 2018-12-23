package view;


import control.ProgramController;
import control.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    ProgramController programController;

    Stage primaryStage;



    @FXML
    private Button button;

    @FXML
    void OpenNewEntry(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/NewEntry.fxml"));
            Parent root = fxmlLoader.load();

            NewEntryController newEntryController = fxmlLoader.getController();
            newEntryController.setProgramController(programController);

            Scene scene = new Scene(root);
            primaryStage = (Stage) button.getScene().getWindow();
            primaryStage.setTitle("Neuer Eintrag");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openAllEntries(ActionEvent event) throws IOException {
        new Util().openEntryList(programController, button , programController.getProgram().getEntries());
    }

    @FXML
    void openSearchEntry(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/SearchEntry.fxml"));
            Parent root = fxmlLoader.load();

            SearchEntryController searchEntryController = fxmlLoader.getController();
            searchEntryController.setProgramController(programController);

            Scene scene = new Scene(root);
            primaryStage = (Stage) button.getScene().getWindow();
            primaryStage.setTitle("Suche Einträge");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openStatistics(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Statistic.fxml"));
            Parent root = fxmlLoader.load();

            StatisticController statisticController = fxmlLoader.getController();
            statisticController.setProgramController(programController);
            statisticController.showStatistic();


            Scene scene = new Scene(root);
            primaryStage = (Stage) button.getScene().getWindow();
            primaryStage.setTitle("Statistiken");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }
    public void closePrimaryStage(){
        primaryStage.hide();
    }


}