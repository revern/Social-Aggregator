package com.example.revern.socialaggregator.di;

import android.app.Activity;

import com.example.revern.socialaggregator.App;
import com.example.revern.socialaggregator.ui.main.MainActivity;

import androidx.annotation.NonNull;

public class Injector {

    private static AppComponent getAppComponent(@NonNull Activity initialScreen) {
        return ((App) initialScreen.getApplicationContext()).getAppComponent();
    }

    public static void inject(MainActivity mainActivity) {
        getAppComponent(mainActivity).inject(mainActivity);
    }
}
