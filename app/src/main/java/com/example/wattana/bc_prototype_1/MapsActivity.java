package com.example.wattana.bc_prototype_1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Marker mMarker;
    CollectionActivity collect;

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

        mMap.addMarker(new MarkerOptions().position(new LatLng(16.458387, 102.809127))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.birdposition_1))
                .title(getString(R.string.pramong)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(16.444075, 102.813776))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.birdposition_1))
                .title(getString(R.string.buengsrithan))); //บึงสี่ฐาน

        mMap.addMarker(new MarkerOptions().position(new LatLng(16.473204, 102.814097))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.birdposition_1))
                .title(getString(R.string.farm))); //แปลงฝึกงาน คณะเกษตรศาสตร์
        mMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        String provider = locationManager.getBestProvider(criteria, true);
//        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for Activity#requestPermissions for more details.
//            return;
//        }
        Location myLocation = locationManager.getLastKnownLocation(provider);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        LatLng myCoordinates = new LatLng(latitude, longitude);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(myCoordinates, 14);
        mMap.animateCamera(yourLocation);

        // Create a LatLng object for the current location
        /*LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));*/
       /* mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("ตำแหน่งของคุณ"));*/


        /*mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("BuengSethan")){
                    collect.home();
                }
                return true;
            }
        });*/

        //คลิกให้แสดง infowindow แล้วคลิก infowindow เพื่อไปหน้าแสดงนก ในตำแหน่ง marker นั้น
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            public void onInfoWindowClick(Marker marker) {
                if (marker.getTitle().equals(getString(R.string.buengsrithan))){
                    Intent intent = new Intent(MapsActivity.this, Sitanbirds.class);
                    startActivity(intent);
                }

                if (marker.getTitle().equals(getString(R.string.pramong))){
                    Intent intent = new Intent(MapsActivity.this, MhudPramongBirds.class);
                    startActivity(intent);
                }

                if (marker.getTitle().equals(getString(R.string.farm))){
                    Intent intent = new Intent(MapsActivity.this, KasetFarm.class);
                    startActivity(intent);
                }


            }
        });

        //คลิก Marker รูปนก  เพื่อไปหน้าแสดงนก ในตำแหน่ง marker นั้น
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                //นกบริเวณทุ่งหย้าเลี้ยงสัตว์ คณะเกษตรศาสตร์
                if (marker.getTitle().equals(getString(R.string.farm))){
                    Intent intent = new Intent(MapsActivity.this, KasetFarm.class);
                    startActivity(intent);
                }

                //นกบริเวณ หมวดประมง
                if (marker.getTitle().equals(getString(R.string.pramong))){
                    Intent intent = new Intent(MapsActivity.this, MhudPramongBirds.class);
                    startActivity(intent);
                }

                //นกบริเวญบึงสีฐาน
                if (marker.getTitle().equals(getString(R.string.buengsrithan))){
                    Intent intent = new Intent(MapsActivity.this, Sitanbirds.class);
                    startActivity(intent);
                }
                return false;
            }
        });


    }





}
