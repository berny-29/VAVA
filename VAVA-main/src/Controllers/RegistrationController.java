package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import src.Model.Account;
import src.Model.ObservableResourceFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationController {
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
    private void register() throws SQLException {
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
                }else{
                    Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
                    existingEmail.setTitle("Email already registered");
                    existingEmail.setContentText("You are already registered");
                    existingEmail.showAndWait();
                }
            }
        }
    }

    //testovacia funkcia
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
        title.setText(def_bundle.getString("registration"));
        password.setPromptText(def_bundle.getString("password"));
        firstName.setPromptText(def_bundle.getString("firstName"));
        lastName.setPromptText(def_bundle.getString("lastName"));
        male.setText(def_bundle.getString("mSex"));
        female.setText(def_bundle.getString("fSex"));
        registerButton.setText(def_bundle.getString("createAccount"));
        birthDate.setPromptText(def_bundle.getString("birthDate"));
    }

    //testovacia funkcia
    @FXML
    public void binding( ObservableResourceFactory resourceFactory) throws SQLException{
        this.
        title.textProperty().bind(resourceFactory.getStringBinding("registration"));
        password.textProperty().bind(resourceFactory.getStringBinding("password"));
        firstName.textProperty().bind(resourceFactory.getStringBinding("firstName"));
        male.textProperty().bind(resourceFactory.getStringBinding("mSex"));
        female.textProperty().bind(resourceFactory.getStringBinding("fSex"));
        registerButton.textProperty().bind(resourceFactory.getStringBinding("createAccount"));
        birthDate.promptTextProperty().bind(resourceFactory.getStringBinding("birthDate"));
    }
}