package com.example.kitchenkompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryItem> {

    private List<GroceryItem> contents;

    public PantryAdapter(List<GroceryItem> contents) {
        this.contents = contents;
    }

    @Override
    public PantryItem onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View list = inflater.inflate(R.layout.pantry_item_view, parent, false);

        //TODO: create swipe to delete function with recycler items

        PantryItem viewHolder = new PantryItem(list);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final PantryItem item, final int position) {
        item.item.setText(contents.get(position).getName());
        item.amount.setText(contents.get(position).amountToString());
        item.date.setText(contents.get(position).getExpiration());
        item.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //TODO: create onclick listener for pantry item
                //listiner.click(index);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return contents.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void addItem(GroceryItem newItem) {
        contents.add(newItem);
    }
}
