package com.example.appprueba;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

//librerias de trenh

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;





public class PantallaCarga extends AppCompatActivity{

    private TextView textView;
    private ProgressBar progressBar;
    private View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallacarga);

        //Enlazar los hilos
        textView=findViewById(R.id.text1);
        progressBar=findViewById(R.id.progress);


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

                    progressBar.setVisibility(View.GONE);
                    textView.setText("gracias por su espera");
                    setContentView(R.layout.pantallacarga);

                }
            });

        }
    });

    //iniciamos el threand
        thread.start();
    }

}
