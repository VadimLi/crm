package crm_model;

public enum PaddingVbox {

    TOP(10),
    LEFT(0),
    BOTTOM(0),
    RIGHT(10);

    private final int value;

    PaddingVbox(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
