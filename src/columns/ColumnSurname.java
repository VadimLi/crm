package columns;


import contacts.Data;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public final class ColumnSurname extends Column {

    public TableColumn createColumn() {
        tableColumn = new TableColumn(getTitle());
        tableColumn.setMinWidth(getMinWidth());
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<Data, String>(getValueFactory()));
        tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent t) {
                        ((Data) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSurname((String) t.getNewValue());
                    }
                }
        );
        return tableColumn;
    }

}
