package com.es.firmware.manager.core;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ApplicationScoped
public class FacesBean {

    public void showError(String message) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public String outcomeLogin(){
        return outcome("/login.xhtml");
    }

    public String outcomeMain(){
        return outcome("/auth/main.xhtml");
    }
    public String outcome(String viewName) {
        return outcome(viewName, true);
    }

    public String outcome(String viewName, boolean redirect) {
        return viewName + (redirect ? "?faces-redirect=true" : "");
    }
}
