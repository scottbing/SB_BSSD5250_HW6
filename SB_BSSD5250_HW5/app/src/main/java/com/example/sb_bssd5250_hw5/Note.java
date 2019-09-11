package com.example.sb_bssd5250_hw5;

import java.util.Date;

public class Note {

    private String name;
    private String date;
    private String desc;

    public Note() {
        date = new Date().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.name = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String descdate) {
        this.name = desc;
    }
}
