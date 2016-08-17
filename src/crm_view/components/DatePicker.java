package crm_view.components;


import crm_view.columns.Column;
import javafx.scene.Parent;

import java.util.List;

public class DatePicker extends javafx.scene.control.DatePicker implements Component {

    private javafx.scene.control.DatePicker datePicker;

    @Override
    public Parent getComponent(final int width,
                               final Column columns) {
        datePicker = (javafx.scene.control.DatePicker) columns.getElement();
        datePicker.setPromptText(columns.getTitle());
        datePicker.setMaxWidth(width);
        return datePicker;
    }

    public static boolean checkDatePicker(final List<javafx.scene.control.DatePicker> dp) {
        for (int i = 0; i < dp.size(); i++) {
            if (dp.get(i).getEditor().getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
