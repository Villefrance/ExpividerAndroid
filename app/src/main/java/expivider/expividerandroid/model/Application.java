package expivider.expividerandroid.model;

import java.io.Serializable;

public class Application implements Serializable {

    private String application_text;
    private String phone;

    public Application(String application_text, String phone) {
        this.application_text = application_text;
        this.phone = phone;
    }

    public String getApplication_text() {
        return application_text;
    }

    public void setApplication_text(String application_text) {
        this.application_text = application_text;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return phone + " : " + application_text;
    }
}
