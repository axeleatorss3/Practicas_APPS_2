package com.example.eva1_4_frag_paramteros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearFrag(View v){
        //se necesita una transaccion
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //crear el fragmento
        ParamFragment paramFragment = ParamFragment.newInstance("hola mundo","valores asignados al fragmentos");
        //remplazar nuestro layout con el fragmento
        fragmentTransaction.replace(R.id.frameLayoutMain,paramFragment);
        //commit
        fragmentTransaction.commit();

    }
}