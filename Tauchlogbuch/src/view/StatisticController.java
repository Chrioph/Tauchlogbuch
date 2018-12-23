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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Statistic;

import java.io.IOException;

public class StatisticController {

    private ProgramController programController;

    @FXML
    private Label maxDepth;

    @FXML
    private Label coldest;

    @FXML
    private Label sumTime;

    @FXML
    private Label longest;

    @FXML
    private Label avgTime;

    @FXML
    private Label warmest;

    @FXML
    private Label avgBuddies;

    @FXML
    private Label count;

    @FXML
    private Label avgTemp;

    @FXML
    private Button button;



    @FXML
    void back(ActionEvent event) throws IOException {
        new Util().openMenu(programController, button);
    }

    public void setProgramController(ProgramController programController){
        this.programController=programController;
    }

    public void showStatistic() {
        Statistic statistic = programController.getStatisticController().CalculateStatistic();
        coldest.setText("" + statistic.getColdestTemp());
        maxDepth.setText("" + statistic.getMaxDepth());
        sumTime.setText("" + statistic.getTimeSum());
        longest.setText("" + statistic.getMaxTime());
        avgTime.setText("" + statistic.getAvgTime());
        warmest.setText("" + statistic.getWarmestTemp());
        maxDepth.setText("" + statistic.getMaxDepth());
        count.setText("" + programController.getProgram().getEntries().size());
        avgTemp.setText("" + statistic.getAvgTemp());
        avgBuddies.setText(""+ statistic.getAvgPartners());
    }
}
