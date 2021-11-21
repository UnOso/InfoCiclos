package com.polariumx.infociclos.models;

public class ModuloModel {
    private String title;
    private String description;
    private Boolean validated;

    public ModuloModel(String title, String description, Boolean validated) {
        this.title = title;
        this.description = description;
        this.validated = validated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }
}
