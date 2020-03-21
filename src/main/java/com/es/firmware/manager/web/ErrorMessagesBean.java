package com.es.firmware.manager.web;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;

@Named
@RequestScoped
public class ErrorMessagesBean {

    private Collection<String> items = new ArrayList<>();

    public Collection<String> getItems() {
        return items;
    }

    public ErrorMessagesBean add(String message) {
        getItems().add(message);
        return this;
    }

    public boolean isAvailable() {
        return getItems() != null && !getItems().isEmpty();
    }
}
