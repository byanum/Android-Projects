package com.example.api_practice;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {

    LayoutInflater inflator;


    public myAdapter(Context ctx, List<com.example.api_practice.fetch> fetch) {
        this.inflator = LayoutInflater.from(ctx);
        this.fetch = fetch;
    }

    List<fetch> fetch;








    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ///        create layout
     LayoutInflater inflator = LayoutInflater.from(parent.getContext());
////        view created
     View view  = inflator.inflate(R.layout.singleview,parent,false);
//        //  return refrence
       return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv1.setText(fetch.get(position).getData());
        holder.tv2.setText(fetch.get(position).getSomething());
    }

    @Override
    public int getItemCount() {
        return fetch.size();
    }


    class holder extends RecyclerView.ViewHolder{
        TextView tv1, tv2;


        public holder(@NonNull View itemView) {
            super(itemView);
            tv1 =(TextView)itemView.findViewById(R.id.t1);
            tv2 =(TextView)itemView.findViewById(R.id.t2);
        }
    }
}
///        create layout
//        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
////        view created
//        View view  = inflator.inflate(R.layout.singleview,parent,false);
//        //  return refrence
//        return new holder(view);