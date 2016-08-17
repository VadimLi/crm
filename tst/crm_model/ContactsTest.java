package crm_model;

import crm_model.contacts.Contacts;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ContactsTest {

    @Test
    public void testAddDataWhenDataIsNotNull() throws Exception {
        final Contacts contacts = new Contacts();
        final String inputData = "Name";
        contacts.addData(inputData);
        assertNotNull(contacts.getName());
    }

    @Test
    public void testGetName() throws Exception {
        final Contacts contacts = new Contacts();
        final String inputName = "Name";
        contacts.addData(inputName);
        final String actualData = contacts.getName();
        assertEquals(inputName, actualData);
    }

    @Test
    public void testIdWhenIdisNotNull() throws Exception {
        final Contacts contacts = new Contacts();
        contacts.id();
        assertNotNull(contacts.getId());
    }

}