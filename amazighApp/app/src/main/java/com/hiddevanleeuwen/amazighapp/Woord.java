package com.hiddevanleeuwen.amazighapp;

public class Woord {
    public String  audiopath;
    public Integer category;
    public String  imagepath;
    public String  woordamz;
    public Integer woordid;
    public String  woordned;

    public Woord() {}

    public Integer getWoordid() {
        return woordid;
    }

    public void setWoordid(Integer woordid) {
        this.woordid = woordid;
    }

    public String getAudiopath() {
        return audiopath;
    }

    public void setAudiopath(String audiopath) {
        this.audiopath = audiopath;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getWoordamz() {
        return woordamz;
    }

    public void setWoordamz(String woordamz) {
        this.woordamz = woordamz;
    }

    public String getWoordned() {
        return woordned;
    }

    public void setWoordned(String woordned) {
        this.woordned = woordned;
    }

}