package com.polariumx.infociclos.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ModuloModel implements Parcelable {
    private String title;
    private String description;
    private Boolean validated;

    public ModuloModel(String title, String description, Boolean validated) {
        this.title = title;
        this.description = description;
        this.validated = validated;
    }

    protected ModuloModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        byte tmpValidated = in.readByte();
        validated = tmpValidated == 0 ? null : tmpValidated == 1;
    }

    public static final Creator<ModuloModel> CREATOR = new Creator<ModuloModel>() {
        @Override
        public ModuloModel createFromParcel(Parcel in) {
            return new ModuloModel(in);
        }

        @Override
        public ModuloModel[] newArray(int size) {
            return new ModuloModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeByte((byte) (validated == null ? 0 : validated ? 1 : 2));
    }
}
