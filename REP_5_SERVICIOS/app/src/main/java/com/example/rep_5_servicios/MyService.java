package com.example.rep_5_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    Thread thread;
    Intent mensaje;
    boolean i = true;
    public MyService() {

    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("mi servicio","OnCreate");
    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("mi servicio", intent.getStringExtra("dato"));
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while(i){
                    try {
                        Thread.sleep(1000);

                        mensaje = new Intent("mi servicio");
                        sendBroadcast(mensaje);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        i = false;
                        break;

                    }
                }
            }
        };
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("mi servicio","onDestroy");
        thread.interrupt();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
