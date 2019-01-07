package com.example.revern.socialaggregator.ui.base;

import androidx.annotation.LayoutRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public class UiInfo {

    @LayoutRes
    private final int layoutRes;
    @StringRes
    private int titleRes;
    @MenuRes
    private int menuRes;
    private String titleStr;
    private boolean hasBackButton;

    public UiInfo(@LayoutRes int layoutRes) {
        this.layoutRes = layoutRes;
    }

    @NonNull
    public UiInfo setMenuRes(@MenuRes int menuRes) {
        this.menuRes = menuRes;
        return this;
    }

    @NonNull
    public UiInfo setTitleRes(@StringRes int titleRes) {
        this.titleRes = titleRes;
        return this;
    }

    @NonNull
    public UiInfo setTitle(@NonNull String titleString) {
        this.titleStr = titleString;
        return this;
    }

    @NonNull
    public UiInfo enableBackButton() {
        this.hasBackButton = true;
        return this;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public int getMenuRes() {
        return menuRes;
    }

    @Nullable
    public String getTitle() {
        return titleStr;
    }

    public boolean hasBackButton() {
        return hasBackButton;
    }

}
