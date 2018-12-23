package view;

import control.ProgramController;
import control.Util;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Entry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class EntryListController {

    private ProgramController programController;

    @FXML
    private TableColumn<Entry, String> date;

    @FXML
    private TableColumn<Entry, String> number;

    @FXML
    private TableColumn<Entry, String> place;

    @FXML
    private TableColumn<Entry, String> time;

    @FXML
    private TableView<Entry> table;

    private ObservableList<Entry> data;


    private String location;

    @FXML
    private Button button;

    public EntryListController(){}




    public void populate(ArrayList<Entry> list){
        data = FXCollections.observableArrayList();

        table.setEditable(true);

        number.setCellValueFactory(cellData -> new SimpleStringProperty("" + cellData.getValue().getNumber()));
        date.setCellValueFactory(cellData -> new SimpleStringProperty("" + cellData.getValue().getDate()));
        place.setCellValueFactory(cellData -> new SimpleStringProperty("" + cellData.getValue().getLocation()));
        time.setCellValueFactory(cellData -> new SimpleStringProperty("" + cellData.getValue().getTime()));

        table.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        new Util().openMenu(programController, button);
    }

    @FXML
    void show(ActionEvent event) throws IOException {
        //Show single entry in the ShowEntry-screen (has to be selected in the table)

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowEntry.fxml"));
        Parent root = fxmlLoader.load();

        ShowEntryController showEntryController = fxmlLoader.getController();
        showEntryController.setProgramController(programController);

        //Suche Index des ausgewaehlten Eintrags
        int entryIndex = table.getSelectionModel().getSelectedItem().getNumber();

        showEntryController.setEntry(programController.getProgram().getEntry(entryIndex));
        showEntryController.refresh();


        Scene scene = new Scene(root);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(scene);
    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }


}
