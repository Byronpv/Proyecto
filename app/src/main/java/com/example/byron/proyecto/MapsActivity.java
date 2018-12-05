package com.example.byron.proyecto;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static com.example.byron.proyecto.R.layout.infowindow_layout;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {


    private GoogleMap mMap;
    private int  MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    private Marker marcador;
    double Lat = 0.0;
    double Lng = 0.0;
    private ImageButton imageButton;
    
    LocationManager locationManager;
    LocationListener locationListener;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            AlertNoGps();
        }
        else{
            AlertNoGps1();
        }
           }



        private void AlertNoGps() {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(MapsActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);


            }

        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Dialog);
            builder.setMessage("El sistema GPS está desactivado, ¿Desea activarlo?")
                    .setCancelable(false)
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                            AlertNoGps1();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(  DialogInterface dialog, int id) {
                            dialog.cancel();
                            AlertNoGps1();

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }



    private void AlertNoGps1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Dialog);
        builder.setMessage("Indique en que entrada de la Universidad se encuentra.");
        builder.setCancelable(false);
        builder.setPositiveButton("CALLE 72", new DialogInterface.OnClickListener() {
            public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {

                Bundle bundle = getIntent().getExtras();
                String stringRecibido = bundle.getString("KeyString");
                int imagen = bundle.getInt("hola");
                ImageView imageView;
                imageView = (ImageView) findViewById(R.id.imagnormal);


                if (stringRecibido.equals("Edificio A")) {

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

                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Edificio B")) {
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
                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Edificio C")) {


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
                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Edificio P")) {

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
                    imageView.setImageResource(imagen);

                } else if (stringRecibido.equals("Edificio E")) {
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
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Baños")) {
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
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("BAÑOS").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA3, 18));
                    imageView.setImageResource(imagen);

                } else if (stringRecibido.equals("Biblioteca")) {
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
                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Restaurante")) {
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

                    LatLng UbicacionA2 = new LatLng(4.658465, -74.059104);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("RESTAURANTE").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2, 18));
                    imageView.setImageResource(imagen);

                } else if (stringRecibido.equals("SM")) {

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
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Salón Multipropósito").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB3, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Casa de biología")) {
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

                    LatLng UbicacionA2 = new LatLng(4.658449, -74.058970);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658494, -74.058927);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658533, -74.058881);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658509, -74.058830);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658467, -74.058757);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658430, -74.058699);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658394, -74.058648);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.658354, -74.058581);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.658325, -74.058535);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.658298, -74.058489);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                    LatLng UbicacionC4 = new LatLng(4.658269, -74.058443);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Casa de Biología").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC4, 18));
                    imageView.setImageResource(imagen);

                } else if (stringRecibido.equals("Edificio A1")) {
                    LatLng UbicacionA = new LatLng(4.657916, -74.059408);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658023, -74.059339);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658076, -74.059291);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658039, -74.059221);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658002, -74.059167);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.657965, -74.059097);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.657933, -74.059043);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.657890, -74.059075);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("EDIFICIO A").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD1, 18));
                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Biblioteca1")) {

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
                    imageView.setImageResource(imagen);
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


                    } else if (stringRecibido.equals("Edificio B1")) {

                    LatLng UbicacionA = new LatLng(4.657954, -74.059402);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658040, -74.059322);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658115, -74.059274);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658179, -74.059220);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658275, -74.059172);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658259, -74.059102);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658211, -74.059032);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658174, -74.058984);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658131, -74.058914);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658104, -74.058855);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658152, -74.058807);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("EDIFICIO B").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC2, 18));
                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Edificio P1")) {
                    LatLng UbicacionA = new LatLng(4.657933, -74.059411);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658013, -74.059311);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658088, -74.059247);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658141, -74.059199);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658237, -74.059129);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658323, -74.059081);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658398, -74.059033);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658473, -74.058990);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658532, -74.059049);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("EDIFICIO P").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2, 18));
                    imageView.setImageResource(imagen);
                }


            }
        });
        builder.setNegativeButton("CALLE 73 ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Bundle bundle = getIntent().getExtras();
                String stringRecibido = bundle.getString("KeyString");
                int imagen = bundle.getInt("hola");
                ImageView imageView;
                imageView = (ImageView) findViewById(R.id.imagnormal);
                imageButton = (ImageButton) findViewById(R.id.info);

                if (stringRecibido.equals("Edificio A")) {

                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658385, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658233, -74.059117);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658158, -74.059157);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658113, -74.059197);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658065, -74.059229);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658029, -74.059261);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.657991, -74.059193);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.657959, -74.059145);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.657915, -74.059110);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.657878, -74.059056);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                    LatLng UbicacionC4 = new LatLng(4.657841, -74.059008);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                    LatLng UbicacionD4 = new LatLng(4.657825, -74.059032);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("EDIFICIO A").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD4, 18));
                    imageView.setImageResource(imagen);
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
                } else if (stringRecibido.equals("Edificio B")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658397, -74.058968);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("EDIFICIO B").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2, 18));
                    imageView.setImageResource(imagen);
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

                } else if (stringRecibido.equals("Edificio C")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658385, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658233, -74.059117);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658158, -74.059157);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658113, -74.059197);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658065, -74.059229);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658029, -74.059261);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658038, -74.059295);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.658080, -74.059372);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.658150, -74.059450);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.658209, -74.059525);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("EDIFICIO C").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB4, 18));
                    imageView.setImageResource(imagen);
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
                } else if (stringRecibido.equals("Edificio P")) {
                    LatLng UbicacionA = new LatLng(4.658780, -74.058768);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658751, -74.058795);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658714, -74.058830);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658682, -74.058873);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658655, -74.058900);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658620, -74.058938);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658652, -74.058994);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("EDIFICIO P").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC1, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Edificio E")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658385, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658233, -74.059117);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658309, -74.059209);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658357, -74.059257);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658402, -74.059316);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658389, -74.059359);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658357, -74.059386);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.658314, -74.059413);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.658271, -74.059440);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.658322, -74.059494);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                    LatLng UbicacionC4 = new LatLng(4.658381, -74.059561);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                    LatLng UbicacionD4 = new LatLng(4.658429, -74.059623);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD4));

                    LatLng UbicacionA5 = new LatLng(4.658474, -74.059674);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA5));

                    LatLng UbicacionB5 = new LatLng(4.658525, -74.059738);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB5));

                    LatLng UbicacionC5 = new LatLng(4.658552, -74.059805);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC5));

                    LatLng UbicacionD5 = new LatLng(4.658592, -74.059864);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD5));

                    LatLng UbicacionA6 = new LatLng(4.658653, -74.059923);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA6).title("EDIFICIO E").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA6, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Baños")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658385, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658233, -74.059117);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658158, -74.059157);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658113, -74.059197);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658065, -74.059229);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658029, -74.059261);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658038, -74.059295);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.658080, -74.059372);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.658150, -74.059450);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.658209, -74.059525);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                    LatLng UbicacionC4 = new LatLng(4.658310, -74.059496);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                    LatLng UbicacionD4 = new LatLng(4.658345, -74.059542);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD4));

                    LatLng UbicacionA5 = new LatLng(4.658409, -74.059638);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA5));

                    LatLng UbicacionB5 = new LatLng(4.658468, -74.059721);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB5));

                    LatLng UbicacionC5 = new LatLng(4.658513, -74.059775);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC5));

                    LatLng UbicacionD5 = new LatLng(4.658569, -74.059858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD5));

                    LatLng UbicacionA6 = new LatLng(4.658617, -74.059930);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA6).title("BAÑOS").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA6, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Biblioteca")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658385, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658233, -74.059117);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658158, -74.059157);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658113, -74.059197);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658065, -74.059229);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658029, -74.059261);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.657991, -74.059193);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.657959, -74.059145);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.657915, -74.059110);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.657878, -74.059056);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                    LatLng UbicacionC4 = new LatLng(4.657841, -74.059008);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                    LatLng UbicacionD4 = new LatLng(4.657825, -74.059032);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("BIBLIOTECA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD4, 18));
                    imageView.setImageResource(imagen);
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


                } else if (stringRecibido.equals("Restaurante")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658499, -74.059082);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Restaurante").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("SM")) {
                    LatLng UbicacionA = new LatLng(4.658757, -74.05872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658709, -74.058750);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658667, -74.058786);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658619, -74.058824);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658582, -74.058858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658534, -74.058901);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658481, -74.058941);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658436, -74.058976);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658385, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658233, -74.059117);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658158, -74.059157);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658113, -74.059197);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658065, -74.059229);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658029, -74.059261);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658038, -74.059295);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.658080, -74.059372);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.658150, -74.059450);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.658209, -74.059525);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                    LatLng UbicacionC4 = new LatLng(4.658310, -74.059496);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                    LatLng UbicacionD4 = new LatLng(4.658345, -74.059542);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD4));

                    LatLng UbicacionA5 = new LatLng(4.658409, -74.059638);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA5));

                    LatLng UbicacionB5 = new LatLng(4.658468, -74.059721);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB5));

                    LatLng UbicacionC5 = new LatLng(4.658513, -74.059775);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC5));

                    LatLng UbicacionD5 = new LatLng(4.658569, -74.059858);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD5));

                    LatLng UbicacionA6 = new LatLng(4.658617, -74.059930);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA6).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA6));

                    LatLng UbicacionLL = new LatLng(4.658680, -74.059974);
                    mMap.addMarker(new MarkerOptions().position(UbicacionLL).title("Salón Multipropósito").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionLL, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Casa de biología")) {
                    LatLng UbicacionA = new LatLng(4.658774, -74.058765);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658729, -74.058792);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658702, -74.058811);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658670, -74.058841);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658627, -74.058860);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658590, -74.058876);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658534, -74.058895);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658489, -74.058841);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658457, -74.058795);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658412, -74.058728);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658380, -74.058682);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658343, -74.058626);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658278, -74.058532);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658257, -74.058492);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658245, -74.058465);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Casa de Biología").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC3, 18));
                    imageView.setImageResource(imagen);
                } else if (stringRecibido.equals("Edificio A1")) {

                    LatLng UbicacionA = new LatLng(4.658791, -74.058805);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658732, -74.058845);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658679, -74.058866);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658620, -74.058904);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658541, -74.058951);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658451, -74.058984);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658381, -74.059027);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658311, -74.059075);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658247, -74.059113);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658161, -74.059151);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658118, -74.059210);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658075, -74.059248);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658043, -74.059269);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.657975, -74.059199);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.657935, -74.059133);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                    LatLng UbicacionD3 = new LatLng(4.657908, -74.059101);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                    LatLng UbicacionA4 = new LatLng(4.657892, -74.059069);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                    LatLng UbicacionB4 = new LatLng(4.657860, -74.059090);

                    mMap.addMarker(new MarkerOptions().position(UbicacionB4).title(" EDIFICIO A").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB4, 18));
                    imageView.setImageResource(imagen);


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

                }else if (stringRecibido.equals("Biblioteca1") ) {

                        LatLng UbicacionA = new LatLng(4.658791, -74.058805);
                        mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                        LatLng UbicacionB = new LatLng(4.658732, -74.058845);
                        mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                        LatLng UbicacionC = new LatLng(4.658679, -74.058866);
                        mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                        LatLng UbicacionD = new LatLng(4.658620, -74.058904);
                        mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                        LatLng UbicacionA1 = new LatLng(4.658541, -74.058951);
                        mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                        LatLng UbicacionB1 = new LatLng(4.658451, -74.058984);
                        mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                        LatLng UbicacionC1 = new LatLng(4.658381, -74.059027);
                        mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                        LatLng UbicacionD1 = new LatLng(4.658311, -74.059075);
                        mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                        LatLng UbicacionA2 = new LatLng(4.658247, -74.059113);
                        mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                        LatLng UbicacionB2 = new LatLng(4.658161, -74.059151);
                        mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                        LatLng UbicacionC2 = new LatLng(4.658118, -74.059210);
                        mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                        LatLng UbicacionD2 = new LatLng(4.658075, -74.059248);
                        mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                        LatLng UbicacionA3 = new LatLng(4.658043, -74.059269);
                        mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                        LatLng UbicacionB3 = new LatLng(4.657975, -74.059199);
                        mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                        LatLng UbicacionC3 = new LatLng(4.657935, -74.059133);
                        mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                        LatLng UbicacionD3 = new LatLng(4.657908, -74.059101);
                        mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                        LatLng UbicacionA4 = new LatLng(4.657892, -74.059069);
                        mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                        LatLng UbicacionB4 = new LatLng(4.657860, -74.059090);

                        mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("BIBLIOTECA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB4, 18));
                        imageView.setImageResource(imagen);


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


                    } else if (stringRecibido.equals("Edificio B1")) {

                    LatLng UbicacionA = new LatLng(4.658786, -74.058801);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658743, -74.058835);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658673, -74.058873);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658614, -74.058911);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658539, -74.058949);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658462, -74.058987);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658344, -74.059038);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658280, -74.059075);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                    LatLng UbicacionA2 = new LatLng(4.658248, -74.059102);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                    LatLng UbicacionB2 = new LatLng(4.658216, -74.059038);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                    LatLng UbicacionC2 = new LatLng(4.658184, -74.058984);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                    LatLng UbicacionD2 = new LatLng(4.658157, -74.058925);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                    LatLng UbicacionA3 = new LatLng(4.658125, -74.058872);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                    LatLng UbicacionB3 = new LatLng(4.658120, -74.058829);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                    LatLng UbicacionC3 = new LatLng(4.658173, -74.058791);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("EDIFICIO B").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC3, 18));
                    imageView.setImageResource(imagen);
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


                } else if (stringRecibido.equals("Edificio P1")) {
                    LatLng UbicacionA = new LatLng(4.658788, -74.058791);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                    LatLng UbicacionB = new LatLng(4.658745, -74.058829);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                    LatLng UbicacionC = new LatLng(4.658708, -74.058845);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                    LatLng UbicacionD = new LatLng(4.658655, -74.058877);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                    LatLng UbicacionA1 = new LatLng(4.658591, -74.058915);
                    mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                    LatLng UbicacionB1 = new LatLng(4.658538, -74.058936);
                    mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                    LatLng UbicacionC1 = new LatLng(4.658523, -74.058987);
                    mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                    LatLng UbicacionD1 = new LatLng(4.658576, -74.059041);
                    mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("EDIFICIO P").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD1, 18));

                    imageView.setImageResource(imagen);


                }


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



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }


        mMap.setMyLocationEnabled(true);


    }


    @Override
    public void onClick(View v) {

    }
}
