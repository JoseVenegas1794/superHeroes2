package com.example.sevenegas.Entidades;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;

@Entity
public class Biography {


    @SerializedName("full-name")
    private String fullName;

    @SerializedName("alter-egos")
    private String alterEgos;

    @SerializedName("place-of-birth")
    private String placeOfBirth;

    @SerializedName("first-appearance")
    private String firstAppearance;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlterEgos() {
        return alterEgos;
    }

    public void setAlterEgos(String alterEgos) {
        this.alterEgos = alterEgos;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }
}
