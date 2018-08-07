package com.example.byron.proyecto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class Modulos extends AppCompatActivity {

     private GridLayout modulos;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

        modulos= (GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(modulos);



    }

    private void setSingleEvent(GridLayout modulos) {

        for(int i=0;i<modulos.getChildCount();i++){

            CardView cardView= (CardView)modulos.getChildAt((i));
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  if(finalI ==0){

                      Intent modulociegos = new Intent(Modulos.this, Modulo_Ciegos.class);
                      startActivity(modulociegos);

                  }
                  else if (finalI ==1){

                      Intent modulonormal = new Intent(Modulos.this, Modulo_Estudiantes.class);
                      startActivity(modulonormal);

                  }
                  else if(finalI ==2){

                      Intent modulosordos= new Intent(Modulos.this, Modulo_sordos.class);
                      startActivity(modulosordos);
                  }
                  else if( finalI ==3){
                      Intent modulomreducida= new Intent(Modulos.this, Modulo_m_reducida.class);
                      startActivity(modulomreducida);


                  }
                  else {

                      Toast.makeText(Modulos.this, "Select Item", Toast.LENGTH_SHORT).show();
                  }

                }
            });

        }
    }




}
