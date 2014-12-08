package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:03 PM
 */
@Named
@SessionScoped
public class SystemController implements Serializable {

    User user;

    public SystemController() {
    }

    public User getCurrentUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCurrentUserDepartment() {
        return user.getDepartment().getName();
    }
}//end SystemController
