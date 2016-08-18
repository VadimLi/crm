package crm_model;

public final class System  {

    private final String title;

    private final int limitDeletingRow;

    private final int widthFrame;

    private final int heightFrame;

    private final int spacingVbox;

    public System(final String title,
                  final int limitDeletingRow,
                  final int widthFrame,
                  final int heightFrame,
                  final int spacingVbox) {
        this.title = title;
        this.limitDeletingRow = limitDeletingRow;
        this.widthFrame = widthFrame;
        this.heightFrame = heightFrame;
        this.spacingVbox = spacingVbox;
    }

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
