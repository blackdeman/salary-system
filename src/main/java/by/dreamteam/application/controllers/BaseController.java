/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.dreamteam.application.controllers;

import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andrew
 */
public class BaseController implements Serializable {
    
    public SystemController getSystemController() {
        return (SystemController) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("systemController");
    }
    
}
