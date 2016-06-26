package columns;

import javafx.scene.control.TableColumn;

public abstract class Column {

    public abstract TableColumn createColumn();
    protected TableColumn tableColumn;

    private String title;
    private String valueFactory;
    private int minWidth;


    public String getTitle() {
        return title;
    }

    public String getValueFactory() {
        return valueFactory;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public ColumnBuilder newBuilder() {
        return this.new ColumnBuilder();
    }

    public class ColumnBuilder {

        private ColumnBuilder() {}

        public ColumnBuilder title(final String title) {
            Column.this.title = title;
            return this;
        }

        public ColumnBuilder valueFactory(final String valueFactory) {
            Column.this.valueFactory = valueFactory;
            return this;
        }

        public ColumnBuilder minWidth(final int minWidth) {
            Column.this.minWidth = minWidth;
            return this;
        }

        public TableColumn create() {
            return Column.this.createColumn();
        }

    }

}
