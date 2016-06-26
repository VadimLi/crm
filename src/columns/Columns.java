package columns;

public enum Columns {

    ID("id"),
    NAME("name"),
    SURNAME("surname");
//    TELEPHONE("Telephone"),
//    NUMBER("Number"),
//    DATE_START("Date Start"),
//    DATE_FINAL("Date finish"),
//    PRICE("Price");

    private String value;

    Columns(final String value) {
        assert value != null;

        this.value = value;
    }

}
