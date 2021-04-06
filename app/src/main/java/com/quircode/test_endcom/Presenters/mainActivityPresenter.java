package com.quircode.test_endcom.Presenters;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public interface mainActivityPresenter {
    interface View{

    }
    interface Model{
        void getEstacionesFromAPI(Context context);
    }
    interface Presenter{
        void requestEstacionesFromView();
        void onViewDestroy();
        void onViewCreate();
    }
}
