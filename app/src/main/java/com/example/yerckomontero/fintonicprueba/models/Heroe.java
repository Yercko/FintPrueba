package com.example.yerckomontero.fintonicprueba.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by yerckomontero on 30/1/18.
 */

public class Heroe  implements Serializable{
    private String photo;
    @SerializedName("realName")
    private String realName;
    private String height;
    private String power;
    private String abilities;
    private String groups;
    private String name;

    public Heroe() {
    }

    public Heroe(String photo, String realName, String height, String power, String abilities, String groups, String name) {
        this.photo = photo;
        this.realName = realName;
        this.height = height;
        this.power = power;
        this.abilities = abilities;
        this.groups = groups;
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
