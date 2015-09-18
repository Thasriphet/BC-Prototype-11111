package com.example.wattana.bc_prototype_1;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(16.473986, 102.823689)).title("นก ก"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(16.444075, 102.813776)).title("นก ข")); //บึงสี่ฐาน
        mMap.addMarker(new MarkerOptions().position(new LatLng(16.444204, 102.814561)).title("นก ค")); //บึงสี่ฐาน 2
        mMap.addMarker(new MarkerOptions().position(new LatLng(16.473204, 102.814097)).title("นก ง")); //แปลงฝึกงาน คณะเกษตรศาสตร์
        mMap.setMyLocationEnabled(true);
    }
}
