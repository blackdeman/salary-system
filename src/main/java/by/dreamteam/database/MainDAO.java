package by.dreamteam.database;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
public class MainDAO {
    
    @PersistenceContext
    protected EntityManager em;

}//end MainDAO
