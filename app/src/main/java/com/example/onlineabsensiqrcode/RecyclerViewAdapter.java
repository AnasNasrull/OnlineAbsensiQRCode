package com.example.onlineabsensiqrcode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder> {
    private ArrayList<Data> rvData;

    public RecyclerViewAdapter(ArrayList<Data> inputData) {
        this.rvData = inputData;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_list_item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Data isi = rvData.get(position);

        holder.tvName.setText(  "Nama       : " + isi.getNama());
        holder.tvNim.setText(   "NIM        : " + isi.getNim());
        holder.tvHadir.setText( "Kehadiran  : " + isi.getHadir());
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvNim, tvHadir;

        ListViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txnama);
            tvNim = itemView.findViewById(R.id.txnim);
            tvHadir = itemView.findViewById(R.id.txhadir);
        }
    }
}