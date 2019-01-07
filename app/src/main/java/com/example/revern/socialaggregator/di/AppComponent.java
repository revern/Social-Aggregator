package com.example.revern.socialaggregator.di;

import com.example.revern.socialaggregator.App;
import com.example.revern.socialaggregator.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(MainActivity mainActivity);
}
