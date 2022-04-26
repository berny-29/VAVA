package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import src.Model.Account;

import java.io.IOException;
import java.sql.SQLException;


public class AdminPageController extends Controller {

    @FXML
    private ToggleButton dayRepeatButton;

    @FXML
    private Button deleteTaskButton;

    @FXML
    private Label deleteTaskLabel;

    @FXML
    private Button languageButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button publishTaskButton;

    @FXML
    private TextField repeatInDayTextField;

    @FXML
    private Button sendMessageButton;

    @FXML
    private Label taskPublishedLabel;

    @FXML
    private TextArea userChatTextArea;

    @FXML
    private TextArea userLogsTextArea;
    
    @FXML
    public void initialize() throws SQLException {
        userLogsTextArea.setText(Account.getLogs().toString());
    }

    @FXML
    public void logout() throws IOException, SQLException {
        Stage s = (Stage) logOutButton.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "LoginPage");
    }

    @FXML
    private void changePageLang() throws SQLException, IOException {
        Stage s = (Stage) languageButton.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "AdminPage");
    }

}
