package com.polariumx.infociclos.models;

import java.io.Serializable;

public class GradoModel implements Serializable {
    private String name;
    private ModuloModel[] modules;

    public GradoModel(String name, ModuloModel[] modules) {
        this.name = name;
        this.modules = modules;
    }

    public GradoModel() {
        modules = new ModuloModel[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModuloModel[] getModules() {
        return modules;
    }

    public void setModules(ModuloModel[] modules) {
        this.modules = modules;
    }

}
