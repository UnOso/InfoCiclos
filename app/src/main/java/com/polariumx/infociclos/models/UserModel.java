package com.polariumx.infociclos.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
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

    protected UserModel(Parcel in) {
        username = in.readString();
        password = in.readString();
        hora = in.readString();
        tiempo = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(hora);
        parcel.writeString(tiempo);
    }
}
