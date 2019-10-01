package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DaftarStatusSapiActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtID_Sapi, edtT_Lahir, edtUmur, edtT_Datang, edtT_Keluar, edtTanda, edtBB, edtU_Bunting, edtP_Lahir, edtS_Vaksin,
            edtRiwayat, edtTemperatur, edtTonus, edtInseminasi, edtPengobatan, edtLokasi;
    private Button btnUpdateSapi, btnHapusSapi;

    private String id_sapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_status_sapi);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.daftar_sapi));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefManager prefManager = new PrefManager(getApplicationContext());
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(DaftarStatusSapiActivity.this, BerandaActivity.class));
                finish();
            }
        });

        Intent intent = getIntent();

        id_sapi = intent.getStringExtra(Konfigurasi.S_ID_SAPI);

        //Inisialisasi dari View
        edtID_Sapi = findViewById(R.id.edtIDSapi);
        edtT_Lahir = findViewById(R.id.edtTandaSapi);
        edtUmur = findViewById(R.id.edtUmur);
        edtT_Datang = findViewById(R.id.edtTanggalDatang);
        edtT_Keluar= findViewById(R.id.edtTanggalKeluar);
        edtTanda = findViewById(R.id.edtTandaSapi);
        edtBB = findViewById(R.id.edtBB);
        edtU_Bunting= findViewById(R.id.edtUmurBunting);
        edtP_Lahir = findViewById(R.id.edtPerkLahir);
        edtS_Vaksin = findViewById(R.id.edtStatusVaksin);
        edtRiwayat = findViewById(R.id.edtRiwayat);
        edtTemperatur = findViewById(R.id.edtTemperatur);
        edtTonus = findViewById(R.id.edtTonus);
        edtInseminasi = findViewById(R.id.edtInseminasi);
        edtPengobatan = findViewById(R.id.edtPengobatan);
        edtLokasi = findViewById(R.id.edtLokasi);

        btnUpdateSapi= findViewById(R.id.btnUpdateSapi);
        btnHapusSapi= findViewById(R.id.btnHapusSapi);

        btnUpdateSapi.setOnClickListener(this);
        btnHapusSapi.setOnClickListener(this);

        edtID_Sapi.setText(id_sapi);

        getSapi();
    }

    private void getSapi() {
        class GetSapi extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DaftarStatusSapiActivity.this, "Mengambil Data...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                tampilSapi(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Konfigurasi.URL_GET_SAPI, id_sapi);
                return s;
            }
        }
        GetSapi gs = new GetSapi();
        gs.execute();
    }

    private void tampilSapi(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String tgl_lahir = c.getString(Konfigurasi.TAG_TGL_LAHIR);
            String j_breed = c.getString(Konfigurasi.TAG_J_BREED);
            String j_kelamin = c.getString(Konfigurasi.TAG_J_KELAMIN);
            String umur = c.getString(Konfigurasi.TAG_UMUR);
            String tgl_datang = c.getString(Konfigurasi.TAG_TGL_DATANG);
            String tgl_keluar = c.getString(Konfigurasi.TAG_TGL_KELUAR);
            String tanda_sapi = c.getString(Konfigurasi.TAG_TANDA_SAPI);
            String berat_badan = c.getString(Konfigurasi.TAG_BERAT_BADAN);
            String u_bunting = c.getString(Konfigurasi.TAG_U_BUNTING);
            String p_lahir = c.getString(Konfigurasi.TAG_P_LAHIR);
            String status_vaksin = c.getString(Konfigurasi.TAG_STATUS_VAKSIN);
            String o_cacing = c.getString(Konfigurasi.TAG_O_CACING);
            String riwayat_kasus = c.getString(Konfigurasi.TAG_RIWAYAT_KASUS);
            String temperatur = c.getString(Konfigurasi.TAG_TEMPERATUR);
            String tonus_rumen = c.getString(Konfigurasi.TAG_TONUS_RUMEN);
            String inseminasi = c.getString(Konfigurasi.TAG_INSEMINASI);
            String pengobatan = c.getString(Konfigurasi.TAG_PENGOBATAN);
            String lokasi = c.getString(Konfigurasi.TAG_LOKASI);

            edtT_Lahir.setText(tgl_lahir);
            edtUmur.setText(umur);
            edtT_Datang.setText(tgl_datang);
            edtT_Keluar.setText(tgl_keluar);
            edtTanda.setText(tanda_sapi);
            edtBB.setText(berat_badan);
            edtU_Bunting.setText(u_bunting);
            edtP_Lahir.setText(p_lahir);
            edtS_Vaksin.setText(status_vaksin);
            edtRiwayat.setText(riwayat_kasus);
            edtTemperatur.setText(temperatur);
            edtTonus.setText(tonus_rumen);
            edtInseminasi.setText(inseminasi);
            edtPengobatan.setText(pengobatan);
            edtLokasi.setText(lokasi);
            }catch (JSONException e)
        {
            e.printStackTrace();
        }
    }


    private void updateSapi() {
        final String tgl_lahir = edtT_Lahir.getText().toString().trim();
        final String umur = edtUmur.getText().toString().trim();
        final String tgl_datang = edtT_Datang.getText().toString().trim();
        final String tgl_keluar = edtT_Keluar.getText().toString().trim();
        final String tanda_sapi = edtTanda.getText().toString().trim();
        final String berat_badan = edtBB.getText().toString().trim();
        final String u_bunting = edtU_Bunting.getText().toString().trim();
        final String p_lahir = edtP_Lahir.getText().toString().trim();
        final String status_vaksin = edtS_Vaksin.getText().toString().trim();
        final String riwayat_kasus = edtRiwayat.getText().toString().trim();
        final String temperatur = edtTemperatur.getText().toString().trim();
        final String tonus_rumen = edtTonus.getText().toString().trim();
        final String inseminasi = edtInseminasi.getText().toString().trim();
        final String pengobatan = edtPengobatan.getText().toString().trim();
        final String lokasi = edtLokasi.getText().toString().trim();

        class UpdateSapi extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DaftarStatusSapiActivity.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(DaftarStatusSapiActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Konfigurasi.KEY_ID_SAPI, id_sapi);
                hashMap.put(Konfigurasi.KEY_TGL_LAHIR, tgl_lahir);
                hashMap.put(Konfigurasi.KEY_UMUR, umur);
                hashMap.put(Konfigurasi.KEY_TGL_DATANG, tgl_datang);
                hashMap.put(Konfigurasi.KEY_TGL_KELUAR, tgl_keluar);
                hashMap.put(Konfigurasi.KEY_TANDA_SAPI, tanda_sapi);
                hashMap.put(Konfigurasi.KEY_BERAT_BADAN, berat_badan);
                hashMap.put(Konfigurasi.KEY_U_BUNTING, u_bunting);
                hashMap.put(Konfigurasi.KEY_P_LAHIR, p_lahir);
                hashMap.put(Konfigurasi.KEY_STATUS_VAKSIN, status_vaksin);
                hashMap.put(Konfigurasi.KEY_RIWAYAT_KASUS, riwayat_kasus);
                hashMap.put(Konfigurasi.KEY_TEMPERATUR, temperatur);
                hashMap.put(Konfigurasi.KEY_TONUS_RUMEN, tonus_rumen);
                hashMap.put(Konfigurasi.KEY_INSEMINASI, inseminasi);
                hashMap.put(Konfigurasi.KEY_PENGOBATAN, pengobatan);
                hashMap.put(Konfigurasi.KEY_LOKASI, lokasi);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(Konfigurasi.URL_UPDATE_SAPI, hashMap);
                return s;
            }
        }
        UpdateSapi us = new UpdateSapi();
        us.execute();
    }

    private void hapusSapi() {
        class HapusSapi extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DaftarStatusSapiActivity.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(DaftarStatusSapiActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Konfigurasi.URL_DELETE_SAPI, id_sapi);
                return s;
            }
        }

        HapusSapi hs = new HapusSapi();
        hs.execute();
    }

    private void konfirmasiHapusSapi() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah kamu yakin ingin menghapus data sapi ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        hapusSapi();
                        startActivity(new Intent(DaftarStatusSapiActivity.this, DaftarSapiActivity.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnUpdateSapi) {
            updateSapi();
        }

        if (v == btnHapusSapi) {
            konfirmasiHapusSapi();
        }
    }
}
