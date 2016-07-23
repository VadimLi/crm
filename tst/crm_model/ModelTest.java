package crm_model;

import crm_model.contacts.Contacts;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ModelTest {

    @Test
    public void testGetWidthFrame() throws Exception {
        final String title = "CRM";
        final Contacts contacts = new Contacts();
        final int inputWidthFrame = 200;
        Model model =  new Model(title, contacts).systemBuilder().widthFrame(inputWidthFrame).build();
        final int actualWidthFrame = model.getWidthFrame();
        assertEquals(inputWidthFrame, actualWidthFrame);
    }

    @Test
    public void testGetHeightFrame() throws Exception {
        final String title = "CRM";
        final Contacts contacts = new Contacts();
        final int heightFrame = 200;
        Model model =  new Model(title, contacts).systemBuilder().heightFrame(heightFrame).build();
        final int actualWidthFrame = model.getHeightFrame();
        assertEquals(heightFrame, actualWidthFrame);
    }

    @Test
    public void testGetWidthString() throws Exception {
        final String title = "CRM";
        final Contacts contacts = new Contacts();
        final int widthId = 20;
        Model model =  new Model(title, contacts).systemBuilder().widthId(widthId).build();
        final int actualWidthFrame = model.getWidthId();
        assertEquals(widthId, actualWidthFrame);
    }

    @Test
    public void testGetWidthId() throws Exception {
        final String title = "CRM";
        final Contacts contacts = new Contacts();
        final int widthString = 50;
        Model model =  new Model(title, contacts).systemBuilder().widthString(widthString).build();
        final int actualWidthFrame = model.getWidthString();
        assertEquals(widthString, actualWidthFrame);
    }

}