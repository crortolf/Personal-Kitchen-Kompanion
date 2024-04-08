package com.example.kitchenkompanion;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PantryItem extends RecyclerView.ViewHolder{

    TextView amount, item, date;
    View view;

    //TODO: adapt view to show amount as well as required minimum

    public PantryItem(View itemView) {
        super(itemView);
        amount = itemView.findViewById(R.id.amountView);
        item = itemView.findViewById(R.id.itemView);
        date = itemView.findViewById(R.id.dateView);
        view = itemView;
    }
}
