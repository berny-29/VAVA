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

public class LoginController {
    public Button changePwdBtn;
    public Text labe0;
    public Label labe1;
    public Label labe2;
    public Label labe3;


    @FXML
    private Label languageEN;

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
    private void login() throws SQLException, IOException {

        String emailField = email.getText();
        String passwordField = password.getText();

        if(Account.userLogin(emailField, passwordField)){
            Stage stage;
            Parent root;

            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/src/GUI/ProfilePage.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Alert existingEmail = new Alert(Alert.AlertType.CONFIRMATION);
            existingEmail.setTitle("Wrong credentials");
            existingEmail.setContentText("Wrong credentials! Please try again");
            existingEmail.showAndWait();
        }

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
            Stage stage;
            Parent root;

            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/src/GUI/LoginPage.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
    @FXML
    private void changeScene() throws SQLException, IOException {
        Stage stage;
        Parent root;

        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/src/GUI/ChangePassword.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void register() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/src/GUI/RegistartionPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //testovacia funkcia

    @FXML
    private void test_loc() throws SQLException, IOException {
        Locale en_loc = new Locale("en");
        Locale sk_loc = new Locale("sk");
        Locale target = null;
        if(Objects.equals(Locale.getDefault(), sk_loc)) {
            Locale.setDefault(new Locale("en"));
            ResourceBundle.clearCache();
            LoadView(new Locale("en"));
        }
        else {
            Locale.setDefault(new Locale("sk"));
            ResourceBundle.clearCache();
            LoadView(new Locale("sk"));
        }
    }

    @FXML
    private void LoadView(Locale locale) throws IOException {
        ResourceBundle def_bundle = ResourceBundle.getBundle("src/RegistrationPage", locale);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/src/GUI/RegistrationPage.fxml"));
        loader.setResources(def_bundle);
        try{
            Parent root = loader.load();
            Stage s = (Stage) email.getScene().getWindow();
            s.setScene(new Scene(root));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void test_en_loc() throws SQLException{
        Locale en_loc = new Locale("en");
        Locale sk_loc = new Locale("sk");
        Locale target = null;
        if(Objects.equals(Locale.getDefault(), sk_loc))
            Locale.setDefault(new Locale("en"));
        else
            Locale.setDefault(new Locale("sk"));
        ResourceBundle.clearCache();
        setAll();
    }

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