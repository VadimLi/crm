package crm_model.components;


import crm_model.components.columns.Column;
import crm_model.contacts.Contacts;

import java.util.List;

public class DatePicker extends javafx.scene.control.DatePicker implements Component {

    private javafx.scene.control.DatePicker datePicker;

    @Override
    public javafx.scene.control.DatePicker getComponent(final int width,
                                                        final Column column) {
        datePicker = (javafx.scene.control.DatePicker) column.getElement();
        datePicker.setPromptText(column.getTitle());
        datePicker.setMaxWidth(width);
        return datePicker;
    }

    public static boolean checkDatePicker(final List<DatePicker> dp) {
        for (int i = 0; i < dp.size(); i++) {
            if (dp.get(i).getEditor().getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void addDataDatePickers(final List<DatePicker> datePickers,
                                          final Contacts contacts) {
        for (final DatePicker datePicker : datePickers) {
            contacts.addData(datePicker.getEditor().getText());
        }
    }

}
