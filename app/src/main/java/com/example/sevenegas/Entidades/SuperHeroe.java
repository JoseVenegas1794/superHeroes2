package com.example.sevenegas.Entidades;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Transient;
@Entity
public class SuperHeroe {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Transient
    @SerializedName("powerstats")
    public PowerStats powerstats;
    @Transient
    @SerializedName("biography")
    public Biography biography;
    @Transient
    @SerializedName("image")
    public Image image;



}



