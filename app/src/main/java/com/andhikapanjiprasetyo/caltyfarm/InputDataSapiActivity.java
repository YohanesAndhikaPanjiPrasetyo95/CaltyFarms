package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class InputDataSapiActivity extends Activity implements View.OnClickListener{
    private EditText edtT_Lahir, edtUmur, edtT_Datang, edtT_Keluar, edtTanda, edtBB, edtU_Bunting, edtP_Lahir, edtS_Vaksin,
            edtRiwayat, edtTemperatur, edtTonus, edtInseminasi, edtPengobatan, edtLokasi;
    private int mYear, mMonth, mDay;
    private Button btnSimpanData, btnLihatData;
    private ImageView imvLahir, imvDatang, imvKeluar;
    private Spinner spinJenisBreed, spinJenisKelamin, spinObatCacing;
    private String id_sapi;
    AlertDialog.Builder builder;

    private static String URL="http://192.168.43.51/caltyfarm/";
    ProgressDialog  pDialog;
    JSONArray JsonArraySapi= null;
    List<String> valueid_sapi= new ArrayList<String>();
    List<String> valuetgl_lahir= new ArrayList<String>();
    List<String> valuej_breed= new ArrayList<String>();
    List<String> valuej_kelamin= new ArrayList<String>();
    List<String> valueumur= new ArrayList<String>();
    List<String> valuetgl_datang= new ArrayList<String>();
    List<String> valuetgl_keluar= new ArrayList<String>();
    List<String> valuetanda_sapi= new ArrayList<String>();
    List<String> valueberat_badan= new ArrayList<String>();
    List<String> valueu_bunting= new ArrayList<String>();
    List<String> valuep_lahir= new ArrayList<String>();
    List<String> valuestatus_vaksin= new ArrayList<String>();
    List<String> valueo_cacing= new ArrayList<String>();
    List<String> valueriwayat_kasus= new ArrayList<String>();
    List<String> valuetemperatur= new ArrayList<String>();
    List<String> valuetonus_rumen= new ArrayList<String>();
    List<String> valueinseminasi= new ArrayList<String>();
    List<String> valuepengobatan= new ArrayList<String>();
    List<String> valuelokasi= new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_sapi);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.input_sapi));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefManager prefManager = new PrefManager(getApplicationContext());
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(InputDataSapiActivity.this, BerandaActivity.class));
                finish();
            }
        });


        //Inisialisasi dari View
        imvLahir = findViewById(R.id.imvDateSapi);
        imvKeluar = findViewById(R.id.imvTanggalKeluar);
        imvDatang = findViewById(R.id.imvTanggalDatang);

        edtT_Lahir = findViewById(R.id.edtTanggalLahir);
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

        btnSimpanData = findViewById(R.id.btnSimpanData);
        btnLihatData = findViewById(R.id.btnLihatData);

        //Setting listeners to button
        btnSimpanData.setOnClickListener(this);
        btnSimpanData.setOnClickListener(this);

        //Setting spinner
        spinJenisBreed = findViewById(R.id.spinJenisBreed);
        spinJenisKelamin = findViewById(R.id.spinJenisKelamin);
        spinObatCacing = findViewById(R.id.spinObatCacing);

        getSapi();

        imvLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(InputDataSapiActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                edtT_Lahir.setText(String.valueOf(dayOfMonth)+ "-" +
                                        String.valueOf(monthOfYear+1)+ "-" +String.valueOf(year));
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        imvDatang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(InputDataSapiActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edtT_Datang.setText(String.valueOf(dayOfMonth) + "-" +
                                        String.valueOf(monthOfYear + 1) + "-" + String.valueOf(year));
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        imvKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(InputDataSapiActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                edtT_Keluar.setText(String.valueOf(dayOfMonth)+ "-" +
                                        String.valueOf(monthOfYear+1)+ "-" +String.valueOf(year));
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    private void tambahSapi(){
        final String tgl_lahir = edtT_Lahir.toString().trim();
        final String umur = edtUmur.toString().trim();
        final String j_breed = valuej_breed.toString().trim();
        final String j_kelaimn = valuej_kelamin.toString().trim();
        final String tgl_datang = edtT_Datang.toString().trim();
        final String tgl_keluar = edtT_Keluar.toString().trim();
        final String tanda_sapi = edtTanda.toString().trim();
        final String berat_badan = edtBB.toString().trim();
        final String u_bunting = edtU_Bunting.toString().trim();
        final String p_lahir = edtP_Lahir.toString().trim();
        final String status_vaksin = edtS_Vaksin.toString().trim();
        final String o_cacing = valueo_cacing.toString().trim();
        final String riwayat_kasus = edtRiwayat.toString().trim();
        final String temperatur = edtTemperatur.toString().trim();
        final String tonus_rumen = edtTonus.toString().trim();
        final String inseminasi = edtInseminasi.toString().trim();
        final String pengobatan = edtPengobatan.toString().trim();
        final String lokasi = edtLokasi.toString().trim();

        class TambahSapi extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(InputDataSapiActivity.this,"Menambahkan Data...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(InputDataSapiActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_TGL_LAHIR,tgl_lahir);
                params.put(Konfigurasi.KEY_J_BREED,j_breed);
                params.put(Konfigurasi.KEY_J_KELAMIN,j_kelaimn);
                params.put(Konfigurasi.KEY_UMUR,umur);
                params.put(Konfigurasi.KEY_TGL_DATANG,tgl_datang);
                params.put(Konfigurasi.KEY_TGL_KELUAR,tgl_keluar);
                params.put(Konfigurasi.KEY_TANDA_SAPI,tanda_sapi);
                params.put(Konfigurasi.KEY_BERAT_BADAN,berat_badan);
                params.put(Konfigurasi.KEY_U_BUNTING,u_bunting);
                params.put(Konfigurasi.KEY_P_LAHIR,p_lahir);
                params.put(Konfigurasi.KEY_STATUS_VAKSIN,status_vaksin);
                params.put(Konfigurasi.KEY_O_CACING,o_cacing);
                params.put(Konfigurasi.KEY_RIWAYAT_KASUS,riwayat_kasus);
                params.put(Konfigurasi.KEY_TEMPERATUR,temperatur);
                params.put(Konfigurasi.KEY_TONUS_RUMEN,tonus_rumen);
                params.put(Konfigurasi.KEY_INSEMINASI,inseminasi);
                params.put(Konfigurasi.KEY_PENGOBATAN,pengobatan);
                params.put(Konfigurasi.KEY_LOKASI,lokasi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }
        TambahSapi ts = new TambahSapi();
        ts.execute();
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
            spinJenisBreed.setOnItemClickListener(spinJenisBreed.getOnItemClickListener());
            spinJenisKelamin.setOnItemClickListener(spinJenisKelamin.getOnItemClickListener());
            edtUmur.setText(umur);
            edtT_Datang.setText(tgl_datang);
            edtT_Keluar.setText(tgl_keluar);
            edtTanda.setText(tanda_sapi);
            edtBB.setText(berat_badan);
            edtU_Bunting.setText(u_bunting);
            edtP_Lahir.setText(p_lahir);
            edtS_Vaksin.setText(status_vaksin);
            spinObatCacing.setOnItemClickListener(spinObatCacing.getOnItemClickListener());
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

    private void getSapi() {
        class GetSapi extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(InputDataSapiActivity.this, "Mengambil Data...", "Tunggu...", false, false);
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

    @Override
    public void onClick(View v) {
        if(v == btnSimpanData){
            tambahSapi();
        }

        if(v == btnLihatData){
            startActivity(new Intent(this,DaftarSapiActivity.class));
        }
    }
}

