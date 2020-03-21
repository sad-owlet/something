package com.es.firmware.manager.web;

import com.es.firmware.manager.core.FacesBean;
import com.es.firmware.manager.db.Person;
import lombok.Data;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.Serializable;

@Data
@Named
@SessionScoped
public class LoginBean implements Serializable {

    @Setter(onMethod_ = @Inject)
    private EntityManager entityManager;
    @Setter(onMethod_ = @Inject)
    private FacesBean facesBean;

    private String userId;
    private String password;

    private Integer id;

    public boolean isLogged() {return id != null;}

    public String login() {
        Person person;
        try {
            person = entityManager.createQuery("  select e from Person e where e.login = :login", Person.class)
                                  .setParameter("login", userId).getSingleResult();
            id = person.getId();
        } catch (NoResultException e) {
            facesBean.showError("Логин или пароль некорректный");
            return facesBean.outcomeLogin();
        }
        return facesBean.outcomeMain();
    }

    public String logout() {
        this.id = null;
        return facesBean.outcomeLogin();
    }
}
