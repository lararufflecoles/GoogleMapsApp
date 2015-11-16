package es.rufflecol.lara.googlemapsapp;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MarkerPointsData {

    public static List<MarkerOptions> fetchData() {

        ArrayList<MarkerOptions> markers = new ArrayList<>();

        markers.add(new MarkerOptions().position(new LatLng(51.483550, 0.005468))
                .title("Tuskar Street").snippet("First home for two bees"));

        markers.add(new MarkerOptions().position(new LatLng(51.511028, -0.117194))
                .title("Somerset House").snippet("See films under the stars with Film4 Summer Screen"));

        markers.add(new MarkerOptions().position(new LatLng(51.512423, -0.143359))
                .title("Wild Honey").snippet("Michelin starred restaurant"));

        markers.add(new MarkerOptions().position(new LatLng(51.508129, -0.095187))
                .title("The Founders Arms").snippet("First date pub"));

        markers.add(new MarkerOptions().position(new LatLng(51.507102, -0.092107))
                .title("Nandos").snippet("First date restaurant"));

        markers.add(new MarkerOptions().position(new LatLng(51.504674, -0.086006))
                .title("London Bridge Underground Station").snippet("First date kiss"));

        markers.add(new MarkerOptions().position(new LatLng(51.482177, 0.030936))
                .title("Victoria Way").snippet("Second home for two bees"));

        markers.add(new MarkerOptions().position(new LatLng(51.514046, -0.096523))
                .title("One New Change").snippet("Amazing roof terrace"));

        markers.add(new MarkerOptions().position(new LatLng(51.509635, -0.082203))
                .title("Saint Dunstan in the East Church Garden").snippet("Peaceful garden in a ruined church"));

        markers.add(new MarkerOptions().position(new LatLng(51.509757, -0.079081))
                .title("Bodeans").snippet("All the meat")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                // The red marker is default - you don't need to specify an icon unless you want something different from the default

        return markers;
    }
}

