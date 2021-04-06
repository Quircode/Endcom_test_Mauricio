package com.quircode.test_endcom.Presenters;

import android.content.Context;

public class mainActivityPresenterImplementation implements mainActivityPresenter.Presenter {

    mainActivityPresenter.View view;
    mainActivityPresenter.Model model;
    Context context;

    public mainActivityPresenterImplementation(mainActivityPresenter.View view, mainActivityPresenter.Model model, Context context) {
        this.view = view;
        this.model = model;
        this.context = context;
    }

    @Override
    public void requestEstacionesFromView() {
        model.getEstacionesFromAPI(context);
    }

    @Override
    public void onViewDestroy() {
        view=null;
    }

    @Override
    public void onViewCreate() {

    }
}
