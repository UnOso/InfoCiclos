package com.polariumx.infociclos.models;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String username, password;
    private GradoModel grado;
    private String hora;
    private String tiempo;

    public UserModel(String username, String password, GradoModel grado, String hora, String tiempo) {
        this.username = username;
        this.password = password;
        this.grado = grado;
        this.hora = hora;
        this.tiempo = tiempo;
    }

    public UserModel() {
        grado = new GradoModel();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GradoModel getGrado() {
        return grado;
    }

    public void setGrado(GradoModel grado) {
        this.grado = grado;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
