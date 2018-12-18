package view;


import control.ProgramController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    ProgramController programController;

    Stage primaryStage;

    public MenuController(){
        this.programController = new ProgramController();
    }


    @FXML
    void OpenNewEntry(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/NewEntry.fxml"));
            Parent root = fxmlLoader.load();



            Scene scene = new Scene(root);
            primaryStage = new Stage();
            primaryStage.setTitle("Neuer Eintrag");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openAllEntries(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/EntryList.fxml"));
            Parent root = fxmlLoader.load();



            Scene scene = new Scene(root);
            primaryStage = new Stage();
            primaryStage.setTitle("Alle Einträge");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openSearchEntry(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/SearchEntry.fxml"));
            Parent root = fxmlLoader.load();



            Scene scene = new Scene(root);
            primaryStage = new Stage();
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



            Scene scene = new Scene(root);
            primaryStage = new Stage();
            primaryStage.setTitle("Statistiken");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}