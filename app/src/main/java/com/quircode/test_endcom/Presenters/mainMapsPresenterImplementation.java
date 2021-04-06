package com.quircode.test_endcom.Presenters;

import android.content.Context;

import com.quircode.test_endcom.Utilities.allBikesInfo;
import com.quircode.test_endcom.Utilities.estacionesVo;

import java.util.ArrayList;
import java.util.List;

public class mainMapsPresenterImplementation implements mainMapsPresenter.Presenter {
    mainMapsPresenter.View view;
    mainMapsPresenter.Model model;
    Context context;

    public mainMapsPresenterImplementation(mainMapsPresenter.View view, mainMapsPresenter.Model model, Context context) {
        this.view = view;
        this.model = model;
        this.context = context;
    }


    @Override
    public void forShowEstaciones() {
        System.out.println("here");
        ArrayList<estacionesVo> bikesList=new ArrayList<>();
        bikesList=model.getEstaciones(context);
        view.showEstaciones(bikesList);
    }

    @Override
    public void onViewDestroy() {
        view=null;
    }
}
