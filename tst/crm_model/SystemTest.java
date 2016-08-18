package crm_model;

import crm_view.CRMView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SystemTest {

    @Test
    public void testGetNameCRM() throws Exception {
        final String inputNameCRM = CRMView.TITLE;
        final System system = new System(inputNameCRM, 2, 2, 2, 2);
        assertEquals(inputNameCRM, system.getNameCRM());
    }

    @Test
    public void testGetWidthFrame() throws Exception {
        final int inputWidthFrame = CRMView.WIDTH_FRAME;
        final System system = new System("sa", 2, inputWidthFrame, 2, 2);
        assertEquals(inputWidthFrame, system.getWidthFrame());
    }

    @Test
    public void testGetHeightFrame() throws Exception {
        final int inputHeightFrame = CRMView.HEIGHT_FRAME;
        final System system = new System("sa", 2, 3, inputHeightFrame, 2);
        assertEquals(inputHeightFrame, system.getHeightFrame());
    }

    @Test
    public void testGetLimitDeletingRow() throws Exception {
        final int inputHeightFrame = CRMView.LIMIT_DELETING_ROW;
        final System system = new System("sa", inputHeightFrame, 3, 4, 2);
        assertEquals(inputHeightFrame, system.getLimitDeletingRow());
    }

    @Test
    public void testGetSpacingVboxOrHbox() throws Exception {
        final int inputHeightFrame = CRMView.SPACING_VBOX;
        final System system = new System("sa", 3, 3, 4, inputHeightFrame);
        assertEquals(inputHeightFrame, system.getSpacingVboxOrHbox());
    }

}