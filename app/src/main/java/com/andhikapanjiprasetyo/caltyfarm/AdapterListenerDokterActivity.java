//package com.andhikapanjiprasetyo.caltyfarm;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AdapterListenerDokterActivity extends AppCompatActivity
//        implements DokterAdapter.DokterAdapterCallback{
//
//    @BindView(R.id.rvDokter)
//    RecyclerView rvDokter;
//
//    Unbinder unbinder;
//    DokterAdapter dokterAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hubungi_dokter);
//
//        ButterKnife.bind(this);
//        unbinder = ButterKnife.bind(this);
//
//        dokterAdapter = new DokterAdapter(this, getDokterList(), this);
//        rvDokter.setLayoutManager(new LinearLayoutManager(this));
//        rvDokter.setItemAnimator(new DefaultItemAnimator());
//        rvDokter.setHasFixedSize(true);
//        rvDokter.setAdapter(dokterAdapter);
//        dokterAdapter.notifyDataSetChanged();
//    }
//
//    private List<DataDokter> getDokterList(){
//        List<DataDokter> dataDokterList= new ArrayList<>();
//        dataDokterList.add(new DataDokter(R.drawable.bakakak_hayam, "Drh. Denok"));
//        dataDokterList.add(new DataDokter(R.drawable.karedok, "Drh. Budi Prakoso"));
//        dataDokterList.add(new DataDokter(R.drawable.lotek, "Drh. Anna Susanti"));
//        dataDokterList.add(new DataDokter(R.drawable.mie_kocok, "Drh. Ari Bagyo"));
//        return dataDokterList;
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unbinder.unbind();
//    }
//
//    @Override
//    public void onRowMakananAdapterClicked(int position) {
//        String nama = getDokterList().get(position).getNama();
//        Toast.makeText(this, "Kamu memilih dokter" + nama, Toast.LENGTH_SHORT).show();
//    }
//}
