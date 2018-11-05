package com.example.byron.proyecto;

import android.app.FragmentManagerNonConfig;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.OnMapReadyCallback;

public class Modulo_Estudiantes extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo__estudiantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.modulo__estudiantes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_biblioteca) {
            String valorString = "Biblioteca";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.bibliotecaint);
            startActivity(intent);


        } else if (id == R.id.nav_restaurante) {
            String valorString = "Restaurante";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.restaurantex);
            startActivity(intent);

        } else if (id == R.id.nav_edificioA) {
            String valorString = "Edificio A";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.edificioaa);
            startActivity(intent);

        } else if (id == R.id.nav_edificioB) {
            String valorString = "Edificio B";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.edificiob);
            startActivity(intent);

        } else if (id == R.id.nav_edificioC) {
            String valorString = "Edificio C";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.edificioc);
            startActivity(intent);

        } else if (id == R.id.nav_edificioE) {
            String valorString = "Edificio E";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.edificioe);
            startActivity(intent);

        }
        else if (id == R.id.nav_edificioP) {
            String valorString = "Edificio P";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.edificiop);
            startActivity(intent);
        }
        else if (id == R.id.nav_casitadebiología) {
            String valorString = "Casa de biología";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.casadebiologia);
            startActivity(intent);

        }
        else if (id == R.id.nav_baños_Edi_E) {
            String valorString = "Baños";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.banosc);
            startActivity(intent);
        }
        else if (id == R.id.nav_salonMP) {
            String valorString = "SM";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivity.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.coliseo);
            startActivity(intent);

        }
        else if (id == R.id.sede_calle72) {
            String valorString = "Calle 72";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivityRoute.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.entrada72);
            startActivity(intent);

        }
        else if (id == R.id.sede_dar) {
            String valorString = "Dar";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivityRoute.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.dar);
            startActivity(intent);

        }   else if (id == R.id.sede_ideas) {
            String valorString = "Ideas";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivityRoute.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.ideas);
            startActivity(intent);
        }
        else if (id == R.id.sede_nogal) {
            String valorString = "Nogal";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivityRoute.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.nogal);
            startActivity(intent);
        } else if (id == R.id.sede_sanmartin) {
            String valorString = "SanMartin";
            Intent intent= new Intent (Modulo_Estudiantes.this, MapsActivityRoute.class);
            intent.putExtra("KeyString", valorString);
            intent.putExtra("hola", R.drawable.sanmartin1);
            startActivity(intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
