package com.andhikapanjiprasetyo.caltyfarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "datasapi.db";
    public static final String TABLE_NAME= "data_table";
    public static final String COL_1 = "ID_SAPI";
    public static final String COL_2 = "TGL_LAHIR";
    public static final String COL_3 = "BREED";
    public static final String COL_4 = "JENIS_KELAMIN";
    public static final String COL_5 = "UMUR";
    public static final String COL_6 = "TGL_DATANG";
    public static final String COL_7 = "TGL_KELUAR";
    public static final String COL_8 = "TANDA_SAPI";
    public static final String COL_9 = "BERAT_BADAN";
    public static final String COL_10 = "UMUR_BUNTING";
    public static final String COL_11 = "PERKIRAAN_LAHIR";
    public static final String COL_12 = "STATUS";
    public static final String COL_13 = "OBAT_CACING";
    public static final String COL_14 = "RIWAYAT";
    public static final String COL_15 = "TEMPERATUR";
    public static final String COL_16 = "TONUS_RUMEN";
    public static final String COL_17 = "INSEMINASI";
    public static final String COL_18 = "PENGOBATAN";
    public static final String COL_19 = "LOKASI";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table data_table(id_sapi integer primary key autoincrement, " +
                "tgl_lahir string," +
                "breed text, " +
                "jenis_kelamin text," +
                "umur text," +
                "tgl_datang string," +
                "tgl_keluar string," +
                "tanda_sapi text," +
                "berat_badan integer," +
                "umur_bunting integer," +
                "perkiraan_lahir date," +
                "status text," +
                "obat_cacing text," +
                "riwayat text," +
                "temperatur integer," +
                "tonus_rumen text," +
                "inseminasi text," +
                "pengobatan text," +
                "lokasi text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //tambah data
    public boolean insertData(String tgl_lahir, String breed, String jenis_kelamin, String umur, String tgl_datang, String tgl_keluar,
                              String tanda_sapi, Integer berat_badan, Integer umur_bunting, String perkiraan_lahir, String status,
                              String obat_cacing, String riwayat, Integer temperatur, String tonus_rumen, String inseminasi,
                              String pengobatan, String lokasi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,tgl_lahir);
        contentValues.put(COL_3,breed);
        contentValues.put(COL_4,jenis_kelamin);
        contentValues.put(COL_5,umur);
        contentValues.put(COL_6,tgl_datang);
        contentValues.put(COL_7,tgl_keluar);
        contentValues.put(COL_8,tanda_sapi);
        contentValues.put(COL_9,berat_badan);
        contentValues.put(COL_10,umur_bunting);
        contentValues.put(COL_11,perkiraan_lahir);
        contentValues.put(COL_12,status);
        contentValues.put(COL_13,obat_cacing);
        contentValues.put(COL_14,riwayat);
        contentValues.put(COL_15,temperatur);
        contentValues.put(COL_16,tonus_rumen);
        contentValues.put(COL_17,inseminasi);
        contentValues.put(COL_18,pengobatan);
        contentValues.put(COL_19,lokasi);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //metode untuk mengambil data
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from data_table", null);
        return res;
    }

    //metode untuk merubah data
    public boolean updateData(String id_sapi,String tgl_lahir, String breed, String jenis_kelamin, Integer umur, String tgl_datang, String tgl_keluar,
                              String tanda_sapi, Integer berat_badan, Integer umur_bunting, String perkiraan_lahir, String status,
                              String obat_cacing, String riwayat, Integer temperatur, String tonus_rumen, String inseminasi,
                              String pengobatan, String lokasi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id_sapi);
        contentValues.put(COL_2,tgl_lahir);
        contentValues.put(COL_3,breed);
        contentValues.put(COL_4,jenis_kelamin);
        contentValues.put(COL_5,umur);
        contentValues.put(COL_6,tgl_datang);
        contentValues.put(COL_7,tgl_keluar);
        contentValues.put(COL_8,tanda_sapi);
        contentValues.put(COL_9,berat_badan);
        contentValues.put(COL_10,umur_bunting);
        contentValues.put(COL_11,perkiraan_lahir);
        contentValues.put(COL_12,status);
        contentValues.put(COL_13,obat_cacing);
        contentValues.put(COL_14,riwayat);
        contentValues.put(COL_15,temperatur);
        contentValues.put(COL_16,tonus_rumen);
        contentValues.put(COL_17,inseminasi);
        contentValues.put(COL_18,pengobatan);
        contentValues.put(COL_19,lokasi);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id_sapi});
        return true;
    }

    //metode untuk menghapus data
    public int deleteData (String id_sapi) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id_sapi});
    }
}
