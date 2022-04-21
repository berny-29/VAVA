package src.Model;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ResourceBundle;
/*@author: James_D
*@url: https://stackoverflow.com/questions/32464974/javafx-change-application-language-on-the-run
* */
public class ObservableResourceFactory {
    private ObjectProperty<ResourceBundle> resources = new SimpleObjectProperty<>();
    public ObjectProperty<ResourceBundle> resourcesProperty() {
        return resources ;
    }
    public final ResourceBundle getResources() {
        return resourcesProperty().get();
    }
    public final void setResources(ResourceBundle resources) {
        resourcesProperty().set(resources);
    }

    public StringBinding getStringBinding(String key) {
        return new StringBinding() {
            { bind(resourcesProperty()); }
            @Override
            public String computeValue() {
                return getResources().getString(key);
            }
        };
    }
}
