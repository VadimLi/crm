package crm_view.components;

import crm_view.columns.Column;
import javafx.scene.Parent;

public interface Component {

    String DATE_START = Column.DATE_START.toString();

    String DATE_FINAL = Column.DATE_FINAL.toString();

    Parent getComponent(final int width,final Column columns);

    static boolean isDataPicker(Column columns) {
        return columns.toString().equals(DATE_START) ||
                columns.toString().equals(DATE_FINAL);
    }

}
