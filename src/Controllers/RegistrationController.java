package src.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private TextField email;

    @FXML
    private TextField password;

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

}
