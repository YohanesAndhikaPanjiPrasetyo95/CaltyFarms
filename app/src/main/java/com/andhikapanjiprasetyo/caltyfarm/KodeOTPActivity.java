package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class KodeOTPActivity extends AppCompatActivity {

    Button button;
    EditText mobile;
    Button btnVerifikasi;
    String noTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kode_otp);

      Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
       mToolbar.setTitle(getString(R.string.prev));
       mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_);
       mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
                PrefManager prefManager = new PrefManager(getApplicationContext());
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(KodeOTPActivity.this, SplashscreenActivity.class));
                finish();
            }
        });

        mobile = (EditText) findViewById(R.id.edtKodeOTP);
        button = (Button) findViewById(R.id.btnVerifikasi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                noTelp = mobile.getText().toString();
                validNo(noTelp);
                Intent intent = new Intent(KodeOTPActivity.this, VerifikasiOTPActivity.class);
                intent.putExtra("mobile", noTelp);
                startActivity(intent);
                Toast.makeText(KodeOTPActivity.this, noTelp, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void validNo(String no) {
        if (no.isEmpty() || no.length() < 11) {
            mobile.setError("Masukkan nomor telepon Anda yang Aktif..");
            mobile.requestFocus();
            return;
        }
    }
}
