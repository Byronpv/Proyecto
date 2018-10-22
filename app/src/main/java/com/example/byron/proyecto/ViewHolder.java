package com.example.byron.proyecto;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    private static final String DEBUG_TAG = "AppCompatActivity";
    ImageView imagen;
    TextView titulo;
    int Position;
    List<Fuente> ListaObjeto;



    public ViewHolder(final View itemView, List<Fuente> datos) {
        super(itemView);


        imagen = (ImageView) itemView.findViewById(R.id.imagen);
        titulo = (TextView) itemView.findViewById(R.id.texto);
        ListaObjeto = datos;
        imagen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void onClick(View v) {

    }





}
