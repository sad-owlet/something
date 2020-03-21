package com.es.firmware.manager.web;


import com.es.firmware.manager.core.FacesBean;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean {

    @Setter(onMethod_ = @Inject)
    private FacesBean facesBean;

    public String getIndex() {
        return facesBean.outcomeMain();
    }

}
