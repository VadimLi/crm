package crm_view;

import crm_model.contacts.Contacts;
import crm_view.columns.Column;
import crm_view.components.Component;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CrmView extends Application{

    private     static      final       int         WIDTH_FRAME     =       900;
    private     static      final       int         HEIGHT_FRAME    =       700;

    public      static      final       int         WIDTH_STRING    =       100;
    public      static      final       int         WIDTH_ID        =       40;

    private     static      final       String      TITLE           =       "CRM FOR HOSTELS";

    private final javafx.scene.control.TableView<Contacts> table = new javafx.scene.control.TableView<Contacts>();

    private final ObservableList<Contacts> dataList = FXCollections.observableArrayList();

    private final List<TextField> textFields = new ArrayList<>();
    private final List<DatePicker> datePickers = new ArrayList<>();

    private final HBox hb = new HBox();

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Scene scene = new Scene(new javafx.scene.Group());
        stage.setTitle(TITLE);
        stage.setWidth(WIDTH_FRAME);
        stage.setHeight(HEIGHT_FRAME);
        final Label label = new Label(TITLE);
        label.setFont(new Font("Arial", 25));

        table.setEditable(true);
/**/
        for (final Column columns : Column.values()) {
            int width;
            if(columns.toString().equals("ID")) {
                width = WIDTH_ID;
            } else {
                width = WIDTH_STRING;

                if (Component.checkDataPicker(columns)) {
                    datePickers.add((DatePicker) new crm_view.components.DatePicker().
                            getComponent(width, columns));
                } else {
                    textFields.add((TextField) new crm_view.components.TextField().
                            getComponent(width, columns));
                }

            }

            final TableColumn newTableColumn = columns.getColumn().
                    newBuilder().
                    title(columns.toString()).
                    valueFactory(convertToLowerCase(columns)).
                    minWidth(width).
                    create();

            table.getColumns().add(newTableColumn);
        }

        table.setItems(dataList);

        final Button addButton = new Button("Add data");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (crm_view.components.TextField.checkTextField(textFields) && crm_view.components.DatePicker.checkDatePicker(datePickers)) {
                    Contacts data = new Contacts().id();
                    for (TextField textField : textFields) {
                        data.addData(textField.getText());
                    }
                    for (DatePicker datePicker : datePickers) {
                        data.addData(datePicker.getEditor().getText());
                    }
                    dataList.addAll(data);
                }
            }
        });

        final Button deleteButton = new Button("Delete row");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                //DB
                int row = table.getSelectionModel().getSelectedIndex();
                table.getItems().remove(row);
            }
        });

        for (TextField textField : textFields) {
            hb.getChildren().add(textField);
        }

        for (DatePicker datePicker : datePickers) {
            hb.getChildren().add(datePicker);
        }

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

    public static String convertToLowerCase(Column columns) {
        return columns.toString().toLowerCase();
    }

}
