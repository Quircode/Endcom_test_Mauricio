package com.quircode.test_endcom.Models;

import android.content.Context;

import com.quircode.test_endcom.Presenters.mainMapsPresenter;
import com.quircode.test_endcom.Utilities.allBikesInfo;
import com.quircode.test_endcom.Utilities.estacionesVo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class mainMapsModelImplementation implements mainMapsPresenter.Model {
    @Override
    public ArrayList<estacionesVo> getEstaciones(Context context) {
        ArrayList<estacionesVo> estacionesList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(allBikesInfo.getInstance().getResponse());
            JSONObject network=jsonObject.getJSONObject("network");
            JSONArray stations=network.getJSONArray("stations");
            for (int i=0;i<stations.length();i++){
                JSONObject jsonObjectStation=new JSONObject(stations.getString(i));
                String name=jsonObjectStation.getString("name");
                String empty_slots=jsonObjectStation.getString("empty_slots");
                String latitude=jsonObjectStation.getString("latitude");
                String longitude=jsonObjectStation.getString("longitude");

                if (empty_slots.equals("0")){

                } else {
                    estacionesList.add(new estacionesVo(name,empty_slots,latitude,longitude));
                }
            }
        }  catch (JSONException e) {
            e.printStackTrace();
        }
        return estacionesList;
    }
}
