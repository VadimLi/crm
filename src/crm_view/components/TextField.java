package crm_view.components;


import crm_view.columns.Column;
import javafx.scene.Parent;

import java.util.List;

public class TextField extends javafx.scene.control.TextField implements Component {

    private javafx.scene.control.TextField textField;

    @Override
    public Parent getComponent(final int width,
                               final Column columns) {
        textField = (javafx.scene.control.TextField) columns.getElement();
        textField.setPromptText(columns.getTitle());
        textField.setMaxWidth(width);
        return textField;
    }


    public static boolean checkTextField(final List<javafx.scene.control.TextField> tf) {
        for (int i = 0; i < tf.size(); i++) {
            if (tf.get(i).getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
