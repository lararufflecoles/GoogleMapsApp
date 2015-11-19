package es.rufflecol.lara.googlemapsapp;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MarkerPointsData {

    public static List<MarkerOptions> fetchData() {

        ArrayList<MarkerOptions> markers = new ArrayList<>();

        markers.add(new MarkerOptions().position(new LatLng(51.480752, 0.037084))
                .title("Charlton House").snippet("Jacobean building built in 1612"));

        markers.add(new MarkerOptions().position(new LatLng(51.511028, -0.117194))
                .title("Somerset House").snippet("See films under the stars with Film4 Summer Screen"));

        markers.add(new MarkerOptions().position(new LatLng(51.512423, -0.143359))
                .title("Wild Honey").snippet("Michelin starred restaurant"));

        markers.add(new MarkerOptions().position(new LatLng(51.508129, -0.095187))
                .title("The Founders Arms").snippet("Riverside pub with superb views"));

        markers.add(new MarkerOptions().position(new LatLng(51.507102, -0.092107))
                .title("Nandos London Bridge").snippet("Chicken heaven"));

        markers.add(new MarkerOptions().position(new LatLng(51.504674, -0.086300))
                .title("The Shard").snippet("The Eye of Mordor"));

        markers.add(new MarkerOptions().position(new LatLng(51.515424, -0.145269))
                .title("John Lewis").snippet("Best shop in the world"));

        markers.add(new MarkerOptions().position(new LatLng(51.514046, -0.096523))
                .title("One New Change").snippet("Amazing roof terrace"));

        markers.add(new MarkerOptions().position(new LatLng(51.509635, -0.082203))
                .title("Saint Dunstan in the East").snippet("Peaceful garden in a ruined church"));

        markers.add(new MarkerOptions().position(new LatLng(51.509757, -0.079081))
                .title("Bodeans Tower Hill").snippet("All the meat")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                // The red marker is default - you don't need to specify an icon unless you want something different from the default

        return markers;
    }
}

