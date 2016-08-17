package crm_view.columns;

import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public enum Column {

    ID(new ColumnId(), null, "id"),

    NAME(new ColumnName(), new TextField(), "textField"),

    SURNAME(new ColumnSurname(), new TextField(), "calendar"),

    TELEPHONE(new ColumnTelephone(), new TextField(),"telephone"),

    NUMBER(new ColumnNumber(), new TextField(),"number"),

    DATE_START(new ColumnDateStart(), new DatePicker(),"date start"),

    DATE_FINAL(new ColumnDateFinal(), new DatePicker(),"date final"),

    PRICE(new ColumnPrice(), new TextField(),"price");

    private final AbstractColumn column;

    private final Parent element;

    private final String title;

    Column(final AbstractColumn column,
           final Parent element,
           final String title) {
        this.column = column;
        this.element = element;
        this.title = title;
    }

    public AbstractColumn getColumn() {
        return column;
    }

    public Parent getElement() {
        return element;
    }

    public String getTitle() {
        return title;
    }

}
