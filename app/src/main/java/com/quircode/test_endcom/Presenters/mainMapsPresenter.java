package com.quircode.test_endcom.Presenters;

import android.content.Context;

import com.quircode.test_endcom.Utilities.allBikesInfo;
import com.quircode.test_endcom.Utilities.estacionesVo;

import java.util.ArrayList;

public interface mainMapsPresenter {
    interface View{
        void showEstaciones(ArrayList<estacionesVo> Estaciones);
    }
    interface Model{
        ArrayList<estacionesVo> getEstaciones(Context context);
    }
    interface Presenter{
        void forShowEstaciones();
        void onViewDestroy();
    }
}
