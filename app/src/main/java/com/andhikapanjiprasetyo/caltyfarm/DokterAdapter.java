//package com.andhikapanjiprasetyo.caltyfarm;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.ViewHolder> {
//
//    private static final String TAG = DokterAdapter.class.getSimpleName();
//
//    private Context context;
//    private List<DataDokter> list;
//    private DokterAdapterCallback mAdapterCallback;
//
//    public DokterAdapter(Context context, List<DokterAdapter> list, DokterAdapterCallback adapterCallback) {
//        this.context = context;
//        this.list = list;
//        this.mAdapterCallback = adapterCallback;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_dokter
//                ,
//                parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        DataDokter item = list.get(position);
//
//        int resourceGambar = item.getGambar();
//        String nama = item.getNama();
//
//        holder.ivGambar.setImageResource(resourceGambar);
//        holder.tvNama.setText(nama);
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public void clear() {
//        int size = this.list.size();
//        this.list.clear();
//        notifyItemRangeRemoved(0, size);
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.ivGambar)
//        ImageView ivGambar;
//        @BindView(R.id.tvNama)
//        TextView tvNama;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//
//            /*
//            Inisialisasi onclick pada itemview dan memanggil interface yang sudah kita buat tadi.
//             */
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    /*
//                    Memanggil interface dan juga methodnya. getAdapterPosition ini adalah method bawaan
//                    adapter untuk memanggil index posisi.
//                     */
//                    mAdapterCallback.onRowDokterAdapterClicked(getAdapterPosition());
//                }
//            });
//        }
//    }
//
//    /*
//    interface sebagai listener onclick adapter ke parent activity
//     */
//    public interface DokterAdapterCallback {
//        /*
//        Disini kalian bisa membuat beberapa fungsi dengan parameter sesuai kebutuhan. Kebutuhan
//        disini adalah untuk mendapatkan pada posisi mana user mengklik listnya.
//         */
//        void onRowDokterAdapterClicked(int position);
//    }
//}
