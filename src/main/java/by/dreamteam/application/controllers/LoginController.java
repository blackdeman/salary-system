package by.dreamteam.application.controllers;

import by.dreamteam.database.UserDAO;
import by.dreamteam.businessservices.entities.User;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
@Named
@ViewScoped
public class LoginController extends BaseController {

    @EJB
    private UserDAO userDAO;

    private User user;
    private boolean loginDone = true;

    public LoginController() {
    }

    public String doLogin() {
        try {
            User gotUser = userDAO.authenticateUser(user);
//            getSystemController().setUser(gotUser);
            return "welcome.xhtml";
        } catch (Exception ex) {
            setLoginDone(false);
        }
        return null;
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoginDone() {
        return loginDone;
    }

    public void setLoginDone(boolean loginDone) {
        this.loginDone = loginDone;
    }

}//end LoginController
