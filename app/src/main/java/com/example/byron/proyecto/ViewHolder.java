package com.example.byron.proyecto;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        imagen.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        int position= getAdapterPosition();

            if(position==0){
                String valorString = "EdificioA";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);



            }
            else if(position==1){
                String valorString = "EdificioB";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);


            }
            else if(position==2){
                String valorString = "EdificioC";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);


            }else if(position==3){
                String valorString = "EdificioE";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);



            }else if(position==4){
                String valorString = "EdificioP";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);


            }else if(position==5){
                String valorString = "Sub";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);


            }else if(position==6){
                String valorString = "Nogal";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);


            }else if (position ==7){
                String valorString = "Biblioteca";
                Intent intent= new Intent (v.getContext(), MapsActivity2.class);
                intent.putExtra("KeyString", valorString);
                v.getContext().startActivity(intent);



            }else if (position ==8){
                String valorString = "Edificio B";
                Intent intent= new Intent (v.getContext(), MapsActivity.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.enfermeriab1);
                v.getContext().startActivity(intent);


            }else if (position ==9){
                String valorString = "Baños";
                Intent intent= new Intent (v.getContext(), MapsActivity.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.banosc);
                v.getContext().startActivity(intent);


            }else if (position ==10){
                String valorString = "SM";
                Intent intent= new Intent (v.getContext(), MapsActivity.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.coliseo);
                v.getContext().startActivity(intent);


            }else if (position ==11){
                String valorString = "Casa de biología";
                Intent intent= new Intent (v.getContext(), MapsActivity.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.casadebiologia);
                v.getContext().startActivity(intent);


            }else if (position ==12){
                String valorString = "Calle 72";
                Intent intent= new Intent (v.getContext(), MapsActivityRoute.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.entrada72);
                v.getContext().startActivity(intent);


            }else if (position ==13){
                String valorString = "SanMartin";
                Intent intent= new Intent (v.getContext(), MapsActivityRoute.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.sanmartin1);
                v.getContext().startActivity(intent);


            }else if (position ==14){
                String valorString = "Ideas";
                Intent intent= new Intent (v.getContext(), MapsActivityRoute.class);
                intent.putExtra("KeyString", valorString);
                intent.putExtra("hola", R.drawable.ideas);
                v.getContext().startActivity(intent);


            }



            }






    }






