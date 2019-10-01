package com.andhikapanjiprasetyo.caltyfarm;

import java.text.ParseException;

public class DataDokter {
    private int gambar, jam_praktek;
    private String nama, pengalaman, univ, lokasi;

    public DataDokter(int gambar, int jam_praktek, String nama, String pengalaman, String univ, String lokasi) {
        this.gambar = gambar;
        this.jam_praktek = jam_praktek;
        this.nama = nama;
        this.pengalaman = pengalaman;
        this.univ = univ;
        this.lokasi = lokasi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public int getJam_praktek() {
        return jam_praktek;
    }

    public void setJam_praktek(int jam_praktek) {
        this.jam_praktek = jam_praktek;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

}
