package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class BerandaActivity extends AppCompatActivity {
    CardView cardVInput, cardVDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
    }

    public void viewLayout(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.cardVInput :  intent = new Intent(BerandaActivity.this, InputDataSapiActivity.class);
                startActivity(intent);
                break;
            case R.id.cardVDaftar :  intent = new Intent(BerandaActivity.this, DaftarStatusSapiActivity.class);
                startActivity(intent);
                break;
            case R.id.cardVAlarm:  intent = new Intent(BerandaActivity.this, DaftarStatusSapiActivity.class);
                startActivity(intent);
                break;
            case R.id.cardVTidakan:  intent = new Intent(BerandaActivity.this, DaftarStatusSapiActivity.class);
                startActivity(intent);
                break;
            case R.id.cardVHubDokter:  intent = new Intent(BerandaActivity.this, DaftarStatusSapiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
