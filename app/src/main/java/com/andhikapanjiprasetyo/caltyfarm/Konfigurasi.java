package com.andhikapanjiprasetyo.caltyfarm;

import android.widget.Spinner;

public class Konfigurasi {
    public static final String URL_ADD="http://192.168.43.51/caltyfarm/tambahSapi.php";
    public static final String URL_GET_ALL = "http://192.168.43.51/caltyfarm/tampilSemuaSapi.php";
    public static final String URL_GET_SAPI = "http://192.168.43.51/caltyfarm/tampilSapi.php";
    public static final String URL_UPDATE_SAPI = "http://192.168.43.51/caltyfarm/updateSapi.php";
    public static final String URL_DELETE_SAPI = "http://192.168.43.51/caltyfarm/hapusSapi.php";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_ID_SAPI = "id_sapi";
    public static final String KEY_TGL_LAHIR = "tgl_lahir"; //tgl_lahir itu variabel untuk posisi
    public static final String KEY_J_BREED = "j_breed";
    public static final String KEY_J_KELAMIN = "j_kelamin";
    public static final String KEY_UMUR= "umur";
    public static final String KEY_TGL_DATANG = "tgl_datang";
    public static final String KEY_TGL_KELUAR = "tgl_keluar";
    public static final String KEY_TANDA_SAPI = "tanda_sapi";
    public static final String KEY_BERAT_BADAN = "berat_badan";
    public static final String KEY_U_BUNTING = "u_bunting";
    public static final String KEY_P_LAHIR = "p_lahir";
    public static final String KEY_STATUS_VAKSIN = "status_vaksin";
    public static final String KEY_O_CACING = "o_cacing";
    public static final String KEY_RIWAYAT_KASUS = "riwayat_kasus";
    public static final String KEY_TEMPERATUR = "temperatur";
    public static final String KEY_TONUS_RUMEN = "tonus_rumen";
    public static final String KEY_INSEMINASI = "inseminasi";
    public static final String KEY_PENGOBATAN = "pengobatan";
    public static final String KEY_LOKASI = "lokasi";
    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID_SAPI = "id_sapi";
    public static final String TAG_TGL_LAHIR = "tgl_lahir";
    public static final String TAG_J_BREED = "j_breed";
    public static final String TAG_J_KELAMIN = "j_kelamin";
    public static final String TAG_UMUR= "umur";
    public static final String TAG_TGL_DATANG = "tgl_datang";
    public static final String TAG_TGL_KELUAR = "tgl_keluar";
    public static final String TAG_TANDA_SAPI = "tanda_sapi";
    public static final String TAG_BERAT_BADAN = "berat_badan";
    public static final String TAG_U_BUNTING = "u_bunting";
    public static final String TAG_P_LAHIR = "p_lahir";
    public static final String TAG_STATUS_VAKSIN = "status_vaksin";
    public static final String TAG_O_CACING = "o_cacing";
    public static final String TAG_RIWAYAT_KASUS = "riwayat_kasus";
    public static final String TAG_TEMPERATUR = "temperatur";
    public static final String TAG_TONUS_RUMEN = "tonus_rumen";
    public static final String TAG_INSEMINASI = "inseminasi";
    public static final String TAG_PENGOBATAN = "pengobatan";
    public static final String TAG_LOKASI = "lokasi";

    //ID Sapi
    public static final String S_ID_SAPI = "id_sapi";
}
