package src.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import src.Main;
import src.Model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfileController extends Controller{

    @FXML
    private PieChart PieChart;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private Button languageSwitch;

    @FXML
    private Button logOutButton;

    @FXML
    private void changePageLang() throws SQLException, IOException {
        Stage s = (Stage) PieChart.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "ProfilePage");
    }
    @FXML
    private void go_to_login() throws IOException {
        Stage s = (Stage) PieChart.getScene().getWindow();
        loadPage(s,"LoginPage");
    }


    @FXML
    private Button createPlan;

    @FXML
    private Button deletePlan;

    @FXML
    private TextArea myPlansArea;

    @FXML
    private TextArea daysTasks;

    @FXML
    private DatePicker pickDate;

    @FXML
    private ChoiceBox<?> selectDeletePlan;

    @FXML
    private ChoiceBox<?> selectNewPlan;


    @FXML
    private Button addChildButton;

    @FXML
    private Button assignChildPlan;

    @FXML
    private TextField childNameTextField;

    @FXML
    private TextArea myChildrenArea;

    @FXML
    private DatePicker pickChildDate;

    @FXML
    private ChoiceBox<?> selectChild;

    @FXML
    private ChoiceBox<?> selectChild1;

    @FXML
    private ChoiceBox<?> selectChildPlan;

    @FXML
    private Button viewChildButton;

    @FXML
    private DatePicker calendarDateTask;

    @FXML
    private TextArea chatTextArea;

    @FXML
    private TextArea hoursTasksTextArea;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private TextArea myInfoTextArea;

    @FXML
    private TextField newEmail;

    @FXML
    private Button sendMessageButton;

    @FXML
    private Button showTasksButton;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newRetypePassword;

    @FXML
    private Button updateInfo;

    @FXML
    public void initialize() {
        myChildrenArea.setText("");



        myInfoTextArea.setText(User.getActiveUser().getName());
        StringBuilder sb = new StringBuilder();

        for(Child child: User.getActiveUser().getChilds()){

            sb.append(child.getName());
            sb.append("\n");

        }
        ObservableList<String> options =
                FXCollections.observableArrayList(User.getActiveUser().getChildsName());
        selectChild1.setItems(options);
        myChildrenArea.setText(sb.toString());

    }

    @FXML
    private void updateUserInfo() throws SQLException {
        String email = newEmail.getText();
        String nPassword = newPassword.getText();
        String nPasswordA = newRetypePassword.getText();
        try {
            if (Account.changePassword(email, nPassword, nPasswordA) == 2) {
                Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
                existingEmail.setTitle("Passwords are different");
                existingEmail.setContentText("Please enter same passwords");
                existingEmail.showAndWait();
            }
            if (Account.changePassword(email, nPassword, nPasswordA) == 0) {
                Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
                existingEmail.setTitle("No account with this email");
                existingEmail.setContentText("Please enter existing email");
                existingEmail.showAndWait();
            }
            if (Account.changePassword(email, nPassword, nPasswordA) == 1) {
                Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
                existingEmail.setTitle("Password succesfully changed");
                existingEmail.showAndWait();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTask(){

    }


    @FXML
    private void deleteUserPlan(){
        String planName = (String) selectDeletePlan.getValue();

        if ( planName != null ) {
            for ( int i = 0; i < Main.GPlans.size(); i++ ) {
                if ( Main.GPlans.get(i).getName().equals(planName) ) {
                    Main.GPlans.remove(i);
                }
            }
        }

    }

    @FXML
    private void addChild() throws SQLException {
        String name = childNameTextField.getText();
        if(User.getActiveUser().addChild(name) == 1){
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Child succesfully added");
            existingEmail.showAndWait();
        }else{
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Wrong email");
            existingEmail.showAndWait();
        }



    }



}

