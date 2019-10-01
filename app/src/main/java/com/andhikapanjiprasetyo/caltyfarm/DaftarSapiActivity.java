package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarSapiActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    private ListView listView;
    private String JSON_STRING;

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
                startActivity(new Intent(DaftarSapiActivity.this, BerandaActivity.class));
                finish();
            }
        });

            listView = (ListView) findViewById(R.id.listView);
            listView.setOnItemClickListener(this);
            getJSON();
    }


    private void tampilSapi(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
            JSONObject jo = result.getJSONObject(i);
            String id_sapi = jo.getString(Konfigurasi.TAG_ID_SAPI);
            String j_breed = jo.getString(Konfigurasi.TAG_J_BREED);

            HashMap<String,String> sapi = new HashMap<>();
            sapi.put(Konfigurasi.TAG_ID_SAPI,id_sapi);
            sapi.put(Konfigurasi.TAG_J_BREED,j_breed);
            list.add(sapi);
            }

            } catch (JSONException e) {
            e.printStackTrace();
            }

            ListAdapter adapter = new SimpleAdapter(
            DaftarSapiActivity.this, list, R.layout.list_item,
            new String[]{Konfigurasi.TAG_ID_SAPI,Konfigurasi.TAG_J_BREED},
            new int[]{R.id.spinJenisBreed, R.id.spinJenisBreed});

            listView.setAdapter(adapter);
            }

    private void getJSON(){
    class GetJSON extends AsyncTask<Void,Void,String> {

        ProgressDialog loading;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(DaftarSapiActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.dismiss();
            JSON_STRING = s;
            tampilSapi();
        }

    @Override
    protected String doInBackground(Void... params) {
            RequestHandler rh = new RequestHandler();
            String s = rh.sendGetRequest(Konfigurasi.URL_GET_ALL);
            return s;
            }
        }
        GetJSON gj = new GetJSON();
            gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(this, DaftarSapiActivity.class);
            HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
            String s_Id = map.get(Konfigurasi.TAG_ID_SAPI).toString();
            intent.putExtra(Konfigurasi.S_ID_SAPI,s_Id);
            startActivity(intent);
            }
}
