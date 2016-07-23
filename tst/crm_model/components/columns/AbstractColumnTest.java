package crm_model.components.columns;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AbstractColumnTest {


    @Test
    public void testGetTitle() throws Exception {
        final String inputTitle = "TITLE";
        final ColumnName column = new ColumnName();
        column.newBuilder().title(inputTitle);
        final String actualTitle = column.getTitle();
        assertEquals(inputTitle, actualTitle);
    }

    @Test
    public void testGetValueFactory() throws Exception {
        final String inputValueFactory = "name";
        final ColumnName column = new ColumnName();
        column.newBuilder().valueFactory(inputValueFactory);
        final String actualValueFactory = column.getValueFactory();
        assertEquals(inputValueFactory, actualValueFactory);
    }

    @Test
    public void testGetMinWidth() throws Exception {
        final int inputMinWidth = 200;
        final ColumnName column = new ColumnName();
        column.newBuilder().minWidth(inputMinWidth);
        final int actualInputMinWidth = column.getMinWidth();
        assertEquals(inputMinWidth, actualInputMinWidth);
    }

}