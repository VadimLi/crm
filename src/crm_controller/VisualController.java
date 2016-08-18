package crm_controller;

import crm_model.contacts.Contacts;
import crm_view.CRMView;
import crm_view.columns.Column;
import crm_view.components.Component;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class VisualController {

    private final CRMView crmView;

    public VisualController(final CRMView crmView) {
        this.crmView = crmView;
    }

    public void addTextFieldsInHBox(final List<TextField> textFields) {
        for (TextField textField : textFields) {
            crmView.getHbox().getChildren().add(textField);
        }
    }

    public void addDatePickersInHBox(final List<DatePicker> datePickers) {
        for (DatePicker datePicker : datePickers) {
            crmView.getHbox().getChildren().add(datePicker);
        }
    }

    public void addNewColumn(final List<TextField> textFields,
                             final List<DatePicker> datePickers,
                             final TableView<Contacts> table,
                             final ObservableList<Contacts> dataList) throws Exception {
        table.setEditable(true);
        for (final Column column : Column.values()) {
            int width = 0;
            checkColumns(column, width, textFields, datePickers);
            final TableColumn newTableColumn = crmView.getTableColumn(column, width);
            table.getColumns().add(newTableColumn);
        }

        table.setItems(dataList);
    }

    private static void checkDataPickers(final int width,
                                         final Column column,
                                         final List<TextField> textFields,
                                         final List<DatePicker> datePickers) {
        if (Component.isDataPicker(column)) {
            datePickers.add((DatePicker) new crm_view.components.DatePicker().
                    getComponent(width, column));
        } else {
            textFields.add((TextField) new crm_view.components.TextField().
                    getComponent(width, column));
        }
    }

    private static void checkColumns(final Column column,
                                     int width,
                                     final List<TextField> textFields,
                                     final List<DatePicker> datePickers) {
        if(column.equals(Column.ID)) {
            width = CRMView.WIDTH_ID;
        } else {
            width = CRMView.WIDTH_STRING;
            checkDataPickers(width, column, textFields, datePickers);
        }
    }

}
