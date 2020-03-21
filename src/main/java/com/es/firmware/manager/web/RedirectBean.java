package com.es.firmware.manager.web;

import com.es.firmware.manager.core.FacesBean;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
@Data
@Named
@RequestScoped
public class RedirectBean {

    @Setter(onMethod_ = @Inject)
    private LoginBean loginBean;
    @Setter(onMethod_ = @Inject)
    private FacesBean facesBean;

    private boolean vee;

    public String redirectIfValidationError() {
        if (FacesContext.getCurrentInstance().isValidationFailed()) {
            return facesBean.outcomeLogin();
        }
        return null;
    }

    public String checkLogged() {
        if (!loginBean.isLogged()) {
            facesBean.showError("Необходимо авторизоваться");
            return facesBean.outcomeLogin();
        }
        return null;
    }
}
