package crm_view.components.columns;

import javafx.scene.Parent;

public enum Column {

    ID(new ColumnId(), null, "id"),

    NAME(new ColumnName(), new crm_view.components.TextField(), "name"),

    SURNAME(new ColumnSurname(), new crm_view.components.TextField(), "calendar"),

    TELEPHONE(new ColumnTelephone(), new crm_view.components.TextField(), "telephone"),

    NUMBER(new ColumnNumber(), new crm_view.components.TextField(), "number"),

    PRICE(new ColumnPrice(), new crm_view.components.TextField(), "price"),

    DATE_START(new ColumnDateStart(), new crm_view.components.DatePicker(), "date start"),

    DATE_FINAL(new ColumnDateFinal(), new crm_view.components.DatePicker(), "date final");


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
