package crm_model.contacts;

import javafx.beans.property.SimpleStringProperty;

import java.lang.reflect.Field;

public class Contacts {

    public SimpleStringProperty name;

    public SimpleStringProperty surname;

    public SimpleStringProperty telephone;

    public SimpleStringProperty number;

    public SimpleStringProperty date_start;

    public SimpleStringProperty date_final;

    public SimpleStringProperty price;

    /* automatical property*/

    private SimpleStringProperty id;

    private int iterator;

    private static int countId = 1;

    private final Field[] fields = Contacts.class.getDeclaredFields();

    public Contacts() {
        this.iterator = 0;
    }

    /*      setters         */

    public void setId() {
       this.id.set(String.valueOf(countId));
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public void setSurname(final String surname) {
        this.surname.set(surname);
    }

    public void setTelephone(final String telephone) {
        this.telephone.set(telephone);
    }

    public void setNumber(final String number) {
        this.number.set(number);
    }

    public void setDate_start(final String date_start) {
        this.date_start.set(date_start);
    }

    public void setDate_final(final String date_final) {
        this.date_final.set(date_final);
    }

    public void setPrice(final String price) {
        this.price.set(price);
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

    public String getTelephone() {
        return telephone.get();
    }

    public String getNumber() {
        return number.get();
    }

    public String getDate_start() {
        return date_start.get();
    }

    public String getDate_final() {
        return date_final.get();
    }

    public String getPrice() {
        return price.get();
    }

    /*      /getters     */

    public Contacts addData(final String data) {
        try {
            fields[this.iterator].set(this, new SimpleStringProperty(data));
            this.iterator++;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Contacts id() {
        Contacts.this.id = new SimpleStringProperty(Integer.toString(countId));
        countId++;
        return this;
    }

}
