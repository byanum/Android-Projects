package com.example.recycle_practice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myviewholer> {
    ArrayList<Model> data;
    Context context;

    public myadapter(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;
    }



    @NonNull
    @Override
    public myviewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = inflater.inflate(R.layout.single,parent,false);
        return new myviewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholer holder, int position) {

//        obs inside temp
        final Model temp = data.get(position);

        holder.t1.setText(data.get(position).getTxt());
        holder.t2.setText(data.get(position).getDes());
        holder.i.setImageResource(data.get(position).getImg());

//        to click on image
        holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//position object inside temp
                Intent i = new Intent(context,MainActivity2.class);
i.putExtra("imagename",temp.getImg());
i.putExtra("txt", temp.getTxt());
i.putExtra("des", temp.getDes());

//start act using
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
