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
    double mlatitude = 0;
    double mlongitude = 0;
    boolean onlocation = true;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Marker mMarker;
    CollectionActivity collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        mMap.setOnMyLocationChangeListener(myLocationChangeListener);
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
    private GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
            mlatitude = location.getLatitude();
            mlongitude = location.getLongitude();
            if (mMap != null) {
                if (mlatitude !=0 && mlongitude!=0 && onlocation){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 12.0f));
                    onlocation = false;
                }

            }
        }
    };

    private void setUpMap() {

        mMap.addMarker(new MarkerOptions().position(new LatLng(16.458387, 102.809127))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.birdposition_1))
                .title(getString(R.string.pramong)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(16.444075, 102.813776))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.birdposition_1))
                .title(getString(R.string.buengsrithan))); //ºÖ§ÊÕè°Ò¹

        mMap.addMarker(new MarkerOptions().position(new LatLng(16.473204, 102.814097))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.birdposition_1))
                .title(getString(R.string.farm))); //á»Å§½Ö¡§Ò¹ ¤³Ðà¡ÉµÃÈÒÊµÃì
        mMap.setMyLocationEnabled(true);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

       /* Criteria criteria = new Criteria();

        String provider = locationManager.getBestProvider(criteria, true);
//
        Location myLocation = locationManager.getLastKnownLocation(provider);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        LatLng myCoordinates = new LatLng(latitude, longitude);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(myCoordinates, 14);
        mMap.animateCamera(yourLocation);*/

        // Create a LatLng object for the current location
        /*LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));*/
       /* mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("µÓáË¹è§¢Í§¤Ø³"));*/


        /*mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("BuengSethan")){
                    collect.home();
                }
                return true;
            }
        });*/

        //¤ÅÔ¡ãËéáÊ´§ infowindow áÅéÇ¤ÅÔ¡ infowindow à¾×èÍä»Ë¹éÒáÊ´§¹¡ ã¹µÓáË¹è§ marker ¹Ñé¹
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

        //¤ÅÔ¡ Marker ÃÙ»¹¡  à¾×èÍä»Ë¹éÒáÊ´§¹¡ ã¹µÓáË¹è§ marker ¹Ñé¹
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                //¹¡ºÃÔàÇ³·Øè§ËÂéÒàÅÕéÂ§ÊÑµÇì ¤³Ðà¡ÉµÃÈÒÊµÃì
                if (marker.getTitle().equals(getString(R.string.farm))){
                    Intent intent = new Intent(MapsActivity.this, KasetFarm.class);
                    startActivity(intent);
                }

                //¹¡ºÃÔàÇ³ ËÁÇ´»ÃÐÁ§
                if (marker.getTitle().equals(getString(R.string.pramong))){
                    Intent intent = new Intent(MapsActivity.this, MhudPramongBirds.class);
                    startActivity(intent);
                }

                //¹¡ºÃÔàÇ­ºÖ§ÊÕ°Ò¹
                if (marker.getTitle().equals(getString(R.string.buengsrithan))){
                    Intent intent = new Intent(MapsActivity.this, Sitanbirds.class);
                    startActivity(intent);
                }
                return false;
            }
        });


    }





}