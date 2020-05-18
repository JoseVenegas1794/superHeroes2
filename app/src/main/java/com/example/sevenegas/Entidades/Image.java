package com.example.sevenegas.Entidades;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
@Entity
public class Image {


    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}