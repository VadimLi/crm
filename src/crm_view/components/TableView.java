package crm_view.components;

import crm_view.View;
import crm_view.components.columns.Column;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import java.util.List;

public class TableView<Contacts> extends javafx.scene.control.TableView {

    private int width;

    public void addColumn(final ObservableList<Contacts> dataList) {
        this.setEditable(true);
        for (final Column columns : Column.values()) {
            checkWidth(columns);
            final TableColumn newTableColumn = columns.getColumn().newBuilder().
                                                                    title(columns.toString()).
                                                                    valueFactory(convertToLowerCase(columns)).
                                                                    minWidth(width).
                                                                    create();
            this.getColumns().add(newTableColumn);
        }
        this.setItems(dataList);
    }

    private void checkWidth(final Column column) {
        if(column.toString().equals(Column.ID))
            width = View.WIDTH_ID;
        else width = View.WIDTH_STRING;
    }

    public void addTextFieldsAndDatePickers(final List<TextField> textFields,
                                            final List<DatePicker> datePickers) {
        for (final Column columns : Column.values()) {
            checkWidth(columns);
            if (checkTextFieldsAndDatePickers(columns))
                datePickers.add((DatePicker) new DatePicker().
                                getComponent(width, columns));
            else textFields.add(new TextField().
                                    getComponent(width, columns));
        }
    }

    private static boolean checkTextFieldsAndDatePickers(final Column column) {
        return column.equals(Column.DATE_START) ||
                column.equals(Column.DATE_FINAL);
    }

    private static String convertToLowerCase(final Column column) {
        return column.toString().toLowerCase();
    }

}
