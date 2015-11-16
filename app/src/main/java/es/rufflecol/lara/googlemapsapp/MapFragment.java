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

import java.util.List;

public class MapFragment extends SupportMapFragment implements
        OnMapReadyCallback, // interface
        GoogleMap.OnMyLocationChangeListener /* interface */ {

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this); // method SupportMapFragment
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) /* method of MapFragment */ {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void initialiseMap() /* Method I created, not one called from any of the classes or interfaces added above */ {
        getMap().setMyLocationEnabled(true);
        getMap().getUiSettings().setZoomControlsEnabled(true);
        getMap().setOnMyLocationChangeListener(this);
    }

    @Override
    public void onMapReady(GoogleMap map) /* method of MapFragment */ {
        initialiseMap();

        List<MarkerOptions> markerOptionsListArray = MarkerPointsData.fetchData();
        for (MarkerOptions aMarker : markerOptionsListArray) {
            map.addMarker(aMarker);
        }
    }

    @Override
    public void onMyLocationChange(Location location) /* method of Map Fragment */ {
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












//        map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.483550, 0.005468))
//                .title("First home for two bees"))
//                .setSnippet("June 10th 2010 to July 4th 2014");
//        map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.511028, -0.117194))
//                .title("Somerset House"))
//                .setSnippet("Head here for Film4 Summer Screen");