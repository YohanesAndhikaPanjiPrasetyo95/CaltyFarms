package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Space;

public class SplashscreenActivity extends AppCompatActivity {
    private int waktu_loading=3000;
    //3000=3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke BerandaActivity
                Intent home=new Intent(SplashscreenActivity.this, BerandaActivity.class);
                startActivity(home);
            }
        },waktu_loading);
    }
}