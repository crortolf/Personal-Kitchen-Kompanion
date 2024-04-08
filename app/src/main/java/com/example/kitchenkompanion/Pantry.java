package com.example.kitchenkompanion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pantry#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pantry extends Fragment {

    private UserViewModel userVM;

    private PantryAdapter panLis;

    public Pantry() {
        // Required empty public constructor
    }
    public static Pantry newInstance() {
        Pantry fragment = new Pantry();
        return fragment;
    }

    //TODO: create new item, add to database and list, create menu for pantry creation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userVM = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        userVM.addTestUser("Larry");
        try { userVM.setCurrent("Larry"); }
        catch (Exception e) { System.out.println(e.getStackTrace()); }
        panLis = new PantryAdapter(new ArrayList<>(userVM.pantry()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View pantry = inflater.inflate(R.layout.fragment_pantry, container, false);
        RecyclerView list = pantry.findViewById(R.id.pantryRecycler);
        list.setAdapter(panLis);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        pantry.findViewById(R.id.addPantryitem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panLis.addItem(new GroceryItem("Fresh Cilantro", "Bundles", 3.0f, new int[]{ 2024, 2, 1}));
                panLis.notifyDataSetChanged();
            }
        });
        return pantry;
    }
}