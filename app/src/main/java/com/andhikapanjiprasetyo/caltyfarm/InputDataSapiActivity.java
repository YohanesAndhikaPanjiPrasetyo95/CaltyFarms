package com.andhikapanjiprasetyo.caltyfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class InputDataSapiActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private ImageView imvDate, imvLahir, imvKeluar;
    private int mYear, mMonth, mDay;
    private EditText edtTanggalDatang, edtTanggalLahir, edtTanggalKeluar,
            edtUmur,edtTandaSapi,edtBeratBadan,edtUmurBunting,edtStatus,
            edtRiwayat,edtTemperatur,edtTonusRumen,
            edtInseminasi,edtPengobatan,edtLokasi;
    private Button btnSimpanData, btnLihatData;
    private Spinner spinJenisBreed, spinObatCacing;
    private RadioGroup rg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_sapi);
        myDb = new DatabaseHelper(this);
        imvDate = findViewById(R.id.imvTanggalDatang);
        imvLahir = findViewById(R.id.imvDateSapi);
        imvKeluar = findViewById(R.id.imvTanggalKeluar);
        edtTanggalDatang = findViewById(R.id.edtTanggalDatang);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtTanggalKeluar = findViewById(R.id.edtTanggalKeluar);
        edtUmur = findViewById(R.id.edtUmur);
        edtTandaSapi = findViewById(R.id.edtTandaSapi);
        edtBeratBadan = findViewById(R.id.edtBB);
        edtUmurBunting = findViewById(R.id.edtUmurBunting);
        edtStatus = findViewById(R.id.edtStatusVaksin);
        edtRiwayat = findViewById(R.id.edtRiwayat);
        edtTemperatur = findViewById(R.id.edtTemperatur);
        edtTonusRumen = findViewById(R.id.edtTonus);
        edtInseminasi = findViewById(R.id.edtInseminasi);
        edtPengobatan = findViewById(R.id.edtPengobatan);
        edtLokasi = findViewById(R.id.edtLokasi);

        spinJenisBreed = findViewById(R.id.spinJenisBreed);
        spinObatCacing = findViewById(R.id.spinObatCacing);

        rg_gender = findViewById(R.id.rg_gender);

        spinJenisBreed.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinObatCacing.setOnItemSelectedListener(new CustomOnItemSelectedListenerObat());

        imvDate.setOnClickListener(new View.OnClickListener() {
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
                            edtTanggalDatang.setText(String.valueOf(dayOfMonth) + "-" +
                                    String.valueOf(monthOfYear + 1) + "-" + String.valueOf(year));
                            }
                        }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });

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
                                edtTanggalLahir.setText(String.valueOf(dayOfMonth)+ "-" +
                                        String.valueOf(monthOfYear+1)+ "-" +String.valueOf(year));
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
                                edtTanggalKeluar.setText(String.valueOf(dayOfMonth)+ "-" +
                                        String.valueOf(monthOfYear+1)+ "-" +String.valueOf(year));
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });



//        tambahData();
//        tampilData();
//        updateData();
//        hapusData();
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        String firstItem = String.valueOf(spinJenisBreed.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinJenisBreed.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "Kamu memilih : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {
        }
    }

    public class CustomOnItemSelectedListenerObat implements AdapterView.OnItemSelectedListener {
        String firstItem = String.valueOf(spinObatCacing.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinObatCacing.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "Kamu memilih : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {
        }
    }

    //fungsi tambahData
    public void tambahData(View view) {
        String tgl_lahir = edtTanggalLahir.getText().toString();
        String umur = edtUmur.getText().toString();
        String tgl_datang = edtTanggalDatang.getText().toString();
        String tgl_keluar = edtTanggalKeluar.getText().toString();
        String status = edtStatus.getText().toString();
        String riwayat = edtRiwayat.getText().toString();
        String tonus = edtTonusRumen.getText().toString();
        String insem = edtInseminasi.getText().toString();
        String pengobatan = edtPengobatan.getText().toString();
        String lokasi = edtLokasi.getText().toString();
        String tanda = edtTandaSapi.getText().toString();

        int j_breed = spinJenisBreed.getSelectedItemPosition()+1;
        int o_cacing = spinObatCacing.getSelectedItemPosition()+1;



        int berat = Integer.parseInt(edtBeratBadan.getText().toString());
        int u_bunting = Integer.parseInt(edtUmurBunting.getText().toString());
        int temperatur = Integer.parseInt(edtTemperatur.getText().toString());

        DatabaseHelper database = new DatabaseHelper(this);
        database.insertData(tgl_lahir, j_breed , umur, status, riwayat, tonus, insem, pengobatan, lokasi, tanda,
                j_breed, o_cacing, berat, u_bunting, temperatur, lokasi);
        Toast.makeText(this, "Transaksi "+name+" berhasil disimpan", Toast.LENGTH_SHORT).show();
        finish();
    }

    //fungsi menampilkan data

//    public void viewAll() {
//        btnLihatData.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = myDb.getAllData();
//                        if(res.getCount() == 0) {
//                            // show message
//                            showMessage("Error","Noting Found");
//                            return;
//                        }
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext() ) {
//                            buffer.append("Id :"+ res.getString(0)+"\n");
//                            buffer.append("Name :"+ res.getString(1)+"\n");
//                            buffer.append("Surname :"+ res.getString(2)+"\n");
//                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
//                        }
//                        // show all data
//                        showMessage("Data",buffer.toString());
//                    }
//                }
//        );
//    }
//
//    //membuat alert dialog
//
//    public void showMessage(String title, String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//
//    }
}
