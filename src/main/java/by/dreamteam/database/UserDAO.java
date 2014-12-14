package by.dreamteam.database;

import by.dreamteam.businessservices.entities.User;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:03 PM
 */
@Stateless
public class UserDAO extends MainDAO {

    /**
     * @param user
     * @return
     * @throws java.lang.Exception
     */
    public User authenticateUser(User user) throws Exception {

        Query query = em.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());

        return (User) query.getSingleResult();
    }
    
    public User getUserByUsername(String username) {
        Query query = em.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        
        return (User) query.getSingleResult();
    }

}//end UserDAO
