package com.example.byron.proyecto;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Byron on 30/04/2018.
 */
import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import java.util.List;

/**
 * Created by dherrera on 15/03/2017.
 */

public class Adaptador extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

    List<Fuente> ListaObjeto;


    public Adaptador(List<Fuente> listaObjeto) {
        ListaObjeto = listaObjeto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagenes_sordos, parent, false);
        return new ViewHolder(vista,ListaObjeto);
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titulo.setText(ListaObjeto.get(position).getTitulo());
        holder.imagen.setImageResource(ListaObjeto.get(position).getImagen());
/*
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        Intent intent = new Intent ( v.getContext(), MapsActivity2.class);
        v.getContext().startActivity(intent, ActivityOptionsCompat.
                makeSceneTransitionAnimation((Activity) v.getContext(),v,"").toBundle());

            }
        });
        */
    }
    @Override

    public int getItemCount() {

        return ListaObjeto.size();
    }

    @Override

    public void onClick(View v) {
    }
    @Override

    public void onViewDetachedFromWindow(ViewHolder viewHolder) {

        super.onViewDetachedFromWindow(viewHolder);
        viewHolder.itemView.clearAnimation();

    }
    /*
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    public void onViewAttachedToWindow(ViewHolder viewHolder) {

        super.onViewAttachedToWindow(viewHolder);
        animateCircularReveal(viewHolder.itemView);

    }
 @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    public void animateCircularReveal(View view) {

        int centerX = 0;
        int centerY = 0;
        int startRadius = 0;
        int endRadius = Math.max(view.getWidth(), view.getHeight());
        Animator animation = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);
        view.setVisibility(View.VISIBLE);
        animation.start();

    }
*/
}