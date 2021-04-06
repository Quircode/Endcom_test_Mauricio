package com.quircode.test_endcom.Presenters;

import java.util.List;

public class mainMapsPresenterImplementation implements mainMapsPresenter.Presenter {
    mainMapsPresenter.View view;
    mainMapsPresenter.Model model;

    public mainMapsPresenterImplementation(mainMapsPresenter.View view, mainMapsPresenter.Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void forShowEstaciones() {

    }

    @Override
    public void onViewDestroy() {
        view=null;
    }
}
