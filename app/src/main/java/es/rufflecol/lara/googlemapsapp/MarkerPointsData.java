package es.rufflecol.lara.googlemapsapp;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MarkerPointsData {

    public static List<MarkerOptions> fetchData() {

        ArrayList<MarkerOptions> markers = new ArrayList<>();

        markers.add(new MarkerOptions().position(new LatLng(51.483550, 0.005468)).title("Tuskar Street").snippet("First home for two bees"));
        markers.add(new MarkerOptions().position(new LatLng(51.511028, -0.117194)).title("Somerset House").snippet("See films under the stars with Film4 Summer Screen"));

        return markers;
    }
}