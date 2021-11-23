package com.polariumx.infociclos.models;

public class UserModel {
    private String username;
    private GradoModel grado;
    private String hora;
    private String tiempo;

    public UserModel(String username, GradoModel grado, String hora, String tiempo) {
        this.username = username;
        this.grado = grado;
        this.hora = hora;
        this.tiempo = tiempo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
