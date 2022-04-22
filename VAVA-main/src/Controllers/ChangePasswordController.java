package src.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.Model.Account;

import java.io.IOException;
import java.sql.SQLException;

public class ChangePasswordController extends Controller{
    @FXML
    private Text title;

    @FXML
    private Button BackButton;

    @FXML
    private Button changePwdBtn;

    @FXML
    private Label labe1;

    @FXML
    private Label labe2;

    @FXML
    private Label labe3;

    @FXML
    private Label languageSwitch;

    @FXML
    private TextField myEmail;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newPasswordAgain;

    //Tato funkcia by sla i inak urobit, daly by sme abstrakny Label titul do triedy Controller a vsetky Stranky by mali
    //mat vlastny jedinecny title, takze by to odstranilo potrebu nastavovania specifickych Stage s objektov
    @FXML
    private void changePageLang() throws SQLException, IOException {
        Stage s = (Stage) myEmail.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "ChangePassword");
    }

    @FXML
    private void changeEmail(ActionEvent event) throws SQLException, IOException {
        String email = myEmail.getText();
        String nPassword = newPassword.getText();
        String nPasswordA = newPasswordAgain.getText();

        if(Account.changePassword(email,nPassword, nPasswordA) == 2){
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Passwords are different");
            existingEmail.setContentText("Please enter same passwords");
            existingEmail.showAndWait();
        }
        if(Account.changePassword(email,nPassword, nPasswordA) == 0){
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("No account with this email");
            existingEmail.setContentText("Please enter existing email");
            existingEmail.showAndWait();
        }
        if(Account.changePassword(email,nPassword, nPasswordA) == 1){
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Password succesfully changed");
            existingEmail.setContentText("You can log in with new password");

            existingEmail.showAndWait();
            Stage s = (Stage) changePwdBtn.getScene().getWindow();
            loadPage(s,"LoginPage");
        }

    }

    @FXML
    private void go_back() throws IOException {
        Stage s = (Stage) BackButton.getScene().getWindow();
        loadPage(s,"LoginPage");
    }
}
