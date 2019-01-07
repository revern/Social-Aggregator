package com.example.revern.socialaggregator.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import com.example.revern.socialaggregator.R2;
import com.example.revern.socialaggregator.di.Injector;
import com.example.revern.socialaggregator.ui.base.BaseActivity;
import com.example.revern.socialaggregator.ui.base.UiInfo;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R2.id.hello)
    TextView uiHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected UiInfo createUiInfo() {
        return new UiInfo(R2.layout.activity_main)
                .setTitle("Hello").enableBackButton();
    }

    @Override
    protected void inject() {
        Injector.inject(this);
    }

    @OnClick(R2.id.hello)
    void onHelloClick() {
        presenter.onHelloClick();
    }

    @Override
    public void showHelloMessage(@Nullable String message) {
        uiHello.setText(message);
    }

}
