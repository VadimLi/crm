package crm_controller;

import crm_model.contacts.Contacts;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.List;

public class DataController {

    private final Contacts contacts;

    public DataController(final Contacts contacts) {
        this.contacts = contacts;
    }

    private static void addDataInTextField(final List<TextField> textFields,
                                           final Contacts data) {
        for (TextField textField : textFields) {
            data.addData(textField.getText());
        }
    }

    private static void addDataInDatePicker(final List<DatePicker> datePickers,
                                            final Contacts data) {
        for (DatePicker datePicker : datePickers) {
            data.addData(datePicker.getEditor().getText());
        }
    }

    public void addInDataList(final List<TextField> textFields,
                              final List<DatePicker> datePickers,
                              final ObservableList<Contacts> dataList) {
        if (crm_view.components.TextField.checkTextField(textFields) && crm_view.components.DatePicker.checkDatePicker(datePickers)) {
            Contacts data = new Contacts().id();
            addDataInTextField(textFields, data);
            addDataInDatePicker(datePickers, data);
            dataList.addAll(data);
        }
    }

}
