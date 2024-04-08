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

    public boolean addTestUser(String name) {
        if (users.containsKey(name)) return false;
        User temp = new User(name);
        temp.inv.add(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        temp.inv.add(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        temp.inv.add(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        temp.inv.add(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        temp.inv.add(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        temp.inv.add(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        temp.inv.add(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        temp.inv.add(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        temp.inv.add(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        temp.inv.add(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        temp.inv.add(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        temp.inv.add(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        temp.inv.add(new GroceryItem("Milk", "Cartons", 0.5f, new int[]{2024, 4, 1}));
        temp.inv.add(new GroceryItem("Apples", "Apples", 4, new int[]{2024, 4, 12}));
        temp.inv.add(new GroceryItem("Flour", "lbs", 3.5f, new int[]{2024, 5, 1}));
        temp.inv.add(new GroceryItem("Ramen", "Cups", 16, new int[]{2024, 5, 2}));
        users.put(name, temp);
        return true;
    }

    public User getUser() {
        return currentUser;
    }

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
