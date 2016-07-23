package crm_model.components;

import crm_model.components.columns.Column;
import javafx.scene.Parent;

public interface Component {

    String DATE_START = Column.DATE_START.toString();

    String DATE_FINAL = Column.DATE_FINAL.toString();

    Parent getComponent(final int width,
                        final Column column);

    static boolean checkDataPicker(final Column columns) {
        return columns.toString().equals(DATE_START) ||
                columns.toString().equals(DATE_FINAL);
    }

}
