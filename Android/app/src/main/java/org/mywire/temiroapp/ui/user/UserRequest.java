package org.mywire.temiroapp.ui.user;

import java.io.Serializable;

public class UserRequest implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
