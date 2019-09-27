package com.generally2.practice1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class FindDubActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private Marker currentUserLocationMarker;
    private static final int REQUEST_USER_LOCATION_CODE = 99;
    private double latitude, longitude;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_dub);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkUserLocationPermissions();

        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.dispensary_map);
        mapFragment.getMapAsync(this);
    }




    public void onClick(View view) {


        Object transferData[] = new Object[2];
        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();



        switch (view.getId()){
            case R.id.search_button:
                EditText addressField = findViewById(R.id.location_search);
                String address = addressField.getText().toString();

                List<Address> addressList;
                MarkerOptions userMarkerOptions = new MarkerOptions();

                if (!TextUtils.isEmpty(address)){
                    Geocoder geocoder = new Geocoder(FindDubActivity.this);



                    try {
                        addressList = geocoder.getFromLocationName(address, 6);
                        if (addressList != null){
                            for (int i = 0; i < addressList.size(); i++){
                                Address userAddress = addressList.get(i);
                                LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());

                                userMarkerOptions.position(latLng);
                                userMarkerOptions.title(address);
                                userMarkerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.map_marker));

                                mMap.addMarker(userMarkerOptions);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(14));

                            }

                        }
                        else {
                            Toast.makeText(this, "Location Not Found", Toast.LENGTH_SHORT).show();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                else {
                    Toast.makeText(this, "Please Enter A location", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.dispensaries:
                String dispensary = getString(R.string.dispensaries);
                mMap.clear();
                String url = getUrl(latitude, longitude, dispensary);
                transferData[0] = mMap;
                transferData[1] = url;

                getNearbyPlaces.execute(transferData);
                Toast.makeText(this, "Search Nearby Dispensaries", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Showing Nearby Dispensaries", Toast.LENGTH_SHORT).show();

                break;

            case R.id.grow_store:
                String growStore = getString(R.string.grow_store);
                mMap.clear();
                url = getUrl(latitude, longitude, growStore);
                transferData[0] = mMap;
                transferData[1] = url;

                getNearbyPlaces.execute(transferData);
                Toast.makeText(this, "Search Nearby Grow Stores", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Showing Nearby Grow Stores", Toast.LENGTH_SHORT).show();

                break;

            case R.id.head_shop:
                String headShop = getString(R.string.head_shop);
                mMap.clear();
                url = getUrl(latitude, longitude, headShop);
                transferData[0] = mMap;
                transferData[1] = url;

                getNearbyPlaces.execute(transferData);
                Toast.makeText(this, "Search Nearby Head Shops", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Showing Nearby Head Shops", Toast.LENGTH_SHORT).show();

                break;

        }

    }

    // nearby places
    private String getUrl(double latitude, double longitude, String nearbyPlace){
        int proximityRadius = 12500;
        String myKey2 = getString(R.string.My_Key2);

        StringBuilder googleURL;
        googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location=").append(latitude).append(",").append(longitude);
        googleURL.append("&radius=").append(proximityRadius);
        googleURL.append("&type=establishment");
        googleURL.append("&keyword=").append(nearbyPlace);
        googleURL.append("&sensor=true");
        googleURL.append("&key=").append(myKey2);

        Log.d("getURL", googleURL.toString());

        return googleURL.toString();
    }




    //enables map
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {


            buildGoogleApiClient();

            mMap.setMyLocationEnabled(true);
        }


        /* Default marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }


    public boolean checkUserLocationPermissions(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_USER_LOCATION_CODE);

            }


            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_USER_LOCATION_CODE);
            }
            return false;
        }
        else
            return true;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_USER_LOCATION_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        if (googleApiClient == null){
                            buildGoogleApiClient();

                        }
                        mMap.setMyLocationEnabled(true);

                    }

                }
                else {
                    Toast.makeText(this,"Permission Denied..." ,Toast.LENGTH_SHORT).show();
                }

        }

    }

    protected synchronized void buildGoogleApiClient(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();


    }
    //finds current user location and changes user location when moving
    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        if (currentUserLocationMarker != null){
            currentUserLocationMarker.remove();


        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("You Are Here!");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.map_marker));
        currentUserLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(14));

        if (googleApiClient != null){
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);

        }


    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);

        }




    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }



}
