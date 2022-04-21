package src.Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.Model.Account;

import java.sql.SQLException;
import javafx.event.ActionEvent;

public class LoginController {
    private Stage primaryStage;

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
    private void login() throws SQLException {

        String emailField = email.getText();
        String passwordField = password.getText();

        if(Account.userLogin(emailField, passwordField)){
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Succesfully logged in");
            existingEmail.setContentText("You are succesfully logged-in");
            existingEmail.showAndWait();
        }else{
            Alert existingEmail = new Alert(Alert.AlertType.CONFIRMATION);
            existingEmail.setTitle("Wrong credentials");
            existingEmail.setContentText("Wrong credentials! Please try again");
            existingEmail.showAndWait();
        }

    }



    @FXML
    private void changeEmail(ActionEvent event) throws SQLException {
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
        }

    }
    @FXML
    private void changeScene() throws SQLException{
        System.out.println("Scene was changed.");
    }
}