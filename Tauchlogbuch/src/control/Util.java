package control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Entry;
import model.Program;
import view.EntryListController;
import view.MenuController;

import java.io.IOException;
import java.util.ArrayList;


public class Util {



    public  void openMenu(ProgramController programController, Button button) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
        Parent root = fxmlLoader.load();

        MenuController menuController = fxmlLoader.getController();
        menuController.setProgramController(programController);

        Scene scene = new Scene(root);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(scene);

    }

    public void openEntryList (ProgramController programController, Button button, ArrayList<Entry> entryList) throws  IOException{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/EntryList.fxml"));
            Parent root = fxmlLoader.load();

            EntryListController entryListController = fxmlLoader.getController();
            entryListController.setProgramController(programController);
            entryListController.populate(entryList);


            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) button.getScene().getWindow();
            primaryStage.setTitle("Einträge");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
