package crm_model;

import crm_model.contacts.Contacts;

public final class Model extends Contacts {

    private String title;

    private Contacts contacts;

    /* Integers variables*/

    private int widthFrame;

    private int heightFrame;

    private int widthString;

    private int widthId;

    public Model() {}

    public Model(final String title,
                 final Contacts contacts) {
        this.title = title;
        this.contacts = contacts;
    }

    public BuilderSystem systemBuilder() {
        return this.new BuilderSystem();
    }

    public String getTitle() {
        return title;
    }

    public int getWidthFrame() {
        return widthFrame;
    }

    public int getHeightFrame() {
        return heightFrame;
    }

    public int getWidthString() {
        return widthString;
    }

    public int getWidthId() {
        return widthId;
    }

    public class BuilderSystem {

        private BuilderSystem() {}

        public BuilderSystem widthFrame(int widthFrame) {
            Model.this.widthFrame = widthFrame;
            return this;
        }

        public BuilderSystem heightFrame(int heightFrame) {
            Model.this.heightFrame = heightFrame;
            return this;
        }

        public BuilderSystem widthString(int widthString) {
            Model.this.widthString = widthString;
            return this;
        }

        public BuilderSystem widthId(int widthId) {
            Model.this.widthId = widthId;
            return this;
        }

        public Model build() {
            return Model.this;
        }

    }

}
