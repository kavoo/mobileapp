// Kavita Shokeen
package com.csd230.assignment.week10.skysalon.ui.dashboard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.csd230.assignment.week10.skysalon.R;
import com.csd230.assignment.week10.skysalon.databinding.FragmentDashboardBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DashboardFragment extends Fragment  implements OnMapReadyCallback {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    // Control holding the google map
    private MapView mapView;
    // Using this to show a toast message
    private View fragmentView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Accessing the Mapping Control
        mapView = (MapView) rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        // Set the map ready callback to receive the GoogleMap object
        mapView.getMapAsync(this);

        // Storing view for displaying toast
        fragmentView = rootView;
        // Get a handle to the fragment and register the callback.
        return rootView;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * Adding Marker for Salon Locations
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * Developer should ensure the image used to test the app has google services in emulator, for
     * map functionality to work.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        GoogleMap mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Adding Marker
        LatLng salon_loc = new LatLng(28.5985029, 76.9895227);
        MarkerOptions markerOptions = new MarkerOptions().position(salon_loc);
        markerOptions.title("Sky Salon");
        //markerOptions.snippet("At your service!");
        Marker marker = mMap.addMarker(markerOptions);
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(salon_loc, 10));

        // adding on click listener to marker of google maps.
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // on marker click we are getting the title of our marker
                // which is clicked and displaying it in a toast message.
                String markerName = marker.getTitle();
                //Toast.makeText( fragmentView, "Clicked location is " + markerName, Toast.LENGTH_SHORT).show();
                displayToast(fragmentView, "Take user to setup an appointment.");
                return false;
            }
        });
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    // helper function to debug
    public void displayToast(View view, String message) {
        Toast.makeText(view.getContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}