package com.example.kitchenkompanion;

import androidx.lifecycle.ViewModel;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UserViewModel extends ViewModel {
    private User currentUser;
    private final HashMap<String, User> users = new HashMap<>();

    public void setCurrent(String name) throws InvalidUserException {
        if (!users.containsKey(name)) throw new InvalidUserException(name);
        else {
            currentUser = users.get(name);
        }
    }

    public Set<String> usernames() { return users.keySet(); }

    public boolean addUser(String name) {
        if (users.containsKey(name)) return false;
        users.put(name, new User(name));
        return true;
    }

    public void addGrocery(GroceryItem item) {
        currentUser.inv.add(item);
    }

    public User getUser() {
        return currentUser;
    }

    public String getUsername() { return currentUser.name; }

    public HashSet<GroceryItem> pantry() {
        return currentUser.inv;
    }

    public User getUser(String name) { return users.get(name); }

    public class User {
        private String name;
        private HashSet<GroceryItem> inv;

        private User(String name) {
            this.name = name;
            inv = new HashSet<>();
        }
    }
}
