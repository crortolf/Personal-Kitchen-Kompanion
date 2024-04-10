package com.example.kitchenkompanion;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userVM = new ViewModelProvider(getActivity()).get(UserViewModel.class);
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
                makePopup();
            }
        });
        return pantry;
    }

    private void makePopup() {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_new_grocery, null);
        int dim = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true; //taps outside of the window will dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, dim, dim, focusable);
        popupWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);

        View.OnClickListener close = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        };

        popupView.findViewById(R.id.greyOutLayout).setOnClickListener(close);
        popupView.findViewById(R.id.cancelAddPantry).setOnClickListener(close);

        //TODO: create datepicker to select expiration date

        popupView.findViewById(R.id.saveAddPantry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPantryItem(popupView);
                popupWindow.dismiss();
            }
        });
    }

    private void addPantryItem(View popupView) {
        TextView name = (TextView) popupView.findViewById(R.id.itemAddPantry);
        TextView date = (TextView) popupView.findViewById(R.id.dateAddPantry);
        TextView amount = (TextView) popupView.findViewById(R.id.quantityAddPantry);
        TextView unit = (TextView) popupView.findViewById(R.id.unitAddPantry);
        String[] dateVals = date.getText().toString().split("-");
        int[] dateValsInt = new int[] {Integer.parseInt(dateVals[2]), Integer.parseInt(dateVals[0]), Integer.parseInt(dateVals[1])};
        GroceryItem temp = new GroceryItem(name.getText().toString(), unit.getText().toString(), Float.valueOf(amount.getText().toString()), dateValsInt);
        panLis.addItem(temp);
        userVM.addGrocery(temp);
        panLis.notifyItemInserted(panLis.getItemCount());
    }
}