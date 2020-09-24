package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intServicio;
    Button butEnd,BtnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intServicio = new Intent(this,MyService.class);
        butEnd = findViewById(R.id.btnEnd);
        BtnStart = findViewById(R.id.btnStart);
        BroadcastReceiver  myBroadcastReciver = new MyBroadcastReciver();
        IntentFilter intentFilter = new IntentFilter("MI SERVICIO");
        registerReceiver(myBroadcastReciver,intentFilter);

    }
    public void iniciar(View v){
        intServicio.putExtra("dato","dato de la actividad!!");
        startService(intServicio);
    }
    public void end(View v){
        stopService(intServicio);
    }
    public class MyBroadcastReciver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //PROCESAR EL MENSAJE
            Log.wtf("mensaje","THREAD corriendo");
        }
    }

}