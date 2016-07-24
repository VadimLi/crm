package crm_view.components.columns;

import javafx.scene.control.TableColumn;

public abstract class AbstractColumn {

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

        ColumnBuilder() {}

        public ColumnBuilder title(final String title) {
            AbstractColumn.this.title = title;
            return this;
        }

        public ColumnBuilder valueFactory(final String valueFactory) {
            AbstractColumn.this.valueFactory = valueFactory;
            return this;
        }

        public ColumnBuilder minWidth(final int minWidth) {
            AbstractColumn.this.minWidth = minWidth;
            return this;
        }

        public TableColumn create() {
            return AbstractColumn.this.createColumn();
        }

    }


}
