package com.example.kitchenkompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class NavigationFrame extends AppCompatActivity {
    private UserViewModel userVM;

    private FragmentManager fm = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userVM = new ViewModelProvider(this).get(UserViewModel.class);
        setContentView(R.layout.activity_navigation_frame);
        addTestUsers();
        setFragments();
        try { userVM.setCurrent("Chris"); }
        catch (Exception e) { e.printStackTrace(); }
    }

    private void setFragments() {
        fm.beginTransaction().add(R.id.contentContainer, new HomePage()).commit();

        View.OnClickListener nav = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment currentPage = fm.findFragmentById(R.id.contentContainer);
                switch (view.getId()) {
                    case R.id.homeButton:
                        if (!(currentPage instanceof HomePage))
                            fm.beginTransaction().replace(R.id.contentContainer, new HomePage()).commit();
                        break;
                    case R.id.pantryButton:
                        if (!(currentPage instanceof Pantry))
                            fm.beginTransaction().replace(R.id.contentContainer, new Pantry()).commit();
                }

            }
        };

        findViewById(R.id.homeButton).setOnClickListener(nav);
        findViewById(R.id.pantryButton).setOnClickListener(nav);
    }

    private void addTestUsers() {
        String[] users = new String[]{"Chris", "Thomas", "Luke", "Nate", "Katy", "Kennan", "Bryan", "Alex"};

        for (String user : users) {
            userVM.addUser(user);
        }

        try {
            userVM.setCurrent(users[0]);
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }
}