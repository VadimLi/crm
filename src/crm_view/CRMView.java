package crm_view;

import crm_model.contacts.Contacts;
import crm_view.components.DatePicker;
import crm_view.components.HBox;
import crm_view.components.TableView;
import crm_view.components.TextField;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public final class CRMView extends Application{

    private final Button addButton  = new Button(View.ADD_DATA);;

    private final Button deleteButton = new Button(View.DELETE_ROW);

    private final Label label = new Label(View.TITLE);

    private final VBox vbox = new VBox();

    private final ObservableList<Contacts> dataList = FXCollections.observableArrayList();

    private final TableView<Contacts> table = new TableView<Contacts>();

    private final List<TextField> textFields = new ArrayList<>();

    private final List<DatePicker> datePickers = new ArrayList<>();

    private final HBox hb = new HBox();


    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public VBox getVbox() {
        return vbox;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Scene scene = new Scene(new javafx.scene.Group());
        stage.setTitle(View.TITLE);
        stage.setWidth(View.WIDTH_FRAME);
        stage.setHeight(View.HEIGHT_FRAME);
        label.setFont(new Font(View.LABEL_FONT, 25));

        table.addColumn(dataList);
        table.addTextFieldsAndDatePickers(textFields, datePickers);

        final Button addButton = new Button("Add data");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (TextField.checkTextField(textFields) && DatePicker.checkDatePicker(datePickers)) {
                    Contacts data = new Contacts().id();
                    TextField.addDataTextFields(textFields, data);
                    DatePicker.addDataDatePickers(datePickers, data);
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

        hb.addTextFields(textFields);
        hb.addDatePickers(datePickers);
        hb.getChildren().addAll(addButton, deleteButton);
        hb.setSpacing(View.SPACING);

        vbox.setSpacing(View.SPACING);
        vbox.setPadding(new Insets( View.PADDING_BOTTOM,
                View.PADDING_LEFT,
                View.PADDING_RIGHT,
                View.PADDING_TOP));


        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
