package es.rufflecol.lara.googlemapsapp;

import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends SupportMapFragment implements
        OnMapReadyCallback, // interface
        GoogleMap.OnMyLocationChangeListener /* interface */ {

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this); // method of SupportMapFragment
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void initialiseMap() {
        getMap().setMyLocationEnabled(true);
        getMap().getUiSettings().setZoomControlsEnabled(true);
        getMap().setOnMyLocationChangeListener(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        initialiseMap();

        map.addMarker(new MarkerOptions()
                .position(new LatLng(51.483550, 0.005468))
                .title("First home for two bees"))
                .setSnippet("June 10th 2010 to July 4th 2014");
        map.addMarker(new MarkerOptions()
                .position(new LatLng(51.511028, -0.117194))
                .title("Somerset House"))
                .setSnippet("Head here for Film4 Summer Screen");
    }

    @Override
    public void onMyLocationChange(Location location) {
        if (flag) {
            CameraPosition position = CameraPosition.builder()
                    .target(new LatLng(location.getLatitude(), location.getLongitude()))
                    .zoom(16f)
                    .build();
            getMap().animateCamera(CameraUpdateFactory.newCameraPosition(position), null);
            flag = false;
        }
    }
}