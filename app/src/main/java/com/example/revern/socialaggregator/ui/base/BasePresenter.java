package com.example.revern.socialaggregator.ui.base;

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

}
