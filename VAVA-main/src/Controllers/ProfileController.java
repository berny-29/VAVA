package src.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import src.Main;
import src.Model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class ProfileController extends Controller{


    @FXML
    private void changePageLang() throws SQLException, IOException {
        Stage s = (Stage) childNameTextField.getScene().getWindow();
        changeDefLoc();
        loadPage(s, "ProfilePage");
    }
    @FXML
    private void go_to_login() throws IOException {
        Stage s = (Stage) childNameTextField.getScene().getWindow();
        loadPage(s,"LoginPage");
    }


    @FXML
    private TextArea myPlansArea;


    @FXML
    private ChoiceBox<?> selectDeletePlan;


    @FXML
    private TextField childNameTextField;

    @FXML
    private TextArea myChildrenArea;

    @FXML
    private ChoiceBox<String> selectChild1;


    @FXML
    private TextArea myInfoTextArea;

    @FXML
    private TextField newEmail;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newRetypePassword;


    @FXML
    private  TextField taskNameTextField;

    @FXML
    private CheckBox repeatCheckBox;

    @FXML
    private ComboBox<String> startHourBox;

    @FXML
    private ComboBox<String> startMinBox;

    @FXML
    private ComboBox<String> endHourBox;

    @FXML
    private ComboBox<String> endMinBox;

    public ArrayList<String> comboHours(){

        ArrayList<String> fillHours= new ArrayList<>();

        int i = 0;
        for(i=0;i<24;i++){
            fillHours.add(String.valueOf(i));
        }
        return fillHours;
    }

    public ArrayList<String> comboMinutes(){

        ArrayList<String> fillMinutes= new ArrayList<>();

        int i = 0;
        for(i=0;i<60;i++){
            fillMinutes.add(String.valueOf(i));
        }
        return fillMinutes;
    }

    @FXML
    private void initialize() {


        ObservableList<String> hours = FXCollections.observableArrayList(comboHours());
        startHourBox.setItems(hours);
        endHourBox.setItems(hours);

        ObservableList<String> minutes = FXCollections.observableArrayList(comboMinutes());
        startMinBox.setItems(minutes);
        endMinBox.setItems(minutes);


        User activeUser = User.getActiveUser();

        myPlansArea.setText(Task.getTasks(activeUser.getId()).toString());



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
    private void addNewTask() throws SQLException {
        createNewTask();
    }

    @FXML
    private void createNewTask() throws SQLException {

        User activeUser = User.getActiveUser();

        String desc = taskNameTextField.getText();
        boolean rep = repeatCheckBox.isSelected();
        String startH = startHourBox.getValue().toString();
        String startM = startMinBox.getValue().toString();
        String endH = endHourBox.getValue().toString();
        String endM = endHourBox.getValue().toString();
        if(selectChild1.getSelectionModel().isEmpty()){
            Task.createTask(rep,desc, LocalTime.of(Integer.parseInt(startH),Integer.parseInt(startM)),LocalTime.of(Integer.parseInt(endH),Integer.parseInt(endM)),activeUser.getId(),activeUser.getId());
        }else {
            int child_id = User.getActiveUser().findChildId(selectChild1.getValue().toString());
            Task.createTask(rep,desc, LocalTime.of(Integer.parseInt(startH),Integer.parseInt(startM)),LocalTime.of(Integer.parseInt(endH),Integer.parseInt(endM)),child_id,child_id);
        }
        myPlansArea.setText(Task.getTasks(activeUser.getId()).toString());

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

    

    @FXML
    private void addChild() throws SQLException {
        String name = childNameTextField.getText();
        if(User.getActiveUser().addChild(name) == 1){
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Child succesfully added");
            existingEmail.showAndWait();
            StringBuilder s = new StringBuilder(myChildrenArea.getText());
            s.append(name + '\n');
            myChildrenArea.setText(s.toString());

        }else{
            Alert existingEmail = new Alert(Alert.AlertType.INFORMATION);
            existingEmail.setTitle("Wrong email");
            existingEmail.showAndWait();
        }



    }



}

