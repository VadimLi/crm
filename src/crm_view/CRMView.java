package crm_view;

import crm_model.components.DatePicker;
import crm_model.components.HBox;
import crm_model.components.TextField;
import crm_model.components.columns.Column;
import crm_model.contacts.Contacts;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CRMView extends Application{

    private final javafx.scene.control.TableView<Contacts> table = new javafx.scene.control.TableView<Contacts>();

    private final static ObservableList<Contacts> dataList = FXCollections.observableArrayList();

    private final static List<TextField> textFields = new ArrayList<>();

    private final static List<DatePicker> datePickers = new ArrayList<>();

    private final HBox hb = new HBox();

    private final Button addButton  = new Button("Add data");;

    private final Button deleteButton = new Button("Delete row");

    private static final int WIDTH_FRAME = 900;

    private static final int HEIGHT_FRAME = 700;

    public static final int WIDTH_STRING = 100;
    
    public static final int WIDTH_ID = 40;

    private static final String TITLE = "CRM FOR HOSTELS";

    private static void addDatePickers(List<Parent> datePickers) {
        for (final Column columns : Column.values()) {
            datePickers.add((DatePicker) new DatePicker().
                    getComponent(width, columns));
        }
    }

    public static void addDataTextFields(final List<TextField> textFields ,
                                         final Contacts contacts) {
        for (final TextField textField : textFields) {
            contacts.addData(textField.getText());
        }
    }

    @Override
    public void start(final Stage stage) throws Exception {
        final Scene scene = new Scene(new javafx.scene.Group());
//        stage.setTitle(title);
//        stage.setWidth(widthFrame);
//        stage.setHeight(heightFrame);
        final Label label = new Label();
        //label.setText();
        label.setFont(new Font("Arial", 25));

        table.setEditable(true);
        /*
        *
        *
        * code
        *
        *
        * */

        table.setItems(dataList);


        hb.addTextFields(textFields);
        hb.addDatePickers(datePickers);
        hb.getChildren().addAll(addButton, deleteButton);
        hb.setSpacing(5);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public static void addColumn(final TableView table,
                                 final int widthId,
                                 final int widthString) {
        for (final Column columns : Column.values()) {
            checkColumn(columns, widthId, widthString);
            final TableColumn newTableColumn = columns.getColumn().newBuilder().
                    title(columns.toString()).
                    valueFactory(convertToLowerCase(columns)).
                    minWidth(width).
                    create();
            addDataTextFields(textFields, )
            table.getColumns().add(newTableColumn);
        }

        table.setItems(dataList);
    }

    private static void checkColumn(final Column column,
                                    final int widthId,
                                    final int widthString) {
        if (column.toString().equals(Column.ID.toString()))
            width = widthId;
        else width = widthString;
    }

    private static String convertToLowerCase(Column columns) {
        return columns.toString().toLowerCase();
    }

    public void addButtonListener(){
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (TextField.checkTextField(textFields) && DatePicker.checkDatePicker(datePickers)) {
                    final Contacts contacts = new Contacts().id();
                    TextField.addDataTextFields(textFields, contacts);
                    DatePicker.addDataDatePickers(datePickers, contacts);
                    dataList.addAll(contacts);
                }
            }
        });
    }

    public void addDeleteListener(){
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //DB
                int row = table.getSelectionModel().getSelectedIndex();
                table.getItems().remove(row);
            }
        });
    }

}
