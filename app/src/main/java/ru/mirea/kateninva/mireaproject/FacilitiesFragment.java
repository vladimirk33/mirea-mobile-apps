package ru.mirea.kateninva.mireaproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FacilitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

class Place {
    String name;
    String description;
    String address;
    GeoPoint location;

    public Place(String name, String description, String address, GeoPoint location) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public GeoPoint getLocation() {
        return location;
    }
}


public class FacilitiesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FacilitiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FacilitiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FacilitiesFragment newInstance(String param1, String param2) {
        FacilitiesFragment fragment = new FacilitiesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private MapView mapView;
    List<Place> places = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().setUserAgentValue("ru.mirea.kateninva.mireaproject");

        places.add(new Place("HOME", "Home sweet home", "ул. Большая Очаковская, 10к1, Москва", new GeoPoint(55.688659, 37.463035)));
        places.add(new Place("UNIVERSITY", "Lovely Stromynka", "ул. Стромынка, 20, Москва", new GeoPoint(55.79425, 37.70154)));
        places.add(new Place("WORK", "Lovely Work", "ул. Преображенская площадь, 8, Москва", new GeoPoint(55.794887, 37.712812)));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facilities, container, false);
        mapView = view.findViewById(R.id.map);
        EditText searchField = view.findViewById(R.id.search_field);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        IMapController mapController = mapView.getController();
        mapController.setZoom(10);
        GeoPoint startPoint = new GeoPoint(55.751244, 37.618423);
        mapController.setCenter(startPoint);

        addMarkersToMap();

        searchField.setOnEditorActionListener((v, actionId, event) -> {
            String searchText = v.getText().toString();
            searchPlaces(searchText);
            return true;
        });

        return view;
    }

    private void addMarkersToMap() {
        for (Place place : places) {
            addMarker(place.getLocation(), place.getName(), place.getDescription(), place.getAddress());
        }
    }


    private void addMarker(GeoPoint point, String title, String description, String address) {
        Marker marker = new Marker(mapView);
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle(title + "\n" + description + "\nАдрес: " + address);
        mapView.getOverlays().add(marker);
    }


    private void searchPlaces(String query) {
        mapView.getOverlays().clear();
        if (query.isEmpty()) {
            addMarkersToMap();
        } else {
            for (Place place : places) {
                if (place.getName().toLowerCase().contains(query.toLowerCase())) {
                    addMarker(place.getLocation(), place.getName(), place.getDescription(), place.getAddress());
                }
            }
        }

        mapView.invalidate();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
}