package crm_view.columns;


import crm_model.contacts.Contacts;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public final class ColumnName extends AbstractColumn {

    @Override
    public TableColumn createColumn() {
        tableColumn = new TableColumn(getTitle());
        tableColumn.setMinWidth(getMinWidth());
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<Contacts, String>(getValueFactory()));
        tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent t) {
                        ((Contacts) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName((String) t.getNewValue());
                    }
                }
        );
        return tableColumn;
    }

}
