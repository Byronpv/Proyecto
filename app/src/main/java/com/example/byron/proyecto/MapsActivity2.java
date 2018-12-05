package com.example.byron.proyecto;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity2 extends FragmentActivity implements
        OnMapReadyCallback, YouTubePlayer.OnInitializedListener
         {

    private GoogleMap mMap;
    private int  MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    LocationManager locationManager;
    LocationListener locationListener;
    AlertDialog alertDialog;
    YouTubePlayerSupportFragment youTubePlayerFragment;
    YouTubePlayer.OnInitializedListener monInitalizedListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        YouTubePlayerSupportFragment frag =
                (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.videoYoutube);
        frag.initialize("AIzaSyAv59bAPtKXHSrXFuAK9nEr5N5paZCy1T8", this);

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

            ActivityCompat.requestPermissions(MapsActivity2.this,
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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String stringRecibido = bundle.getString("KeyString");



        if (stringRecibido.equals("EdificioA")) {

            LatLng UbicacionA = new LatLng(4.657924, -74.059408);
            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA, 18));

            LatLng UbicacionB = new LatLng(4.657994, -74.059358);
            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

            LatLng UbicacionC = new LatLng(4.658076, -74.059320);
            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

            LatLng UbicacionD = new LatLng(4.658047, -74.059253);
            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

            LatLng UbicacionA1 = new LatLng(4.658012, -74.059189);
            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

            LatLng UbicacionB1 = new LatLng(4.657977, -74.059117);
            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

            LatLng UbicacionC1 = new LatLng(4.657937, -74.059047);
            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

            LatLng UbicacionD1 = new LatLng(4.657889, -74.058977);
            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

            LatLng UbicacionA2 = new LatLng(4.657849, -74.058923);
            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

            LatLng UbicacionB2 = new LatLng(4.657788, -74.058974);
            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("EDIFICIO A").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));


            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(LayoutInflater.from(getApplication())));
                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            Uri uri = Uri.parse("http://humanidades.pedagogica.edu.co/");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                    return false;
                }
            });
            /*
            monInitalizedListener= new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                        //I assume the below String value is your video id
                        youTubePlayer.loadVideo("W4hTJybfU7s");

                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
*/

        }else if(stringRecibido.equals("EdificioB")){
            LatLng UbicacionA = new LatLng(4.657906, -74.059372);
            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

            LatLng UbicacionB = new LatLng(4.657906, -74.059372);
            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

            LatLng UbicacionC = new LatLng(4.658050, -74.059283);
            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

            LatLng UbicacionD = new LatLng(4.658132, -74.059223);
            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

            LatLng UbicacionA1 = new LatLng(4.658203, -74.059162);
            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

            LatLng UbicacionB1 = new LatLng(4.658289, -74.059083);
            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

            LatLng UbicacionC1 = new LatLng(4.658356, -74.059039);
            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

            LatLng UbicacionD1 = new LatLng(4.658407, -74.059007);
            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

            LatLng UbicacionA2 = new LatLng(4.658388, -74.058972);
            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("EDIFICIO B").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2, 18));
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter2(LayoutInflater.from(getApplication())));
                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            Uri uri = Uri.parse("http://cienciaytecnologia.pedagogica.edu.co/");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                    return false;
                }
            });

        }else if(stringRecibido.equals("EdificioC")){
            LatLng UbicacionA = new LatLng(4.657930, -74.059407);
            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

            LatLng UbicacionB = new LatLng(4.657986, -74.059363);
            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

            LatLng UbicacionC = new LatLng(4.658038, -74.059310);
            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

            LatLng UbicacionD = new LatLng(4.658091, -74.059364);
            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

            LatLng UbicacionA1 = new LatLng(4.658149, -74.059434);
            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

            LatLng UbicacionB1 = new LatLng(4.658181, -74.059477);
            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

            LatLng UbicacionC1 = new LatLng(4.658232, -74.059573);
            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("EDIFICIO C").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC1, 18));

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter3(LayoutInflater.from(getApplication())));
                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            Uri uri = Uri.parse("http://educacion.pedagogica.edu.co/");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                    return false;
                }
            });
        }else if(stringRecibido.equals("EdificioE")){
            LatLng UbicacionA = new LatLng(4.657930, -74.059407);
            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

            LatLng UbicacionB = new LatLng(4.657986, -74.059363);
            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

            LatLng UbicacionC = new LatLng(4.658038, -74.059310);
            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

            LatLng UbicacionD = new LatLng(4.658091, -74.059364);
            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

            LatLng UbicacionA1 = new LatLng(4.658149, -74.059434);
            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

            LatLng UbicacionB1 = new LatLng(4.658181, -74.059477);
            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

            LatLng UbicacionC1 = new LatLng(4.658288, -74.059464);
            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

            LatLng UbicacionD1 = new LatLng(4.658358, -74.059557);
            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

            LatLng UbicacionA2 = new LatLng(4.658400, -74.059621);
            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

            LatLng UbicacionB2 = new LatLng(4.658464, -74.059706);
            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

            LatLng UbicacionC2 = new LatLng(4.658512, -74.059776);
            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

            LatLng UbicacionD2 = new LatLng(4.658565, -74.059846);
            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

            LatLng UbicacionA3 = new LatLng(4.658621, -74.059915);
            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

            LatLng UbicacionB3 = new LatLng(4.658680, -74.059974);
            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("EDIFICIO E").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB3, 18));


        }else if(stringRecibido.equals("EdificioP")){
            LatLng UbicacionA = new LatLng(4.657906, -74.059372);
            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

            LatLng UbicacionB = new LatLng(4.657906, -74.059372);
            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

            LatLng UbicacionC = new LatLng(4.658050, -74.059283);
            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

            LatLng UbicacionD = new LatLng(4.658132, -74.059223);
            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

            LatLng UbicacionA1 = new LatLng(4.658203, -74.059162);
            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

            LatLng UbicacionB1 = new LatLng(4.658289, -74.059083);
            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

            LatLng UbicacionC1 = new LatLng(4.658356, -74.059039);
            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

            LatLng UbicacionD1 = new LatLng(4.658407, -74.059007);
            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

            LatLng UbicacionA2 = new LatLng(4.658467, -74.058982);
            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

            LatLng UbicacionB2 = new LatLng(4.658528, -74.058939);
            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

            LatLng UbicacionC2 = new LatLng(4.658587, -74.058904);
            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

            LatLng UbicacionD2 = new LatLng(4.658651, -74.058993);
            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("EDIFICIO P").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD2, 18));


        }else if(stringRecibido.equals("Sub")){
            LatLng UPN= new LatLng(4.666003, -74.058674);
            mMap.addMarker(new MarkerOptions().position(UPN).icon(BitmapDescriptorFactory.defaultMarker()).title("SUBDIRECCIÓN DE ADMISIONES Y REGISTRO")).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UPN,18));

        }else if(stringRecibido.equals("Nogal")){
            LatLng UPN= new LatLng(4.662099, -74.054056);
            mMap.addMarker(new MarkerOptions().position(UPN).icon(BitmapDescriptorFactory.defaultMarker()).title("Sede: el Nogal")).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UPN,18));

        }else if(stringRecibido.equals("Biblioteca")){
            LatLng UbicacionA = new LatLng(4.657924, -74.059408);
            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

            LatLng UbicacionB = new LatLng(4.657994, -74.059358);
            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

            LatLng UbicacionC = new LatLng(4.658076, -74.059320);
            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

            LatLng UbicacionD = new LatLng(4.658047, -74.059253);
            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

            LatLng UbicacionA1 = new LatLng(4.658012, -74.059189);
            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

            LatLng UbicacionB1 = new LatLng(4.657977, -74.059117);
            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

            LatLng UbicacionC1 = new LatLng(4.657937, -74.059047);
            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

            LatLng UbicacionD1 = new LatLng(4.657889, -74.058977);
            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

            LatLng UbicacionA2 = new LatLng(4.657849, -74.058923);
            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

            LatLng UbicacionB2 = new LatLng(4.657788, -74.058974);
            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("BIBLIOTECA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB2, 18));

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter4(LayoutInflater.from(getApplication())));
                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            Uri uri = Uri.parse("http://biblioteca.pedagogica.edu.co/");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    });
                    return false;
                }
            });

        }

    }


             @Override
             public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer,
                                                 boolean wasRestored) {
                 Bundle bundle = getIntent().getExtras();
                 String stringRecibido = bundle.getString("KeyString");
                 if(stringRecibido.equals("EdificioA")) {
                     youTubePlayer.loadVideo("xkpsb3G45Co");
                 }
                 else if(stringRecibido.equals("EdificioB")){
                     youTubePlayer.loadVideo("yHw2v21DIIQ");
                 }
                 else if(stringRecibido.equals("EdificioC")){
                     youTubePlayer.loadVideo("RWmmRMkBW3k");
                 }
                 else if(stringRecibido.equals("EdificioE")){
                     youTubePlayer.loadVideo("d9WXNo0nuMc");
                 }
                 else if(stringRecibido.equals("EdificioP")){
                     youTubePlayer.loadVideo("RqGdqIireKA");
                 }
                 else if(stringRecibido.equals("Sub")){
                     youTubePlayer.loadVideo("ReGUTFXIG_c");
                 }
                 else if(stringRecibido.equals("Nogal")){
                     youTubePlayer.loadVideo("rhz2UKb-QqI");
                 }
                 else if(stringRecibido.equals("Biblioteca")){
                     youTubePlayer.loadVideo("xkpsb3G45Co");
                 }
             }
             @Override
             public void onInitializationFailure (YouTubePlayer.Provider
                                                          provider, YouTubeInitializationResult errorReason){

             }


         }

