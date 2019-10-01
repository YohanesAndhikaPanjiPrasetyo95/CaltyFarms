package com.andhikapanjiprasetyo.caltyfarm.daftarsapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.andhikapanjiprasetyo.caltyfarm.R;
import com.andhikapanjiprasetyo.caltyfarm.model.SapiModel;
import java.util.List;

public class AdapterSapi extends RecyclerView.Adapter<AdapterSapi.ViewHolder> {

    List<SapiModel> list;

    Context context;

    public View view;

    public AdapterSapi(List<SapiModel> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public AdapterSapi.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_sapi, parent, false);
        AdapterSapi.ViewHolder holder = new AdapterSapi.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterSapi.ViewHolder holder, int position) {
        SapiModel model = list.get(position);
        holder.tvIdSapi.setText("ID"+model.idSapi);
        if (model.statusVaksin.equalsIgnoreCase("sudah")) {
            holder.tvSehat.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        } else {
            holder.tvSakit.setTextColor(ContextCompat.getColor(context, R.color.colorError));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdSapi, tvSehat, tvSakit;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvIdSapi = view.findViewById(R.id.tv_id_sapi);
            tvSehat = view.findViewById(R.id.tv_sehat);
            tvSakit = view.findViewById(R.id.tv_sakit);
        }
    }
}