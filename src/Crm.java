import crm_controller.DataController;
import crm_controller.VisualController;
import crm_model.PaddingVbox;
import crm_model.System;
import crm_model.contacts.Contacts;
import crm_view.CRMView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CRM extends Application{

    private final List<TextField> textFields = new ArrayList<>();

    private final List<DatePicker> datePickers = new ArrayList<>();

    private final ObservableList<Contacts> dataList = FXCollections.observableArrayList();

    private final javafx.scene.control.TableView<Contacts> table = new javafx.scene.control.TableView<Contacts>();

    private final System system = new System(CRMView.TITLE,
                                             CRMView.LIMIT_DELETING_ROW,
                                             CRMView.WIDTH_FRAME,
                                             CRMView.HEIGHT_FRAME,
                                             CRMView.SPACING_VBOX);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Contacts contacts = new Contacts();
        final CRMView crmView = new CRMView();
        final DataController dataController = new DataController(contacts);
        final VisualController visualController = new VisualController(crmView);

        final Scene scene = new Scene(new javafx.scene.Group());
        stage.setTitle(system.getNameCRM());
        stage.setWidth(system.getWidthFrame());
        stage.setHeight(system.getHeightFrame());

        visualController.addNewColumn(textFields, datePickers, table, dataList);

        crmView.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dataController.addInDataList(textFields, datePickers, dataList);
            }
        });

        crmView.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //DB
                int row = table.getSelectionModel().getSelectedIndex();
                if(row != system.getLimitDeletingRow()) {
                    table.getItems().remove(row);
                }
            }
        });

        visualController.addTextFieldsInHBox(textFields);
        visualController.addDatePickersInHBox(datePickers);

        crmView.getHbox().getChildren().addAll(crmView.getAddButton(),
                                crmView.getDeleteButton());
        crmView.getHbox().setSpacing(system.getSpacingVboxOrHbox());

        crmView.getVbox().setSpacing(system.getSpacingVboxOrHbox());
        crmView.getVbox().setPadding(new Insets( PaddingVbox.TOP.getValue(),
                                                 PaddingVbox.LEFT.getValue(),
                                                 PaddingVbox.BOTTOM.getValue(),
                                                 PaddingVbox.RIGHT.getValue() ));

        crmView.getVbox().getChildren().addAll(crmView.getLabelTitle(), table, crmView.getHbox());

        ((Group) scene.getRoot()).getChildren().addAll(crmView.getVbox());

        stage.setScene(scene);
        stage.show();
    }

}
