package com.example.byron.proyecto;

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

public class Modulo_m_reducida extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_m_reducida);
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
        getMenuInflater().inflate(R.menu.modulo_m_reducida, menu);
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
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);
        } else if (id == R.id.nav_restaurante) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        } else if (id == R.id.nav_edificioA) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        } else if (id == R.id.nav_edificioB) {

            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        } else if (id == R.id.nav_edificioC) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        } else if (id == R.id.nav_edificioE) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        }
        else if (id == R.id.nav_edificioP) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        }
        else if (id == R.id.nav_casitadebiología) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity.class);
            startActivity(maps);

        }
        else if (id == R.id.nav_baños_Edi_E) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity2.class);
            startActivity(maps);

        }
        else if (id == R.id.nav_salonMP) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity2.class);
            startActivity(maps);
        }
        else if (id == R.id.sede_nogal) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity2.class);
            startActivity(maps);
        }
        else if (id == R.id.sede_ideas) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity2.class);
            startActivity(maps);
        }
        else if (id == R.id.sede_dar) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity2.class);
            startActivity(maps);
        }
        else if (id == R.id.sede_calle72) {
            Intent maps = new Intent(Modulo_m_reducida.this, MapsActivity2.class);
            startActivity(maps);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
