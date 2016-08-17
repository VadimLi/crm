package crm_view;

import crm_view.columns.Column;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CRMView {

    private static final int WIDTH_FRAME = 900;

    private     static      final       int         HEIGHT_FRAME    =       700;

    private     static      final       String      TITLE           =       "CRM FOR HOSTELS";

    private     static      final       String      ADD_BUTTON           =       "Add button";

    private     static      final       String      DELETE_ROW           =       "Add button";



    private final Label label = new Label(TITLE);

    private final Button addButton = new Button(ADD_BUTTON);

    private final Button deleteButton = new Button(DELETE_ROW);

    private final VBox vbox = new VBox();

    private final HBox hb = new HBox();

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Label getLabelTitle() {
        label.setFont(new Font("Arial", 25));
        return label;
    }

    public VBox getVbox() {
        return vbox;
    }

    public HBox getHbox() {
        return hb;
    }

    public TableColumn getTableColumn(final Column column,
                                      final int width) {
        return column.getColumn().
                        newBuilder().
                title(column.toString()).
                valueFactory(convertToLowerCase(column)).
                minWidth(width).
                create();
    }

    private static String convertToLowerCase(Column columns) {
        return columns.toString().toLowerCase();
    }

}
