package com.example.rep_1_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVdatos = findViewById(R.id.txtVwDatos);
        MiClaseAsincrona miClaseAsincrona = new MiClaseAsincrona();
        miClaseAsincrona.execute(1,10,1000);
    }
    class MiClaseAsincrona extends AsyncTask<Integer,String,Double> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVdatos.append("incio del hilo");
        }


        @Override
        protected Double doInBackground(Integer... integers) {
            int i = integers[0];
            do{
                try {
                    Thread.sleep(integers[2]);
                    publishProgress("hola");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(i <= integers[1]);
            return null;
        }



        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
        }
    }
}