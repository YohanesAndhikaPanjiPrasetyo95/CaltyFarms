package com.andhikapanjiprasetyo.caltyfarm.daftarsapi;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.andhikapanjiprasetyo.caltyfarm.BerandaActivity;
import com.andhikapanjiprasetyo.caltyfarm.ListSapiResponse;
import com.andhikapanjiprasetyo.caltyfarm.network.NetworkConfig;
import com.andhikapanjiprasetyo.caltyfarm.PrefManager;
import com.andhikapanjiprasetyo.caltyfarm.R;
import com.andhikapanjiprasetyo.caltyfarm.model.SapiModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarStatusSapiActivity extends AppCompatActivity {

    RecyclerView rvSapi;

    AdapterSapi adapter;

    ArrayList<SapiModel> listSapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_status_sapi);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.daftar_sapi));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_);
        mToolbar.setNavigationOnClickListener(view -> {
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            startActivity(new Intent(DaftarStatusSapiActivity.this, BerandaActivity.class));
            finish();
        });

        rvSapi = findViewById(R.id.rv_sapi);
        listSapi = new ArrayList<>();
        adapter = new AdapterSapi(listSapi, this);
        rvSapi.setAdapter(adapter);
        rvSapi.setLayoutManager(new LinearLayoutManager(this));
        getListSapi();
    }

    void getListSapi() {
        NetworkConfig.createService().getListSapi()
                .enqueue(new Callback<ListSapiResponse>() {
                    @Override
                    public void onResponse(final Call<ListSapiResponse> call,
                            final Response<ListSapiResponse> response) {
                        listSapi.clear();
                        listSapi.addAll(response.body().data);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(final Call<ListSapiResponse> call, final Throwable t) {

                    }
                });
    }

}
