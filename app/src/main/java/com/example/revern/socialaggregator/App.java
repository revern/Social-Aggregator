package com.example.revern.socialaggregator;

import android.app.Application;

import com.example.revern.socialaggregator.di.AppComponent;
import com.example.revern.socialaggregator.di.AppModule;
import com.example.revern.socialaggregator.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDaggerComponents();
    }

    private void initDaggerComponents() {
        appComponent = createAppComponent();
    }

    protected AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
