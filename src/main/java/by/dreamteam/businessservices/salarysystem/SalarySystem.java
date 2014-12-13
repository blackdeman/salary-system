package by.dreamteam.businessservices.salarysystem;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:03 PM
 */
@SessionScoped
@Named
public class SalarySystem implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(SalarySystem.class);

    public SalarySystem() {        
    }
    
    public String getMsg() {
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!!!!!!!!!!!!!!!!LOGGGGGG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "Welcome to log!";
    }

}//end SalarySystem
