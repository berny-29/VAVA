package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Controllers.RegistrationController;
import src.Model.ObservableResourceFactory;

import java.awt.desktop.SystemEventListener;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main<aspect> extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        ResourceBundle def_bundle = ResourceBundle.getBundle("src/RegistrationPage", Locale.getDefault());

        Parent root = FXMLLoader.load(getClass().getResource("/src/GUI/RegistrationPage.fxml"), def_bundle);
        primaryStage.setTitle("Vava_Project");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {

        launch(args);
    }
}
