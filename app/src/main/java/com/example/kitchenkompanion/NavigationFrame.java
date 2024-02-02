package com.example.kitchenkompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class NavigationFrame extends AppCompatActivity {
    private UserViewModel userVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_frame);
        userVM = new ViewModelProvider(this).get(UserViewModel.class);
    }
}