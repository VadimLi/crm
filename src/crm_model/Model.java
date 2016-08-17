package crm_model;

import crm_model.contacts.Contacts;

public final class Model extends Contacts {

    private final String title = "CRM FOR HOSTELS";

    private final int widthFrame = 1200;

    private final int heightFrame = 700;

    public String getNameCRM() {
        return title;
    }

    public int getWidthFrame() {
        return widthFrame;
    }

    public int getHeightFrame() {
        return heightFrame;
    }

}
