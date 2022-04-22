package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

public class ProfileController extends Controller{

    @FXML
    private PieChart PieChart;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private Button languageSwitch;

    @FXML
    private Button logOutButton;

}

