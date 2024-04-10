package com.example.kitchenkompanion;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.Set;

//TODO: Remove add/adjust grocery buttons, replace with notifications container
public class HomePage extends Fragment {

    UserViewModel userVM;

    Button selected;
    public HomePage() {
        // Required empty public constructor
    }

    public static HomePage newInstance() {
        HomePage fragment = new HomePage();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userVM = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        selected = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home = inflater.inflate(R.layout.fragment_home_page, container, false);

        LinearLayout ll = home.findViewById(R.id.userLayout);

        Context act = requireActivity();
        View.OnClickListener userButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Button temp = (Button) view;
                    userVM.setCurrent(temp.getText().toString());
                } catch (Exception e) { e.printStackTrace(); }
                if (selected != null) {
                    selected.setBackgroundColor(ContextCompat.getColor(act, R.color.brown));
                    selected.setTextColor(ContextCompat.getColor(act, R.color.white));
                }
                if (selected != view) {
                    selected = (Button) view;
                    selected.setBackgroundColor(ContextCompat.getColor(act, R.color.green));
                    selected.setTextColor(ContextCompat.getColor(act, R.color.black));
                }
            }
        };

        View.OnClickListener testGroceryButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTestGroceries();
            }
        };

        home.findViewById(R.id.addTest).setOnClickListener(testGroceryButton);

        Set<String> users = userVM.usernames();

        for (String name : users) {
            Button b = new Button(act);
            b.setTypeface(ResourcesCompat.getFont(act, R.font.helvetica));
            b.setBackgroundColor(ContextCompat.getColor(act, R.color.brown));
            b.setTextColor(ContextCompat.getColor(act, R.color.white));
            b.setText(name);
            b.setOnClickListener(userButton);
            b.setAllCaps(false);
            b.setLayoutParams(new ViewGroup.LayoutParams(260, ViewGroup.LayoutParams.MATCH_PARENT));
            ll.addView(b);
            if (name.equals(userVM.getUsername())) b.callOnClick();
        }
        return home;
    }

    private void addTestGroceries() {
        userVM.addGrocery(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        userVM.addGrocery(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        userVM.addGrocery(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        userVM.addGrocery(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        userVM.addGrocery(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        userVM.addGrocery(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        userVM.addGrocery(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        userVM.addGrocery(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        userVM.addGrocery(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        userVM.addGrocery(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        userVM.addGrocery(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        userVM.addGrocery(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        userVM.addGrocery(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        userVM.addGrocery(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        userVM.addGrocery(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        userVM.addGrocery(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
    }
}