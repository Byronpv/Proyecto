package com.example.byron.proyecto;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


public class Modulos extends AppCompatActivity implements View.OnClickListener {

    private CardView modulo_ciegos, modulo_estudiantes, modulo_sordos,modulo_m_reducida, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

        modulo_ciegos=(CardView)findViewById(R.id.modulo_ciegos);
        modulo_estudiantes=(CardView)findViewById(R.id.modulo_estudiantes);
        modulo_sordos=(CardView)findViewById(R.id.modulo_sordos);
        modulo_m_reducida=(CardView)findViewById(R.id.modulo_m_reducida);
        salir=(CardView)findViewById(R.id.salir);

        modulo_ciegos.setOnClickListener(this);
        modulo_estudiantes.setOnClickListener(this);
        modulo_sordos.setOnClickListener(this);
        modulo_m_reducida.setOnClickListener(this);
        salir.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.modulo_ciegos:

                Intent ciegos = new Intent (this, Modulo_Ciegos.class);
                startActivity(ciegos);
                break;
            case R.id.modulo_estudiantes:

                Intent estudiantes = new Intent (this, Modulo_Estudiantes.class);
                startActivity(estudiantes);
                break;

            case R.id.modulo_sordos:

                Intent sordos = new Intent (this, Modulo_sordos.class);
                startActivity(sordos);
                break;
            case R.id.modulo_m_reducida:

                Intent m_reducida = new Intent (this, Modulo_m_reducida.class);
                startActivity(m_reducida);
                break;
            case R.id.salir:
                Intent salir = new Intent (Intent.ACTION_MAIN);
                salir.addCategory(Intent.CATEGORY_HOME);
                salir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(salir);
             break;

        }

    }
}