package crm_view.components;


import crm_model.contacts.Contacts;
import crm_view.components.columns.Column;

import java.util.List;

public class TextField extends javafx.scene.control.TextField implements Component {

    private TextField textField;

    @Override
    public TextField getComponent(final int width,
                                  final Column column) {
        textField = (TextField) column.getElement();
        textField.setPromptText(column.getTitle());
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
        for (final javafx.scene.control.TextField textField : textFields) {
            contacts.addData(textField.getText());
        }
    }

}

