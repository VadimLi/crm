package contacts;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;
import java.util.List;

public final class Data {

    public SimpleStringProperty id;
    public SimpleStringProperty name;
    public SimpleStringProperty surname;

    private int iterator;

    private final Field[] fields = Data.class.getDeclaredFields();

    public Data() {
        this.iterator = 0;
    }

    public static DataBuilder newBuilder() {
        return new Data().new DataBuilder();
    }

    /*      setters         */

    public void setId(final String id) {
        this.id.set(id);
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public void setSurname(final String surname) {
        this.surname.set(surname);
    }

    /*      /setters    */

    /*      getters     */

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getSurname() {
        return surname.get();
    }

    /*      /getters     */

    public Data addData(final String data) {
        try {
            fields[this.iterator].set(this, new SimpleStringProperty(data));
            this.iterator++;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean checkTextField(final List<TextField> tf) {
        for (int i = 0; i < tf.size(); i++) {
            if (tf.get(i).getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public class DataBuilder {

        private DataBuilder() {}

        public DataBuilder id(final int id) {
            Data.this.id = new SimpleStringProperty(Integer.toString(id));
            return this;
        }

        public DataBuilder name(final String name) {
            Data.this.name = new SimpleStringProperty(name);
            return this;
        }

        public DataBuilder surname(final String surname) {
            Data.this.surname = new SimpleStringProperty(surname);
            return this;
        }

        public Data build() {
            return Data.this;
        }

    }

}
