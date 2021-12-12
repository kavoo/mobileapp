/**
 * Kavita Shokeen
 * This class is for showing notifcations
 */
package com.csd230.assignment.week10.skysalon.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("There are no new notifications!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}