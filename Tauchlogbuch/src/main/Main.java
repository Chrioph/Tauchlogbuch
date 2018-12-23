package main;

import control.IOController;
import control.ProgramController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Program;
import view.MenuController;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            ProgramController programController = new ProgramController();

            programController.setProgram(IOController.load());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
            Parent root = fxmlLoader.load();


            MenuController menuController = fxmlLoader.getController();
            menuController.setProgramController(programController);


            Scene scene = new Scene(root);
            final Program program = programController.getProgram();
            primaryStage.setOnCloseRequest(event -> {IOController.save(program);
                System.out.println("Saved");});
            primaryStage.setTitle("Menu");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
