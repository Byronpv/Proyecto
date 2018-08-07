package com.example.byron.proyecto;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;

import javax.xml.datatype.Duration;

import static android.support.v4.content.ContextCompat.startActivity;

public class Modulo_sordos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_sordos);



        ArrayList<Fuente> imagen= new ArrayList<Fuente>();

        imagen.add(new Fuente("BIBLIOTECA", R.drawable.bibliotecaint,0));
        imagen.add(new Fuente("EDIFICIO A", R.drawable.edificioa,0));
        imagen.add(new Fuente("EDIFICIO B", R.drawable.edificiob,0));
        imagen.add(new Fuente("EDIFICIO C", R.drawable.edificioc,0));
        imagen.add(new Fuente("EDIFICIO E", R.drawable.edificioe,0));
        imagen.add(new Fuente("EDIFICIO P", R.drawable.edificiop,0));
        imagen.add(new Fuente("ENFERMERÍA", R.drawable.enfermeriab,0));
        imagen.add(new Fuente("BAÑOS EDIFICIO C", R.drawable.banosc,0));
        imagen.add(new Fuente("S. MULTIPROPÓSITO", R.drawable.coliseo,0));
        imagen.add(new Fuente("CASA DE BIOLOGÍA", R.drawable.casadebiologia,0));




        RecyclerView contenedor = (RecyclerView) findViewById(R.id.contenedor);
        contenedor.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor.setAdapter(new Adaptador(imagen));
        contenedor.setLayoutManager(layout);

    }
    private Transition transition;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onExplodeClicked (View view){

        transition = new Explode();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void OnslideClicked(){
        transition = new Slide(Gravity.START);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void OnfadeClicked(){

        transition = new Fade(Fade.OUT);

    }

}

