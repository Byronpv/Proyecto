package com.example.byron.proyecto;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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





public class MapsActivityRoute extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMarkerDragListener {


    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location mLocation;
    private Marker currentLocationMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    double end_Latitude, end_Longitude;
    double latitude, longitude;
    private Button button;
    private int  MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    LocationManager locationManager;
    android.location.LocationListener locationListener;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_route);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            CheckLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();
        String stringRecibido = bundle.getString("KeyString");
        int imagen = bundle.getInt("hola");
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.imagnormal);
        button =(Button)findViewById(R.id.distanceTo);
        Object dataTransfer[] = new Object[2];

        if (stringRecibido.equals("Calle 72")) {

             button.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Object dataTransfer[] = new Object[2];

                     switch (v.getId()) {

                         case R.id.distanceTo:
                             dataTransfer = new Object[3];
                             String url = getDirectionsUrlCalle72();
                             GetDirectionsData getDirectionsData = new GetDirectionsData();
                             dataTransfer[0] = mMap;
                             dataTransfer[1] = url;
                             dataTransfer[2] = new LatLng(end_Latitude, end_Longitude);
                             getDirectionsData.execute(dataTransfer);
                             break;


                     }

                 }

             });
            imageView.setImageResource(imagen);
        }
        else if(stringRecibido.equals("Dar")){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object dataTransfer[] = new Object[2];

                    switch (v.getId()) {

                        case R.id.distanceTo:
                            dataTransfer = new Object[3];
                            String url = getDirectionsUrlDar();
                            GetDirectionsData getDirectionsData = new GetDirectionsData();
                            dataTransfer[0] = mMap;
                            dataTransfer[1] = url;
                            dataTransfer[2] = new LatLng(end_Latitude, end_Longitude);
                            getDirectionsData.execute(dataTransfer);
                            break;

                    }
                }
            });
            imageView.setImageResource(imagen);
       }
        else if(stringRecibido.equals("Nogal")){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object dataTransfer[] = new Object[2];

                    switch (v.getId()) {

                        case R.id.distanceTo:
                            dataTransfer = new Object[3];
                            String url = getDirectionsUrlNogal();
                            GetDirectionsData getDirectionsData = new GetDirectionsData();
                            dataTransfer[0] = mMap;
                            dataTransfer[1] = url;
                            dataTransfer[2] = new LatLng(end_Latitude, end_Longitude);
                            getDirectionsData.execute(dataTransfer);
                            break;

                    }
                }
            });
            imageView.setImageResource(imagen);
        }   else if(stringRecibido.equals("Ideas")){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object dataTransfer[] = new Object[2];

                    switch (v.getId()) {

                        case R.id.distanceTo:
                            dataTransfer = new Object[3];
                            String url = getDirectionsUrlIdeas();
                            GetDirectionsData getDirectionsData = new GetDirectionsData();
                            dataTransfer[0] = mMap;
                            dataTransfer[1] = url;
                            dataTransfer[2] = new LatLng(end_Latitude, end_Longitude);
                            getDirectionsData.execute(dataTransfer);
                            break;

                    }
                }
            });
            imageView.setImageResource(imagen);
        }

        else if(stringRecibido.equals("SanMartin")){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Object dataTransfer[] = new Object[2];

                    switch (v.getId()) {

                        case R.id.distanceTo:
                            dataTransfer = new Object[3];
                            String url = getDirectionsUrlSanMartin();
                            GetDirectionsData getDirectionsData = new GetDirectionsData();
                            dataTransfer[0] = mMap;
                            dataTransfer[1] = url;
                            dataTransfer[2] = new LatLng(end_Latitude, end_Longitude);
                            getDirectionsData.execute(dataTransfer);
                            break;

                    }
                }
            });
            imageView.setImageResource(imagen);
        }


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            AlertNoGps();
        }

    }


    private void AlertNoGps() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MapsActivityRoute.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);


        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Dialog);
        builder.setMessage("El sistema GPS esta desactivado, ¿Desea activarlo?")
                .setCancelable(false)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        // AlertNoGps();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(  DialogInterface dialog, int id) {
                        dialog.cancel();
                        //  AlertNoGps();

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        if ( client == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

        // Add a marker in Sydney and move the camera
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);


    }

    protected synchronized void buildGoogleApiClient(){
        client= new GoogleApiClient.Builder(this).
                addConnectionCallbacks(this).
                addOnConnectionFailedListener(this).
                addApi(LocationServices.API).
                build();

        client.connect();
    }


    @Override
    public void onLocationChanged(Location location) {


        mLocation = location;
        latitude= location.getLatitude();
        longitude= location.getLongitude();

        if(currentLocationMarker != null){
            currentLocationMarker.remove();
        }

        LatLng latLng = new LatLng(latitude, longitude);
        MarkerOptions markerOptions= new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Estoy Aquí");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        currentLocationMarker =mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,18));


        if(client != null){
            LocationServices.FusedLocationApi.removeLocationUpdates(client,  this);

        }


    }
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest= new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                ==PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }
    }

    public boolean CheckLocationPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION_CODE);

            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION_CODE);
            }
            return false;
        }
        else{
            return  true;
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.setDraggable(true);
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        end_Latitude = marker.getPosition().latitude;
        end_Longitude = marker.getPosition().longitude;
    }
  /*

    */



    private String getDirectionsUrlCalle72()
    {

        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+4.658825+","+-74.058719);
        googleDirectionsUrl.append("&mode=walking");
        googleDirectionsUrl.append("&key="+"AIzaSyAt2_PlP9pJPgidyVgHqDX6vwjwVi6ExH0");

        return googleDirectionsUrl.toString();
    }

    private String getDirectionsUrlNogal()
    {

        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+4.662096+","+-74.054100);
        googleDirectionsUrl.append("&mode=walking");
        googleDirectionsUrl.append("&key="+"AIzaSyAt2_PlP9pJPgidyVgHqDX6vwjwVi6ExH0");

        return googleDirectionsUrl.toString();
    }

    private String getDirectionsUrlDar()
    {

        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+4.666002+","+-74.058763);
        googleDirectionsUrl.append("&mode=walking");
        googleDirectionsUrl.append("&key="+"AIzaSyAt2_PlP9pJPgidyVgHqDX6vwjwVi6ExH0");

        return googleDirectionsUrl.toString();
    }

    private String getDirectionsUrlIdeas()
    {

        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+4.654758+","+-74.060191);
        googleDirectionsUrl.append("&mode=walking");
        googleDirectionsUrl.append("&key="+"AIzaSyAt2_PlP9pJPgidyVgHqDX6vwjwVi6ExH0");

        return googleDirectionsUrl.toString();
    }

    private String getDirectionsUrlSanMartin()
    {

        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+4.668258+","+-74.058855);
        googleDirectionsUrl.append("&mode=walking");
        googleDirectionsUrl.append("&key="+"AIzaSyAt2_PlP9pJPgidyVgHqDX6vwjwVi6ExH0");

        return googleDirectionsUrl.toString();
    }


}

