package com.quircode.test_endcom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.quircode.test_endcom.Models.mainActivityModelImplementation;
import com.quircode.test_endcom.Models.mainMapsModelImplementation;
import com.quircode.test_endcom.Presenters.mainActivityPresenter;
import com.quircode.test_endcom.Presenters.mainActivityPresenterImplementation;
import com.quircode.test_endcom.Presenters.mainMapsPresenter;
import com.quircode.test_endcom.Presenters.mainMapsPresenterImplementation;
import com.quircode.test_endcom.Utilities.estacionesVo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements mainActivityPresenter.View {
    mainActivityPresenter.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new mainActivityPresenterImplementation(this,new mainActivityModelImplementation(),this);
        presenter.requestEstacionesFromView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroy();
    }


}
