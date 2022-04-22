package src.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

abstract class Controller  {
    @FXML
    public void changeDefLoc() throws SQLException, IOException {
        Locale en_loc = new Locale("en");
        Locale sk_loc = new Locale("sk");
        if(Objects.equals(Locale.getDefault(), sk_loc))
            Locale.setDefault(new Locale("en"));
        else
            Locale.setDefault(new Locale("sk"));
        ResourceBundle.clearCache();
    }
    @FXML
    public void loadPage(Stage s, String pageName) throws IOException {
        ResourceBundle def_bundle = ResourceBundle.getBundle("src/Resources/"+pageName, Locale.getDefault());
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
