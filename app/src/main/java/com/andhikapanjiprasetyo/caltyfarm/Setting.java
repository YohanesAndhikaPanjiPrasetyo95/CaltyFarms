package com.andhikapanjiprasetyo.caltyfarm;

import androidx.annotation.DrawableRes;

public class Setting {
    @DrawableRes
    private int gambar;
    private String title, desc;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
