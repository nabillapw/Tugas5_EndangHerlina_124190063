package com.example.dbrumahsakit.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbrumahsakit.R;
import com.example.dbrumahsakit.nodos.pasien;

import java.util.List;



public class PasienAdapter extends RecyclerView.Adapter<PasienAdapter.Viewholder>{
    private List<pasien> pasienList; // Cached
    private LayoutInflater inflater;

    public PasienAdapter(Context context){ this.inflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Viewholder(inflater.inflate( R.layout.list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  PasienAdapter.Viewholder viewHolder, int i) {
        if(pasienList != null){
            pasien item = pasienList.get(i);
            viewHolder.nama.setText(item.getNama());
            viewHolder.tglmasuk.setText(item.getTglmasuk());
            viewHolder.tglkeluar.setText(item.getTglkeluar());

        }

    }

    public void setPasiens(List<pasien> pasiens){
        pasienList = pasiens;
        notifyDataSetChanged();
    }

    public void addPasien(pasien pasiens){
        pasienList.add(pasiens);
        notifyDataSetChanged();
    }

    pasien getPasien(int position){
        return pasienList.get(position);
    }

    @Override
    public int getItemCount() {
        if (pasienList != null)
            return pasienList.size();
        return 0;
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView nama, tglmasuk, tglkeluar;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            tglmasuk = itemView.findViewById(R.id.tglmasuk);
            tglkeluar = itemView.findViewById(R.id.tglkeluar);

        }
    }
}