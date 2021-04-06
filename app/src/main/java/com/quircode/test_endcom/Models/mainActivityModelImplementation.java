package com.quircode.test_endcom.Models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.quircode.test_endcom.MapsActivity;
import com.quircode.test_endcom.Presenters.mainActivityPresenter;
import com.quircode.test_endcom.Utilities.allBikesInfo;
import com.quircode.test_endcom.Utilities.estacionesVo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mainActivityModelImplementation implements mainActivityPresenter.Model {
    @Override
    public void getEstacionesFromAPI(final Context context) {
        String URL="http://api.citybik.es/v2/networks/ecobici";

        final ArrayList<estacionesVo> estacionesList = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                allBikesInfo.getInstance().setResponse(response);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(context, MapsActivity.class);
                        context.startActivity(intent);
                        ((Activity) context).finish();
                    }
                },1200);
                /*try {
                    JSONObject jsonObject=new JSONObject(response);
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error "+error);

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();

                return map;
            }
        };
        //Toast.makeText(CircularActivity.this, String.valueOf(x), Toast.LENGTH_SHORT).show();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
