package com.example.kitchenkompanion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel  extends ViewModel {
    private final MutableLiveData<User> currentUser = new MutableLiveData<>();

    public void setUser(User you) {
        currentUser.setValue(you);
    }

    public LiveData<User> getUser() {
        return currentUser;
    }
}
