package crm_model;

public final class System  {

    private final String title = "CRM FOR HOSTELS";

    private final int limitDeletingRow = -1;

    private final int widthFrame = 1200;

    private final int heightFrame = 700;

    private final int spacingVbox = 5;

    public String getNameCRM() {
        return title;
    }

    public int getWidthFrame() {
        return widthFrame;
    }

    public int getHeightFrame() {
        return heightFrame;
    }

    public int getLimitDeletingRow() {
        return limitDeletingRow;
    }

    public int getSpacingVboxOrHbox() {
        return spacingVbox;
    }

}
