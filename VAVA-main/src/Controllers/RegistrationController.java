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
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationController extends Controller {
    @FXML
    private Text title;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private CheckBox male;

    @FXML
    private CheckBox female;

    @FXML
    private Button registerButton;

    @FXML
    private DatePicker birthDate;

    @FXML
    private Button logInButton;

    @FXML
    private void changePageLang() throws SQLException, IOException {
        Stage s = (Stage) email.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "RegistrationPage");
    }

    @FXML
    private void register() throws SQLException, IOException {
        String emailText = email.getText();
        String passwordText = password.getText();
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        boolean msex = male.isSelected();
        boolean fsex = female.isSelected();
        LocalDate date = birthDate.getValue();


        if(emailText.isEmpty() || passwordText.isEmpty() || firstNameText.isEmpty() || lastNameText.isEmpty()
        || (!msex & !fsex) || date == null){
            Alert data = new Alert(Alert.AlertType.INFORMATION);
            data.setTitle("Missing registration details");
            data.setContentText("Please fill all registration details");
            data.showAndWait();
        }else {
            String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

            Pattern pattern = Pattern.compile(regex);


            Matcher matcher = pattern.matcher(emailText);
            if(!matcher.matches()){
                Alert emailAlert = new Alert(Alert.AlertType.INFORMATION);
                emailAlert.setTitle("Wrong email");
                emailAlert.setContentText("Please enter valid email.");
                emailAlert.showAndWait();
            }else {
                String userSex;
                if(msex){
                    userSex = male.getText();
                }else{
                    userSex = female.getText();
                }
                if(Account.accountRegistration(firstNameText,lastNameText,userSex,date.toString(),passwordText,emailText)){
                    Alert succesfullyRegistered = new Alert(Alert.AlertType.CONFIRMATION);
                    succesfullyRegistered.setTitle("Succesfully registered");
                    succesfullyRegistered.setContentText("Press OK to continue to login");
                    succesfullyRegistered.showAndWait();

                    Stage s = (Stage) registerButton.getScene().getWindow();
                    loadPage(s,"LoginPage");
                }else{
                    Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
                    existingEmail.setTitle("Email already registered");
                    existingEmail.setContentText("You are already registered");
                    existingEmail.showAndWait();
                }
            }
        }
    }

    @FXML
    private void go_to_login() throws IOException {
        Stage s = (Stage) logInButton.getScene().getWindow();
        loadPage(s,"LoginPage");
    }


    @FXML
    private void setAll() throws SQLException{
        ResourceBundle def_bundle = ResourceBundle.getBundle("src/RegistrationPage", Locale.getDefault());
        title.setText(def_bundle.getString("registration"));
        password.setPromptText(def_bundle.getString("password"));
        firstName.setPromptText(def_bundle.getString("firstName"));
        lastName.setPromptText(def_bundle.getString("lastName"));
        male.setText(def_bundle.getString("mSex"));
        female.setText(def_bundle.getString("fSex"));
        registerButton.setText(def_bundle.getString("createAccount"));
        birthDate.setPromptText(def_bundle.getString("birthDate"));
    }

   
}
