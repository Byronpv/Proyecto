package com.example.byron.proyecto;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
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

import static com.google.android.gms.location.DetectedActivity.WALKING;

//import android.location.LocationListener;



public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location mLocation;
    private Marker currentLocationMarker;
    public static final int REQUEST_LOCATION_CODE = 99;
    public static double RADIO= 1.0;
    double end_Latitude, end_Longitude;
    double latitude, longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);



        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            CheckLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




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
        Vibrator vibrator=(Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        MediaPlayer mediaPlayer;


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

        Bundle bundle = getIntent().getExtras();
        String stringRecibido = bundle.getString("KeyString");

        if(stringRecibido.equals("EdificioA")){

            Toast.makeText(this,"Edificio B", Toast.LENGTH_SHORT).show();


    }else if(stringRecibido.equals("EdificioB")){


            Object dataTransfer[] = new Object[2];
            dataTransfer = new Object[6];
            String url = getDirectionsUrl();
            GetDirectionsDataCiegos getDirectionsDataCiegos = new GetDirectionsDataCiegos();
            dataTransfer[0] = mMap;
            dataTransfer[1] = url;
            dataTransfer[2] = new LatLng(4.658741, -74.058806);
            dataTransfer[3] = new LatLng(4.658522, -74.058975);
            dataTransfer[4] = new LatLng(4.658426, -74.059042);
            dataTransfer[5] = new LatLng(4.658393, -74.058991);
            getDirectionsDataCiegos.execute(dataTransfer);
            MarkerOptions markerOptions1= new MarkerOptions();
            MarkerOptions markerOptions2= new MarkerOptions();
            MarkerOptions markerOptions3= new MarkerOptions();
            MarkerOptions markerOptions4= new MarkerOptions();
            markerOptions1.position(new LatLng(4.658741, -74.058806));
            markerOptions2.position(new LatLng(4.658522, -74.058975));
            markerOptions3.position(new LatLng(4.658426, -74.059042));
            markerOptions4.position(new LatLng(4.658393, -74.058991));
            markerOptions1.title("Destino");
            float results[] = new float[10];
            float results1[] = new float[10];
            float results2[] = new float[10];
            float results3[] = new float[10];
            Location.distanceBetween(latitude,longitude,4.658741, -74.058806, results);
            Location.distanceBetween(latitude,longitude,4.658522, -74.058975, results1);
            Location.distanceBetween(latitude,longitude,4.658426, -74.059042, results2);
            Location.distanceBetween(latitude,longitude,4.658393, -74.058991, results3);
            mMap.addMarker(markerOptions1);
            mMap.addMarker(markerOptions2);
            mMap.addMarker(markerOptions3);
            mMap.addMarker(markerOptions4);

            if (results[0] < RADIO) {
                Toast.makeText(this, "Ud está aquí", Toast.LENGTH_SHORT).show();
                mediaPlayer= MediaPlayer.create(this, R.raw.continuaenlinearecta);
                mediaPlayer.start();
            }

            else if(results1[0]<RADIO){
                Toast.makeText(this, "En rango", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(800);

            }else if(results2[0]<RADIO){
                Toast.makeText(this, "En rango", Toast.LENGTH_SHORT).show();
                mediaPlayer=MediaPlayer.create(this, R.raw.gizquierda);
                mediaPlayer.start();
            }else if(results3[0]<RADIO){
                Toast.makeText(this, "Llegó", Toast.LENGTH_SHORT).show();
                mediaPlayer=MediaPlayer.create(this, R.raw.destino);
                mediaPlayer.start();
                vibrator.vibrate(800);

            }
        }
        else if(stringRecibido.equals("EdificioC")){
            Toast.makeText(this,"Edificio C", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("EdificioE")){
            Toast.makeText(this,"Edificio E", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("EdificioP")){
            Toast.makeText(this,"Edificio P", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("BañosC")){
            Toast.makeText(this,"Baños C", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Biblioteca")){
            Toast.makeText(this,"Biblioteca", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Restaurante")){
            Toast.makeText(this,"Restaurante", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Multipropósito")){
            Toast.makeText(this,"Multipropósito", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Casadebiologia")){
            Toast.makeText(this,"Casita de biología", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Calle72")){
            Toast.makeText(this,"Calle 72", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Dar")){
            Toast.makeText(this,"Dar", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Ideas")){
            Toast.makeText(this,"Ideas", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("Nogal")){
            Toast.makeText(this,"Nogal", Toast.LENGTH_SHORT).show();
        }
        else if(stringRecibido.equals("SanMartin")){
            Toast.makeText(this,"SanMartin", Toast.LENGTH_SHORT).show();
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


    private String getDirectionsUrl(){

        StringBuilder googleDirectionsUrl = new StringBuilder("https://maps.googleapis.com/maps/api/directions/json?");
        googleDirectionsUrl.append("origin="+latitude+","+longitude);
        googleDirectionsUrl.append("&destination="+4.560444+","+-74.239788);
        googleDirectionsUrl.append("&mode=walking" );
        googleDirectionsUrl.append("&key="+"AIzaSyAt2_PlP9pJPgidyVgHqDX6vwjwVi6ExH0");

        return googleDirectionsUrl.toString();
    }


}
