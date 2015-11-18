package es.rufflecol.lara.googlemapsapp;

import android.content.Intent;
import android.location.Location;
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

        // getActivity should be called whenever you need a context within a fragment

        switch (marker.getTitle()) {
            case "Charlton House":
                Intent intentCharltonHouse = new Intent(getActivity(), DetailActivity.class);
                intentCharltonHouse.putExtra("activityDetailTitle", R.string.charlton_house_detail_title);
                intentCharltonHouse.putExtra("activityDetailImage", R.drawable.bm);
                intentCharltonHouse.putExtra("activityDetailText", R.string.activity_detail_text);
                startActivity(intentCharltonHouse);
                break;
            case "Somerset House":
                Intent intentSomersetHouse = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentSomersetHouse);
                break;
            case "Wild Honey":
                Intent intentWildHoney = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentWildHoney);
                break;
            case "The Founders Arms":
                Intent intentTheFoundersArms = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentTheFoundersArms);
                break;
            case "Nandos":
                Intent intentNandos = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentNandos);
                break;
            case "The Shard":
                Intent intentTheShard = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentTheShard);
                break;
            case "John Lewis":
                Intent intentJohnLewis = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentJohnLewis);
                break;
            case "One New Change":
                Intent intentOneNewChange = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentOneNewChange);
                break;
            case "Saint Dunstan in the East":
                Intent intentSainDunstanInTheEast = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentSainDunstanInTheEast);
                break;
            case "Bodeans":
                Intent intentBodeans = new Intent(getActivity(), DetailActivity.class);
                startActivity(intentBodeans);
                break;
        }
    }
}