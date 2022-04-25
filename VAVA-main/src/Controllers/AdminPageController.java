package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import src.Model.Account;

import java.sql.SQLException;


public class AdminPageController {

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

}
