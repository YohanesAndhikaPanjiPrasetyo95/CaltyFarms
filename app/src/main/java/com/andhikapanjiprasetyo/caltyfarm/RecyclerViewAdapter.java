package com.andhikapanjiprasetyo.caltyfarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> rvData;

    public RecyclerViewAdapter(ArrayList<String> inputData) {
        rvData = inputData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tv_id, tv_no_id, tv_status_sehat, tv_status_sakit ;


        public ViewHolder(View v) {
            super(v);
            tv_id =v.findViewById(R.id.tv_id);
            tv_no_id =v.findViewById(R.id.tv_no_id);
            tv_status_sehat =v.findViewById(R.id.tv_status_sehat);
            tv_status_sakit =v.findViewById(R.id.tv_status_sakit);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rv_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        final String name = rvData.get(position);
        holder.tv_id.setText(rvData.get(position));
        holder.tv_no_id.setText(rvData.get(position));
        holder.tv_status_sehat.setText(rvData.get(position));
        holder.tv_status_sakit.setText(rvData.get(position));
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return 5;
    }
}