package es.rufflecol.lara.googlemapsapp;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

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
        OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.InfoWindowAdapter /* interfaces */ {

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
        getMap().setInfoWindowAdapter(this);
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
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater.inflate(R.layout.marker, null);

        TextView titleTextView = (TextView) view.findViewById(R.id.title_text);
        titleTextView.setText(marker.getTitle());

        TextView snippetTextView = (TextView) view.findViewById(R.id.snippet_text);
        snippetTextView.setText(marker.getSnippet());

        return view;
  }

    @Override
    public void onInfoWindowClick(Marker marker) {

        // getActivity should be called whenever you need a context within a fragment

        switch (marker.getTitle()) {
            case "Charlton House":
                Intent intentCharltonHouse = new Intent(getActivity(), DetailActivity.class);
                intentCharltonHouse.putExtra("activityDetailTitle", R.string.charlton_house_detail_title);
                intentCharltonHouse.putExtra("activityDetailImage", R.drawable.charlton_house);
                intentCharltonHouse.putExtra("activityDetailUrl", R.string.charlton_house_url_link);
                intentCharltonHouse.putExtra("activityDetailText", R.string.charlton_house_detail_text);
                startActivity(intentCharltonHouse);
                break;
            case "Somerset House":
                Intent intentSomersetHouse = new Intent(getActivity(), DetailActivity.class);
                intentSomersetHouse.putExtra("activityDetailTitle", R.string.somerset_house_detail_title);
                intentSomersetHouse.putExtra("activityDetailImage", R.drawable.somerset_house);
                intentSomersetHouse.putExtra("activityDetailUrl", R.string.somerset_house_url_link);
                intentSomersetHouse.putExtra("activityDetailText", R.string.somerset_house_detail_text);
                startActivity(intentSomersetHouse);
                break;
            case "Wild Honey":
                Intent intentWildHoney = new Intent(getActivity(), DetailActivity.class);
                intentWildHoney.putExtra("activityDetailTitle", R.string.wild_honey_detail_title);
                intentWildHoney.putExtra("activityDetailImage", R.drawable.wild_honey);
                intentWildHoney.putExtra("activityDetailUrl", R.string.wild_honey_url_link);
                intentWildHoney.putExtra("activityDetailText", R.string.wild_honey_detail_text);
                startActivity(intentWildHoney);
                break;
            case "The Founders Arms":
                Intent intentTheFoundersArms = new Intent(getActivity(), DetailActivity.class);
                intentTheFoundersArms.putExtra("activityDetailTitle", R.string.the_founders_arms_detail_title);
                intentTheFoundersArms.putExtra("activityDetailImage", R.drawable.the_founders_arms);
                intentTheFoundersArms.putExtra("activityDetailUrl", R.string.the_founders_arms_url_link);
                intentTheFoundersArms.putExtra("activityDetailText", R.string.the_founders_arms_detail_text);
                startActivity(intentTheFoundersArms);
                break;
            case "Nandos London Bridge":
                Intent intentNandosLondonBridge = new Intent(getActivity(), DetailActivity.class);
                intentNandosLondonBridge.putExtra("activityDetailTitle", R.string.nandos_london_bridge_detail_title);
                intentNandosLondonBridge.putExtra("activityDetailImage", R.drawable.nandos_london_bridge);
                intentNandosLondonBridge.putExtra("activityDetailUrl", R.string.nandos_london_bridge_url_link);
                intentNandosLondonBridge.putExtra("activityDetailText", R.string.nandos_london_bridge_detail_text);
                startActivity(intentNandosLondonBridge);
                break;
            case "The Shard":
                Intent intentTheShard = new Intent(getActivity(), DetailActivity.class);
                intentTheShard.putExtra("activityDetailTitle", R.string.the_shard_detail_title);
                intentTheShard.putExtra("activityDetailImage", R.drawable.the_shard);
                intentTheShard.putExtra("activityDetailUrl", R.string.the_shard_url_link);
                intentTheShard.putExtra("activityDetailText", R.string.the_shard_detail_text);
                startActivity(intentTheShard);
                break;
            case "John Lewis":
                Intent intentJohnLewis = new Intent(getActivity(), DetailActivity.class);
                intentJohnLewis.putExtra("activityDetailTitle", R.string.john_lewis_detail_title);
                intentJohnLewis.putExtra("activityDetailImage", R.drawable.john_lewis);
                intentJohnLewis.putExtra("activityDetailUrl", R.string.john_lewis_url_link);
                intentJohnLewis.putExtra("activityDetailText", R.string.john_lewis_detail_text);
                startActivity(intentJohnLewis);
                break;
            case "One New Change":
                Intent intentOneNewChange = new Intent(getActivity(), DetailActivity.class);
                intentOneNewChange.putExtra("activityDetailTitle", R.string.one_new_change_detail_title);
                intentOneNewChange.putExtra("activityDetailImage", R.drawable.one_new_change);
                intentOneNewChange.putExtra("activityDetailUrl", R.string.one_new_change_url_link);
                intentOneNewChange.putExtra("activityDetailText", R.string.one_new_change_detail_text);
                startActivity(intentOneNewChange);
                break;
            case "Saint Dunstan in the East":
                Intent intentSaintDunstanInTheEast = new Intent(getActivity(), DetailActivity.class);
                intentSaintDunstanInTheEast.putExtra("activityDetailTitle", R.string.saint_dunstan_in_the_east_detail_title);
                intentSaintDunstanInTheEast.putExtra("activityDetailImage", R.drawable.saint_dunstan_in_the_east);
                intentSaintDunstanInTheEast.putExtra("activityDetailUrl", R.string.saint_dunstan_in_the_east_url_link);
                intentSaintDunstanInTheEast.putExtra("activityDetailText", R.string.saint_dunstan_in_the_east_detail_text);
                startActivity(intentSaintDunstanInTheEast);
                break;
            case "Bodeans Tower Hill":
                Intent intentBodeansTowerHill = new Intent(getActivity(), DetailActivity.class);
                intentBodeansTowerHill.putExtra("activityDetailTitle", R.string.bodeans_tower_hill_detail_title);
                intentBodeansTowerHill.putExtra("activityDetailImage", R.drawable.bodeans_tower_hill);
                intentBodeansTowerHill.putExtra("activityDetailUrl", R.string.bodeans_tower_hill_url_link);
                intentBodeansTowerHill.putExtra("activityDetailText", R.string.bodeans_tower_hill_detail_text);
                startActivity(intentBodeansTowerHill);
                break;
        }
    }
}