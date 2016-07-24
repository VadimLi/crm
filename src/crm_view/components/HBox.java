package crm_view.components;


import java.util.List;

public class HBox extends javafx.scene.layout.HBox{

    public void addTextFields(final List<TextField> textFields) {
        for(final TextField textField : textFields) {
            this.getChildren().add(textField);
        }
    }

    public void addDatePickers(final List<DatePicker> datePickers) {
        for(final DatePicker datePicker : datePickers) {
            this.getChildren().add(datePicker);
        }
    }

}
