package com.example.sevenegas.Entidades;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;

@Entity
public class PowerStats {


    @SerializedName("speed")
    private String speed;
    @SerializedName("intelligence")
    private String intelligence;
    @SerializedName("strength")
    private String strength;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }


}
