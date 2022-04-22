package src.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

abstract class Controller {

    @FXML
    public void loadPage(Stage s, String pageName) throws IOException {
        ResourceBundle def_bundle = ResourceBundle.getBundle("src/"+pageName, Locale.getDefault());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/src/GUI/"+pageName+".fxml"));
        loader.setResources(def_bundle);

        try{
            Parent root = loader.load();
            s.setScene(new Scene(root));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
