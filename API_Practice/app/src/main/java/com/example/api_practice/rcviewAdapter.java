package com.example.api_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rcviewAdapter extends RecyclerView.Adapter<rcviewAdapter.h1> {

    public rcviewAdapter(String[] data) {
        this.data = data;
    }

    String data[];

    @NonNull
    @Override
    public h1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           LayoutInflater inflator = LayoutInflater.from(parent.getContext());
   View view = inflator.inflate(R.layout.rcviewsingle,parent,false);
////        return refrence
     return new h1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull h1 holder, int position) {
        holder.t1.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class h1 extends RecyclerView.ViewHolder{
TextView t1;
ImageView I1;
        public h1(@NonNull View itemView) {
            super(itemView);
            t1= itemView.findViewById(R.id.demotxt);
            I1= itemView.findViewById(R.id.img1);

        }
    }
}
//    LayoutInflater inflator = LayoutInflater.from(parent.getContext());
//    View view = inflator.inflate(R.layout.rcviewsingle,parent,false);
////        return refrence
//        return new h1(view);