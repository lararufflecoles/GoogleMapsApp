package es.rufflecol.lara.googlemapsapp;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapFragment extends SupportMapFragment implements
        OnMapReadyCallback, // interface
        GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener /* interface */ {

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this); // method SupportMapFragment
    }

    private void initialiseMap() /** Method I created, not one called from any of the classes or interfaces added above **/ {
        getMap().setMyLocationEnabled(true);
        getMap().getUiSettings().setZoomControlsEnabled(true);
        getMap().setOnMyLocationChangeListener(this);
        getMap().setOnInfoWindowClickListener(this);
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

    @Override
    public void onInfoWindowClick(Marker marker) {

        switch (marker.getTitle()) {
            case "Tuskar Street":
                Intent intentTuskarStreet = new Intent(getActivity(), MarkerDetailActivity.class); // getActivity should be called whenever you need a context within a fragment
                startActivity(intentTuskarStreet);
                break;
            case "Somerset House":
                Intent intentSomersetHouse = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.somersethouse.org.uk"));
                startActivity(intentSomersetHouse);
                break;
        }
    }
}