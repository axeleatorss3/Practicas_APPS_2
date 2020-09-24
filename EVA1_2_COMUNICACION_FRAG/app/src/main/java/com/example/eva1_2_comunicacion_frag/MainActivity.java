package com.example.eva1_2_comunicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //1.recuperar los fragmentos
    FRAG_LIST listFragment;
     FRAG_1 dataFragment;
    //2. acceder
    //hay un metodo que se ejecuta cuando se vincula




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ListFragment.class){
            listFragment = (FRAG_LIST) fragment;
        }
        else if(fragment.getClass() == FRAG_1.class){
            dataFragment = (FRAG_1)fragment;

        }
    }
    public void  onMessageFromFragToMAain(String sender,String param){
        if(sender.equals("lista")){//recibimos infomracion
            //envair fragmento data
            dataFragment.onMessageFromMainToFrag(param);

        }
        else if(sender.equals("data")){
            //imprimir mensaje
            Toast.makeText(this, param, Toast.LENGTH_SHORT).show();
        }
    }
}