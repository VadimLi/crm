import columns.*;
import contacts.Data;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class CrmView extends Application {

    private     static      final       int         WIDTH_FRAME     =       900;
    private     static      final       int         HEIGHT_FRAME    =       700;

    public      static      final       int         WIDTH_STRING    =       100;
    public      static      final       int         WIDTH_ID        =       40;

    private     static      final       String      TITLE           =       "CRM FOR HOSTELS";

    private final javafx.scene.control.TableView<Data> table = new javafx.scene.control.TableView<Data>();

    private final ObservableList<Data> dataList = FXCollections.observableArrayList(Data.newBuilder().
                                                                                        id(1).
                                                                                        name("sad").
                                                                                        surname("wqe").
                                                                                        build());

    private final HBox hb = new HBox();

    private final List<TextField> textFields = new ArrayList<TextField>();

    private final List<Column> list = new ArrayList<Column>();

    private final List<TableColumn> tableColumn = new ArrayList<TableColumn>();

    private TextField addField;
    private Data data;

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
        final TableColumn columnID = new ColumnId().newBuilder().
                                                    title(Columns.ID.name()).
                                                    valueFactory(Columns.ID.toString().toLowerCase()).
                                                    minWidth(WIDTH_ID).
                                                    create();

        final TableColumn columnName = new ColumnName().newBuilder().
                                                        title("sda").
                                                        valueFactory(Columns.NAME.toString().toLowerCase()).
                                                        minWidth(WIDTH_STRING).
                                                        create();

        final TableColumn columnSurname = new ColumnSurname().newBuilder().title("ewr").valueFactory(Columns.SURNAME.toString().toLowerCase()).minWidth(WIDTH_STRING).create();

        table.getColumns().addAll(  columnID,
                                    columnName,
                                    columnSurname   );

        table.setItems(dataList);

        for (final Columns columns : Columns.values()) {
            addField = new TextField();
            if (columns.name().equals("ID")) {
                addField.setMaxWidth(WIDTH_ID);
            } else {
                addField.setMaxWidth(WIDTH_STRING);
            }
            addField.setPromptText(columns.name());
            textFields.add(addField);
        }

        final Button addButton = new Button("Add data");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data = new Data();
                if (data.checkTextField(textFields)) {
                    for (int i = 0; i < textFields.size(); i++) {
                        data.addData(textFields.get(i).getText());
                        textFields.get(i).clear();
                    }
                    dataList.add(data);
                }
            }
        });

        for (final TextField textField : textFields) {
            hb.getChildren().add(textField);
        }

        hb.getChildren().add(addButton);
        hb.setSpacing(5);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
