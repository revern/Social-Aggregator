package com.example.revern.socialaggregator.di;

import android.app.Application;

import com.example.revern.socialaggregator.ui.main.MainPresenter;

import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
