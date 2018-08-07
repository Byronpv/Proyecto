package com.example.byron.proyecto;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private Marker marcador;
    double Lat = 0.0;
    double Lng = 0.0;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Holo_Dialog);
            builder.setMessage("El sistema GPS esta desactivado, ¿Desea activarlo?")
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
        builder.setMessage("Indique en que entrada de la Universidad se encuentra.")
                .setCancelable(false)
                .setPositiveButton("CALLE 72", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {

                        Bundle bundle = getIntent().getExtras();
                        String stringRecibido = bundle.getString("KeyString");
                        int imagen=bundle.getInt("hola");
                        ImageView imageView;
                        imageView=(ImageView)findViewById(R.id.imagnormal);

                        if( stringRecibido.equals("Edificio A")) {

                            LatLng UbicacionA =new LatLng(4.657924, -74.059408  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA,18));

                            LatLng UbicacionB =new LatLng(4.657994, -74.059358 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658076, -74.059320 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658047, -74.059253 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658012, -74.059189  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.657977, -74.059117  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.657937, -74.059047 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.657889, -74.058977);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.657849, -74.058923  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.657788, -74.058974  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("EDIFICIO A").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            imageView.setImageResource(imagen);

                        }
                        else if (stringRecibido.equals("Edificio B")){
                            LatLng UbicacionA =new LatLng(4.657906, -74.059372  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657906, -74.059372 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658050, -74.059283 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658132, -74.059223 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658203, -74.059162);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658289, -74.059083  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658356, -74.059039 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658407, -74.059007);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658388, -74.058972  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("EDIFICIO B").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2,18));
                            imageView.setImageResource(imagen);

                        }
                        else if(stringRecibido.equals("Edificio C")){


                            LatLng UbicacionA =new LatLng(4.657930, -74.059407  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657986, -74.059363 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658038, -74.059310 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658091, -74.059364 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658149, -74.059434);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658181, -74.059477  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658232, -74.059573 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("EDIFICIO C").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC1,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Edificio P")){

                            LatLng UbicacionA =new LatLng(4.657906, -74.059372  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657906, -74.059372 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658050, -74.059283 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658132, -74.059223 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658203, -74.059162);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658289, -74.059083  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658356, -74.059039 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658407, -74.059007);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658467, -74.058982  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658528, -74.058939  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658587, -74.058904 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658651, -74.058993  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("EDIFICIO P").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD2,18));
                            imageView.setImageResource(imagen);

                        }
                        else if(stringRecibido.equals("Edificio E")){
                            LatLng UbicacionA =new LatLng(4.657930, -74.059407  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657986, -74.059363 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658038, -74.059310 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658091, -74.059364 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658149, -74.059434);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658181, -74.059477  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658288, -74.059464);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658358, -74.059557);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658400, -74.059621  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658464, -74.059706);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658512, -74.059776 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658565, -74.059846  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658621, -74.059915  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658680, -74.059974  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("EDIFICIO E").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB3,18));
                            imageView.setImageResource(imagen);
                       }
                       else if(stringRecibido.equals("Baños")){
                            LatLng UbicacionA =new LatLng(4.657930, -74.059407  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657986, -74.059363 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658038, -74.059310 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658091, -74.059364 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658149, -74.059434);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658181, -74.059477  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658288, -74.059464);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658358, -74.059557);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658400, -74.059621  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658464, -74.059706);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658512, -74.059776 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658565, -74.059846  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658621, -74.059915  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("BAÑOS").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA3,18));
                            imageView.setImageResource(imagen);

                        }
                        else if(stringRecibido.equals("Biblioteca")){
                            LatLng UbicacionA =new LatLng(4.657924, -74.059408  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657994, -74.059358 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658076, -74.059320 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658047, -74.059253 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658012, -74.059189  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.657977, -74.059117  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.657937, -74.059047 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.657889, -74.058977);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.657849, -74.058923  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.657788, -74.058974  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("BIBLIOTECA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB2,18));
                            imageView.setImageResource(imagen);

                        }
                        else if(stringRecibido.equals("Restaurante")){
                            LatLng UbicacionA =new LatLng(4.657906, -74.059372  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657906, -74.059372 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658050, -74.059283 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658132, -74.059223 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658203, -74.059162);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658289, -74.059083  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658356, -74.059039 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658407, -74.059007);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658465, -74.059104  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("RESTAURANTE").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2,18));
                            imageView.setImageResource(imagen);

                        }
                        else if(stringRecibido.equals("SM")){

                            LatLng UbicacionA =new LatLng(4.657930, -74.059407  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657986, -74.059363 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658038, -74.059310 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658091, -74.059364 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658149, -74.059434);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658181, -74.059477  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658288, -74.059464);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658358, -74.059557);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658400, -74.059621  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658464, -74.059706);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658512, -74.059776 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658565, -74.059846  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658621, -74.059915  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658680, -74.059974  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Salón Multipropósito").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB3,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Casa de biología")){
                            LatLng UbicacionA =new LatLng(4.657906, -74.059372  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.657906, -74.059372 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658050, -74.059283 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658132, -74.059223 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658203, -74.059162);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658289, -74.059083  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658356, -74.059039 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658407, -74.059007);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658449, -74.058970  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658494, -74.058927);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658533, -74.058881 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658509, -74.058830 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658467, -74.058757  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658430, -74.058699  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.658394, -74.058648);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.658354, -74.058581   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.658325, -74.058535  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.658298, -74.058489  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                            LatLng UbicacionC4 =new LatLng(4.658269, -74.058443  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Casa de Biología").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC4,18));
                            imageView.setImageResource(imagen);
                        }

                    }
                })
                .setNegativeButton("CALLE 73 ", new DialogInterface.OnClickListener() {
                    public void onClick(  DialogInterface dialog, int id) {
                        Bundle bundle = getIntent().getExtras();
                        String stringRecibido = bundle.getString("KeyString");
                        int imagen=bundle.getInt("hola");
                        ImageView imageView;
                        imageView=(ImageView)findViewById(R.id.imagnormal);

                        if(stringRecibido.equals("Edificio A")){

                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658385, -74.059027  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658233, -74.059117);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658158, -74.059157 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658113, -74.059197 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658065, -74.059229   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658029, -74.059261  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.657991, -74.059193);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.657959, -74.059145   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.657915, -74.059110  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.657878, -74.059056  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                            LatLng UbicacionC4 =new LatLng(4.657841, -74.059008 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                            LatLng UbicacionD4 =new LatLng(4.657825, -74.059032 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("EDIFICIO A").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD4,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Edificio B")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658397, -74.058968  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("EDIFICIO B").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Edificio C")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658385, -74.059027  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658233, -74.059117);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658158, -74.059157 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658113, -74.059197 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658065, -74.059229   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658029, -74.059261  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.658038, -74.059295);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.658080, -74.059372   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.658150, -74.059450 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.658209, -74.059525 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("EDIFICIO C").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionB4,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Edificio P")){
                            LatLng UbicacionA =new LatLng(4.658780, -74.058768 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658751, -74.058795 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658714, -74.058830 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658682, -74.058873 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658655, -74.058900);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658620, -74.058938  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658652, -74.058994);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("EDIFICIO P").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC1,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Edificio E")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658385, -74.059027  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658233, -74.059117);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658158, -74.059157 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658113, -74.059197 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658065, -74.059229   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658029, -74.059261  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.658038, -74.059295);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.658080, -74.059372   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.658150, -74.059450 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.658209, -74.059525 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                            LatLng UbicacionC4 =new LatLng(4.658310, -74.059496 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                            LatLng UbicacionD4 =new LatLng(4.658345, -74.059542 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD4));

                            LatLng UbicacionA5 =new LatLng(4.658409, -74.059638 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA5));

                            LatLng UbicacionB5 =new LatLng(4.658468, -74.059721 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB5));

                            LatLng UbicacionC5 =new LatLng(4.658513, -74.059775 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC5));

                            LatLng UbicacionD5 =new LatLng(4.658569, -74.059858 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD5));

                            LatLng UbicacionA6 =new LatLng(4.658617, -74.059930 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA6).title("EDIFICIO E").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA6,18 ));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Baños")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658385, -74.059027  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658233, -74.059117);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658158, -74.059157 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658113, -74.059197 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658065, -74.059229   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658029, -74.059261  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.658038, -74.059295);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.658080, -74.059372   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.658150, -74.059450 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.658209, -74.059525 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                            LatLng UbicacionC4 =new LatLng(4.658310, -74.059496 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                            LatLng UbicacionD4 =new LatLng(4.658345, -74.059542 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD4));

                            LatLng UbicacionA5 =new LatLng(4.658409, -74.059638 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA5));

                            LatLng UbicacionB5 =new LatLng(4.658468, -74.059721 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB5));

                            LatLng UbicacionC5 =new LatLng(4.658513, -74.059775 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC5));

                            LatLng UbicacionD5 =new LatLng(4.658569, -74.059858 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD5));

                            LatLng UbicacionA6 =new LatLng(4.658617, -74.059930 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA6).title("BAÑOS").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA6,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Biblioteca")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658385, -74.059027  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658233, -74.059117);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658158, -74.059157 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658113, -74.059197 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658065, -74.059229   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658029, -74.059261  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.657991, -74.059193);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.657959, -74.059145   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.657915, -74.059110  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.657878, -74.059056  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                            LatLng UbicacionC4 =new LatLng(4.657841, -74.059008 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                            LatLng UbicacionD4 =new LatLng(4.657825, -74.059032 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("BIBLIOTECA").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionD4,18));
                            imageView.setImageResource(imagen);


                        }
                        else if(stringRecibido.equals("Restaurante")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658499, -74.059082  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Restaurante").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionA2,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("SM")){
                            LatLng UbicacionA =new LatLng(4.658757, -74.05872 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658709, -74.058750 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658667, -74.058786 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658619, -74.058824 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658582, -74.058858);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658534, -74.058901  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658481, -74.058941);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658436, -74.058976);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658385, -74.059027  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658233, -74.059117);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658158, -74.059157 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658113, -74.059197 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658065, -74.059229   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658029, -74.059261  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.658038, -74.059295);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC3));

                            LatLng UbicacionD3 =new LatLng(4.658080, -74.059372   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD3));

                            LatLng UbicacionA4 =new LatLng(4.658150, -74.059450 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA4));

                            LatLng UbicacionB4 =new LatLng(4.658209, -74.059525 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB4));

                            LatLng UbicacionC4 =new LatLng(4.658310, -74.059496 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC4));

                            LatLng UbicacionD4 =new LatLng(4.658345, -74.059542 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD4).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD4));

                            LatLng UbicacionA5 =new LatLng(4.658409, -74.059638 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA5));

                            LatLng UbicacionB5 =new LatLng(4.658468, -74.059721 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB5));

                            LatLng UbicacionC5 =new LatLng(4.658513, -74.059775 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC5));

                            LatLng UbicacionD5 =new LatLng(4.658569, -74.059858 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD5).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD5));

                            LatLng UbicacionA6 =new LatLng(4.658617, -74.059930 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA6).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA6));

                            LatLng UbicacionLL =new LatLng(4.658680, -74.059974  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionLL).title("Salón Multipropósito").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionLL,18));
                            imageView.setImageResource(imagen);
                        }
                        else if(stringRecibido.equals("Casa de biología")){
                            LatLng UbicacionA =new LatLng(4.658774, -74.058765 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA));

                            LatLng UbicacionB =new LatLng(4.658729, -74.058792 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB));

                            LatLng UbicacionC =new LatLng(4.658702, -74.058811 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC));

                            LatLng UbicacionD =new LatLng(4.658670, -74.058841 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionD).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD));

                            LatLng UbicacionA1 =new LatLng(4.658627, -74.058860);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA1).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA1));

                            LatLng UbicacionB1 =new LatLng(4.658590, -74.058876 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB1).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB1));

                            LatLng UbicacionC1 =new LatLng(4.658534, -74.058895);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC1).title("Ubicacion2").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC1));

                            LatLng UbicacionD1 =new LatLng(4.658489, -74.058841);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD1).title("Ubicacion3").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD1));

                            LatLng UbicacionA2 =new LatLng(4.658457, -74.058795);
                            mMap.addMarker(new MarkerOptions().position(UbicacionA2).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA2));

                            LatLng UbicacionB2 =new LatLng(4.658412, -74.058728);
                            mMap.addMarker(new MarkerOptions().position(UbicacionB2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB2));

                            LatLng UbicacionC2 =new LatLng(4.658380, -74.058682 );
                            mMap.addMarker(new MarkerOptions().position(UbicacionC2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionC2));

                            LatLng UbicacionD2 =new LatLng(4.658343, -74.058626);
                            mMap.addMarker(new MarkerOptions().position(UbicacionD2).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionD2));

                            LatLng UbicacionA3 =new LatLng(4.658278, -74.058532   );
                            mMap.addMarker(new MarkerOptions().position(UbicacionA3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionA3));

                            LatLng UbicacionB3 =new LatLng(4.658257, -74.058492  );
                            mMap.addMarker(new MarkerOptions().position(UbicacionB3).title("Ubicacion1").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(UbicacionB3));

                            LatLng UbicacionC3 =new LatLng(4.658245, -74.058465);
                            mMap.addMarker(new MarkerOptions().position(UbicacionC3).title("Casa de Biología").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))).showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UbicacionC3,18));
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
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }


        mMap.setMyLocationEnabled(true);


    }



}
