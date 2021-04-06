package com.quircode.test_endcom;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.quircode.test_endcom.Models.mainMapsModelImplementation;
import com.quircode.test_endcom.Presenters.mainMapsPresenter;
import com.quircode.test_endcom.Presenters.mainMapsPresenterImplementation;
import com.quircode.test_endcom.Utilities.estacionesVo;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, mainMapsPresenter.View {

    private GoogleMap mMap;
    mainMapsPresenter.Presenter presenter;
    ArrayList<estacionesVo> myNewList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        presenter = new mainMapsPresenterImplementation(this,new mainMapsModelImplementation(),this);
        presenter.forShowEstaciones();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        for (int i=0;i<myNewList.size();i++){
            Double lat=Double.valueOf(myNewList.get(i).getLatitude());
            Double lon=Double.valueOf(myNewList.get(i).getLongitude());
            LatLng aNewmarkerToPlace = new LatLng(lat,lon);
            mMap.addMarker(new MarkerOptions().position(aNewmarkerToPlace).title(myNewList.get(i).getName()));
            if (i == 10)
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aNewmarkerToPlace));
            mMap.setMinZoomPreference(14.0f);
        }

    }

    @Override
    public void showEstaciones(ArrayList<estacionesVo> Estaciones) {
        myNewList=Estaciones;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroy();
    }
}
