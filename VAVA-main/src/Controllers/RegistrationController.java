package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import src.Model.Account;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationController {

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
}
