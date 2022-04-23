package src.Controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.Model.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class LoginController extends Controller {
    public Button changePwdBtn;
    public Text labe0;
    public Label labe1;
    public Label labe2;
    public Label labe3;


    @FXML
    private Label languageENG;

    @FXML
    private Label languageSK;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private TextField myEmail;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newPasswordAgain;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button loginButton;

    @FXML
    private Label forgotPass;

    @FXML
    private Button BackButton;

    @FXML
    private void changePageLang() throws SQLException, IOException {
        Stage s = (Stage) email.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "LoginPage");
    }

    @FXML
    private void login() throws Exception {

        String emailField = email.getText();
        String passwordField = password.getText();

        if(Account.userLogin(emailField, passwordField)){
            Stage s = (Stage) loginButton.getScene().getWindow();
            loadPage(s,"ProfilePage");
            //loggingsa
            Account.loginLogger(emailField,passwordField,"succes");
        }else{
            Alert existingEmail = new Alert(Alert.AlertType.CONFIRMATION);
            existingEmail.setTitle("Wrong credentials");
            existingEmail.setContentText("Wrong credentials! Please try again");
            existingEmail.showAndWait();
            //logging
            Account.loginLogger(emailField,passwordField,"failure");
        }

    }

    @FXML
    private void forgotenPassword() throws SQLException, IOException {
        Stage s = (Stage) forgotPass.getScene().getWindow();
        loadPage(s,"ChangePassword");
    }

    @FXML
    private void register() throws IOException {
        Stage s = (Stage) RegisterButton.getScene().getWindow();
        loadPage(s,"RegistrationPage");


    }





    //Iny sposob vykonavania zmeny jazyka bez reloadnutia stranky -->
    @FXML
    private void setAll() throws SQLException{
        ResourceBundle def_bundle = ResourceBundle.getBundle("src/RegistrationPage", Locale.getDefault());
        
        email.setText(def_bundle.getString("login"));
        password.setPromptText(def_bundle.getString("password"));
        newPassword.setPromptText(def_bundle.getString("newPassword"));
        newPasswordAgain.setPromptText(def_bundle.getString("newPasswordAgain"));
        myEmail.setPromptText(def_bundle.getString("myEmail"));
        RegisterButton.setText(def_bundle.getString("registerButton"));
        loginButton.setText(def_bundle.getString("loginButton"));
        forgotPass.setText(def_bundle.getString("forgotPass"));


        changePwdBtn.setText(def_bundle.getString("changeEmail"));
        labe0.setText(def_bundle.getString("changePassword"));
        labe1.setText(def_bundle.getString("typeNewPassword"));
        labe2.setText(def_bundle.getString("typeAgainNewPassword"));
        labe3.setText(def_bundle.getString("myEmail"));
    }
}
