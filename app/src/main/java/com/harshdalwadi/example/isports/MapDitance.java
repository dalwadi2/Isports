package com.harshdalwadi.example.isports;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapDitance extends AppCompatActivity {
    GoogleMap googleMap;
    SharedPreferences sharedPreferences;
    int locationCount = 0;
    private Toolbar toolbar;
    private NavigationView navigationView;
    TextView mm;
    Geocoder geocoder;
    List<Address> addresses;
    private DrawerLayout drawerLayout;
    private String address = null, city = null, state = null, country = null, postalCode = null, knownName = null;
    private StringBuffer ss = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_ditance);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mm = (TextView) findViewById(R.id.mytext);
        geocoder = new Geocoder(this, Locale.getDefault());
        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(false);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    case R.id.home:
                        Intent iii = new Intent(MapDitance.this, MainActivity.class);
                        startActivity(iii);
                        Toast.makeText(getApplicationContext(), "home Selected", Toast.LENGTH_SHORT).show();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.myaccount:
                        Toast.makeText(getApplicationContext(), "myacc Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.login:
                        Toast.makeText(getApplicationContext(), "login Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.signup:
                        Toast.makeText(getApplicationContext(), "signup Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.filter:
                        Toast.makeText(getApplicationContext(), "filter Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nearme:
                        Intent i = new Intent(MapDitance.this, MapDitance.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(), "nearme Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.favourites:
                        Toast.makeText(getApplicationContext(), "favourites Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.fetures:
                        Intent ii = new Intent(MapDitance.this, second.class);
                        startActivity(ii);
                        Toast.makeText(getApplicationContext(), "features Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "about Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.merchandise:
                        Toast.makeText(getApplicationContext(), "merchndise Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.worldcup:
                        Toast.makeText(getApplicationContext(), "worldcup Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());

        // Showing status
        if (status != ConnectionResult.SUCCESS) { // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        } else { // Google Play Services are available

            // Getting reference to the SupportMapFragment of activity_main.xml
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

            // Getting GoogleMap object from the fragment
            googleMap = fm.getMap();

            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);

            // Opening the sharedPreferences object
            sharedPreferences = getSharedPreferences("location", 0);

            // Getting number of locations already stored
            locationCount = sharedPreferences.getInt("locationCount", 0);

            // Getting stored zoom level if exists else return 0
            String zoom = sharedPreferences.getString("zoom", "0");

            // If locations are already saved
            if (locationCount != 0) {

                String lat = "";
                String lng = "";

                // Iterating through all the locations stored
                for (int i = 0; i < locationCount; i++) {

                    // Getting the latitude of the i-th location
                    lat = sharedPreferences.getString("lat" + i, "0");

                    // Getting the longitude of the i-th location
                    lng = sharedPreferences.getString("lng" + i, "0");

                    // Drawing marker on the map
                    drawMarker(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)));
                }

                // Moving CameraPosition to last clicked position
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng))));

                // Setting the zoom level in the map on last position  is clicked
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(Float.parseFloat(zoom)));
            }
        }

        googleMap.setOnMapClickListener(new OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                locationCount++;

                // Drawing marker on the map
                drawMarker(point);

                /** Opening the editor object to write data to sharedPreferences */
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Storing the latitude for the i-th location
                editor.putString("lat" + Integer.toString((locationCount - 1)), Double.toString(point.latitude));

                // Storing the longitude for the i-th location
                editor.putString("lng" + Integer.toString((locationCount - 1)), Double.toString(point.longitude));

                // Storing the count of locations or marker count
                editor.putInt("locationCount", locationCount);

                /** Storing the zoom level to the shared preferences */
                editor.putString("zoom", Float.toString(googleMap.getCameraPosition().zoom));

                /** Saving the values stored in the shared preferences */
                editor.commit();

                Toast.makeText(getBaseContext(), "Marker is added to the Map", Toast.LENGTH_SHORT).show();
                try {
                    addresses = geocoder.getFromLocation(point.latitude, point.longitude, 1);

                } catch (IOException e) {
                    Toast.makeText(getBaseContext(), "error : " + e, Toast.LENGTH_SHORT).show();
                    //e.printStackTrace();
                }
                /*
                city = addresses.get(0).getLocality();
                state = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                postalCode = addresses.get(0).getPostalCode();
                knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
                address = addresses.get(0).getAddressLine(1); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()


                ss.append(address.trim());
                ss.append(" " + postalCode.toString());
                ss.append(" " + city + " " + state + " " + country + " " + knownName);
                //   Toast.makeText(getBaseContext(), address + " " + Integer.parseInt(postalCode) + " " + city + " " + state, Toast.LENGTH_SHORT).show();
                mm.setText(ss.toString());
                */
            }
        });

        googleMap.setOnMapLongClickListener(new OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng point) {
                // Removing the marker and circle from the Google Map
                googleMap.clear();

                // Opening the editor object to delete data from sharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Clearing the editor
                editor.clear();

                // Committing the changes
                editor.commit();

                // Setting locationCount to zero
                locationCount = 0;

            }
        });
    }

    private void drawMarker(LatLng point) {

        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.custompin));
        // Setting latitude and longitude for the marker
        markerOptions.position(point);

        markerOptions.title(point.latitude + "," + point.longitude);
        // Adding marker on the Google Map
        googleMap.addMarker(markerOptions);
    }
}
