package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewEntryController {

    @FXML
    private TextField duration;

    @FXML
    private TextField date;

    @FXML
    private TextField buddy1;

    @FXML
    private TextField buddy2;

    @FXML
    private AnchorPane buddy3;

    @FXML
    private TextField temperature;

    @FXML
    private TextArea comment;

    @FXML
    private TextField place;

    @FXML
    private TextField time;

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void done(ActionEvent event) {

    }

}
