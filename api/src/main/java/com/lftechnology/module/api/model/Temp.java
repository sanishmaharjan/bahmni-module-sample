package com.lftechnology.module.api.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

public class Temp extends BaseOpenmrsData {
    private Integer tempId;
    private String name;

    public Temp() {
    }

    public Temp(Integer tempId, String name) {
        this.tempId = tempId;
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    @Override
    public Integer getId() {
        return getTempId();
    }

    @Override
    public void setId(Integer id) {
        setTempId(id);
    }
}
