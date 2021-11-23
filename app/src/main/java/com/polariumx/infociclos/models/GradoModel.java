package com.polariumx.infociclos.models;

import android.os.Parcel;
import android.os.Parcelable;

public class GradoModel implements Parcelable {
    private String name;
    private ModuloModel[] modules;

    public GradoModel(String name, ModuloModel[] modules) {
        this.name = name;
        this.modules = modules;
    }

    public GradoModel() {
        modules = new ModuloModel[0];
    }

    protected GradoModel(Parcel in) {
        name = in.readString();
        modules = in.createTypedArray(ModuloModel.CREATOR);
    }

    public static final Creator<GradoModel> CREATOR = new Creator<GradoModel>() {
        @Override
        public GradoModel createFromParcel(Parcel in) {
            return new GradoModel(in);
        }

        @Override
        public GradoModel[] newArray(int size) {
            return new GradoModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeTypedArray(modules, i);
    }
}
