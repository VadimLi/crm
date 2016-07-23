package crm_model.components;


import crm_model.contacts.Contacts;
import crm_model.components.columns.Column;

import java.util.List;

public class TextField extends javafx.scene.control.TextField implements Component {

    private javafx.scene.control.TextField textField;

    @Override
    public javafx.scene.control.TextField getComponent(final int width,
                                                       final Column columns) {
        textField = (javafx.scene.control.TextField) columns.getElement();
        textField.setPromptText(columns.getTitle());
        textField.setMaxWidth(width);
        return textField;
    }

    public static boolean checkTextField(final List<TextField> tf) {
        for (int i = 0; i < tf.size(); i++) {
            if (tf.get(i).getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void addDataTextFields(final List<TextField> textFields,
                                         final Contacts contacts) {
        for (final TextField textField : textFields) {
            contacts.addData(textField.getText());
        }
    }

}

