package com.example.appprueba;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
//librerias de trenh

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class PantallaPrincipal extends AppCompatActivity {
    
//variables para el thread

  private TextView textView;
  private ImageView imageView;
  private ProgressBar progressBar;
  private View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        //Enlazar los hilos
        textView=findViewById(R.id.text1);

        activity=findViewById(R.id.main);

        //programacion del thread

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            //programacion de la pausa  5 segundos
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){

                e.printStackTrace();
            }

            //actualizamos la pantalla principal

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    textView.setText("Gracias por su espera");




                    }
                });



            }
        });

        //iniciamos el threand

        thread.start();
    }


    public void mediciondia(View view) {
        // Crear un Intent para redirigir a MedicionDiaria
        Intent intent = new Intent(PantallaPrincipal.this, Mediciondiaria.class);
        startActivity(intent);
        }
    public void promediomedicion(View view) {
        // Crear un Intent para redirigir a promediomedicion
        Intent intent = new Intent(PantallaPrincipal.this, promediomedicion.class);
        startActivity(intent);
    }

    public void Mapas (View view) {
        // Crear un Intent para redirigir a Mapas
        Intent intent = new Intent(PantallaPrincipal.this, Mapas.class);
        startActivity(intent);
    }


}