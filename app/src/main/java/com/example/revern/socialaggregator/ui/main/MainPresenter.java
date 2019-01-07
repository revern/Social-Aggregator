package com.example.revern.socialaggregator.ui.main;

import com.example.revern.socialaggregator.ui.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainView> {

    public void onHelloClick() {
        view.showHelloMessage("HELLO MZFCKU!");
    }
}
