package com.quircode.test_endcom.Presenters;

import java.util.ArrayList;
import java.util.List;

public interface mainMapsPresenter {
    interface View{
        void showEstaciones(List<String> Estaciones);
    }
    interface Model{
        ArrayList<String> getEstaciones();
    }
    interface Presenter{
        void forShowEstaciones();
        void onViewDestroy();
    }
}
