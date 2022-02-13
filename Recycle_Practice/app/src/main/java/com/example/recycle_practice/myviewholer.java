package com.example.recycle_practice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholer extends RecyclerView.ViewHolder {

    ImageView i;
    TextView t1, t2;

    public myviewholer(@NonNull View itemView) {
        super(itemView);
        i=itemView.findViewById(R.id.img);
        t1=itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);

    }
}
