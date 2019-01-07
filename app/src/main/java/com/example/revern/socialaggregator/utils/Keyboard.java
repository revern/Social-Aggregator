package com.example.revern.socialaggregator.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

public class Keyboard {

    public static void hide(@NonNull Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = activity.getCurrentFocus();
        if (v != null && inputManager != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static void hide(@NonNull View view) {
        InputMethodManager inputManager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null && inputManager.isActive()) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void show(@NonNull Context context) {
        InputMethodManager inputManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }

    public static void show(@NonNull View view) {
        InputMethodManager inputManager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

}
